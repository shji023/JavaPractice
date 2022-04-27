package Pack01;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class controller {
	@RequestMapping("/")
	public String f0() {
		// System.out.println("f0 call");
		return "index";
	}
	
	@Autowired
	RabbitTemplate template;
	 
	static int count = 0;
	@RequestMapping("/t1")
	public String f1() {
		System.out.println("f1 call");
		String msg = "ㄲ"+count++;
		template.convertAndSend("helloQueue", msg);
		// return "controllerView";
		return "redirect:/";
	}
}
