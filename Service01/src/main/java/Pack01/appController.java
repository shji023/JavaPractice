package Pack01;

import java.util.Map;
import java.util.Set;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/t4")
class appController4 {
	// href="app/1000"
	@GetMapping("/{num}")
	public String f1(@PathVariable String num) {
		System.out.println(num);
		RestTemplate rt = new RestTemplate();
		Integer[] data = rt.getForObject(
				"http://localhost:8082/s4/2000",
				Integer[].class
			);
		String result = "";
		for (Integer item : data) {
			result += item+" ";
		}
		return "appController : "+"<br/>"+result;
	}
}

@RestController
@RequestMapping("/t5")
class appController5 {
	// href="app/1000"
	@GetMapping("/{num}")
	public String f1(@PathVariable String num) {
		System.out.println(num);
		RestTemplate rt = new RestTemplate();
		String[] data = rt.getForObject(
				"http://localhost:8082/s5/2000",
				String[].class
			);
		String result = "";
		for (String item : data) {
			result += item+" ";
		}
		return "appController : "+"<br/>"+result;
	}
}

@RestController
@RequestMapping("/t6")
class appController6 {
	// href="app/1000"
	@GetMapping("/{num}")
	public String f1(@PathVariable String num) {
		System.out.println(num);
		RestTemplate rt = new RestTemplate();
		People[] data = rt.getForObject(
				"http://localhost:8082/s6/2000",
				People[].class
			);
		String result = "";
		for (People item : data) {
			result += (item.getName()+item.getAge()+" ");
		}
		return "appController : "+"<br/>"+result;
	}
}

@RestController
@RequestMapping("/t7")
class appController7 {
	// href="app/1000"
	@GetMapping("/{num}")
	public String f1(@PathVariable String num) {
		System.out.println(num);
		RestTemplate rt = new RestTemplate();
		ResponseEntity<Integer[]> data = rt.getForEntity(
				"http://localhost:8082/s7/2000",
				Integer[].class
			);
		String result ="";
		for(Integer item: data.getBody()) {
			result +=(item+" ");
		}

		return "appController : "+"<br/>"+result;
	}
}

@RestController
@RequestMapping("/t8")
class appController8 {
	// href="app/1000"
	@GetMapping("/{num}")
	public String f1(@PathVariable String num) {
		System.out.println(num);
		RestTemplate rt = new RestTemplate();
		ResponseEntity<People[]> data = rt.getForEntity(
				"http://localhost:8082/s8/2000",
				People[].class
			);
		String result ="";
		for(People item: data.getBody()) {
			result +=(item.getName()+" "+item.getAge());
		}

		return "appController : "+"<br/>"+result;
	}
}

@RestController
@RequestMapping("/t9")
class appController9 {
	// href="app/1000"
	@GetMapping("/{num}")
	public String f1(@PathVariable String num) {
		System.out.println(num);
		int test = 777+Integer.parseInt(num);
		RestTemplate rt = new RestTemplate();
		Integer data = rt.getForObject(
				"http://localhost:8082/s9/{apple}",
				Integer.class,
				test
			);
		return "appController : "+"<br/>"+data;
	}
}

@RestController
@RequestMapping("/t10")
class appController10 {
	// href="app/1000"
	@GetMapping("/{num}")
	public String f1(@PathVariable String num) {
		System.out.println(num);

		RestTemplate rt = new RestTemplate();
		String data = rt.getForObject(
				"http://localhost:8082/s10/{apple}/{banana}",
//				"http://localhost:8082/s10/777/888"
				String.class,
				777,888
			);
		return "appController : "+"<br/>"+data;
	}
}

@RestController
@RequestMapping("/t11")
class AppController11 {
   @SuppressWarnings("unchecked")
   @GetMapping("/{num}")
   public String f1(@PathVariable String num ) {
      System.out.println(num);
      
      RestTemplate rt = new RestTemplate();
      // Collection은 다른 데이터와 다르게 가져온다.
      ResponseEntity<Map> data = rt.getForEntity(
            "http://localhost:8082/s11/11000",
            Map.class
      );
      
      Map<String, String> map = data.getBody();
      System.out.println(map);
      String result = "";
      
      Set<String> keys = map.keySet();
      for(String key : keys) {
         result += key + " : " + map.get(key) + ", ";
      }
      System.out.println(keys);
      
      System.out.println(map.get("key1"));
      System.out.println(map.get("key2"));
      System.out.println(map.get("key3"));
      
      return "AppController : " +  
            "<br/>" + result;
   }
}