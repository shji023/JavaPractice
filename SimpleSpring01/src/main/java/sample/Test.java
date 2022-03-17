package sample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
// 트랜잭션 
// 준비하세요 -> 변경되지 않는 공퉁 코드
// 저장 -> 변동되는 부분에 끼워넣는 것. 관심의 대상(AOP, Aspect O P)
// 완료되었습니다. -> 변경되지 않는 공퉁 코드
//ex08)
class Tiger{
	void f1() {
		System.out.println("start"); // 변경되지 않는 공퉁 코드 (advice)
		//System.out.println("아침먹자"); // 핵심 코드
		System.out.println("점심먹자"); // 핵심 코드
		//System.out.println("저녁먹자");// 핵심 코드
		System.out.println("end"); // 공통코드 (advice)
	}
}

@Configuration
class AppConfig {
}

public class Test {
	public static void main(String[] args) {
		System.out.println(1); 
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		//System.out.println(3); // 1,2,3 출력
		System.out.println(4);
		Tiger t = ctx.getBean("tiger",Tiger.class);
		t.f1();
		System.out.println(6);
		ctx.close();
		System.out.println(8);
	}
}



/* 
// ex01)
@Configuration
class AppConfig {
	
}
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[]names = ctx.getBeanDefinitionNames();
		for(String name:names) {
			BeanDefinition bf = ctx.getBeanDefinition(name);
			if(bf.getRole()!=BeanDefinition.ROLE_INFRASTRUCTURE) {
				System.out.println(name);
			}
		}
		ctx.close();
	}
}


// ex02)
@Component
class Tiger1 {
}
@Controller
class Tiger2 {
}
@Service
class Tiger3 {
}
@Repository
class Tiger4 {
}
@Configuration
@ComponentScan(useDefaultFilters = false) // false -> 객체 생성 금지
class AppConfig {
	
}
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[]names = ctx.getBeanDefinitionNames();
		for(String name:names) {
			BeanDefinition bf = ctx.getBeanDefinition(name);
			if(bf.getRole()!=BeanDefinition.ROLE_INFRASTRUCTURE) {
				System.out.println(name); // tiger1->class이름의 소문자로 나타냄
			}
		}
		ctx.close();
	}
}

// ex03) 어노테이션은 프로그래머가 직접 만들 수 있다.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Apple{}

@Apple
class Tiger1{}
@Apple
class Tiger2{}
@Apple
class Tiger3{}

@Configuration
@ComponentScan(useDefaultFilters = false) // false -> 객체 생성 금지
class AppConfig {
	
}
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[]names = ctx.getBeanDefinitionNames();
		for(String name:names) {
			BeanDefinition bf = ctx.getBeanDefinition(name);
			if(bf.getRole()!=BeanDefinition.ROLE_INFRASTRUCTURE) {
				System.out.println(name); // tiger1->class이름의 소문자로 나타냄
			}
		}
		ctx.close();
	}
}


//ex04) 사용자 정의 어노테이션을 자동 객체 생성하고 싶다.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Apple{}

@Apple
class Tiger1{}
@Apple
class Tiger2{}
@Apple
class Tiger3{}

@Configuration
@ComponentScan(
		useDefaultFilters = false,
		includeFilters = 
			@ComponentScan.Filter(
					type = FilterType.ANNOTATION,
					classes = Apple.class))
class AppConfig {
	
}
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[]names = ctx.getBeanDefinitionNames();
		for(String name:names) {
			BeanDefinition bf = ctx.getBeanDefinition(name);
			if(bf.getRole()!=BeanDefinition.ROLE_INFRASTRUCTURE) {
				System.out.println(name); // tiger1->class이름의 소문자로 나타냄
			}
		}
		ctx.close();
	}
}

//ex05) 부모 자식 관계 있는 것들은 다 객체를 생성시켜라 
class Apple{}
class Banana extends Apple{}
class Orange extends Apple{}

// apple과 관련없는 키위는 객체 상성 안됨
class Kiwi {}
@Configuration
@ComponentScan(
	useDefaultFilters = false,
	includeFilters = 
		@ComponentScan.Filter(
			type = FilterType.ASPECTJ,
			// 1.
			//pattern="sample..*")) // sample 패키지 하위폴더 전부. * : 모든 클래스
			// 2.
			// pattern = "*..*")) // 모든 패키지 밑에 있는 모든 클래스
			// 3. 1번과 비교
			// pattern = "sample.*")) // apple, banana, orange, appConfig, kiwi
			// 4.
			// pattern = "*..animal..*")) // animal 밑에있는 모든 하위 패키지, blackLion, whiteLion, blackTiger, whiteTiger
			// 5.
			// pattern="*..animal.*"))
			// 6.
			// pattern="*..animal..lion.*")) // blackLion, whiteLion
			// 7.
			// pattern="*..Black*")) // black으로 시작하는 모든 클래스
			// 8.
			// pattern="*..*Iris")) // Iris로 끝나는 모든 클래스
			// 9.
			// pattern = "*..*o*")) //o가 들어가는 모든 것
			// 10.
			pattern = "*..Rose..*o*")) //rose안에서 o가 들어가는 모든 것
class AppConfig {}

public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		String[]names = ctx.getBeanDefinitionNames();
		for(String name:names) {
			BeanDefinition bf = ctx.getBeanDefinition(name);
			if(bf.getRole()!=BeanDefinition.ROLE_INFRASTRUCTURE) {
				System.out.println(name); // 키위는 안나옴
			}
		}
		ctx.close();
	}
}

//ex06)
class Tiger implements InitializingBean, DisposableBean{
	Tiger() {
		System.out.println(2);
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println(3);
		// 네트워크 접속
	}
	public void destroy() throws Exception {
		System.out.println(7);
		// 접속 종료..
	}
	void f1() {
		System.out.println(5);
	}
}

@Configuration
class AppConfig {
	@Bean
	Tiger tiger() {
		return new Tiger();
	}
	
	
}

public class Test {
	public static void main(String[] args) {
		System.out.println(1); 
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		//System.out.println(3); // 1,2,3 출력
		System.out.println(4);
		Tiger t = ctx.getBean("tiger",Tiger.class);
		t.f1();
		System.out.println(6);
		ctx.close();
		System.out.println(8);
	}
}

//ex07)
class Tiger{
	Tiger() {
		System.out.println(2);
	}
	public void connect() {
		System.out.println(3);
		// 네트워크 접속
	}
	public void disconnet() {
		System.out.println(7);
		// 접속 종료..
	}
	void f1() {
		System.out.println(5);
	}
}

@Configuration
class AppConfig {
	@Bean (initMethod="connect", destroyMethod="disconnect")
	Tiger tiger() {
		return new Tiger();
	}
}

public class Test {
	public static void main(String[] args) {
		System.out.println(1); 
		AnnotationConfigApplicationContext ctx=
				new AnnotationConfigApplicationContext(AppConfig.class);
		//System.out.println(3); // 1,2,3 출력
		System.out.println(4);
		Tiger t = ctx.getBean("tiger",Tiger.class);
		t.f1();
		System.out.println(6);
		ctx.close();
		System.out.println(8);
	}
}

*/