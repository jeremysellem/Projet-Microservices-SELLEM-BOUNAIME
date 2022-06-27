package fr.dauphine.miageif.msa.Transactions;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Data;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Data
@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getTransactionByIban(final String iban) {
        return Stream.concat(transactionRepository.findByIbanFrom(iban).stream(), transactionRepository.findByIbanTo(iban).stream()).collect(Collectors.toList());
    }

    public Optional<Transaction> getTransactionByID(final Long id) {
        return transactionRepository.findById(id);
    }

    public Iterable<Transaction> getTransactions() { return transactionRepository.findAll(); }

    public void deleteTransaction(final Long id) {
        transactionRepository.deleteById(id);
    }

    public Transaction saveTransaction(Transaction transaction1) {
        return transactionRepository.save(transaction1);
    }

    public boolean ibanExist(String iban) {
        String uri = "http://localhost:8000/account/exist/{iban}";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, boolean.class, iban);
    }

    public String updateAccount(String iban, float montant) {
        String uri = "http://localhost:8000/account/update-balance";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject params = new JSONObject();
        params.put("iban", iban);
        params.put("valeur", montant);
        HttpEntity<String> request = new HttpEntity<>(params.toString(), headers);
        return restTemplate.postForObject(uri, request, String.class);
    }
}
