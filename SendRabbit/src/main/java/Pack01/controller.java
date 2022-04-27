//package Pack01;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import lombok.Data;
//
//@Controller 
//public class controller {
//	@RequestMapping("/")
//	public String f0() {
//		System.out.println("f0 call");
//		return "index";
//	}
//	@RequestMapping("/t1")
//	public String f1() {
//		System.out.println("f1 call");
//		return "controllerView";
//		// return "redirect:/";
//	}
//	@Autowired
//	RabbitTemplate rabbitTemplate;
//	static int count = 0;
//	@RequestMapping("/t2")
//	public String f2() {
//		System.out.println("f2 call");
//		System.out.println(rabbitTemplate);
//		String str = "호랑이" +  count++;
//		rabbitTemplate.convertAndSend(
//				"exchange01",
//				"routingKey01", // 주는놈의 키
//				str
//				);
//		// return "controllerView";
//		return "redirect:/";
//	}
//	
//	@RequestMapping("/t3")
//	   public String f3() {
//	      System.out.println("f3 call");
//	      Person person = new Person("호랑이", 10);
//	      rabbitTemplate.convertAndSend(
//	            "exchange01",
//	            "routingKey02",
//	            person
//	      );
//	      
//	      //컨트롤러로 전달하고 싶을 때
//	      return "redirect:/";
//	   }
//
//}
//// getter, setter, allargs, noargs, toString
//@Data
//class Person{
//   final String name;
//   final int age;
//}

package Pack01;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RestController
public class controller {
   @RequestMapping("/")
   public String f0() {
      System.out.println("f0 call");
      
      return "index";
   }
   
   @RequestMapping("/t1")
   public String f1() {
      System.out.println("f1 call");
      
      return "Tiger";
      
      // 컨트롤러로 전달하고 싶을 때
      // return "redirect:/";
   }
   
   // rabbitMQ를 사용하기 위한 변수
   // 우리가 생성하지않아도
   // 이미 존재하기 때문에 @Autowired해주면 자동 주입된다.
   @Autowired
   RabbitTemplate rabbitTemplate;
   
   static int count = 0;
   @RequestMapping("/t2")
   public String f2() {
      System.out.println("f2 call");
      
      System.out.println(rabbitTemplate);
      
      // 전송할 데이터
      String str = "호랑이" + count++;
      // rabbitMq(대시보드) 쪽으로 데이터를 전송한다.
      rabbitTemplate.convertAndSend(
         "exchange01", // 교환소
         "routingKey01", // 송신자(Producer) 키
         str // 전송할 데이터
      );
      
      // 컨트롤러로 전달하고 싶을 때
      return "redirect:/";
   }
   
   // 객체 전송
   @RequestMapping("/t3")
   public String f3() {
      System.out.println("f3 call");
      
      // 전송할 데이터
      Person person = new Person("호랑이", 10);
      
      // rabbitMq(대시보드) 쪽으로 데이터를 전송한다.
      rabbitTemplate.convertAndSend(
         "exchange01", // 교환소
         "routingKey02", // 전달자(Producer) 키
         person // 전송할 데이터
      );
      
      // 컨트롤러로 전달하고 싶을 때
      return "redirect:/";
   }
   
   // 객체 전송
   @RequestMapping("/t4")
   public String f4(@RequestBody MultiplicationResultAttempt mra) {
      System.out.println("f4 call");
      
      // 들어온 데이터 확인
      System.out.println(mra);
      System.out.println(mra.user.alias);
//      System.out.println(mra.multiplication.factorA);
//      System.out.println(mra.multiplication.factorB);
//      System.out.println(mra.resultAttempt);
      System.out.println(mra.result);
      
      // rabbitMq(대시보드) 쪽으로 데이터를 전송한다.
      rabbitTemplate.convertAndSend(
         "exchange01", // 교환소
         "routingKey01", // 전달자(Producer) 키
         mra // 전송할 데이터
      );
      
      // 컨트롤러로 전달하고 싶을 때
      return "redirect:/";
   }
   
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
class Person {
   String name;
   int age;
}


@RequiredArgsConstructor
@Getter
@ToString
class Multiplication{
   final int factorA;
   final int factorB;
   public Multiplication() {
      // TODO Auto-generated constructor stub
      this(0, 0);
   }
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class User{ // 수검자 정보
   String alias;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
class MultiplicationResultAttempt {
   User user; // 수검자
   Multiplication multiplication; // 문제
   int resultAttempt; // 답안
   boolean result;
   int questionId;
}