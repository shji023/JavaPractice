package Pack01;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
@Component
@RabbitListener(queues="helloQueue")
class Tut1Receiver{
	@RabbitHandler
	public void receive(String in) {
		try {Thread.sleep(2000);}catch(Exception e) {}
		System.out.println(in);
	}
}
