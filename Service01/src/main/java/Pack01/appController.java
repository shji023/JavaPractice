package Pack01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.*;


@RestController
@RequestMapping("/t1")
public class appController {
	// href="app/1000"
	@GetMapping("/{num}")
	public String f1(@PathVariable String num) {
		System.out.println(num);
		RestTemplate rt = new RestTemplate();
		Integer data = rt.getForObject(
				"http://localhost:8082/s1/2000",
				Integer.class
			);
		return "appController : "+"<br/>"+data;
	}
}

@RestController
@RequestMapping("/t2")
class appController2 {
	// href="app/1000"
	@GetMapping("/{num}")
	public String f1(@PathVariable String num) {
		System.out.println(num);
		RestTemplate rt = new RestTemplate();
		String data = rt.getForObject(
				"http://localhost:8082/s2/2000",
				String.class
			);
		return "appController : "+"<br/>"+data;
	}
}
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
class People{
	String name;
	int age; 
}
@RestController
@RequestMapping("/t3")
class appController3 {
	// href="app/1000"
	@GetMapping("/{num}")
	public String f1(@PathVariable String num) {
		System.out.println(num);
		RestTemplate rt = new RestTemplate();
		People data = rt.getForObject(
				"http://localhost:8082/s3/2000",
				People.class
			);
		return "appController : "+"<br/>"+data.getName()+data.getAge();
	}
}