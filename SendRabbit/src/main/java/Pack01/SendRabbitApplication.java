package Pack01;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SendRabbitApplication {
	// 직렬화 위한 객체 생성
	@Bean
	Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SendRabbitApplication.class, args);
	}

}
