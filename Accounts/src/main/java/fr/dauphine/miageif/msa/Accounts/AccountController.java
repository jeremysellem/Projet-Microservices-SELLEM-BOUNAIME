package fr.dauphine.miageif.msa.Accounts;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
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
     * Récupérer un compte par son id
     */
    @GetMapping("/account/id/{id}")
    public Account getAccountByID(@PathVariable("id") final Long id) {
        Optional<Account> account = accountService.getAccountByID(id);
        return account.isPresent() ? account.get() : null;
    }

    /**
     * Récupérer un compte par son iban
     */
    @GetMapping("/account/iban/{iban}")
    public Account getAccountByIban(@PathVariable("iban") final String iban) {
        Optional<Account> account = accountService.getAccountByIban(iban);
        return account.isPresent() ? account.get(): null;
    }

    /**
     * Créer un compte
     */
    @PostMapping("/account/create")
    public Account createAccount(@RequestBody @NotNull Map<String, String> params) {
        if(!(params.containsKey("iban") && params.containsKey("account_type") && params.containsKey("interet") && params.containsKey("frais") && params.containsKey("solde")))
            return null;

        Account compte = new Account(params.get("iban"), params.get("account_type"), Float.parseFloat(params.get("interet")), Float.parseFloat(params.get("frais")), Float.parseFloat(params.get("solde")));
        accountService.saveAccount(compte);
        return compte;
    }

    @Transactional
    @PostMapping("/account/delete")
    public void deleteAccount(@RequestParam Long id) {
        Optional<Account> account = accountService.getAccountByID(id);
        if (account.isPresent())
            accountService.deleteAccount(id);
    }

    /**
     * Mettre à jour un solde
     */
    @PostMapping("/account/update-balance")
    public String updateBalance(@RequestBody @NotNull Map<String, String> params) {
        if(!(params.containsKey("iban") && params.containsKey("valeur")))
            return "Bad arguments to create an account, expected: iban, valeur";

        Optional<Account> account = accountService.getAccountByIban(params.get("iban"));
        if (!account.isPresent())
            return "Account with this IBAN does not exist";

        float oldValue = account.get().getSolde();
        account.get().updateSolde((1-account.get().getFrais()) * Float.parseFloat(params.get("valeur")));
        accountService.saveAccount(account.get());

        return "Old value: " + oldValue + " New value: " + account.get().getSolde();
    }
}
