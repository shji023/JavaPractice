package Pack01;

import java.util.LinkedList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

@RestController
@RequestMapping("/s2")
class bppController2 {
	@GetMapping("/{num}")
	public String f1(@PathVariable String num) {
		System.out.println(num);
		String result = "문자열";
		return result;
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
@RequestMapping("/s3")
class bppController3 {
	@GetMapping("/{num}")
	public People f1(@PathVariable String num) {
		System.out.println(num);
		People result = new People("호랑이",20);
		return result;
	}
}

@RestController
@RequestMapping("/s4")
class bppController4 {
	@GetMapping("/{num}")
	public Integer[] f1(@PathVariable String num) {
		System.out.println(num);
		Integer[] ar = {10,20,30};
		return ar;
	}
}

@RestController
@RequestMapping("/s5")
class bppController5 {
	@GetMapping("/{num}")
	public String[] f1(@PathVariable String num) {
		System.out.println(num);
		String[] ar = {"호","랑","이"};
		return ar;
	}
}

@RestController
@RequestMapping("/s6")
class bppController6 {
	@GetMapping("/{num}")
	public People[] f1(@PathVariable String num) {
		System.out.println(num);
		People[] ar = {
				new People("홍길동1",10),
				new People("홍길동2",20),
				new People("홍길동3",30)
		};
		return ar;
	}
}

@RestController
@RequestMapping("/s7")
class bppController7 {
	@GetMapping("/{num}")
	public LinkedList<Integer> f1(@PathVariable String num) {
		System.out.println(num);
		LinkedList<Integer> li = new LinkedList<Integer>();
		li.add(100);
		li.add(200);
		li.add(300);
		return li;
	}
}