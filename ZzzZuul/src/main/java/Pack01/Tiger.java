package Pack01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
