package Pack01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
