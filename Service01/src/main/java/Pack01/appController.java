package Pack01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/app")
public class appController {
	// href="app/1000"
	@GetMapping("/{appNum}")
	public String f1(@PathVariable String appNum) {
		System.out.println(appNum);
		RestTemplate rt = new RestTemplate();
		String str = rt.getForObject(
				"http://localhost:8082/bpp/2000",
				String.class
			);
		return "appController : "+appNum+"<br/>"+str;
	}
}
