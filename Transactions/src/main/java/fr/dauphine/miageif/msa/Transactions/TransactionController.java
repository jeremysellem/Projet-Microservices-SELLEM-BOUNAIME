package fr.dauphine.miageif.msa.Transactions;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/* Endpoints REST */
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    public TransactionController(TransactionService service) {
        this.transactionService = service;
    }

    /**
     * Récupérer toutes les transactions
     */
    @GetMapping("/transactions")
    public Iterable<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }

    /**
     * Récupérer une transaction par son id
     */
    @GetMapping("/transaction/id/{id}")
    public Transaction getTransactionByID(@PathVariable("id") final Long id) {
        Optional<Transaction> transaction = transactionService.getTransactionByID(id);
        return transaction.isPresent() ? transaction.get() : null;
    }

    /**
     * Récupérer les transactions ayant cet IBAN en source ou en destinataire
     */
    @GetMapping("/transaction/iban/{iban}")
    public List<Transaction> getAccountByIban(@PathVariable("iban") final String iban) {
        return transactionService.getTransactionByIban(iban);
    }

    /**
     * Créer une transaction
     */
    @PostMapping("/transaction/create")
    public Transaction createAccount(@RequestBody @NotNull Map<String, String> params) throws ParseException {
        if(!(params.containsKey("type") && params.containsKey("ibanFrom") && params.containsKey("ibanTo") && params.containsKey("montant") && params.containsKey("date")))
            return null;
        if(!(transactionService.ibanExist(params.get("ibanFrom")) && transactionService.ibanExist(params.get("ibanTo"))))
            return null;

        Transaction transaction1 = new Transaction(params.get("type"), params.get("ibanFrom"), params.get("ibanTo"), Float.parseFloat(params.get("montant")), new SimpleDateFormat("dd/MM/yyyy").parse(params.get("date")));
        transactionService.updateAccount(params.get("ibanFrom"), -Float.parseFloat(params.get("montant")));
        transactionService.updateAccount(params.get("ibanTo"), Float.parseFloat(params.get("montant")));

        transactionService.saveTransaction(transaction1);
        return transaction1;
    }

    /**
     * Supprimer une transaction
     */
    @Transactional
    @PostMapping("/transaction/delete")
    public void deleteAccount(@RequestParam Long id) {
        Optional<Transaction> account = transactionService.getTransactionByID(id);
        if (account.isPresent())
            transactionService.deleteTransaction(id);
    }
}
