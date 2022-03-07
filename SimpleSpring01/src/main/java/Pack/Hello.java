package Pack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Apple {
	void f1() {
		System.out.println("f1 call");
	}
}

// 스프링에게 객체를 생성할 환경설정하는 클래스라는것을 알린다. 
@Configuration
class AppConfig {
// 여기안에서 객체를 생성시킨다.
	
	// 빈 객체
	// 스프링이 생성시킨 객체를 빈이라고 한다.
	// @Bean이 있으면 안에 코드가 없어도 빈 객체가 만들어졌다고 생각
	// 자바 파일안에 public  한개만 있어야하기 때문에 public 못 붙임
	@Bean
	Apple apple() {
		System.out.println(1000);
		return new Apple();
	}
	@Bean
	Greeter greet() {
		System.out.println(1000);
		return new Greeter();
	}
}

class Greeter {
	String format; 
	void setFormat(String format) {
		this.format = format;
	}
	String greet(String guest) {
		return String.format(format, guest);
	}
}
public class Hello {

	public static void main(String[] args) {
		Greeter g = new Greeter();
		g.setFormat("안녕하세요");
		System.out.println(g.greet("호랑이"));
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		// 아래 코드는 내가 객체를 생성하는 것
		// Apple apple = new Apple();
		// Apple apple = ctx.getBean("apple",Apple.class);
		Apple apple = ctx.getBean(Apple.class); // 위 코드와 같은 의미
		apple.f1();
		System.out.println(apple.hashCode());
		
		Greeter g1 = ctx.getBean(Greeter.class);
		g1.setFormat("%s식사하세요");
		ctx.close();
	}

}
