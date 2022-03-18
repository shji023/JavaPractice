package Pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
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

@Controller
@ResponseBody
@RequestMapping("t4")
class Lion {
	@RequestMapping("")
	public String f4() {
		System.out.println("@Con+@Resp");
		return "무궁화꽃이피었습니다"; // 문자열 아니면 객체
	}
}