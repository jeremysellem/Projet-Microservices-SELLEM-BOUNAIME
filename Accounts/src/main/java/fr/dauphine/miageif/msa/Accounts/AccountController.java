package fr.dauphine.miageif.msa.Accounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;

/* Endpoints REST */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

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
    public Account getEmployee(@PathVariable("iban") final String iban) {
        Optional<Account> account = accountService.getAccount(iban);
        return account.isPresent() ? account.get() : null;
    }

    /**
     * Créer un compte
     */
    @PostMapping("/account/create")
    public Account createAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

}
