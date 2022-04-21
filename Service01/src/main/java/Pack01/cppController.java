package Pack01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
class Person{
	String name;
	int age;
}

@RestController
@RequestMapping("/cpp")
public class cppController {
	// href="app/1000"
	@GetMapping("/{cppNum}")
	public String f1(@PathVariable String cppNum) {
		System.out.println(cppNum);
		RestTemplate rt = new RestTemplate();
		Person person = rt.getForObject(
				"http://localhost:8082/dpp/2000",
				Person.class
			);
		return "cppController : "+"<br/>"+person.getName()+person.getAge();
	}
}
