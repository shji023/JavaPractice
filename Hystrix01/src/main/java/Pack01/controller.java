package Pack01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

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
@RequestMapping("/app")
class AppController{
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Autowired
	RestTemplate restTemplate;
	
	// 성공 - 실패 - 실패 : 실패확률(66%) > 50%
	// 서킷 발동의 의미 : 서비스 호출 자체를 안함. fallbackMethod함수 호출
	// 서킷 발동 8초 이후에 몇년이 지나서 1회 클릭했을 때 
	@GetMapping("/{appNum}")
	@HystrixCommand(
			fallbackMethod="tiger",
			commandProperties = {
					@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", 
							value = "500"), // 응답을 기다리는 시간 
					@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", 
						value = "25"), // 50% 이상 문제가 발생하면 스킷을 오픈
					@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", 
						value = "10000"), // 최근 10초 동안
					@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", 
						value = "3"),  // 서비스 호출이 3회 이상이면 통계 시작
					@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", 
						value = "8000") // 스킷브레이크 오픈 유지시간 
				}
			)
	public String f1(@PathVariable String appNum) {
		System.out.println(appNum);
		String result = restTemplate.getForObject(
				"http://localhost:8082/bpp/"+2000,
				String.class
		);
		
		return "AppCont : " + appNum+
				"BppCont : " + result;
	}
	public String tiger(String s, Throwable t) {
		System.out.println(t);
		return "기본 광고";
	}
}

