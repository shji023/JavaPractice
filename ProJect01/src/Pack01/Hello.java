package Pack01;

import java.util.Random;

/*
class Tiger {

}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
	}
}
*/

// ex1) hello world
public class Hello {
	public static void main(String[] args) {
		System.out.println("Hello world");
		System.out.println(1000);
	}
}

// ex2) 숫자열, 문자열
public class Hello {
	public static void main(String[] args) {
		System.out.println(100); // 정수
		System.out.println('s'); // 문자
		System.out.println("double space"); // 문자열
		System.out.println(100+200); // 숫자 연산
		System.out.println(100+"string"); // 문자열 숫자->문자 치환됨
		System.out.println("string"+100); // 문자열 숫자->문자 치환됨
		System.out.println("string"+"string"); // 문자열
		System.out.println("100"); // 문자열
		System.out.println("100"+"100"); // 문자열
		System.out.println(10+20+"호랑이"); // 순차적으로 계산, 숫자+숫자 => 숫자, 숫자+문자열=>문자열
		System.out.println("호랑이"+10+20); // 순차적으로 계산, 문자열+숫자 => 문자열, 문자열+문자열=>문자열
		System.out.println(10+" "+20); // 한줄에 두개의 값보기
		System.out.println(10+'A'); //문자 산술연산 일어나면 아스키 코드로 치환
		System.out.println(1+'A'); // 대문자 아스키코드 65
		System.out.println((char)66); // type casting
	}
}

// ex3) 산술연산
 public class Hello {
	public static void main(String[] args) {
		System.out.println(17+3);
		System.out.println(17-3);
		System.out.println(17*3);
		System.out.println(17/3);
		System.out.println(17%3);
		System.out.println(3+4*5); // 곱셈, 나눗셈이 우선순위가 높음
		System.out.println((3+4)*5); // 괄호 연산이 가장 우선순위가 높음
		System.out.println(2+3*4+5);
	}
}

// ex4) 관계연산
public class Hello {
	public static void main(String[] args) {
		System.out.println(10 > 5); // >=, <, <=, ==, != 결과값 true, false

	}
}

// ex5) 논리연산
public class Hello {
	public static void main(String[] args) {
		// or
		System.out.println(false || false); // false
		System.out.println(true || false); // true
		System.out.println(true || true); // true
		// and
		System.out.println(false && false); // false
		System.out.println(true && false); // false
		System.out.println(true && true); // true
		
		// 산술 > 관계 > 논리 순서대로 실행
		System.out.println(3+2 > 7 && 2+6 < 8);
		
		//부정연산자
		System.out.println(!(3>2));
	}
}

// ex6) type크기
public class Hello {
	public static void main(String[] args) {
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Short.MIN_VALUE); // 2byte
		System.out.println(Short.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE); // 4byte
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MIN_VALUE); // 8byte
		System.out.println(Long.MAX_VALUE);
	}
}

// ex7)primitive type활용
public class Hello {
	public static void main(String[] args) {
		// byte, short, int, long
		byte apple; // 값을 변환 시킬 수 있다 -> 변수
					// 값을 변환 시킬 수 없다 -> 상수
		// 대입 연산
		apple = 10;
		System.out.println(apple);
		apple = 20;
		System.out.println(apple);
		//apple = 200; err -128~127사이의 값만
		apple = 127;
		
		//type variable 대입연산자 리터럴
		short banana = 20; // 선언과 동시에 값 할당 가능 
		int orange = 30;
		long kiwi = 22292999;
		//byte, short 거의 안씀, int 일반적으로 많이 사용
		
		//boolean(1), char(2byte), float(소숫점, 4byte), double(8byte소숫점)
		boolean t1 = true;
		char t2 = 'A';
		char t3 = 'B';
		// 밑의 코드는 가급적 피한다. 가독성이 떨어짐
		char t4 = 65;
		System.out.println((int)(t3+1));
		System.out.println((char)(t3+1));
		
		// char는 음수가 없음 0~2^16
		System.out.println((int)Character.MAX_VALUE);
		System.out.println((int)Character.MIN_VALUE);
		
		float t5 = 3.14f; // float 타입은 반드시 숫자 뒤에f 붙이기
		double t6 = 3.14; // f 필요없음, 좀 더 정밀한 작업 시 사용, float는 오차가 있기에 
		System.out.println(t5);
		
		double sum = 0.0;
		
		for (int i = 0; i<100; i++) {
			sum = sum + 0.1;
		}
		System.out.println(sum); // 오차생김
	}
}

// ex8)변수특성
public class Hello {
	public static void main(String[] args) {
		// 1. 변수이름 중복될 수 없다
		int apple;
		// 2. 대소문자 구분 된다
		int Apple;
		// 3. 첫글자가 숫자가 아니라면 숫자 사용가능
		int Apple123;
		// int 9Apple (x)
		
		// 4. _ $ 제외 특수문자 사용 불가
		int apple_num;
		int _34; // 보통 행렬에서 사용
		
		// 5. 한글 사용 가능(가급적 피한다.)
		int 사과;
		
		// 6. 한 단어 이상 합성시에는 카멜표기법 사용
		int bananaNum;
	}
}

