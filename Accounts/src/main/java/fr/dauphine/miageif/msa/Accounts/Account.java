package fr.dauphine.miageif.msa.Accounts;
import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "iban")
    private String iban;
    @Column(name="account_type")
    private String account_type;
    @Column(name="interet")
    private float interet;
    @Column(name="frais")
    private float frais;
    @Column(name="solde")
    private float solde;

    public void setInteret(float interet) {
        this.interet = interet;
    }

    public void setFrais(float frais) {
        this.frais = frais;
    }

    public void setSolde(float solde) {
        this.solde = solde;
    }

    public Long getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void updateSolde(float valeur) {
        setSolde(this.solde + valeur);
    }
    public float getInteret() {
        return interet;
    }

    public float getFrais() {
        return frais;
    }

    public float getSolde() {
        return solde;
    }

    public Account() {
    }

    public Account(String iban, String account_type, float interet, float frais, float solde) {
        this.iban = iban;
        this.account_type = account_type;
        this.interet = interet;
        this.frais = frais;
        this.solde = solde;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", iban=" + iban +
                ", account_type='" + account_type + '\'' +
                ", interet=" + interet +
                ", frais=" + frais +
                ", solde=" + solde +
                '}';
    }
}
