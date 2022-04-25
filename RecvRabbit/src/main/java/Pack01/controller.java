package Pack01;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.Data;

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

@Component
class RecvObject{
	@RabbitListener(
		bindings = @QueueBinding(
				exchange = @Exchange(name="exchange01",type=ExchangeTypes.TOPIC),
				value=@Queue(name="queue02"), // 받는키
				key="routingKey02")			  // 주는키
		)
	public void receiver(Person person) {
		System.out.println(person.toString());
	}		
}

@Data
class Person{
	String name;
	int age;
}