// ex9)
public class Hello {
	public static void main(String[] args) {
		int n = 10;
		n = 20; // 데이터 갱신, 20
		n = n + 10; // 30
		// 복합 대입 연산자 - 컴파일 속도 빠름, 실행속도 같음
		n += 10; // 40
		
		// 단항연산자
		n++; // 실행속도 가장 빠름 assembly - add, move연산
		++n; // inc연산
		
		n=10;
		int a, b;
		a = n++; // 대입->증가, a=10 n=11
		n=10;
		b = ++n; // 증가->대입, b=11 n=11
		System.out.println(a);
		System.out.println(b);
	}
}

// ex10) swap
public class Hello {
	public static void main(String[] args) {
		int a = 10, b = 20;
		int t;
		System.out.println(a + " " + b);
		t = a; 
		a = b;
		b = t;
		System.out.println(a + " " + b);
	}
}

// ex11) 제어문 if, for, while, switch >>> do while(사용x)
public class Hello {
	public static void main(String[] args) {
		// if
		if(true) {
			System.out.println(1);
		}
		// unreached코드
		if(false) { 
			System.out.println(2);
		}
		// 모든 제어문은 제어문 안에 사용할 수 있음
		if(true) {
			System.out.println(3);
			if(true) {
				System.out.println(3);
			}
			System.out.println(4);
		}
		System.out.println('a');
		if(3>2) {
			System.out.println('b');
			if(3!=4) {
				System.out.println('c');
			}
			System.out.println('d');
			if(3+4>=7) {
				System.out.println('e');
			}
			System.out.println('f');
		}
		System.out.println('g');
	}
}

// ex12)
public class Hello {
	public static void main(String[] args) {
		// 1. if() {}
		// 2. if() {} else {}
		// 3. if() {} else if () else if() {}
		
		int num = 10;
		if(num%2==0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
		// if else 안에 들어가는 내용은 비슷해야함, 잘못된 코드
		int password = 1234;
		if(password != 1234) {
			System.out.println("틀림");
		} else {
			System.out.println("맞음");
			System.out.println("로그인 되었습니다.");
			System.out.println("다음 정보 확인");
		}
		// 이런식으로
		int password1 = 1234;
		if(password1 != 1234) {
			System.out.println("틀림");
			//break
		}
			System.out.println("맞음");
			System.out.println("로그인 되었습니다.");
			System.out.println("다음 정보 확인");
			
		int nn = 10;
		if(nn < 0) {
			nn = -nn;
		}else {
			nn = +nn; // 굳이 쓸 필요없지만 올바른 코드. 진행되는 시간이 안정화 되기에 일반적으로 넣어줌
		}
	}
}

// ex13)
public class Hello {
	public static void main(String[] args) {
		int score = 87;
		if(score >= 90) {
			System.out.println('A');
		} else if(score >= 80) {
			System.out.println('B');
		} else if(score >= 70) {
			System.out.println('C');
		} else {
			System.out.println('F');
		}
		//실행속도 평준화 하기 위해 위 같은 구조의 if else 경우 switch사용
	}
}

// ex14)
public class Hello {
	public static void main(String[] args) {
		// 유형1
		for (int i = 0; i <	4; i++) {
		// break는 탈출, continue는 i++	
			System.out.println(i);
		}
		// 유형2
		for (int i = 1; i <= 4; i++) {
			System.out.println(i);
		}
		// 유형3 - 최적화와 관련됨
		for (int i = -3; i <= 3; i++) {
			System.out.println(1);
		} 
	}
}

// ex15) 구구단 예제
public class Hello {
	public static void main(String[] args) {
		// for문은 템플릿 형식으로 놔두기 수정변경 용이 하도록
		int num = 5;
		for (int i = 0; i < 10; i++) {
			System.out.println(num + "*" + i + "="+ num*i);
		}
		int sum = 0;
		int num2 = 10;
		for (int i = 1; i <= num2; i++) {
			//sum = sum + i;
			sum += i;
			System.out.println(sum);
		}
		System.out.println(sum);
		
		//2의 8승
		int sum2 = 1;
		int a = 2, b = 8;
		for (int i = 0; i < b; i++) {
			sum2 *= a;
			
		}
	}
}
// ex16)
public class Hello {
	public static void main(String[] args) {
		//16-1
		for (int i = 0; i < 3; i++) {
			System.out.println("---------");
			for (int j = 0; j < 4; j++) {
				System.out.println(1);
			}
		}
		//16-2
		for (int i = 0; i < 3; i++) { // 세로
			for (int j = 0; j < 4; j++) { // 가로
				System.out.print("*");
			}
			System.out.println(); // 줄바꿈
		}
		for (int i = 0; i < 3; i++) { 
			for (int j = 0; j < 4; j++) { 
				System.out.print("[" +i+" "+j+"]");
			}
			System.out.println(); 
		}
//		OXOXOX
//		XOXOXO
//		OXOXOX
//		XOXOXO
//		OXOXOX
		for (int i = 0; i < 5; i++) { 
			for (int j = 0; j < 6; j++) { 
				System.out.print((i+j)%2==0 ?"O":"X"); 
			}
			System.out.println();
		}
		
		// 삼항연산자
		int result;
		if(3>2) {
			result = 10;
		}else {
			result = 20;
		}
		// 위 구조의 경우 무조건 삼항연산으로 수정한다.
		result = (3>2)? 10: 20;
		
//		int func() {
//			return 3>2 ? 100:200;
//		}
	}
}

// ex17) while (비슷하게 사용: for) 반복횟수 처음부터 모를때 사용
public class Hello {
	public static void main(String[] args) {
//		int num = 0;
//		while(true) {
//			num++;
//			System.out.println(num);
//		}
		// 반복횟수를 알 경우는 for문 사용하기
		int num = 0;
		while(num < 4) {
			System.out.println(num);
			num ++;
		}
		//break
		num = 0;
		while(true) {
			if(num == 4) {
				System.out.println("break 전");
				break; // while문을 빠져나감
//				System.out.println("unreached code");
			}
			System.out.println(num);
			num++;
		}
	}
}
// ex18)
public class Hello {
	public static void main(String[] args) {
		int num = 17;
		while(true) {
			num =  num % 2 ==0? num/2 : num*3+1;
			if(num == 1) {
				System.out.println(num);
				break;
			}
		}
		
	}
}
// ex19)
public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		int num = rnd.nextInt();
		if(num < 0) {
			num = -num;
		}
		System.out.println(num);
		int sum = 0;
		while(true) {
			sum += num % 10;
			num = num / 10;
			if (num <= 0) {
				break;
			}
		}
		System.out.println(sum);
	}
}

