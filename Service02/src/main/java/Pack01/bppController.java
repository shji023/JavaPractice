package Pack01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bpp")
public class bppController {
	@GetMapping("/{bppNum}")
	public String f1(@PathVariable String bppNum) {
		System.out.println(111);
		return "호랑이";
	}
}
