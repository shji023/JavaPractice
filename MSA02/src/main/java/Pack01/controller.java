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
	@RequestMapping("/t4_1")
	public String f41() {
		System.out.println("f41 call");
		String msg = "오렌지"+count++;
		// 보내는 쪽에서는 큐 설정을 하지 않는다.
		template.convertAndSend(
				"ex01", // exchange 설정
				"orange", // key
				msg);
		// return "controllerView";
		return "redirect:/";
	}
	@RequestMapping("/t4_2")
	public String f42() {
		System.out.println("f42 call");
		String msg = "black"+count++;
		// 보내는 쪽에서는 큐 설정을 하지 않는다.
		template.convertAndSend(
				"ex01", // exchange 설정
				"black", // key
				msg);
		// return "controllerView";
		return "redirect:/";
	}
	@RequestMapping("/t4_3")
	public String f43() {
		System.out.println("f43 call");
		String msg = "green"+count++;
		// 보내는 쪽에서는 큐 설정을 하지 않는다.
		template.convertAndSend(
				"ex01", // exchange 설정
				"green", // key
				msg);
		// return "controllerView";
		return "redirect:/";
	}
	@RequestMapping("/t4_4")
	public String f44() {
		System.out.println("f43 call");
		String msg;
		msg = "오렌지"+count++;
		template.convertAndSend(
				"ex01", 
				"orange", 
				msg);
		msg = "black"+count++;
		template.convertAndSend(
				"ex01", 
				"black",
				msg);
		msg = "green"+count++;
		template.convertAndSend(
				"ex01",
				"green", 
				msg);
		return "redirect:/";
	}
	
	@RequestMapping("/t5")
	public String f5() {
		System.out.println("f43 call");
		String msg = "블랙"+count++;
		// 보내는 쪽에서는 큐 설정을 하지 않는다.
		template.convertAndSend(
				"ex01", // exchange 설정
				"black", // key
				msg);
		// return "controllerView";
		return "redirect:/";
	}
	@RequestMapping("/t6_1")
	public String f61() {
		System.out.println("f61 call");
		String msg = "error"+count++;
		// 보내는 쪽에서는 큐 설정을 하지 않는다.
		template.convertAndSend(
				"ex01", // exchange 설정
				"error", // key
				msg);
		// return "controllerView";
		return "redirect:/";
	}
	@RequestMapping("/t6_2")
	public String f62() {
		System.out.println("f62 call");
		String msg = "info"+count++;
		// 보내는 쪽에서는 큐 설정을 하지 않는다.
		template.convertAndSend(
				"ex01", // exchange 설정
				"info", // key
				msg);
		// return "controllerView";
		return "redirect:/";
	}
	@RequestMapping("/t6_3")
	public String f63() {
		System.out.println("f63 call");
		String msg = "warning"+count++;
		// 보내는 쪽에서는 큐 설정을 하지 않는다.
		template.convertAndSend(
				"ex01", // exchange 설정
				"warning", // key
				msg);
		// return "controllerView";
		return "redirect:/";
	}
}