// ex20) switch
public class Hello {
	public static void main(String[] args) {
		// 1. switch안에 변수를 사용할 수 있다.
		// 2. case뒤에 변수를 사용할 수 없다.
		// 3. break를 생략하면 switch를 빠져나오지 못함.
		// 4. 만족하는 분기문이 없을 때는 default로 이동한다.
		// 5. 정수, 문자, 문자열 모두 분기가 가능 
		// 6. 의도적으로 break생략하기도 한다.
		char ch = '한';
		int num = 20;
		switch (num) {
		case 10:
			System.out.println(10);
			break;
		case 20:
			System.out.println(20);
			break;
		case 30:
			System.out.println(30);
			break;
		default:
			System.out.println("default");
			break;
		}
	}
}

// ex21)
public class Hello {
	public static void main(String[] args) {
		int score = 87;
		switch (score /10) {
		case 10: // break;
		case 9:
			System.out.println("A");
			break;
		case 8:
			System.out.println("B");
			break;
		case 7:
			System.out.println("C");
			break;
		case 6:
			System.out.println("D");
			break;
		default:
			System.out.println("F");
			break;
		}
	}
}

// ex22) switch 활용
public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		// 0~9숫자 랜덤하게
		int num = rnd.nextInt(30);
		switch(num%2) {
		case 0: {
			for (int i = 0; i < 10; i++) {
				System.out.println(num + "*" + i + "="+ num*i);
			}
			
		} break; // 한줄 이상일 경우에는 중괄호 묶고 뒤에 바로 break
		case 1:{
			int sum = 0;
			for (int i = 1; i <= num; i++) {
				sum += i;
			}
			System.out.println(num + "까지의 합은"+sum);
		} break;
		default:
			break;
		}
	}
}

// ex23) 배열(array)
public class Hello {
	public static void main(String[] args) {
		// 1.  정석
		int[] arr = new int[10]; // A[] arr = new A[1]
		
		// 2. 예제 샘플에서 사용
		int[] brr = new int[] {10, 20, 30};
		
		// 3.
		int[] crr = {40, 50, 60};
		
		// arr은 변수가 10개 있다.
		
		arr[0] = 10;
		System.out.println(arr[0]);
		System.out.println(arr[1]); // 미 설정시 초기화 0 -> 속도 저하 원인
		
		arr[9] = 20;
		System.out.println(arr[9]);
		
		// ArrayIndexOutOfBoundsException, 프로그램 중단됨
		//arr[-5] = 100; 
		//arr[10] = 100;
		System.out.println("호랑이");
		
		// 인덱스로 변수 사용 및 산술연산 가능
		int num = 4;
		arr[num*2] = 10;
		arr[num*2-7] = 999;
		System.out.println(arr[8]); // 10
		
		arr[5] = 7;
		arr[7] = 777;
		arr[arr[5]*2-7] = 888;
		System.out.println(arr[7]); /// 888
		
		System.out.println(arr.length); //10
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}System.out.println(); // 줄바꿈까지 하나의 쌍으로
		System.out.println("독수리");
	}
}

// ex24)
public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		int[]  arr = new int[10];
		// 데이터 갱신과 출력은 따로 구분
		for (int i = 0; i < arr.length; i++) {
			//데이터 갱신
			arr[i] = rnd.nextInt(20);
		}
		for (int i = 0;  i < arr.length; i++) {
			// 데이터 출력
			System.out.print(arr[i]+" ");
		}System.out.println();
		
		// 맨앞+맨뒤, 그다음 앞+그다음 뒤, ...
		int sum = 0;
		for (int i = 0; i < arr.length/2; i++) {
			sum += arr[i] + arr[arr.length-i-1];
			System.out.print(sum+" ");
			sum = 0;
			
		}

		
	}
}

// 클래스의 첫글자는 대문자
class Airplane {
	// 1. 필드(변수) >> 속성
	// 멤버 변수
	int a; 
	float b;
	int seat;
	// int[] arr; 메모리를 몇개 요청? 없다. new로 안만들면 할당되는 메모리 없음
	int[] arr = new int[4];
	
