package Pack;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Apple {

}
// ���������� ��ü�� ������ ȯ�漳���ϴ� Ŭ������°��� �˸���. 
@Configuration
class AppConfig {
// ����ȿ��� ��ü�� ������Ų��.
	
	// �� ��ü
	// �������� ������Ų ��ü�� ���̶�� �Ѵ�.
	// 
	@Bean
	Apple apple() {
		System.out.println(1000);
		return new Apple();
	}
}
public class Hello {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		ctx.close();
	}

}
