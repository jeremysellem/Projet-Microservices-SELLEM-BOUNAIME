package fr.dauphine.miageif.msa.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findById(Long id);
    Optional<Account> findByIban(String iban);
    void deleteById(Long id);
    @Query(value = "select a from Account a")
    List<Account> findAll();
    Account save(Account compte);
}