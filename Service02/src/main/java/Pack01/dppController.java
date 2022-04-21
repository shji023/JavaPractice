package Pack01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/dpp")
public class dppController {
	@GetMapping("/{dppNum}")
	public Person f1(@PathVariable String dppNum) {
		Person person = new Person();
		person.setName("홀앙이");
		person.setAge(20);
		return person;
	}
}





