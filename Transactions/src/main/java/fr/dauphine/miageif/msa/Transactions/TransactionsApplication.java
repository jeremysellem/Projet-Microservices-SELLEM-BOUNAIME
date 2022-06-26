package fr.dauphine.miageif.msa.Transactions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TransactionsApplication {

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World Transactions";
	}

	public static void main(String[] args) {
		SpringApplication.run(TransactionsApplication.class, args);
	}

}