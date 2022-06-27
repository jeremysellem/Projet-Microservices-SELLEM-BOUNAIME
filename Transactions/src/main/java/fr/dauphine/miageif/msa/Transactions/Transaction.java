package fr.dauphine.miageif.msa.Transactions;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name="type")
    private String type;
    @Column(name="ibanFrom")
    private String ibanFrom;
    @Column(name="ibanTo")
    private String ibanTo;
    @Column(name="montant")
    private float montant;
    @Column(name="date")
    private Date date;

    public Transaction() {
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getibanFrom() {
        return ibanFrom;
    }

    public String getibanTo() {
        return ibanTo;
    }

    public float getMontant() {
        return montant;
    }

    public Date getDate() {
        return date;
    }

    public Transaction(String type, String ibanFrom, String ibanTo, float montant, Date date){
        this.type = type;
        this.ibanFrom = ibanFrom;
        this.ibanTo = ibanTo;
        this.montant = montant;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transaction_type='" + type + '\'' +
                ", ibanFrom=" + ibanFrom +
                ", ibanTo=" + ibanTo +
                ", montant=" + montant +
                ", date=" + date +
                '}';
    }

}
