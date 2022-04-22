package Pack01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s1")
public class bppController {
	@GetMapping("/{num}")
	public Integer f1(@PathVariable String num) {
		System.out.println(num);
		Integer result = Integer.parseInt(num);
		return result;
	}
}
