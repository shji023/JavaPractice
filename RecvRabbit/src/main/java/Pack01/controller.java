package Pack01;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.core.ExchangeTypes;

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
class RecvModule{
	@RabbitListener(
		bindings = @QueueBinding(
				exchange = @Exchange(name="exchange01",type=ExchangeTypes.TOPIC),
				value=@Queue(name="queue01"), // 받는키
				key="routingKey01")			  // 주는키
		)
	public void receiver(String msg) {
		System.out.println(msg);
	}
			
}
