package blockchain.vctransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VctransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(VctransferApplication.class, args);
	}

}