	int num = 99;
	// 2. 생성자
	// 3. 메소드(함수)
}
// ex25) 클래스
public class Hello {
	public static void main(String[] args) {
		// 실제 비행기가 만들어짐
		Airplane air = new Airplane();
		Airplane air2 = new Airplane();
		
		// air.a = 10; dot-체이닝
		air.b = 20.0f;
		air.seat = 30;
		
		System.out.println(air.a); // 0으로 초기화됨
		System.out.println(air.b); // 20.0
		
		air2.seat = 40;
		//air와 air2는 서로다른 메모리이다.
		System.out.println(air.seat+" "+air2.seat);
		
		for (int i = 0; i < air.arr.length; i++) {
			air.arr[i] = i*10;
		}
		for (int i = 0; i < air.arr.length; i++) {
			System.out.print(air.arr[i]);
		}System.out.println();
		for (int i = 0; i < air2.arr.length; i++) {
			System.out.print(air2.arr[i]);
		}System.out.println();
		
		// 과거의 값들은 사라지고 새로운 메모리 할당됨
		air.arr = new int[8];
				
		// 부가 설명
		// int[]ar;
		// ar = new int[10];
		// ar을 사용했다고 치고 이전의 10개는 사라짐. 새로운 20개가 생성
		// ar = new int [20];
		
		// 메모리 반납 코드
		// delete ar; << 자바에서는 프로그래머가 신경쓸 부분이 아니다.
		
		// 값은 같기만 각각 다른 메모리안에 존재
		System.out.println(air.num); // 99
		System.out.println(air2.num); // 99
	}
}

class Tiger {
	// 1. void f1() {} / 리턴없다 f1(인수전달 없음) {}
	// 2. void f1(int a) {} / 리턴없다 f1(인수전달 있음) {}
	// 3. int f1() {} / 리턴있다 f1(인수전달 없음) {}
	// 3. int f1(int a) {} / 리턴있다 f1(인수전달 있음) {}
	
	void method01() {
		System.out.println("method01");
	}
	void method02() {
		System.out.println("method02");
	}
}
// ex26) class 1
public class Hello {
	public static void main(String[] args) {
		// 코드의 재활용
		// 함수(메소드): 자주 사용되는 코드를 저장해서 재활용한다.
		Tiger t1 = new Tiger();
		System.out.println(1000);
		t1.method01(); // 함수를 호출한다. method01로 프로그램 분기가 일어남
		System.out.println(2000);
		
		Tiger t2 = new Tiger();
		t2.method01(); // 함수 메모리는 딱 한번만 만들어짐
		t1.method02();
		t2.method02();
	}
}

// ex27) class2
class Tiger {
	void m1() {
		System.out.println("멍");
	}
	void m2(int num) {
		//num은 지역변수
		System.out.println("멍" + num);
	}
	void m3(int num) {
		for (int i = 0; i < num; i++) {
			System.out.print("멍");
		}
	}
	// 두개의 인수에 각각 다 type을 붙여주어야함
	void m4(int a, int b) {
		System.out.println(a*b);
	}
	void m5(int width, int height, char ch, boolean b) {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(ch + " ");
			}System.out.println();
		}
	}
	void m6(int num) {
		for (int i = 0; i < 10; i++) {
			System.out.println(num+" * "+i+" = "+i*num);

		}
	}
	void m7(int num) {
		int sum = 0;
		for (int i = 1; i <= num; i++) {
			sum += i;
			System.out.println(sum);
		}
	}
	void m8(int w, int h, char ch1, char ch2) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(
						(i+j) % 2 == 0? ch1+" ": ch2+ " "
				);	
			}System.out.println();
		}
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.m1();
		t1.m2(3);
		t1.m3(8);
		t1.m4(3, 4);
		// 가로, 세로
		t1.m5(5, 4, '*', true);
		t1.m6(5);
		t1.m7(10);
		t1.m8(8, 7, 'O', 'X');
	}
}
// ex28) 
class Tiger {
	void func01() {
	}
	// 정수 리턴 해야함.
	int func02() {
		return 100;
	}
	// 메소드에서 return 키워드를 만나면 함수가 중단된다. 
	
	int func03() {
		if (3>2) {
			return 100;
		} else if ( false ) {
			return 200;
		}else {
			System.out.println(1000); // 어떤 식으로 코드가 진행 되더라도 return을 만나야함
			//return 300;
		}
		return 2000;
	}
	 // void 이지만 return 키워드를 사용할 수 있다.
	void func04() {
		for (int i = 0; i < 10; i++) {
			if(i==5) {
				break; // for문 탈출 
				// return; func04 중단
			}
		}
		System.out.println("for 중단됨");
	}
	int func05(int num) {
		// return num * num;
		int result = num * num;
		return result;
	}
	int func06(int num) {
		return num * num;
	}
	// 규칙을 만든다 (음수면 -1리턴 등등) 
	// -1이 리턴된 경우는 음수인 경우이다. 
	int func07(int num) {
		if(num < 0) {
			System.out.println("음수임");
			return -1; 
		}
		if (num % 2 == 0) {
			System.out.println("짝");
		} else {
			System.out.println("홀");
		}
		return 1;
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		
		int num = t1.func02();
		System.out.println(num);
		
		System.out.println(t1.func02());
		System.out.println(100);
		
		// 왜 에러냐 -> 리턴값이 없는데 출력하려하기 때문
		// System.out.println(t1.func01());
		
		t1.func04();
		t1.func05(5);
		t1.func07(-4);
		
		if(t1.func07(-4)==-1) {
			// 출력문을 main에서 써야 응용이 가능함
			// 함수에서 쓰면 무조건 한번 쓴대로만 써야하기에 응용이 쉽지 않음
			System.out.println("음수입니다.");
		}
	}
}

