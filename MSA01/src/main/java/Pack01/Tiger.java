package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//public class Tiger {
//	@RequestMapping("/t1")
//	String f1() {
//		System.out.println("들어옴");
//		return "TigerView";
//	}
//}


@RestController
public class Tiger {
	@RequestMapping("/t1")
	String f1() {
		System.out.println("들어옴");
		return "호랑이";
	}
}
