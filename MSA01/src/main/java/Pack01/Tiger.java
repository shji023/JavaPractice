package Pack01;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.*;

//@Controller
//public class Tiger {
//	@RequestMapping("/t1")
//	String f1() {
//		System.out.println("들어옴");
//		return "TigerView";
//	}
//}
@RequiredArgsConstructor
@Getter
@ToString
class Multiplication {
	final int factorA;
	final int factorB;
	Multiplication(){
		this(0,0);
	}
}
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
class User {
	String alias;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
class MultiplicationResultAttempt {
	private User user;
	Multiplication multiplication;
	int resultAttempt;
}
//interface MultiplicationService {
//	Multiplication createRandomMultiplication();
//}
@Service
class MultiplicationServiceImpl {
	public Multiplication createRandomMultiplication() {
		Random rnd = new Random();
		int factorA = rnd.nextInt(10);
		int factorB = rnd.nextInt(10);
		return new Multiplication(factorA,factorB);
	}
	// 채점 서비스
	boolean checkAttempt(final MultiplicationResultAttempt mra) {
		return mra.getResultAttempt()==
				mra.getMultiplication().getFactorA()*
				mra.getMultiplication().getFactorB();
 	}
}
// 문제 출제서비스
@RestController
public class Tiger {
	@Autowired
	MultiplicationServiceImpl ms;
	
	@RequestMapping("/t1")
	Multiplication f1() {
		System.out.println("들어옴");
//		Multiplication m =ms.createRandomMultiplication();
//		System.out.println(m.getFactorA());
//		System.out.println(m.getFactorB());
		//return new Multiplication(3, 4);
		return ms.createRandomMultiplication();
	}
	
	@RequestMapping("/t2")
	boolean f2(@RequestBody MultiplicationResultAttempt mra) {
		System.out.println(mra);//Pack01.MultiplicationResultAttempt@bcf30dd9
		System.out.println(mra.getUser().getAlias());// tiger
		System.out.println(mra.multiplication.factorA); //0
		System.out.println(mra.multiplication.factorB); //0
		System.out.println(mra.resultAttempt); //200
		System.out.println(" f2들어옴");
		// return true;
		return ms.checkAttempt(mra);
	}
}
