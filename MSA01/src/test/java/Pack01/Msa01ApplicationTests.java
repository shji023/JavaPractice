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
@Service
class RandomGenServiceImpl implements RandomGenService{
	public int getGenRandom() {
		return new Random().nextInt(10);
	}
}
class MultiplicationResultAttempt {
	
}
interface MultipleService {
	Multiple getMultiple(); 
	boolean checkAttempt(MultiplicationResultAttempt restultAttempt);
}
@Service
class MultipleServiceImpl implements MultipleService{
	@Autowired
	RandomGenService t;
	
	public Multiple getMultiple() {
		int a = t.getGenRandom();
		int b = t.getGenRandom();
		return new Multiple(a, b);
	}
	@Override
	public boolean checkAttempt(MultiplicationResultAttempt restultAttempt) {
		return false;
	}
}

@RequiredArgsConstructor
@ToString
@Getter
class User{
	final String alias;
	User(){
		// this(null);
		alias = "익명";
	}
}
@SpringBootTest
class Msa01ApplicationTests{
	@Test
	void test01() {
		User user1 = new User("호랑이");
		User user2 = new User("호랑이");
		System.out.println(user1.toString());
		System.out.println(user1.getAlias());
	}
}

	

