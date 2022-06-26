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

    public Optional<Account> getAccount(final String iban) {
        return accountRepository.findById(iban);
    }

    public Iterable<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public void deleteAccount(final String iban) {
        accountRepository.deleteById(iban);
    }

    public Account saveAccount(Account iban) {
        return accountRepository.save(iban);
    }

}
