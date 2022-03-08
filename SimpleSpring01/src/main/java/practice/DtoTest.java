package practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

// ex1)
class FormDTO {
	String name;
	FormDTO(){}
}
class RegisterRequest {
	String name;
	RegisterRequest(String name){
		this.name = name;
	}
}

public class DtoTest {
	public static void main(String[] args) {
		// 1. 클라이언트에서 데이터를 전송함
		// 2. 서버에서는 DTO클래스로 값을 얻게 된다.
		// 3. String name = 객체.name;
		// 4. 키보드에서 input을 받는다 (input이 DTO데이터이다.)
		String inputName = "홍길동";
		RegisterRequest rr = new RegisterRequest(inputName);
	}
}

// ex2)
 * class FormDTO {
	String name;
	FormDTO(){}
}
// VO class
class RegisterRequest {
	String name;
	RegisterRequest(String name){
		// 데이터 검증 코드가 상당부분 생략되었다. 
		this.name = name + "독수리";
	}
}

// Entity 클래스
class Entity {
}
class Member extends Entity{
	int id;
	String name;
}
public class DtoTest {
	public static void main(String[] args) {
		String inputName = "홍길동";
		RegisterRequest rr = new RegisterRequest(inputName);
		
		Member member = new Member();
		member.id = 1000;
		member.name = rr.name;
		
		// member >> DB에 저장( Map Collection 사용 )
	}
}

//ex3)
class FormDTO {
	String name;
	FormDTO(){}
}
// VO class
class RegisterRequest {
	String name;
	RegisterRequest(String name){
		// 데이터 검증 코드가 상당부분 생략되었다. 
		this.name = name + "독수리";
	}
}

// Entity 클래스
class Member {
	int id;
	String name;
}
class MemberDao {
	boolean insert(Member member) {
		// 커리 문장을 사용하는 코드이지만
		System.out.println(member.name + "DB에 저장하였습니다.");
		return true;
	}
}

class MemberRegisterService {
	void register() {
		insert();
	}
}
public class DtoTest {
	public static void main(String[] args) {
		String inputName = "홍길동";
		RegisterRequest rr = new RegisterRequest(inputName);
		
		Member member = new Member();
		member.id = 1000;
		member.name = rr.name;
		
		MemberDao memberDao = new MemberDao();
		memberDao.insert(member);
		// member >> DB에 저장( Map Collection 사용 )
		
		
	}
}

//ex4)
class FormDTO {
	String name;
	FormDTO(){}
}
// VO class
class RegisterRequest {
	String name;
	RegisterRequest(String name){
		// 데이터 검증 코드가 상당부분 생략되었다. 
		this.name = name + "독수리";
	}
}

// Entity 클래스
class Member {
	int id;
	String name;
}
class MemberDao {
	boolean insert(Member member) {
		// 커리 문장을 사용하는 코드이지만
		System.out.println(member.name + "DB에 저장하였습니다.");
		return true;
	}
}
// 서비스 클래스
class MemberRegisterService {
	MemberDao memberDao;
	
	MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	void register(Member member) {
		if(memberDao.insert(member)==true) {
			System.out.println("모든 작업이 정상입니다.");
		}
	}
}
public class DtoTest {
	public static void main(String[] args) {
		String inputName = "홍길동";
		RegisterRequest rr = new RegisterRequest(inputName);
		
		Member member = new Member();
		member.id = 1000;
		member.name = rr.name;
		
		MemberRegisterService mrs = new MemberRegisterService(new MemberDao());
		mrs.register(member);
		//MemberDao memberDao = new MemberDao();
		//memberDao.insert(member);
		// member >> DB에 저장( Map Collection 사용 )
	}
}

// ex5) 스프링 작업 변환 전
class RegisterRequest {
	String name;
	RegisterRequest(String name){
		// 데이터 검증 코드가 상당부분 생략되었다. 
		this.name = name + "독수리";
	}
}

