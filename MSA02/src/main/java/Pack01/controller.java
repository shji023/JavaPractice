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
	
	@RequestMapping("/t2")
	public String f2() {
		System.out.println("f2 call");
		String msg = "ㄲ"+count++;
		template.convertAndSend("helloQueue", msg);
		// return "controllerView";
		return "redirect:/";
	}
	
	@RequestMapping("/t3")
	public String f3() {
		System.out.println("f3 call");
		String msg = "ㄲ"+count++;
		// 보내는 쪽에서는 큐 설정을 하지 않는다.
		template.convertAndSend(
				"ex01", // exchange 설정
				"", // key
				msg);
		// return "controllerView";
		return "redirect:/";
	}
}
