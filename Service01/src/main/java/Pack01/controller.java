package Pack01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController 
public class controller {
//	@RequestMapping("/")
//	public String f0() {
//		System.out.println("f0 call");
//		return "index";
//	}
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Autowired
	RestTemplate restTemplate;
	
	
	@RequestMapping("/a1")
	public String f1() {
		System.out.println("f1 call");
		
		String str = restTemplate.getForObject(
				"http://localhost:8082/a2",
				String.class
				);
		System.out.println(str);
		//return "controllerView";
//		 return "redirect:/";
		return str;
	} 
}

