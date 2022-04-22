package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class controller {
//	@RequestMapping("/")
//	public String f0() {
//		System.out.println("f0 call");
//		return "index"; 
//	}
	@RequestMapping("/t1")
	public String f1() {
		System.out.println("f1 call");
		
//		return "controllerView";
		 return "redirect:/";
	}
	@RequestMapping("/a2")
	public String f2() {
		System.out.println("a2 call");
		
		return "controllerView";
//		 return "redirect:/";
	}
}