// ex29)
class Tiger {
	void f1() {
		System.out.println(1);
	}
	void f2() {
		f1();
		System.out.println(2);
	}
	void f3() {
		f2();
		System.out.println(3);
	}
	// 상호호출 - 무한 루프
	void f4() {
		System.out.println(4);
		f5();
	}
	void f5() {
		System.out.println(5);
		f4();
	}
	// 재귀 호출(recursive call)
	void f6() {
		System.out.println(6);
		f6();
	}

}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.f3(); // 1 2 3
		
	}
}

// ex30)
class Tiger {
	int a, b;
	void showData() {
		System.out.println(a+" "+b);
	}
	int add() {
		return a+b;
	}
	void m1(int a, int b) {
		// 이름 중첩 시 지역변수 먼저 사용
		// 인수값이 먼저 사용된다.
		int result = a + b;
		System.out.println(result); // 500
		// 필드의 a, b를 사용하고 싶으면?
		// this 사용
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.a = 10;
		t1.b = 20;
		t1.showData();
		System.out.println(t1.add());
		t1.m1(100, 400);
		
	}
}

// ex31)
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		// String: 문자열을 전문적으로 관리한다. 첫글자 대문자!( =클래스)
		// 만든적이 없는데? => 표준으로 제공되는 클래스
		// 도움될만한 method가 뭐가 있을까
		
		String s1 = new String();
		s1 = "호랑이";
		System.out.println(s1);
		System.out.println(s1.length());
		
		// 약식 표현
		String s2 = "앵무새";
		System.out.println(s2);
		
		Math m;
	}
}

// ex32)
class Tiger {
	// String을 인수로 받을 수 있다는 얘기는 class를 받는것
	// 인수로 받을 수 있는것 : primitive type + class
	void m1(float a, String s) {
		System.out.println(a+" "+s);
		System.out.println(s.length());
	}
	String m2() {
		String s = "호랑이";
		return s;
	}
	String m3() {
		return null; // 초기에 null로 세팅
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.m1(3.14f, "호랑이");
		
		String s = t1.m2();
		System.out.println(s);
		
		// 앞으로 객체가 생성이 된다면 사용될 이름을 정의해놓은것
		// 객체가 생성된 것은 아님
		String s2;
		// s2.length(); 에러
		
		// 아직 s2는 객체가 아니다라는 것을 명시적으로 표시
		String s3 = null;
		s3 = "코끼리";
		// 적당하게 사용하다가..
		s3 = null;
	}
}

// ex33)
class Tiger {

}
class Lion {
	// Lion이 될까?
	// Tiger t = new Tiger() => t는 newTiger()니까 newTiger()넘겨주면됨
	void m1(int a, String s, Tiger t, Lion l) {
		if(s != null) {
		}
	}
	Tiger m2() {
		return null;
	}
	Tiger m3() {
		return new Tiger(); // 클래스 객체 리턴 가능
	}
	Tiger m4() {
		Tiger t = new Tiger();
		return t;
	}
	Tiger m5(Tiger t) {
		return t;
	}
}
public class Hello {
	public static void main(String[] args) {
		Lion t1 = new Lion();
		// String으로 null을 넣어줘도 됨-> 사용을 안하려면
		t1.m1(10, "호랑이", new Tiger(), new Lion());
	}
}

// ex34)
class Tiger {
	int num = 100;
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.hashCode());
		
		Tiger t2 = new Tiger();
		System.out.println(t2.hashCode());
	
		Tiger t3 = null;
		// System.out.println(t3.hashCode()); err=>해시코드를 얻어낼 수 없어 에러 검출 불가능
		t3 = t1; // 해시코드 값 부여 
		//메모리를 참조한다.(공유한다)
		System.out.println(t3.hashCode());
		System.out.println(t1.num);
		System.out.println(t3.num);
		t1.num = 200;
		System.out.println(t3.num);// t1을 바꿔도 변화됨
	}
}
// ex35)
class Tiger {
	int number;
}
class Lion {
	// Tiger bbb = aaa; 자료 공유
	Tiger m1(Tiger bbb) {
		System.out.println(bbb.number);
		System.out.println(bbb.hashCode());
		bbb.number  = 888;
		return bbb;
	}
}

public class Hello {
	public static void main(String[] args) {
		Lion t1 = new Lion();
		Tiger aaa = new Tiger();
		aaa.number = 999;
		System.out.println("aaa hashCode = "+aaa.hashCode());
		Tiger ccc = t1.m1(aaa);
		System.out.println("ccc hashCode = "+ccc.hashCode());
		System.out.println("ccc number = "+ccc.number);
		
	}
}

// ex36) 오버로딩(Overloading): 함수이름을 동일하게 작명 가능한 경우
class Tiger {
	void showMeTheMoney() {
		System.out.println(1);
	}
	// 인수 전달 개수 다를 시 동일한 이름의 함수 사용 가능
	void showMeTheMoney(int a) {
		System.out.println(2);
	}
	void showMeTheMoney(int a, int b) {
		System.out.println(3);
	}
	// 인수 개수 같아도 타입이 다를 시 동일한 이름의 함수 사용 가능
	void showMeTheMoney(float a) {
		System.out.println(4);
	}
	void showMeTheMoney(Tiger t) {
		System.out.println(5);
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.showMeTheMoney();
		t1.showMeTheMoney(10);
		t1.showMeTheMoney(10, 20);
		t1.showMeTheMoney(3.14f);
		t1.showMeTheMoney(new Tiger());
		float f = 3; // 모호하게 3.0f로 안쓰고
		t1.showMeTheMoney((float)3); // type casting을 할수도 있음
		// type casting할 바엔 3.0f 정확하게 쓰는게 낫다
		
	}
}

