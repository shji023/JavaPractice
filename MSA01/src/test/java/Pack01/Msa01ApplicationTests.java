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
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
class Tiger {
	String name;
	int age;
//	@Override
//	public String toString() {
//		return "Tiger [name=" + name + ", age=" + age + "]";
//	}
	
}
@SpringBootTest
class Msa01ApplicationTests{
	@Test
	void test01() {
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger("호랑이",10);
		System.out.println(t1.toString());
		System.out.println(t2.toString());
	}
}

	

