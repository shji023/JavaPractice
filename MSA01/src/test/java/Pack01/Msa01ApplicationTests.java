package Pack01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service("tiger")
class Tiger {
	Tiger(){}
	void f1() {
		
	}
}
@SpringBootTest
class Msa01ApplicationTests{
	@Autowired // 객체가 있으면 자동주입
	Tiger t;
	// Tiger t = new Tiger(); >> new로 생성한 객체는 스프링이 관리 안함
	@Test
	void test01() {
		System.out.println("start");
		System.out.println(t.hashCode());
		t.f1();
	}
	
}
