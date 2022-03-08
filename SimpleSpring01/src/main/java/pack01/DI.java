package pack01;

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
	@Autowired // 밑에 주석잡은 생성자 코드를 만든다. 필드 주입
	// 1. 사용하지 않는것을 권장 (스프링 측)
	// 2. 실전에서 사용을 많이 함 
	Apple apple;
	// 생성자 주입
//	Orange(Apple apple){
//		this.apple = apple;
//	}
	// 생성자 뿐 만 아니라 setter함수 사용하여 주입가능
	@Autowired // 자동으로 위에 애플 객체 쓸 수 있게함
	// 세터 주입(수정자 주입)
	void setApple(Apple apple) {
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
	@Bean()
	Orange orange() {
		//return new Orange(apple()); // 원래의 apple을 그대로 쓰고있다. singleton
		// Orange o = new Orange();
		// o.setApple(apple());
		return new Orange();// setApple Autowired
		// return o;
		//return new Orange(); // Autowired
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
		Orange o = new Orange();
		o.setApple(new Apple());
		o.f2(); // 세터주입 적용 방법, 스프링 방식x
		Orange orange = ctx.getBean("orange", Orange.class);
		orange.f2(); // 스프링활용 주입 코드
		ctx.close();
		
		
	}
}