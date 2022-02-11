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
// ex61)
public class Hello2 {
	static String hexaToBinary(int n) {
		String s = Integer.toBinaryString(n);

		while(s.length()<32) 
			s = "0"+s;
		
		StringBuffer sb = new StringBuffer(s);
		for (int i = 0; i < 7; i++) 
			sb.insert((7-i)*4, " ");
		
		return sb.toString();
	}
	public static void main(String[] args) {
		int n1 = 0x1234abcd;
		System.out.println(n1 & 0xffff0000);
		
		System.out.println(hexaToBinary(n1));
		System.out.println(hexaToBinary(0xffff0000)); // mask data (걸러낼 때 중간역할)
		System.out.println(hexaToBinary(n1 & 0xffff0000));
		
		// 데이터 합성
		System.out.println(hexaToBinary(n1 | 0xffff0000));
		
		int a = 0x000000f3;
		int b = 0x00003600;
		int c = 0x00EC0000;
		int d = a | b | c;
		System.out.println(hexaToBinary(d));
		System.out.println("---------------------");
		int e = 0xf09;
		System.out.println(hexaToBinary(e));
		System.out.println(hexaToBinary(e<<4)); // 데이터 4칸씩 왼쪽으로 이동
		System.out.println(hexaToBinary(e>>4)); // 데이터 4칸씩 오른쪽으로 이동
		
		System.out.println("---------------------");
		int data = 0xabcd;
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 뒤에서 다섯개의 비트는 10진수로 얼마일까 - 13
		// 그 앞의 6개의 비트는 10진수로 얼마일까 - 30
		// 그 앞의 5개의 비트는 10진수로 얼마일까 - 21
		System.out.println(hexaToBinary(data));
		
		// 뒤에서 다섯개 비트 걸러내기
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 0000 0000 0001 1111 -> 0x1f
		System.out.println(data & 0x1f); // 13
		
		// 뒤에서 다섯개 비트 걸러내기
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 0000 0111 1110 0000 -> 0x1f
		System.out.println(data & 0x7E0); // 960, 30 나와야되는데 뒤에 0이 차지하고있어서 큰 숫자가 나옴 ->shift연산 필요
		System.out.println((data & 0x7E0) >> 6);
		
		// 뒤에서 다섯개 비트 걸러내기
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 1111 1000 0000 0000 -> 0x1f
		System.out.println(data & 0xF800); // 960, 30 나와야되는데 뒤에 0이 차지하고있어서 큰 숫자가 나옴 ->shift연산 필요
		System.out.println((data & 0xF800) >>11);
		
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
		System.out.println(s1.length()); // 13
	
		// ex2) char String.charAt(int index)
		System.out.println(s1.charAt(5)); // 이
		
		// ex3) int String.indexOf(int ch)
		System.out.println(s1.indexOf("이")); // 5
		// 음수, 혹은 -1 값이 리턴된다 << 검색실패
		System.out.println(s1.indexOf("뀨")); // -1
		System.out.println(s1.indexOf("뀨")==-1?"검색실패":"검색성공"); // 검색실패
	
		// ex4)
		// String replace {
		//		CharSequence target,
		//		CharSequence replacement}
		s1.replace("꽃이", "나무가");
		// 주의 : 원본 데이터를 변경하는가 하지 않는가?
		// String 클래스는 절대로 원본을 변경하지 않는다.
		// StringBuffer 클래스는 원본 데이터를 변경할 수 있다.
		System.out.println(s1); // 무궁화 꽃이 피었습니다.
		// s1 = "호랑이";
		// System.out.println(s1); // 호랑이 -> 원본데이터가 변경된 것이 아님
		// 1. s1의 메모리가 삭제된다
		// 2. s1의 메모리는 재할당 받는다. (객체가 없어지고 새로운 객체가 만들어진 것임)
		String s2 = s1.replace("꽃이", "나무가");
		System.out.println(s2); // 무궁화 나무가 피었습니다.
		System.out.println(s1.replace("꽃이","식물이")); // 무궁화 식물이 피었습니다.
		System.out.println(s1); //무궁화 꽃이 피었습니다.
		
		// ex5) sub string
		System.out.println(s1.substring(3)); // 인덱스3 부터 그 뒤에있는 글자 전부
		System.out.println(s1.substring(3, 5)); // 인덱스 3부터 5까지 start~end-1
		
		// ex6)
		s1 = "Apple";
		System.out.println(s1.toLowerCase()); // 소문자로 
		System.out.println(s1.toUpperCase()); // 대문자로
		
		// ex7)
		s1 = "  A p p l e  ";
		System.out.println(1000);
		// 앞 뒤 공백 제거, 중간에 있는 공백은 놔둠
		System.out.println(s1.trim());
		System.out.println(2000);
 	}
}

