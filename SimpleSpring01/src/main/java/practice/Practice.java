package practice;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

// 1. 스프링없이 주입시키는 방법(생성자 주입)
class Apple {
	void f1() {
		System.out.println("f1 call");
	}
}
class Orange {
	Apple apple;
	Orange (Apple apple) {
		this.apple = apple;
	}
	void f2() {
		apple.f1();
	}
}

public class Practice {
	public static void main(String[] args) {
		Orange o = new Orange(new Apple());
		o.f2();
	}
}

// 2. 스프링없이 주입시키는 방법(수정자 주입)
class Apple {
	void f1() {
		System.out.println("f1 call");
	}
}
class Orange {
	Apple apple;
	void setApple(Apple apple) {
		this.apple = apple;
	}
	void f2() {
		apple.f1();
	}
}

public class Practice {
	public static void main(String[] args) {
		Orange o = new Orange();
		o.setApple(new Apple());
		o.f2();
	}
}

// 3. AutoWired 없이 스프링사용 주입시키는 방법(생성자 주입)
class Apple {
	void f1() {
		System.out.println("f1 call");
	}
}
class Orange {
	Apple apple;
	Orange(Apple apple) {
		this.apple = apple;
	}
	void f2() {
		apple.f1();
	}
}
@Configuration
class AppConfig {
	@Bean()
	Apple apple() {
		return new Apple();
	}
	@Bean()
	Orange orange() {
		return new Orange(apple());

	}

}
public class Practice {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Orange orange = ctx.getBean("orange", Orange.class);
		orange.f2();
	}
}

// 4. AutoWired 없이 스프링사용 주입시키는 방법(세트(수정자) 주입)
class Apple {
	void f1() {
		System.out.println("f1 call");
	}
}
class Orange {
	Apple apple;
	void setApple(Apple apple) {
		this.apple = apple;
	}
	void f2() {
		apple.f1();
	}
}
@Configuration
class AppConfig {
	@Bean()
	Apple apple() {
		return new Apple();
	}
	@Bean()
	Orange orange() {
		Orange o = new Orange();
		o.setApple(apple());
		return o;

	}

}
public class Practice {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Orange orange = ctx.getBean("orange", Orange.class);
		orange.f2();
	}
}

// 5. AutoWired사용하여 스프링으로 주입시키는 방법 (필드 주입)
class Apple {
	void f1() {
		System.out.println("f1 call");
	}
}
class Orange {
	@Autowired // Autowired 붙으면서 생성자 사라짐
	Apple apple;
	
	void f2() {
		apple.f1();
	}
}
@Configuration
class AppConfig {
	@Bean()
	Apple apple() {
		return new Apple();
	}
	@Bean()
	Orange orange() {
		return new Orange();
	}

}
public class Practice {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Orange orange = ctx.getBean("orange", Orange.class);
		orange.f2();
	}
}

// 6. AutoWired사용하여 스프링으로 주입시키는 방법 (세터 주입)
class Apple {
	void f1() {
		System.out.println("f1 call");
	}
}
class Orange {
	Apple apple;
	
	@Autowired
	void setApple(Apple apple) {
		this.apple = apple;
	}
	void f2() {
		apple.f1();
	}
}
@Configuration
class AppConfig {
	@Bean()
	Apple apple() {
		return new Apple();
	}
	@Bean()
	Orange orange() {
		return new Orange();
	}

}
public class Practice {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Orange orange = ctx.getBean("orange", Orange.class);
		orange.f2();
	}
}

// 생성자 주입에서 
class Apple {
	void f1() {
		System.out.println("f1 call");
	}
}
class Orange {
	// 한번 받은 객체는 갱신 못하도록 final
	// 한번 주입이 일어나면 이후는 불변이 원칙이다.
	// final 적극 사용 권장
	final Apple apple;
	
	Orange(Apple apple) {
		this.apple = apple;
	}
	void f2() {
		apple.f1();
	}
}
@Configuration
class AppConfig {
	@Bean()
	Apple apple() {
		return new Apple();
	}
	@Bean()
	Orange orange() {
		return new Orange(apple());
	}

}
public class Practice {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Orange orange = ctx.getBean("orange", Orange.class);
		orange.f2();
	}
}

// 세터 주입에서
class Apple {
	void f1() {
		System.out.println("--헤드라인 뉴스--"); // 객체가 있었다면 출력됨
	}
}
class Orange {
	Apple apple;
	@Autowired
	//void setApple(Apple apple) {
	// @Nullable 객체가 없다고 하더라도 호출은 함
	void setApple(@Nullable Apple apple) {
		System.out.println("호랑이");
		if(apple != null) {
			this.apple = apple; // 제어프로그램을 작성할 수 있음
		}
		this.apple = apple;
	}
	void f2() {
		if(apple != null) {
			apple.f1();
		}
		System.out.println("내일이 대통령 선거일입니다");
	}
}
@Configuration
class AppConfig {
	// apple 객체가 없을 때 세터 주입이 일어나게 하고싶은데
	// 객체가 없으면 호출을 안함
	// Autowired적어줬다고 하더라도
//	@Bean()
//	Apple apple() {
//		return new Apple();
//	}

	@Bean()
	Orange orange() {
		return new Orange();
	}

}
public class Practice {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Orange orange = ctx.getBean("orange", Orange.class);
		orange.f2();
		ctx.close();
	}
}

