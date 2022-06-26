package fr.dauphine.miageif.msa.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/* Endpoints REST */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    public AccountController(AccountService service) {
        this.accountService = service;
    }

    /**
     * Récupérer tous les comptes
     */
    @GetMapping("/accounts")
    public Iterable<Account> getAccounts() {
        return accountService.getAccounts();
    }

    /**
     * Récupérer un compte par son iban
     */
    @GetMapping("/account/{iban}")
    public Account getAccount(@PathVariable("iban") final String iban) {
        Optional<Account> account = accountService.getAccount(iban);
        return account.isPresent() ? account.get() : null;
    }

    /**
     * Créer un compte
     */
    @PostMapping("/account/create")
    public Account createAccount(@RequestParam String iban, @RequestParam String type, @RequestParam String interet, @RequestParam String frais, @RequestParam String solde) {
        Account compte = new Account(iban, type, interet, frais, solde);
        accountService.saveAccount(compte);
        return compte;
    }

    @PostMapping("/account/delete")
    public void deleteAccount(@RequestParam String iban) {
        Optional<Account> account = accountService.getAccount(iban);
        if (account.isPresent())
            accountService.deleteAccount(iban);
        return;
    }

}
