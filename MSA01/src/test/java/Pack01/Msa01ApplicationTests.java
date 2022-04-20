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
interface RandomGenService{
	int getGenRandom();
}
class RandomGenServiceImpl implements RandomGenService{
	@Override
	public int getGenRandom() {
		return new Random().nextInt(10);
	}
}
// 곱셈 문제 생성지
interface MultipleGenService {
	Multiple getMultiple(); 
}
class MultipleGenServiceImpl implements MultipleGenService{
	@Override
	public Multiple getMultiple() {
		RandomGenServiceImpl r = new RandomGenServiceImpl();
		return new Multiple(r.getGenRandom(), r.getGenRandom());
	}
}
@SpringBootTest
class Msa01ApplicationTests{
	@Test
	void test01() {
	}
}

