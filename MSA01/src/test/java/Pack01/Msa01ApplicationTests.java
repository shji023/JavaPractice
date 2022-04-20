package Pack01;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import lombok.*;

import static org.mockito.BDDMockito.*;

//class Tiger {
//	final String name;
//	final int age;
//	Tiger(){
//		this("",0);
//	}
//	Tiger(String name, int age){
//		this.name = name;
//		this.age = age;
//	}
//}
@RequiredArgsConstructor
class Tiger {
	final String name;
	final int age;
	Tiger(){
		this("",0);
	}
}
@SpringBootTest
class Msa01ApplicationTests{
	@Test
	void test01() {
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger("호랑이",10);
		System.out.println(t2.toString());
	}
}

	