// ex58) 진법( bit 연산 ) => 2(컴퓨터), 10(인간), 16(절충)
class Tiger {
	// 9 > a
	// 1F > 20
	// 9F > 1000
	// fff > 1000
	// cf > d0
	// A 10
	// B 11
	// C 12
	// D 13
	// E 14
	// F 15
	
	// 네자리씩 끊음
	// 1 0101 0101 1110 1111
	//		5    5    E    F
} 
public class Hello2 {
	public static void main(String[] args) {
		
	}
}

// ex59)
public class Hello2 {
	public static void main(String[] args) {
		int num1 = 100; 
		System.out.println(num1); // 100
		
		int num2 = 0x100;
		System.out.println(num2); // 256
		
		int num3 = 0xABCD;
		System.out.println(num3); // 43981
		
		// 한자리당 4비트 
		// 두자리면 8비트 - 1byte 
		// int는 4byte까지이기에 4byte를 넘을 수 없음 (FF FF FF FF)
		int num4 = 0x63CE7BCD;
		System.out.println(num4); // 1674476493
		// 0110 0011 1100 1110 0111 1011 1100 1101
		
		// 0x7f ff ff ff >> 0 ~ 80 00 00 00, 80 00 00 00 ~ FF FF FF FF
		int num;
		// 16진수로 만들어진 문자열을 리턴
		// 110 0011 1100 1110 0111 1011 1100 1101
		System.out.println(Integer.toBinaryString(num4));
		int num5 = 0xab;
		// 10101011 => 이 형태 말고 
		// 0000 0000 0000 0000 0000 0000 1010 1011 => 이 형태로 
		System.out.println(Integer.toBinaryString(num5));
	}
}

// ex60) 32bit 해당하는 문자열 만들기
public class Hello2 {
	static String hexaToBinary(int n) {
		String s = Integer.toBinaryString(n);
		// System.out.println(s);
		// System.out.println(s.length()); // 31
		
		// 32에 해당하는 문자열을 만든다.
		while(s.length()<32) {
			s = "0"+s;
		}
		// System.out.println(s.length()); // 32
		// System.out.println(s);
		// string buffer - 데이터 갱신 위해 
		StringBuffer sb = new StringBuffer(s);
		System.out.println(sb);
		// StringBuffer: insert(); 제공, 중간에 띄어쓰기 추가하기 위해
		// 뒤에서부터 인덱스 계산하기 
		// 앞에서부터 하면 일정하게 x
		for (int i = 0; i < 7; i++) {
			sb.insert((7-i)*4, " ");
		}
		// return sb; 리턴 타입 불일치 String, StringBuffer
		return sb.toString();
	}
	public static void main(String[] args) {
		// >> 내가 원하는 포맷으로 2진수 출력
		int num = 0x63CE7BCD;
		System.out.println(hexaToBinary(num));
	}
}

// ex60) 32bit 해당하는 문자열 만들기
public class Hello2 {
	static String hexaToBinary(int n) {
		String s = Integer.toBinaryString(n);
		// System.out.println(s);
		// System.out.println(s.length()); // 31
		
		// 32에 해당하는 문자열을 만든다.
		while(s.length()<32) {
			s = "0"+s;
		}
		// System.out.println(s.length()); // 32
		// System.out.println(s);
		// string buffer - 데이터 갱신 위해 
		StringBuffer sb = new StringBuffer(s);
		System.out.println(sb);
		// StringBuffer: insert(); 제공, 중간에 띄어쓰기 추가하기 위해
		// 뒤에서부터 인덱스 계산하기 
		// 앞에서부터 하면 일정하게 x
		for (int i = 0; i < 7; i++) {
			sb.insert((7-i)*4, " ");
		}
		// return sb; 리턴 타입 불일치 String, StringBuffer
		return sb.toString();
	}
	public static void main(String[] args) {
		// >> 내가 원하는 포맷으로 2진수 출력
		int num = 0x63CE7BCD;
		System.out.println(hexaToBinary(num));
		
		System.out.println(hexaToBinary(0xab));
		int num2 = 100;
		
		// 처음      중간   끝
		// 00 1f 7f 80 af ff
	}
}
*/