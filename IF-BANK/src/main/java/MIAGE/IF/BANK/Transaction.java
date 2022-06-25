package MIAGE.IF.BANK;
import javax.persistence.*;

@Entity
public class Transaction {
    @Id
    private String id;
    private String IBAN_from;
    private String IBAN_to;
    private String type;
    private int montant;
    private String date;

    public Transaction(String id, String IBAN_from, String IBAN_to, String type, int montant, String date){
        this.id = id;
        this.IBAN_from = IBAN_from;
        this.IBAN_to = IBAN_to;
        this.type = type;
        this.montant = montant;
        this.date = date;
    }

}