//ex37) 함수 오버로딩 예
class Tiger {
	int getRectangle(int w, int h) {
		return w * h;
	}
	// 작명-> 오버로딩이 없었을 때는 getRectangle2 이런식으로 했음
	int getRectangle(int x1, int y1, int x2, int y2){
		int width = x2-x1+1;
		int height = y2-y1+1;
		return width * height;
	}
	// 단, 리턴 값이 다른경우에는 오버로딩 불가능
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.getRectangle(10, 5));
		System.out.println(t1.getRectangle(10, 5, 20, 15));
	}
}
// ex38) 생성자 
// 1. 사용 목적: 필드 초기화
// 2. 생성자 메소드 => 함수이다.
// 3. 함수의 이름은 반드시 클래스 이름과 동일
// 4. 인수를 전달 받을 수 있지만, return을 가질 수 없음.
// 5. 인수 전달이 없는 생성자를 디폴트 생성자라고 함.
// 6. 호출은 new키워드를 사용할 때 딱 1번 호출됨.
// 	  프로그래머가 임의로 호출할 수 없음.
// 7. 함수이기때문에 오버로딩을 할 수 있음
// 8. 생성자코드를 작성하지 않으면 자동으로 작성됨.
//	  <-> 생성자 코드를 작성하면 자동으로 생성자 코드가 만들어지지 않음
class Tiger {
	// 필드
	int age;
	
	// 디폴트 생성자
	Tiger() {
		System.out.println("생성자 콜");
		age = 100;
	}
	// 메소드
}
public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		Tiger t1 = new Tiger(); // new 때문에 생성자 호출됨. Tiger()함수 호출하시오.
		System.out.println(2);
		
		// 객체를 한번 더 만들면?
		Tiger t2 = new Tiger(); // 또 생성자 호출
		System.out.println(3);
		
		for (int i = 0; i < 3; i++) {
			Tiger temp = new Tiger();
			System.out.println(temp.hashCode());
		}
	}
}
// ex39)
class Tiger{
	// 생성자에서 값 변경할 수 있도록 int age = 100; 이런식으로x
	int age;                // 초기화방법1(먼저실행)
	Tiger() {				// 초기화방법2(나중실행)
		System.out.println(1);
		age = 100;
	}
	Tiger(int data) {
		System.out.println(2);
		age = data;
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.age); //100
		Tiger t2 = new Tiger(200);
		System.out.println(t2.age); //200
	}
}

// ex40)
class Tiger {
	int age = 10; // 초기에 값을 넣어버리면 출발이 무조건 10
	Tiger() {
		System.out.println(age); //10
		age = 20;
	}
	Tiger(int data) {
		age = data;
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.age); //20
		Tiger t2 = new Tiger(200);
		System.out.println(t2.age);
	}
}
// ex41)
class Tiger {
	String name;
	int age;
	
	// 안적으면 자동으로 생성됨
	// 적으면 자동으로 안만들어지기 때문에 Tiger t1 = new Tiger(); 에러뜸
	Tiger(){} // 그냥 적어줌, 일반적으로 미리 적어준다.
	Tiger(int data) {
		//name = null;
		name = "익명";
		age = data; 
	}
	Tiger(String n, int data) {
		name = n;
		age = data;
	}
	//멤버를 출력할 수 있는 전용함수를 만들다
	void showData() {
		System.out.println(name+" "+age);
	}
	
	// 해당함수 드래그하고 우클릭->source->generate toString
	@Override
	public String toString() {
		return "Tiger [name=" + name + ", age=" + age + "]";
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger(100);
		System.out.println(t1.name+" "+t1.age);
		Tiger t2 = new Tiger("홍길동", 200);
		t2.showData();
		
		System.out.println(t1.toString());
		System.out.println(t1);
	}

	@Override
	public String toString() {
		return "Hello [toString()=" + super.toString() + "]";
	}
}

// 42)
class Tiger {
	// 부품 취급
	// 밖에서 직접적으로 사용하는 것은 금기
	// data, 변수들은 밖으로 노출 되는 것을 꺼림
	// data 은닉 필요
	private int age; // 뒤에있는 필드는 클래스 안에서만 사용하기
	// 다 공용으로 사용할 수 있을 때는 public. 원래 default 키워드 사용,  
	private String name; 
	
	// getter setter 메소드
	// get(read), set(write)으로 외부의 값 오픈하는것에 대한 경우의수 4가지 나옴
	// 외부에서 접근해도 되겠다 싶은 것들 선택적으로 오픈 가능
	int getAge() {
		return age;
	}
	void setAge(int data) {
		age = data;
	}
	Tiger() {
		age = 100;
	}
	
	void setName(String n) {
		name = n;
	}
	String getName() {
		return name;
	}
	
	// f1, f2는 f3을 목적으로 쓰는것이기에 private으로 은닉
	private void f1() {
	}
	private void f2() {
	}
	void f3() {
		f1();
		f2();
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		// 멤버필드는 객체를 생성시켜서
		// 직접 사용하는 것은 거의 xx
		// System.out.println(t1.age);
		// 클래스에서 속성은 밖으로 드러지 않음
		// t1.money = 200;
		// 객체를 만드는 사람은 클래스 안에 필드내용을 모르고도 사용할 줄 알아야함
		// 함수를 사용함으로써
		
		// t1.f1(); private이라 접근 불가
		t1.setAge(1000);
		System.out.println(t1.getAge());
		
	}
}

