package Pack01;

import java.util.Random;

/*
public class Hello {
	public static void main(String[] args) {
	}
}
*/
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
/*
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
 */