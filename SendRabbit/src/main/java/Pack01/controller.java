package Pack01;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;

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
	@Autowired
	RabbitTemplate rabbitTemplate;
	static int count = 0;
	@RequestMapping("/t2")
	public String f2() {
		System.out.println("f2 call");
		System.out.println(rabbitTemplate);
		String str = "호랑이" +  count++;
		rabbitTemplate.convertAndSend(
				"exchange01",
				"routingKey01", // 주는놈의 키
				str
				);
		// return "controllerView";
		return "redirect:/";
	}
	
	@RequestMapping("/t3")
	   public String f3() {
	      System.out.println("f3 call");
	      Person person = new Person("호랑이", 10);
	      rabbitTemplate.convertAndSend(
	            "exchange01",
	            "routingKey02",
	            person
	      );
	      
	      //컨트롤러로 전달하고 싶을 때
	      return "redirect:/";
	   }

}
// getter, setter, allargs, noargs, toString
@Data
class Person{
   final String name;
   final int age;
}
