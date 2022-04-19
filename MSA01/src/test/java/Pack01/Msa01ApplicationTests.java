package Pack01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service("tiger")
class Tiger {
	Tiger(){
		System.out.println("생성자 콜");
	}
	void f1() {
		System.out.println("f1 콜");
	}
}
@SpringBootTest
class Msa01ApplicationTests implements ApplicationContextAware{
	ApplicationContext applicationContext;
	public void setApplicationContext(
			ApplicationContext applicationContext)
					throws BeansException{
		System.out.println("setApplicationContext");
		this.applicationContext = applicationContext;
	}
	
	@Test
	void test01() {
		System.out.println(100);
		try {
		Tiger t = applicationContext.getBean("tiger",Tiger.class);
		System.out.println(t.hashCode());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
