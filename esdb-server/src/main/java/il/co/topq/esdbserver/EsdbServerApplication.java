package il.co.topq.esdbserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EsdbServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EsdbServerApplication.class, args);
	}
}
