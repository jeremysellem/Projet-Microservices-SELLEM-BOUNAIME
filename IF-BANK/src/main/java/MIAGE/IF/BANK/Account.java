package MIAGE.IF.BANK;
import javax.persistence.*;
@Entity
public class Account {
    @Id
    private String IBAN;
    private String type;
    private String interet;
    private String frais;

    public Account(String IBAN, String type, String interet, String frais){
        this.IBAN = IBAN;
        this.type = type;
        this.interet = interet;
        this.frais = frais;
    }

}
