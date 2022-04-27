package Pack01;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
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
class Tut1Receiver1{
	@RabbitListener(
			// exchange 설정, Queue 설정, key는 설정안함
			bindings = @QueueBinding(
			exchange = @Exchange(value = "ex01", type = ExchangeTypes.DIRECT),
			value = @Queue(value = "queue02"),
			key = "black"
			)
	)
	// public void receive(String in) {
	public void receive(String in) {
		System.out.println(in);
	}
}

@Component
class Tut1Receiver2{
	@RabbitListener(
			// exchange 설정, Queue 설정, key는 설정안함
			bindings = @QueueBinding(
			exchange = @Exchange(value = "ex01", type = ExchangeTypes.DIRECT),
			value = @Queue(value = "queue02"),
			key = "info"
			)
	)
	// public void receive(String in) {
	public void receive(String in) {
		System.out.println(in);
	}
}
@Component
class Tut1Receiver3{
	@RabbitListener(
			// exchange 설정, Queue 설정, key는 설정안함
			bindings = @QueueBinding(
			exchange = @Exchange(value = "ex01", type = ExchangeTypes.DIRECT),
			value = @Queue(value = "queue02"),
			key = "warning"
			)
	)
	// public void receive(String in) {
	public void receive(String in) {
		System.out.println(in);
	}
}
//@Component
//class Tut1Receiver2{
//	@RabbitListener(
//			// exchange 설정, Queue 설정, key는 설정안함
//			bindings = @QueueBinding(
//			exchange = @Exchange(value = "ex01", type = ExchangeTypes.DIRECT),
//			value = @Queue(value = "queue02"),
//			key = "green"
//			)
//	)
//	// public void receive(String in) {
//	public void receive(String in) {
//		System.out.println(in);
//	}
//}

//@Component
//class Tut1Receiver{
//	@RabbitListener(
//			// exchange 설정, Queue 설정, key는 설정안함
//			bindings = @QueueBinding(
//			exchange = @Exchange(value = "ex01", type = ExchangeTypes.FANOUT),
//			value = @Queue(value = "queue01") 
//			)
//	)
//	// public void receive(String in) {
//	public void receive(String in) {
//		System.out.println(in);
//	}
//}
