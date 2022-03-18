package Pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

// @Component은 mapping과 짝을 지을 수 없음
//	1. @Controller >> request mapping annotation을 곧 쓰겠다
//  2. @Service >>
//  3. @Repository
@Controller // mapping쓰러면 @Component말고 Controller로
public class Tiger {
   //default 경로
   @RequestMapping("/")
   public String f0() {
      System.out.println("곧 index.jsp 실행");
      return "index";
   }
   @RequestMapping("t1")
   public String f1() {
	   System.out.println("곧 TigerView.jsp");
	   return "TigerView";
   }
   @RequestMapping("t2")
   public String f2(@RequestParam(value="name") String name) {
	   System.out.println(name);
	   return "TigerView";
   }
   @RequestMapping("t3/{num}")
   public String f3(@PathVariable String num) {
	   System.out.println(num);
	   return "TigerView";
   }
}
// @RestController:  @Controller + @ResponseBody
//@Controller
//@ResponseBody
@RestController
@RequestMapping("t4")
class Lion {
	@RequestMapping("")
	public String f4() {
		System.out.println("@Con+@Resp");
		return "무궁화꽃이피었습니다"; // 문자열 아니면 객체
	}
	// @RequestMapping("/{num}")
	@GetMapping("/{num}")
	public String f5(@PathVariable String num) {
		System.out.println("@Con+@Resp");
		return "무궁화:"+num; // 문자열 아니면 객체
	}
	@GetMapping("t5/{num}")
	public String f6(@PathVariable String num) {
		System.out.println("@Con+@Resp");
		return "민들레:"+num; // 문자열 아니면 객체
	}
}

interface Apple{
	void f1();
}
//-> @Component 붙인것. 다른곳에서 자동주입되고 있는 것을 간접적으로 알림
// GetBean의 대상이 아님. 어디선가 나를 Autowired하고있음
@Service 
// @Component -> 객체 생성됨
// apple인터페이스를 상속받아서 구현한 클래스다 
class AppleImpl implements Apple{
	@Override
	public void f1() {
		System.out.println("call");
	}
}
@Controller
class Fruit{
	@Autowired //자동주입이 될 것 같은데 될 수가 없음 AppleImpl는 객체를 생성한 적이없음 -> 객체를 생성시키면됨
	Apple apple = null;
	@RequestMapping("t6")
	public String f2() {
		apple.f1();
		return "TigerView";
	}
}