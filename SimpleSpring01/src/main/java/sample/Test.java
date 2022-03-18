package sample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

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

// 트랜잭션 
// 준비하세요 -> 변경되지 않는 공퉁 코드
// 저장 -> 변동되는 부분에 끼워넣는 것. 관심의 대상(AOP, Aspect O P)
// 완료되었습니다. -> 변경되지 않는 공퉁 코드
//ex08)
class Tiger{
	void f1() {
		System.out.println("start"); // 변경되지 않는 공퉁 코드 (advice)
		//System.out.println("아침먹자"); // 핵심 코드 (JoinPoint)
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

//ex09) AOP
interface Fruits {
	void taste();
}

class Apple implements Fruits {
	public void taste() {
		System.out.println("Good");
	}
}

class Orange implements Fruits {
	public void taste() {
		System.out.println("Bad");
	}
}

@Configuration
class AppConfig {
}

public class Test {
	public static void main(String[] args) {
		Fruits f1 = new Apple();
		// 과일 맛 프록시
		System.out.println("start"); //공통코드
		f1.taste(); // 핵심 코드
		System.out.println("end"); //공통코드
		System.out.println("---------------------"); //공통코드
		
		Fruits f2 = new Orange();
		System.out.println("start"); //공통코드
		f2.taste(); // 핵심 코드
		System.out.println("end"); //공통코드
		System.out.println("---------------------"); //공통코드
	}
}

// ----------------------------------------입출금 프록시
// 로그인-> 공통 코드
// 보안 설정
// 공인인증서
// 입금, 송금, 이체
// 로그아웃
// -----------------------------------------
// System.out.println("end");
// System.out.println("-------------------------")


//----------------------------------------실행시간 측정 프록시
// a = 현재시간                   >> 공통코드
// 선택정렬, 버블정렬, 퀵정렬, 합병 정렬 >> 핵심 코드
// b = 현재시간                   >> 공통코드
// c = b - a;                  >> 공통코드
//-----------------------------------------
//System.out.println("end");
//System.out.println("-------------------------")

// 웹 서버 프록시 : 공통되는 코드가 깔려있어 누구든지 웹 서버에 접속했을 때는 기본 시작과 끝은 똑같음 안에 들어가는 내용이 달라짐


//ex10) 프록시 테스트
interface Fruits {
	void taste();
}

class Apple implements Fruits {
	public void taste() {
		System.out.println("Good");
	}
}

class Orange implements Fruits {
	public void taste() {
		System.out.println("Bad");
	}
}

class ProxyTest {
	Fruits fruit;
	public ProxyTest(Fruits fruit) {
		this.fruit = fruit;
	}
	void common() {
		System.out.println("start"); //공통코드
		fruit.taste(); // 핵심 코드
		System.out.println("end"); //공통코드
		System.out.println("---------------------"); //공통코드
	}
}

public class Test {
	public static void main(String[] args) {
		ProxyTest t1 = new ProxyTest(new Apple());
		t1.common();
		ProxyTest t2 = new ProxyTest(new Orange());
		t2.common();
	}
}

//ex10) 프록시 테스트 스프링1
interface Fruits {
	void taste();
}

class Apple implements Fruits {
	public void taste() {
		System.out.println("Good");
	}
}

class Orange implements Fruits {
	public void taste() {
		System.out.println("Bad");
	}
}

class ProxyTest {
	// 1. 주입객체 생성자 주석처리 
//	Fruits fruit;
//	public ProxyTest(Fruits fruit) {
//		this.fruit = fruit;
//	}
	
	// 2. ProceedingJoinPoint joinpoint
	void common(ProceedingJoinPoint joinpoint) {
		System.out.println("start"); 
		// fruit.taste();
		
		//3. 스프링에서 제공하는 코드로 변경
		try {
			joinpoint.proceed(); // fruit.taste() 호출한다는 말
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		System.out.println("end"); 
		System.out.println("---------------------"); 
	}
}
@Configuration
class AppConfig {
	@Bean
	Fruits apple() {
		return new Apple();
	}
	@Bean
	Fruits orange() {
		return new Orange();
	}
	// 4. 생성자 인수 전달 삭제
	@Bean
	ProxyTest proxtTest() {
		return new ProxyTest();
		// return new ProxyTest(apple());
	}
	// 4. 생성자 인수 전달 삭제
	@Bean
	ProxyTest proxtTest2() {
		return new ProxyTest();
		// return new ProxyTest(orange());
	}
}
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		// 5. 
//		ProxyTest t1 = ctx.getBean("proxyTest1", ProxyTest.class);
//		ProxyTest t2 = ctx.getBean("proxyTest2", ProxyTest.class);
//		t1.common();
//		t2.common();
		ctx.close();
	}
}

//ex10) 프록시 테스트 스프링2
interface Fruits {
	void taste();
}

class Apple implements Fruits {
	public void taste() {
		System.out.println("Good");
	}
}

class Orange implements Fruits {
	public void taste() {
		System.out.println("Bad");
	}
}
//1. @Aspect 추가
@Aspect
class ProxyTest {
	// @Around 설정
	// 관심 함수가 인수로 전달 되는데
	// 그 함수의 원형이 어떻게 생겼는지를 정의해주는 annotation 설정 해야 한다.
	@Around("execution(public void sample.Apple.taste(..))") // 인수전달이 없다고 생각하면됨
	void common(ProceedingJoinPoint joinpoint) {
		System.out.println("start");
		try {
			joinpoint.proceed(); 
		} catch (Throwable e) {
			e.printStackTrace();
		} 
		System.out.println("end"); 
		System.out.println("---------------------"); 
	}
}
// 3.
@Configuration
@EnableAspectJAutoProxy
class AppConfig {
	@Bean
	Fruits apple() {
		return new Apple();
	}
	@Bean
	Fruits orange() {
		return new Orange();
	}
	@Bean
	ProxyTest proxtTest() {
		return new ProxyTest();
	}
	// 4. 주석
//	@Bean
//	ProxyTest proxtTest2() {
//		return new ProxyTest();
//	}
}
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Fruits apple = ctx.getBean("apple",Fruits.class); // 얘를 조인포인트에 넣어준다. 프록시의 관심코드라고 보고 관심코드에 주입.
		apple.taste();
		ctx.close();
	}
}

