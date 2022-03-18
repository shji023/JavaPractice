package Pack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Tiger {
   //default 경로
   @RequestMapping("/")
   public String f0() {
      System.out.println("곧 index.jsp 실행");
      return "index";
   }
}