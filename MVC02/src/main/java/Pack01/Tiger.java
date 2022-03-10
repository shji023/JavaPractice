package Pack01;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Tiger {
	@RequestMapping("/t1")
	// t1
	String func01() {
		System.out.println("호랑이1");
		return "TigerView";
	}
	
	@RequestMapping("/t2")
	// t2
	String func02() {
		System.out.println("호랑이2");
		return "TigerView";
	}
	
	//@RequestParam(value="name"): 클라이언트에서 name이라는 이름으로 전송된다.
	@RequestMapping("/t3")
	// t3, 함수의 인수 전달로 받음
	String func03(@RequestParam(value="name")String name) {
		System.out.println("f3 call");
		System.out.println(name);
		return "TigerView";
	}
	
	// 2개 이상 인수 전달 시 콤마 이용
	@RequestMapping("/t4")
	// t4, 함수의 인수 전달로 받음
	String func04(@RequestParam(value="name")String name,
			@RequestParam(value="age")String age) {
		System.out.println("f4 call");
		System.out.println(name+" "+age);
		return "TigerView";
	}
	
	@RequestMapping("/t5")
	// t5, 서블릿 객체 이용해 인수 전달로 받음
	String func05(HttpServletRequest request) {
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println("f5 call");
		System.out.println(name+" "+age);
		return "TigerView";
	}
	@RequestMapping("/t6")
	// t6, 스프링이 던져주는 객체
	String func06(Model model) {
		System.out.println("func06 call");
		model.addAttribute("name","독수리");
		model.addAttribute("age",200);
		return "TigerView";
	}
	
	@RequestMapping("/t7")
	// t6, 클라이언트에서 값 전달
	String func07(Model model,
			@RequestParam(value="name")String name,
			@RequestParam(value="age")String age) {
		System.out.println("func07 call");
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "TigerView";
	}
}