// Entity 클래스
class Member {
	int id;
	String name;
}
class MemberDao {
	boolean insert(Member member) {
		// 커리 문장을 사용하는 코드이지만
		System.out.println(member.name + "DB에 저장하였습니다.");
		return true;
	}
}
// 서비스 클래스
class MemberRegisterService {
	MemberDao memberDao;
	
	MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	// vo -> entity
	void register(RegisterRequest rr) {
		Member member = new Member();
		member.id = 1000;
		member.name=rr.name;
		if(memberDao.insert(member)==true) {
			System.out.println("모든 작업이 정상입니다.");
		}
		
	}
}
public class DtoTest {
	public static void main(String[] args) {

		MemberRegisterService mrs = new MemberRegisterService(new MemberDao());
		mrs.register(new RegisterRequest("홍길동"));
		//MemberDao memberDao = new MemberDao();
		//memberDao.insert(member);
		// member >> DB에 저장( Map Collection 사용 )
	}
}

// ex7) 스프링 사용
// VO class
class RegisterRequest {
	String name;
	RegisterRequest(String name){
		// 데이터 검증 코드가 상당부분 생략되었다. 
		this.name = name + "독수리";
	}
}

// Entity 클래스
class Member {
	int id;
	String name;
}
class MemberDao {
	boolean insert(Member member) {
		// 커리 문장을 사용하는 코드이지만
		System.out.println(member.name + "DB에 저장하였습니다.");
		return true;
	}
}
// 서비스 클래스
class MemberRegisterService {
	@Autowired
	MemberDao memberDao;
	// Autowired 해주고 날려버림
	//	MemberRegisterService(MemberDao memberDao) {
	//		this.memberDao = memberDao;
	//	}
	// vo -> entity
	void register(RegisterRequest rr) {
		Member member = new Member();
		member.id = 1000;
		member.name=rr.name;
		if(memberDao.insert(member)==true) {
			System.out.println("모든 작업이 정상입니다.");
		}
		
	}
}
class AppConfig {
	@Bean //Dao는 객체가 만들어짐
	MemberDao memberDao() {
		return new MemberDao();
	}
	// 날리고 Autowired
	//@Bean
	//MemberRegisterService memberRegisterService() {
	//	return new MemberRegisterService(memberDao());
	// }
	@Bean
	MemberRegisterService memberRegisterService() {
		return new MemberRegisterService();
	}
	
}
public class DtoTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		MemberRegisterService mrs = ctx.getBean("memberRegisterService", MemberRegisterService.class);
		mrs.register(new RegisterRequest("홍길동"));
		//MemberRegisterService mrs = new MemberRegisterService(new MemberDao());
		//mrs.register(new RegisterRequest("홍길동"));
		ctx.close();
	}
}

// ex8)
// VO class
class RegisterRequest {
	String name;
	RegisterRequest(String name){
		// 데이터 검증 코드가 상당부분 생략되었다. 
		this.name = name + "독수리";
	}
}

// Entity 클래스
class Member {
	int id;
	String name;
}
class MemberDao {
	boolean insert(Member member) {
		// 커리 문장을 사용하는 코드이지만
		System.out.println(member.name + "DB에 저장하였습니다.");
		return true;
	}
}
// 서비스 클래스
class MemberRegisterService {
	MemberDao memberDao;
	MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	// vo -> entity
	void register(RegisterRequest rr) {
		Member member = new Member();
		member.id = 1000;
		member.name=rr.name;
		if(memberDao.insert(member)==true) {
			System.out.println("모든 작업이 정상입니다.");
		}
		
	}
}
// config역할
class Assemble {
	MemberRegisterService f1() {
		MemberRegisterService mrs = 
				new MemberRegisterService(new MemberDao());
		return mrs;
	}
}
public class DtoTest {
	public static void main(String[] args) {

		Assemble a = new Assemble();
		MemberRegisterService mrs = a.f1();
		mrs.register(new RegisterRequest("홍길동"));
	}
}