// 세터 주입에서
class Apple {
	void f1() {
		System.out.println("--헤드라인 뉴스--"); // 객체가 있었다면 출력됨
	}
}
class Orange {
	Apple apple;
	@Autowired
	//void setApple(Apple apple) {
	// @Nullable 객체가 없다고 하더라도 호출은 함
	void setApple(Optional<Apple> apple) {
		if(apple.isPresent()) {
			System.out.println("객체가 존재하는 경우");
			this.apple = apple.get();
		}else {
			System.out.println("객체가 존재하지 않는 경우");
			this.apple = null;
		}
		System.out.println("호랑이");
	}
	void f2() {
		if(apple != null) {
			apple.f1();
		}
		System.out.println("내일이 대통령 선거일입니다");
	}
}
@Configuration
class AppConfig {
	// apple 객체가 없을 때 세터 주입이 일어나게 하고싶은데
	// 객체가 없으면 호출을 안함
	// Autowired적어줬다고 하더라도
//	@Bean()
//	Apple apple() {
//		return new Apple();
//	}

	@Bean()
	Orange orange() {
		return new Orange();
	}

}
public class Practice {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Orange orange = ctx.getBean("orange", Orange.class);
		orange.f2();
		ctx.close();
	}
}

// Qualifier
class Apple {
	void f1() {
		System.out.println("--헤드라인 뉴스--"); // 객체가 있었다면 출력됨
	}
}
class Orange {
	@Autowired
	@Qualifier("apple01")
	Apple apple;
	
	void f2() {
		System.out.println("내일이 대통령 선거일입니다");
	}
}
// @Qualifier : 한정자
// 한정자: 사용범위를 조건이나 제한을 걸 때 사용되는 예약어
@Configuration
class AppConfig {
	// 싱글톤인데 
	// 누구를 자동주입하라고?
	// Qualifier 사용
	@Bean()
	@Qualifier("apple01")
	Apple apple01() {
		return new Apple();
	}
	@Bean()
	@Qualifier("apple02")
	Apple apple02() {
		return new Apple();
	}

	@Bean()
	Orange orange() {
		return new Orange();
	}

}
public class Practice {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Orange orange = ctx.getBean("orange", Orange.class);
		orange.f2();
		ctx.close();
	}
}

// Qualifier
class Apple {
	void f1() {
		System.out.println("Apple Call"); // 객체가 있었다면 출력됨
	}
}
class Orange extends Apple {
	@Override
	void f1() {
		System.out.println("Orange Call");
	}
}
class Kiwi {
//	Apple a1 = new Apple();
//	Apple a2 = new Orange();
	@Autowired
	// @Qualifier("apple")
	@Qualifier("orange")
	Apple apple; // Apple
				 // Orange
	void f2() {
		apple.f1();
	}
}

// @Qualifier : 한정자
// 한정자: 사용범위를 조건이나 제한을 걸 때 사용되는 예약어
@Configuration
class AppConfig {
	@Bean()
	Apple apple() {
		return new Apple();
	}
	@Bean()
	Orange orange() {
		return new Orange();
	}
	@Bean()
	Kiwi kiwi() {
		return new Kiwi();
	}
}
public class Practice {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Kiwi kiwi = ctx.getBean("kiwi", Kiwi.class);
		kiwi.f2();
		ctx.close();
	}
}

// 복습필요 
class Airplane {
	// @Autowired
	Water water;
	// 위에껄 쓸것인가 아래 것을 쓸것인가
	@Autowired
	void setWater(Water water) {
		this.water = water;
	}
//	Airplane(Water water) {
//		this.water = water;
//	}
	void fly() {
		this.water.use();
		System.out.println("날아간다.");
	}
}
class Water {
	void use() {
		System.out.println("물 사용");
	}
}

@Configuration
class AppConfig {
	// 스프링에게 객체를 생성시켜 달라라고
	@Bean
	Water water() {
		return new Water();
	}
	@Bean
	Airplane airplane() {
		return new Airplane();
	}
}
public class Practice {
	public static void main(String[] args) {
//		Airplane airplane = new Airplane(new Water());
//		airplane.fly();
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		// Water water = ctx.getBean("water", Water.class);
		// Airplane airplane = new Airplane(water);
		Airplane airplane = ctx.getBean("airplane", Airplane.class);
		// airplane.fly();
		ctx.close();
	}
}

@Component
// 객체 이름을 소문자로
class Airplane {
	// @Autowired
	Water water;
	
	void fly() {
		this.water.use();
		System.out.println("날아간다.");
	}
}

class Water {
	void use() {
		System.out.println("물 사용");
	}
}

@Configuration
@ComponentScan // @Component가 있는 곳을 찾아서 객체를 생성시킴
// 코드가 흩어질 수 있는 단점 존재
class AppConfig {
	@Bean
	Water water() {
		return new Water();
	}
	// config를 사용 못하는 상황이면 @ComponentScan 사용하기
//	@Bean
//	Airplane airplane() {
//		return new Airplane();
//	}
}
public class Practice {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Airplane airplane = ctx.getBean("airplane", Airplane.class);

		ctx.close();
	}
}

class Apple{
	void f1() {
		System.out.println(123);
	}
}
public class Practice {
	public static void main(String[] args) {
		/*		AnnotationConfigApplicationContext ctx = 
						new AnnotationConfigApplicationContext(AppConfig.class);
				ctx.close();*/
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:Context.xml");
		Apple apple = ctx.getBean("apple",Apple.class);
		apple.f1();
		ctx.close();
	}
}