//ex43) static (설계도 안에 들어있는 관제탑 한개만 만들어 놓으세요. 매번 객체 생성할때마다 그리지 말고)
class Tiger {
	
	static int n1; // 필드명도 static 활용가능, 모든 객체는 n1을 공용으로 사용한다.
	int n2;
	// static-컴파일이 되면 클래스 외부로 나가버리는 코드 
	// 모든 객체는 관제탑을 공용으로 사용한다.
	static void 관제탑() {
		System.out.println("콜");
	}
	void fly() {
		
	}
}
public class Hello {
	public static void main(String[] args) {
		// 밑에 주석해서 객체 생성 안하면 fly 사용 불가
		// Tiger t1 = new Tiger();
		Tiger.관제탑(); // 객체 생성 안해도 사용가능
		// 컴파일 시 외부에서 이미 존재하기 때문에
		// fly쓰고 싶으면 객체 생성시켜서 써야함
		Tiger t1 = new Tiger();
		t1.fly();
		t1.관제탑(); // 객체로도 관제탑 접근 가능
		System.out.println(Tiger.n1);
		System.out.println(t1.n2);
	}
}

// ex43-1)
class Tiger {
	// 필드는 객체 만드는대로 생기는데 
	// 함수는 한번만 만들어짐
	// 그러면 왜 한번만 만들어지는 static을 사용해야할까?
	// 객체를 생성시키는 new 문장의 비용이 매우 높음
	// static->시스템의 속도를 요구할 때 사용함
	static void f1() {
		
	}
	void f2() {
		
	}
}
public class Hello {
	// 아래 코드 모두 작성 가능
	int age;
	Hello() {
		
	}
	void  f1() {
		
	}
	// 진입점(Entry Point)
	// static - 객체를 생성시키지 않아도 메모리를 가짐
	// main 호출은 OS
	// Hello h = new Hello();
	// h.main();
	// Hello.main()
	public static void main(String[] args) {
		// 객체 생성 비용이 많이 든다.
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
	}
	// 메인 아래 코드 작성해도 무방
	void f2() {
		
	}
}

// ex43-2)
class Tiger {
	int n1;
	static int n2;
	static void f1() {
		// n1 = 100; 없는 메모리를 들고 나가기 때문에 에러 
		n2 = 200;
		// f2();
		f3();
		// static안에서는 static만 사용가능
	}
	void f2() {
		f1();
	}
	static void f3() {}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
	}
}
// ex43-3)
class Tiger {
	void f1() {
		Tiger t = new Tiger();
	}
}
public class Hello {
	int n1;
	static int n2;
	void f1() {};
	static void f2() {};
 	public static void main(String[] args) {
		//f1();
		f2();
		//n1 = 10;
		n2 = 10;
		Hello h = new Hello(); // hello 객체 두개-> window객체 생성, 새로 생성
		h.n1 = 10;
		h.n2 = 20;
		h.f1();
		h.f1();
	}
}

//ex43-4)
class Tiger {
	static int count = 0;
	int num = 0;
	Tiger() {
		count++;
		num++;
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
		Tiger t3 = new Tiger();
		// 공용으로 사용하기에 count 누적 증가
		System.out.println("생성된 객체 수는: "+Tiger.count);
		System.out.println(t1.num);
		System.out.println(t2.num);
		System.out.println(t3.num);
	}
}

// ex44)
class Tiger {
	private Tiger() {	
	}
}
public class Hello {
	public static void main(String[] args) {
		// Tiger t1 = new Tiger(); tiger객체생성 불가-> private
		// Math m = new Math();
		// m.abs();
		System.out.println(Math.abs(-10));
		Math.abs(-10);
		
	}
}

// ex45)
class Lion {
	
}
class Tiger {
	Lion lion;
	Tiger tiger;
	Tiger() {
		// this = ???; new 쓰기전
		// this = t1; new 쓴 후
		// this = t2
		System.out.println(this.hashCode()); // 1586600255
	}
	// Tiger this; 생략된 코드 내부적으로 만들어짐
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.hashCode()); // 1586600255
		
		Tiger t2 = new Tiger();
		System.out.println(t2.hashCode());
	}
}

// ex46-1) this용법 1
// 함수의 전달 인수와 필드를 구분하기 위한 용도
// 자동생성: 생성자, getter setter, toString
class Tiger {
	String name;
	int age;
	// 가독성이 떨어지는 코드, 인수명이 무엇을 의미하는지 모름
	//	Tiger(String n, int a) {
	//		
	//	}
	// 필드명과 인수 이름 똑같이 사용하는게 원칙으로 
	
	Tiger(String name, int age) {
		this.name = name; // 필드 <= 인수
		this.age = age; // 필드 <= 인수
	}
	
	void f1() {
		// System.out.println(name+""+age);
		System.out.println(this.name+""+this.age);
		// 인수명이랑 구분할 필요도 없는데 왜 붙이냐 
		System.out.println(name+""+age);
	}
	
	// source -> generate constructor using field
//	public Tiger(String name, int age) {
//		super();
//		this.name = name;
//		this.age = age;
//	}

	void f2() {
		f1();
		this.f1();
	}
	void f3(String name, int age) {
		this.name = name;
		this.age = age; 
	}

