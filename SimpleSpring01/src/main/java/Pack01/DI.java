package Pack01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Apple {
	void f1() {
		System.out.println("test");
	}
}
class Orange {
	Apple apple;
	Orange(Apple apple){
		this.apple = apple;
	}
	void f2() {
		apple.f1();
	}
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
		
		Orange orange = new Orange(new Apple());
		orange.f2(); // 사용자가 직접적으로 주입을 시켜서 사용함 
		
		ctx.close();
		
		
	}
}