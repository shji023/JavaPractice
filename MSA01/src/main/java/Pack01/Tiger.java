package Pack01;

import org.springframework.stereotype.Controller;
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
	User user;
	Multiplication multiplication;
	int resultAttempt;
}
@RestController
public class Tiger {
	@RequestMapping("/t1")
	Multiplication f1() {
		System.out.println("들어옴");
		return new Multiplication(3, 4);
	}
	
	@RequestMapping("/t2")
	boolean f2(@RequestBody MultiplicationResultAttempt mra) {
		System.out.println(mra);//Pack01.MultiplicationResultAttempt@bcf30dd9
		System.out.println(mra.user.alias);// tiger
		System.out.println(mra.multiplication.factorA); //0
		System.out.println(mra.multiplication.factorB); //0
		System.out.println(mra.resultAttempt); //200
		System.out.println(" f2들어옴");
		return true;
	}
}
