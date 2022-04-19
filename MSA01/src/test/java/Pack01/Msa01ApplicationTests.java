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
// Multiplication
// RandomGeneratorService
// RandomGeneratorServiceImpl
// MultiplicationService
// MultiplicationServiceImpl
class  Multiplication {
	int factorA, factorB;
	int result;
	Multiplication(int factorA, int factorB){
		this.factorA = factorA;
		this.factorB = factorB;
		this.result = factorA*factorB;
	}
	int getFactorA() {return factorA;}
	int getFactorB() {return factorB;}
	int getResult() {return result;}
	@Override
	public String toString() {
		return "Multiplication [factorA=" + factorA + ", factorB=" + factorB + ", result=" + result + "]";
	}
}
// ex) B
interface RandomGeneratorService{
	int generateRandomFactor();
}
@Service
class RandomGeneratorServiceImpl implements RandomGeneratorService{
	@Override
	public int generateRandomFactor() {
//		int a = 10; 최솟값
//		int b = 20; 최댓값
//		return new Random().nextInt(b-a+1)+10; 최솟값과 최댓값 사이에서 랜덤하게 추출
		return new Random().nextInt(100);
	}
}

// ex) C
interface MultiplicationService{
	Multiplication createRandomMultiplication();
}
@Service
class MultiplicationServiceImpl implements MultiplicationService{
	@Autowired
	RandomGeneratorService randomGeneratorService;
	
//	@Autowired
//	MultiplicationServiceImpl (RandomGeneratorService randomGeneratorService){
//		this.randomGeneratorService = randomGeneratorService;
//	}
	@Override
	public Multiplication createRandomMultiplication() {
		int factorA = randomGeneratorService.generateRandomFactor();
		int factorB = randomGeneratorService.generateRandomFactor();
		return new Multiplication(factorA, factorB);
	}
}

interface AAA {
	int getRandomNum();
}
interface BBB {
	int get();
}
@Service
class BBBImpl implements BBB {
	@Autowired
	AAA aaa;
	
	public int get() {
		System.out.println(aaa.getRandomNum());
		System.out.println(aaa.getRandomNum());
		System.out.println(aaa.getRandomNum());
		System.out.println(aaa.getRandomNum());
		return aaa.getRandomNum();
	}
}
@SpringBootTest
class Msa01ApplicationTests{
//	@MockBean
//	RandomGeneratorService randomGeneratorService;
	
	@Autowired
	MultiplicationServiceImpl multiplicationServiceImpl;
	
	@ MockBean
	AAA aaa;
	
	@Autowired
	BBB bbb;
	@Test
	void test01() {
//		Multiplication m = multiplicationServiceImpl.createRandomMultiplication();
//		System.out.println(m.toString());
		// 랜덤한 2개의 숫자를 뽑는다. 
		given(aaa.getRandomNum()).willReturn(10, 20, 30, 40);
		bbb.get();
		System.out.println("end");
		// 1. 회사에서 시험 문제를 출제한다.
		// 2. 시험문제는 램덤한 2개의 숫자이다.
		// 3. 2개의 숫자를 사용자가 곱한다.
		// 4. 곱한 결과를 회사에 다시 제출한다.
		// 5. 제출된 결과를 채점한다.
		// 6. 채점결과를 사용자에게 다시 돌려준다.
	}
}



// @Service
// @Component
// @Controller
// @Repository
