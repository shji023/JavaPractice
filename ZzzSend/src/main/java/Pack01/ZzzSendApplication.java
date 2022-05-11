package Pack01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ZzzSendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZzzSendApplication.class, args);
	}

}
