package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Tiger {
	@RequestMapping("/")
	public String f0() {
		System.out.println("메인화면");
		
		return "index";
	}
	
	@RequestMapping("/t1")
	public String f1() {
		System.out.println("f1 call");
		
		return "TigerView";
//		return "redirect:/"; t1이 호출되어도 메인화면에 남아있고 싶을 때.
	}
}

@RestController
class AppController {
	@RequestMapping("/app/{num}")
	public String f1(@PathVariable String num) {
		System.out.println("AppRecv");
		try { Thread.sleep(Integer.parseInt(num)); } catch (Exception e) { e.printStackTrace(); }
		System.out.println(num);
		return num;
	}
}