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
@RequiredArgsConstructor // 변수자체가 final이라는 말
class Tiger {
	final String name;
	final int age;
}
@SpringBootTest
class Msa01ApplicationTests{
	@Test
	void test01() {
		Tiger t2 = new Tiger("호랑이",10);
		System.out.println(t2.toString());
	}
}

	

