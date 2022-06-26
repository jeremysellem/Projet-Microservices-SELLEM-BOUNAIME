package fr.dauphine.miageif.msa.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findById(String iban);
    void deleteById(String iban);
    List<Account> findAll();
    Account save(Account compte);
}