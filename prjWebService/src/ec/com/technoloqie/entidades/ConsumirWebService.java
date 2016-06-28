package ec.com.technoloqie.entidades;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ConsumirWebService implements CommandLineRunner  {
	
	private static final Logger log = LoggerFactory.getLogger(ConsumirWebService.class);
	
	public static void main(String args[]) {
		SpringApplication.run(ConsumirWebService.class);
	}

	@Override
	public void run(String... arg0) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
        //Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		ClasePrueba quote = restTemplate.getForObject("http://rest-service.guides.spring.io/greeting", ClasePrueba.class);
        log.info(quote.toString());
	}

}
