package Pack01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Feign01Application {

	public static void main(String[] args) {
		SpringApplication.run(Feign01Application.class, args);
	}

}
