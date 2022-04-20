package Pack01;

import org.springframework.stereotype.Controller;
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
@RestController
public class Tiger {
	@RequestMapping("/t1")
	Multiplication f1() {
		System.out.println("들어옴");
		return new Multiplication(3, 4);
	}
	
	@RequestMapping("/t2")
	boolean f2() {
		System.out.println(" f2들어옴");
		return true;
	}
}