//ex10) 프록시 테스트 스프링3
interface Fruits {
	void taste();
}

class Apple implements Fruits {
	public void taste() {
		System.out.println("Good");
	}
}

class Orange implements Fruits {
	public void taste() {
		System.out.println("Bad");
	}
}
@Aspect
class ProxyTest {
	@Pointcut("execution(public void sample.*.taste(..))")// apple -> *
	void something() {}
	// 1. *
	@Around("something()") 
	void common(ProceedingJoinPoint joinpoint) throws Throwable{
		// try catch 수정
		joinpoint.proceed(); 
		
		System.out.println("end"); 
		System.out.println("---------------------"); 
	}
}

@Configuration
@EnableAspectJAutoProxy
class AppConfig {
	@Bean
	Fruits apple() {
		return new Apple();
	}
	@Bean
	Fruits orange() {
		return new Orange();
	}
	@Bean
	ProxyTest proxtTest() {
		return new ProxyTest();
	}
}
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Fruits apple = ctx.getBean("apple",Fruits.class); 
		apple.taste();
		Fruits orange = ctx.getBean("orange",Fruits.class);
		orange.taste();
		ctx.close();
	}
}

//ex10) 프록시 테스트 스프링4 example
interface Ai {
	void play();
}

class AlphaGo implements Ai {
	public void play() {
		System.out.println("알파고");
	}
}

class BetaGo implements Ai {
	public void play() {
		System.out.println("베타고");
	}
}
@Aspect
class ProxyBaduk {
	@Pointcut("execution(public void sample.*.*(..))")
	void something() {}
	@Around("something()") 
	void common(ProceedingJoinPoint joinpoint) throws Throwable{
		System.out.println("대국을 시작합니다.");
		joinpoint.proceed(); 
		
		System.out.println("end"); 
		System.out.println("---------------------"); 
	}
}

@Configuration
@EnableAspectJAutoProxy
class AppConfig {
	@Bean
	Ai alphaGo() {
		return new AlphaGo();
	}
	@Bean
	Ai betaGo() {
		return new BetaGo();
	}
	@Bean
	ProxyBaduk proxtTest() {
		return new ProxyBaduk();
	}
}
public class Test {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		Ai a = ctx.getBean("alphaGo", Ai.class); 
		a.play();
		Ai b = ctx.getBean("betaGo",Ai.class);
		b.play();
		ctx.close();
	}
}
*/