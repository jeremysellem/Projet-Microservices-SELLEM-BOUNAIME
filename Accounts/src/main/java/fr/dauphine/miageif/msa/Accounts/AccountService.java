package fr.dauphine.miageif.msa.Accounts;
import java.util.Optional;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> getAccountByIban(final String iban) {
        return accountRepository.findByIban(iban);
    }

    public Optional<Account> getAccountByID(final Long id) {
        return accountRepository.findById(id);
    }

    public Iterable<Account> getAccounts() { return accountRepository.findAll(); }

    public void deleteAccount(final Long id) {
        accountRepository.deleteById(id);
    }

    public Account saveAccount(Account compte) {
        return accountRepository.save(compte);
    }

}
