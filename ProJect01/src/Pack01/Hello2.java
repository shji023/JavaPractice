package Pack01;
import java.util.Random;
/*
class Aaa {
	void f1() {}
}

class Bbb extends Aaa {
	void f2() {}
}
public class Hello2 {
	public static void main(String[] args) {
		
	}
}
*/
// ex57)
class Aaa {
	void f1() {}
}

class Bbb extends Aaa {
	void f2() {}
}
public class Hello2 {
	public static void main(String[] args) {
		
		String s1 = "무궁화 꽃이 피었습니다.";
		// ex1) int String.length()
		System.out.println(s1.length());
	
		// ex2) char String.charAt(int index)
		System.out.println(s1.charAt(5));
		
		// ex3) int String.indexOf(int ch)
		System.out.println(s1.indexOf("이"));
	}
}
/*
// ex52) 다형성 업캐스팅 ***** 매우중요 
class Aaa {
	void f1() {}
}

class Bbb extends Aaa {
	void f2() {}
}
public class Hello2 {
	public static void main(String[] args) {
		// 상속하고 아무 관계가 없음
		Aaa t1 = new Aaa(); // 부모 = 부모
		t1.f1();
		
		// 업캐스팅(UpCasting)
		Aaa t2 = new Bbb(); // 부모 = 자식
		t2.f1(); // f2()메모리가 있는데 사용을 못할뿐
		
		// 다운캐스팅(자바에서 미지원)
		// Bbb t3 = new Aaa(); 자식 = 부모
		
		Bbb t4 = new Bbb(); // 자식 = 자식
		t4.f1();
		t4.f2();
	}
}

class Aaa {
	void f1() {}
	void f3() {
		System.out.println("부모f3");
	}
	void f4() {
		System.out.println("부모f4");
	}
}

class Bbb extends Aaa {
	void f2() {}
	void f4() {
		System.out.println("자식f4");
	}
}
public class Hello2 {
	public static void main(String[] args) {
		Aaa t = new Bbb();
		t.f3(); // 부모f3
		t.f4(); // 자식f4
		
		// 굳이 위에것 처럼 안해도 결과는 똑같은데 왜 위에 것을 사용할까?
		Bbb t2 = new Bbb();
		t2.f3(); // 부모f3
		t2.f4(); // 자식f4
	}
}

// ex53)
class Animal {
	void cry() {
		System.out.println("소리를 낼 수 없음");
	}
}
class Tiger extends Animal {
	@Override
	void cry() {
		System.out.println("어흥");
	}
}
class Cat extends Animal {
	@Override
	void cry() {
		System.out.println("야옹");
	}
}
class Snake extends Animal {
}
public class Hello2 {
	public static void main(String[] args) {
		Animal t1 = new Tiger();
		t1.cry();
		
		Animal t2 = new Cat();
		t2.cry();
		
		Animal t3 = new Snake();
		t3.cry();
		
		// 왜 밑에 처럼 써도 되는데 Animal로 쓸까?
		Tiger t4 = new Tiger();
		t4.cry();
		Cat t5 = new Cat();
		t5.cry();
		Snake t6 = new Snake();
		t6.cry();
		
		// 배열 놔두고 뭐하나
//		String s0, s1, s2, s3;
//		s0 = "호랑이0";
//		s1 = "호랑이1";
//		s2 = "호랑이2";
//		s3 = "호랑이3";
		
		// 객체4개를 생성시킬 수 있는 변수 4개를 만든 것
		// 문자열 객체가 만들어진 것이 아님
		String[] arr = new String[4];
		arr[0] = "호랑이0";
		arr[1] = "호랑이1";
		arr[2] = "호랑이2";
		arr[3] = "호랑이3";
		
		String[] ar = new String[] {"호랑이0","호랑이1","호랑이2","호랑이3"};
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		// 아직 객체 만들어진것 x
		Test[] br = new Test[4];
		// br[0] = new Test(); ... 

		Test[] brr = new Test[] {new Test(),new Test(),new Test(),new Test()};
		for (int i = 0; i < brr.length; i++) {
			br[i].f1();
		} 
	}
}
class Test {
	void f1() {
		System.out.println(1);
	}
}

// ex54)
class Animal {
	void cry() {
		System.out.println("소리를 낼 수 없음");
	}
}
class Tiger extends Animal {
	@Override
	void cry() {
		System.out.println("어흥");
	}
}
class Cat extends Animal {
	@Override
	void cry() {
		System.out.println("야옹");
	}
}
class Snake extends Animal {}
public class Hello2 {
	public static void main(String[] args) {
		Random rnd = new Random();
		Tiger t0 = new Tiger();
		Cat t1 = new Cat();
		Snake t2 = new Snake();
		for (int i = 0; i < 6; i++) {
			// 업캐스팅을 사용하게되면 switch문이 사라짐
			switch(rnd.nextInt(3)) {
			case 0:
				t0.cry();
				break;
			case 1:
				t1.cry();
				break;
			case 2:
				t2.cry();
				break;
			}
		}
		System.out.println("--------------");
//		Animal[] ani = new Animal[3];
//		ani[0] = new Tiger();
//		ani[1] = new Cat();
//		ani[2] = new Snake();
		// 업캐스팅 활용했을 경우
		// 업캐스팅 사용안하면 switch문 사용할 수 있는 방법 없음
		Animal[] ani = new Animal[] {new Tiger(), new Cat(), new Snake()};
		for (int i = 0; i < 6; i++) {
			ani[rnd.nextInt(3)].cry();	
		}
		
	}
}

// ex55) 다형성
class Animal {
	void cry() {
		System.out.println("소리 내지 못함");}
}

class Tiger extends Animal {
	void cry() {System.out.println("어흥");}
}
class Cat extends Animal{
	void cry() {System.out.println("야옹");}
}
class Snake extends Animal{
}
// Lion 추가해도 zoo 변동 없음
class Lion extends Animal{
	void cry() {System.out.println("까꿍");}
}
// zoo라는 클래스가 완성이 되고 나면 가급적 코드를 수정 안하는게 좋음
// 외부에서 동물이 추가 될때마다 코드가 수정이 되면 ....오바
class Zoo extends Animal{
	void sound(Animal t) {
		t.cry(); // 다양한 형태의 결과로 나올 수 있음 -> 다형성 프로그램
	}
	// 밑에 다 받지 말고 위에처럼 부모를 받아라 그럼 똑같음
	// 업캐스팅
	// 개방 폐쇄 원칙
	// 업캐스팅을 하면 다형성 프로그램이 자동으로 
//	void sound(Tiger t) {
//		t.cry();
//	}
//	void sound(Cat t) {
//		t.cry();
//	}
//	void sound(Snake t) {
//		t.cry();
//	}
}
public class Hello2 {
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.sound(new Tiger());
		zoo.sound(new Cat());
		zoo.sound(new Snake());
		zoo.sound(new Lion());
	}
}

/ ex56)
// 4. 추상메소드가 있는 추상클래스에는 abstract 붙여야함
abstract class Aaa {
	// 1. 오버라이딩을 목표로 한다.
	// 2. 정작 본인은 코드를 작성할 생각이 없음.
	// void f1() {}
	// 3. void f1(); 이렇게 중괄호 제거-> 미완성 코드 -> '추상'->abstract 붙임
	abstract void f1();
}
// 추상 클래스를 상속받는 자손은 반드시 코드를 구현해야함. 완성시켜야함
class Bbb extends Aaa {
	@Override
	void f1() {
		System.out.println("bbb");
	}
}
public class Hello2 {
	public static void main(String[] args) {
		Aaa a = new Bbb();
		
		// 5. 추상클래스는 미완성 코드이기에 객체를 생성시킬 수 없음
		// Aaa t = new Aaa(); err
	}
}
*/