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
import static org.mockito.BDDMockito.*;

// 곱셈 문제지
class Multiple {
	int factorA, factorB;
	int result;
	Multiple(int factorA, int factorB){
		this.factorA = 1;
		this.factorB = 2;
		this.result = this.factorA*this.factorB;
	}
	void show() {
		System.out.println("factorA:"+factorA);
		System.out.println("factorB:"+factorB);
		System.out.println("result:"+result);
	}
}
interface RandomGenService {
	int getGenRandom();
}
// 난수 생성 서비스
class RandomGenServiceImpl implements RandomGenService{
	public int getGenRandom() {
		return new Random().nextInt(10);
	}
	
}
interface MultipleService{
	Multiple getMultiple();
}
// 곱셈 생성 서비스
class MultipleServiceImpl implements MultipleService {
	public Multiple getMultiple() {
		RandomGenService rnd = new RandomGenServiceImpl();
		int a = rnd.getGenRandom();
		int b = rnd.getGenRandom();
		a = 3;
		b = 4;
		return new Multiple(a, b);
	}
}
@SpringBootTest
class Msa01ApplicationTests{
	@Test
	void test01() {
		MultipleService multipleService = new MultipleServiceImpl();
		Multiple multiple = multipleService.getMultiple();
		multiple.show();
	}
}

