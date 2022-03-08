package Pack01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Apple {

}
@Configuration
class AppConfig {
	@Bean(name="appleMango")
	Apple apple() {
		return new Apple();
	}

}

// DI(의존주입), AOP(관점지향프로그램), IOC(제어의역전)
// 실질적 적용은 DI
public class DI {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(ctx.getBeanDefinitionCount()); //default 5개 + 방금 만든 한개
		ctx.close();
		
		
	}
}