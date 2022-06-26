package fr.dauphine.miageif.msa.Transactions;
import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    private String id;
    @Column(name="IBAN_from")
    private String IBAN_from;
    @Column(name="IBAN_to")
    private String IBAN_to;
    @Column(name="transaction_type")
    private String type;
    @Column(name="montant")
    private float montant;
    @Column(name="date")
    private String date;

    public Transaction() {
    }

    public Transaction(String id, String IBAN_from, String IBAN_to, String type, float montant, String date){
        this.id = id;
        this.IBAN_from = IBAN_from;
        this.IBAN_to = IBAN_to;
        this.type = type;
        this.montant = montant;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id + '\'' +
                ", IBAN_from=" + IBAN_from + '\'' +
                ", IBAN_to=" + IBAN_to + '\'' +
                ", transaction_type='" + type + '\'' +
                ", montant=" + montant + '\'' +
                ", date=" + date +
                '}';
    }

}
