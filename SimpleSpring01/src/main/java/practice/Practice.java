package practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
