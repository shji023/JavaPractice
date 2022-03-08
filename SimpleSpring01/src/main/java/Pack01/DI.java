package Pack01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Apple {
	void f1() {
		System.out.println("f1 call");
	}
}
class Orange {
	@Autowired // 밑에 주석잡은 생성자 코드를 만든다.
	Apple apple;
	// 생성자 주입
//	Orange(Apple apple){
//		this.apple = apple;
//	}
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
	@Bean()
	Orange orange() {
		//return new Orange(apple()); // 원래의 apple을 그대로 쓰고있다. singleton
		return new Orange(); // Autowired
	}

}

// DI(의존주입), AOP(관점지향프로그램), IOC(제어의역전)
// 실질적 적용은 DI
public class DI {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(ctx.getBeanDefinitionCount()); //default 5개 + 방금 만든 한개
		
		// Orange orange = new Orange(new Apple());
		// orange.f2(); // 사용자가 직접적으로 주입을 시켜서 사용함 
		
		Orange orange = ctx.getBean("orange", Orange.class);
		orange.f2(); // 스프링활용 주입 코드
		ctx.close();
		
		
	}
}