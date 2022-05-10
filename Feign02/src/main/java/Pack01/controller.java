package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller 
public class controller {
	@RequestMapping("/")
	public String f0() {
		System.out.println("f0 call");
		
		return "index";
	}
	@RequestMapping("/t1")
	public String f1() {
		System.out.println("f1 call");
		
		return "controllerView";
		// return "redirect:/";
	}
}

@RestController
class AppController {
	@RequestMapping("/bpp")
	public String f1() {
		System.out.println("bpp");
		return "Test02 : ";
	}
}

@RestController
class AppController2 {
	@RequestMapping("/bpp2")
	public String f1() {
		System.out.println("bpp");
		return "Test02 : ";
	}
}