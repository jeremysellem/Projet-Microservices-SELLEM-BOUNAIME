package fr.dauphine.miageif.msa.Transactions;
import java.util.Optional;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Optional<Transaction> getTransaction(final String id) {
        return transactionRepository.findById(id);
    }

    public Iterable<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public void deleteTransaction(final String id) {
        transactionRepository.deleteById(id);
    }

    public Transaction saveTransaction(Transaction id) {
        return transactionRepository.save(id);
    }

}