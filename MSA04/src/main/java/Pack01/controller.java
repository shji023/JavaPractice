package Pack01;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// import확인 필요 AMQP들어가있으면 안됨
import com.rabbitmq.client.Channel;

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
	// public void receive(String in) {
	public void receive(String in, 
			Channel channel, 
			Message msg) {
		System.out.println(channel.toString());
		try {Thread.sleep(5000);}catch(Exception e) {}
		System.out.println(in);
		long tag = msg.getMessageProperties().getDeliveryTag();
		// 작업이 완료되었음을 Rabbit에게 알림.
		try {
			channel.basicAck(tag, false);	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