	@Override
	public String toString() {
		return "Tiger [name=" + name + ", age=" + age + "]";
	}
	
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger("호랑이", 10);
		System.out.println(t1);
		t1.f3("독수리",20);
		System.out.println(t1);
	}
}

// ex46-2) this용법2
// chaining을 목적으로 함
class Tiger {
	// Tiger this;
	Tiger f1() {
		System.out.println("아침");
		// return null;
		// return new Tiger();
		return this;
	}
	
	Tiger f2() {
		System.out.println("점심");
		return this; // 뒤에 체이닝을 걸 수 있다는 말
	}
	void f3() {
		System.out.println("저녁");
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.f1().f2().f3(); // f1이 newTiger리턴했으니까
		// 체이닝
		t1.f1().f1().f1().f2().f1().f3();
		// 밑에 처럼 해도 되는데 왜 체이닝을?
		t1.f1();
		t1.f2();
		t1.f3();
		// 끼어들기 가능. 이질감이 있는 코드가 끼어들 수 있음
		// 끼어들기 막기 위해 체이닝 사용
		// 일괄적인 작업을 유도 시킬 때 
		t1.f1();
		System.out.println("끼어들기");
		t1.f2();
		t1.f3();
	}
}

// ex46-3)this용법 3
class Man {
	void f1() {
		Woman w = new Woman();
		// this -> 다른 클래스에 나의 정보를 던질 때 사용
		boolean result = w.marry(this);
		System.out.println(result ? "^^":"ㅜ.ㅜ");
	}
	String 성격() {
		return "포악";
	}
}
class Woman {
	boolean marry(Man info) {
		String str = info.성격();
		return str == "포악" ? false : true;
	}
}
public class Hello {
	public static void main(String[] args) {
		Man t1 = new Man();
		t1.f1();
		
		Control con = new Control();
		// 여기서 this는 hello객체 던지는 것
		con.makeButton(this, "텍스트", "색상") {
			this.칠하다();
		}
	}
	void 칠하다() {}
	// 첫번째 인수에 this가 있으면 
	// 상대방 클래스에 나의 정보를 던져주는 것이다.
}

// ex47) 상속
class Aaa { // 부모
	void f1() {
		System.out.println(1);
	}
	// 함수 원형(prototype) - void f3() 
	void f3() {
		System.out.println(31);
	} // 직접적으로는 호출 불가 자식에 f3 있기 때문
	
	String f5(int a, int b, String t) {
		return null;
	}
}
class Bbb extends Aaa { // 자식
	void f2() {
		System.out.println(2);
	}
	// 오버라이딩 (overriding) - 부모이름과 똑같음
	void f3() {
		System.out.println(32);
	}
	void f4() {
		f3(); // 바로 위에 32, = this.f3();
		super.f3(); // 부모의 f3 31
	}
	// 오버라이딩 해서 사용하기 
	// 오버라이딩 된 함수라는 것을 알리기 위해 @Override 적어줌 
	@Override
	String f5(int a, int b, String t) {
		return null;
	}
	// 오버라이드 한다고 해놓고 인수 제대로 다 안쓰면 에러
}
public class Hello {
	public static void main(String[] args) {
		Bbb t1 = new Bbb();
		t1.f1(); // 1
		t1.f2(); // 2
		t1.f3(); // 32
		t1.f4();
	}
}

// ex48)
class Aaa { // 조부
	void f1() {
		System.out.println(1);
	}
}
class Bbb extends Aaa { // 부모
	
}
class Ccc extends Bbb {
	
}
class Ddd extends Bbb {
	
}

public class Hello {
	public static void main(String[] args) {
		Ccc t1 = new Ccc();
		t1.f1();
	}
}

// ex49)
// 생성자가 호출되는 실행 순서: 부모 >> 자식 --- 잘못된 해석
// 자식 - 부모임
class Aaa {
	Aaa() {
		System.out.println(1);
	}
	Aaa(int a) {
		System.out.println(3);
	}
}
class Bbb extends Aaa {
	Bbb() {
		// 부모 생성자를 콜하는 코드가 생략되었다.
		// 만약에 생략을 안했다면
		super(100); // 인수 정해주면 밑에 Aaa
		System.out.println(2);
	}
	Bbb(int a, int b) {
		super(); 
		System.out.println(2);
	}
}
public class Hello {
	public static void main(String[] args) {
		Bbb b1 = new Bbb(); // 3 2
		Bbb b2 = new Bbb(3, 4); // 1 2
	}
}

// ex50)
//class Aaa extends Object {
//	
//}
// 실질적으로 작성하는 모든 class는 자식 클래스
class Aaa {
	void f1() {}
}
class Bbb extends Aaa {
	void f2() {}
}
class Ccc extends Bbb {
	void f3() {}
	void f4() {}
}
public class Hello {
	public static void main(String[] args) {
		Ccc t1 = new Ccc();
		StringBuffer sb;
	}
}

// ex51) this용법 4
class Tiger {
	int num;
	int age;
	Tiger() {
		age = 1000; // 이렇게 쓰면 모든 생성자가 다 기본 1000이 됨 -> this로 Tiger()을 부르니까
		System.out.println(1);
	}
	Tiger(int a) {
		this(); // 반드시 코드의 첫줄에 와야함
		num = a;
		System.out.println(2);	
	}
	Tiger(int b, int c) {
		// 위에 Tiger(int a)를 콜하고 싶다면
		this(b*c);
		System.out.println(3);
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger(10, 30);
		Tiger t2 = new Tiger();
		System.out.println(t2.age);
	}
}