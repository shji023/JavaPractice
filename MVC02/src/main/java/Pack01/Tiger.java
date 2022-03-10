package Pack01;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	// t7, 클라이언트에서 값 전달
	String func07(Model model,
			@RequestParam(value="name")String name,
			@RequestParam(value="age")String age) {
		System.out.println("func07 call");
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		return "TigerView";
	}
	
	@RequestMapping("/t8")
	// t8
	ModelAndView func08() {
		System.out.println("func08 call");
		String s = null;
		if (true) {
			s = "TigerView";
		} else  {
			s = "LionView";
		}
		ModelAndView mv = new ModelAndView(s);
		mv.addObject("name", "앵무새");
		mv.addObject("age", 400);
		return mv;
	}
	
	@RequestMapping("/t10")
	// t10
	String func10(Person person) {
		// 속성이 10개를 보냈다고 했을 때 
		// 10개를 객체로 한꺼번에 받으려고 한다
		// DTO(커맨드 객체)
		// VO클래스가 있어야함 -> DTO가공하기 위해
		// VO >> Entity
		System.out.println("func10 call");
		System.out.println(person.getId());
		System.out.println(person.getPwd());
		return "TigerView";
	}
	@RequestMapping("/t11")
	// t11
	String func11(Model model) {
		int num = 10;
		// 1. 정수
		model.addAttribute("num", num);
		
		// 2. String
		String str = "문자열";
		model.addAttribute("str", str);
		
		// 3. Array 전달
		int[] ar = {10, 20, 30};
		model.addAttribute("ar", ar);
		
		// 4. 객체 전송
		//Person person = new Person();
		//person.setId("소나무");
		//person.setPwd(1234);
		//model.addAttribute("person", person);
		
		// 5. Collection 전송(Int)
		LinkedList<Integer> list01 = new LinkedList<Integer>();
		list01.add(40);
		list01.add(50);
		list01.add(60);
		model.addAttribute("list01", list01);
		
		// 6. Collection 전송(String)
		LinkedList<String> list02 = new LinkedList<String>();
		list02.add("독수리0");
		list02.add("독수리1");
		list02.add("독수리2");
		model.addAttribute("list02", list02);
		
		// 7. Collection 전송(객체)
		LinkedList<Person> list03 = new LinkedList<Person>();
		list03.add(new Person("독수리3", 10));
		list03.add(new Person("독수리4", 20));
		list03.add(new Person("독수리5", 30));
		model.addAttribute("list03", list03);
		return "LionView";
		
	}
}