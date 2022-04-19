package Pack01;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
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
@SpringBootTest
class Msa01ApplicationTests{
	@Test
	void test01() {
		Multiplication m = new Multiplication(3, 4);
		System.out.println(m.toString());
	}
}



// @Service
// @Component
// @Controller
// @Repository
