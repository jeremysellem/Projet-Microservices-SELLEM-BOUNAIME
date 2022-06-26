package fr.dauphine.miageif.msa.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;

/* Endpoints REST */
@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

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
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

}
