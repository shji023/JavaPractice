package Pack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Apple {

}
// 스프링에게 객체를 생성할 환경설정하는 클래스라는것을 알린다. 
@Configuration
class AppConfig {
// 여기안에서 객체를 생성시킨다.
	
	// 빈 객체
	// 스프링이 생성시킨 객체를 빈이라고 한다.
	// 
	@Bean
	Apple apple() {
		System.out.println(1000);
		return new Apple();
	}
}
public class Hello {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.close();
	}

}
