package Pack01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

@RestController
class AppController {
	@RequestMapping("/app")
	public String f1() {
		System.out.println("f1");
		RestTemplate restTemplate = new RestTemplate();
		String str = restTemplate.getForObject(
			"http://localhost:8082/bpp", String.class);
		
		return "Test01 : " + str;
	}
}

@FeignClient(name="tiger", url="http://localhost:8082")
interface TestClient {
	@RequestMapping("/bpp2")
	String myfunc();
}
@RestController
class AppController2 {
	@Autowired
	TestClient testClient;
	
	@RequestMapping("/app2")
	public String f1() {
		System.out.println("f2");
		String str = testClient.myfunc();
		
		return "Test01 : "+str;
	}
}

@FeignClient(name="tiger2", url="http://localhost:8082")
interface TestClient2 {
	@RequestMapping("/bpp2")
	String myfunc();
}
@Service
class TestService{
	@Autowired
	TestClient testClient;
	
	String myfunc() {
		String str = testClient.myfunc();
		return str;
	};
}
@RestController
class AppController3 {
	@Autowired
	TestService testService;
	@RequestMapping("/app3")
	public String f1() {
		System.out.println("f2");
		String str = testService.myfunc();
		
		return "Test01 : "+ str;
	}
}