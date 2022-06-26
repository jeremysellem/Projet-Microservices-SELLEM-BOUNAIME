package fr.dauphine.miageif.msa.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/transaction/{id}")
    public Transaction getTransaction(@PathVariable("id") final String id) {
        Optional<Transaction> transaction = transactionService.getTransaction(id);
        return transaction.isPresent() ? transaction.get() : null;
    }

    /**
     * Créer une transaction
     */
    @PostMapping("/transaction/create")
    public Transaction createTransaction(@RequestParam String id, @RequestParam String IBAN_from, @RequestParam String IBAN_to, @RequestParam String type, @RequestParam float montant, @RequestParam String date) {
        Transaction transaction1 = new Transaction(id, IBAN_from, IBAN_to, type, montant, date);
        transactionService.saveTransaction(transaction1);
        return transaction1;
    }

}
