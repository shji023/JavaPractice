package Pack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

class Apple {
	void f1() {
		System.out.println("f1 call");
	}
}

// 스프링에게 객체를 생성할 환경설정하는 클래스라는것을 알린다. 
// @configuration이 있어야 싱글톤 유지
@Configuration
class AppConfig {
// 여기안에서 객체를 생성시킨다.
	
	// 빈 객체
	// 스프링이 생성시킨 객체를 빈이라고 한다.
	// @Bean이 있으면 안에 코드가 없어도 빈 객체가 만들어졌다고 생각
	// 자바 파일안에 public  한개만 있어야하기 때문에 public 못 붙임
	@Bean
	//@Scope("singleton") // 객체를 생성시키는데 두개 생성시키지 않음
	// 스프링은 기본적으로 싱글톤 베이스
	//Scope("prototype")
	Apple apple() {
		System.out.println(1000);
		return new Apple();
	}
	@Bean
	Apple applebanana() {
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
		
		Apple a1 = ctx.getBean("apple", Apple.class);
		Apple a2 = ctx.getBean("apple", Apple.class);
		
		System.out.println(a2.hashCode());
		System.out.println(a2.hashCode());
		System.out.println(a1==a2);
		
		Apple a3 = ctx.getBean("applebanana", Apple.class);
		ctx.close();
		
		
	}
// 스프링은 객체를 관리하는 컨테이너다
// xml과 위 코드 비교
	
}
