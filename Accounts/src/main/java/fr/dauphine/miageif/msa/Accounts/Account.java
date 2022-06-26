package fr.dauphine.miageif.msa.Accounts;
import javax.persistence.*;

@Entity
public class Account {
    @Id
    private String IBAN;
    @Column(name="account_type")
    private String type;
    @Column(name="interests")
    private String interet;
    @Column(name="fees")
    private String frais;

    @Column(name="solde")
    private String solde;

    public Account() {
    }

    public Account(String IBAN, String type, String interet, String frais, String solde){
        this.IBAN = IBAN;
        this.type = type;
        this.interet = interet;
        this.frais = frais;
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Account{" +
                "IBAN=" + IBAN +
                ", account_type='" + type + '\'' +
                ", interests=" + interet + '\'' +
                ", fees=" + frais + '\'' +
                ", solde=" + solde +
                '}';
    }

}
