package Pack01;

import org.springframework.beans.factory.annotation.Autowired;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Tiger {
	@RequestMapping("/")
	public String f0() {
		System.out.println("메인화면");
		
		return "index";
	}
	
	@RequestMapping("/t1")
	public String f1() {
		System.out.println("f1 call");
		
		return "TigerView";
//		return "redirect:/"; t1이 호출되어도 메인화면에 남아있고 싶을 때.
	}
}

// App 요청
@FeignClient(name="tiger34567",
			url="http://localhost:8765",
			fallbackFactory = FeignFactory.class)
interface TestClient{
	@RequestMapping("/app/{num}")
	String myfunc(@PathVariable String num);
}

@RestController
class AppController {
	@Autowired
	TestClient testClient;
	
	@RequestMapping("/app/{num}")
	public String f2(@PathVariable String num) {
		String str = testClient.myfunc(num);
		System.out.println(str);
		return "App에서 들고왔어요 : " + str;
	}
}
@Component
class FeignFactory implements FallbackFactory<TestClient>{
	@Override
	public TestClient create(Throwable cause) {
		System.out.println("아~~~~~~~~~~~에러발생 했어요~~~~~~");
		return new TestClient() {
			@Override
			public String myfunc(String num) {
				System.out.println("fallback called : " + num);
				return "에러발생";
			}
		};
	}
}

// Bpp 요청
@FeignClient(name="tiger2", url="http://localhost:8765")
interface TestClient2{
	@RequestMapping("bpp")
	String myfunc();
}

@RestController
class BppController {
	@Autowired
	TestClient2 testClient;
	
	@RequestMapping("/bpp")
	public String f2() {
		String str = testClient.myfunc();
		return "Bpp에서 들고왔어요 : " + str;
	}
}