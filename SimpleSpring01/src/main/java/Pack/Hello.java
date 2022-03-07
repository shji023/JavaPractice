package Pack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Apple {
	void f1() {
		System.out.println("f1 call");
	}
}

// ���������� ��ü�� ������ ȯ�漳���ϴ� Ŭ������°��� �˸���. 
@Configuration
class AppConfig {
// ����ȿ��� ��ü�� ������Ų��.
	
	// �� ��ü
	// �������� ������Ų ��ü�� ���̶�� �Ѵ�.
	// @Bean�� ������ �ȿ� �ڵ尡 ��� �� ��ü�� ��������ٰ� ����
	// �ڹ� ���Ͼȿ� public  �Ѱ��� �־���ϱ� ������ public �� ����
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
		g.setFormat("�ȳ��ϼ���");
		System.out.println(g.greet("ȣ����"));
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		// �Ʒ� �ڵ�� ���� ��ü�� �����ϴ� ��
		// Apple apple = new Apple();
		// Apple apple = ctx.getBean("apple",Apple.class);
		Apple apple = ctx.getBean(Apple.class); // �� �ڵ�� ���� �ǹ�
		apple.f1();
		System.out.println(apple.hashCode());
		
		Greeter g1 = ctx.getBean(Greeter.class);
		g1.setFormat("%s�Ļ��ϼ���");
		ctx.close();
	}

}
