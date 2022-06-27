package fr.dauphine.miageif.msa.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Optional<Transaction> findById(Long id);
    @Query(value = "select t from Transaction t")
    List<Transaction> findAll();
    Transaction save(Transaction transaction1);
    List<Transaction> findByIbanTo(String iban);
    List<Transaction> findByIbanFrom(String iban);
    void deleteById(Long id);
}