package fr.dauphine.miageif.msa.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Optional<Transaction> findById(String id);
    List<Transaction> findAll();
    Transaction save(Transaction transaction1);
}