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

// ex2) ���ڿ�, ���ڿ�
public class Hello {
	public static void main(String[] args) {
		System.out.println(100); // ����
		System.out.println('s'); // ����
		System.out.println("double space"); // ���ڿ�
		System.out.println(100+200); // ���� ����
		System.out.println(100+"string"); // ���ڿ� ����->���� ġȯ��
		System.out.println("string"+100); // ���ڿ� ����->���� ġȯ��
		System.out.println("string"+"string"); // ���ڿ�
		System.out.println("100"); // ���ڿ�
		System.out.println("100"+"100"); // ���ڿ�
		System.out.println(10+20+"ȣ����"); // ���������� ���, ����+���� => ����, ����+���ڿ�=>���ڿ�
		System.out.println("ȣ����"+10+20); // ���������� ���, ���ڿ�+���� => ���ڿ�, ���ڿ�+���ڿ�=>���ڿ�
		System.out.println(10+" "+20); // ���ٿ� �ΰ��� ������
		System.out.println(10+'A'); //���� ������� �Ͼ�� �ƽ�Ű �ڵ�� ġȯ
		System.out.println(1+'A'); // �빮�� �ƽ�Ű�ڵ� 65
		System.out.println((char)66); // type casting
	}
}

// ex3) �������
 public class Hello {
	public static void main(String[] args) {
		System.out.println(17+3);
		System.out.println(17-3);
		System.out.println(17*3);
		System.out.println(17/3);
		System.out.println(17%3);
		System.out.println(3+4*5); // ����, �������� �켱������ ����
		System.out.println((3+4)*5); // ��ȣ ������ ���� �켱������ ����
		System.out.println(2+3*4+5);
	}
}

// ex4) ���迬��
public class Hello {
	public static void main(String[] args) {
		System.out.println(10 > 5); // >=, <, <=, ==, != ����� true, false

	}
}

// ex5) ������
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
		
		// ��� > ���� > �� ������� ����
		System.out.println(3+2 > 7 && 2+6 < 8);
		
		//����������
		System.out.println(!(3>2));
	}
}

// ex6) typeũ��
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

// ex7)primitive typeȰ��
public class Hello {
	public static void main(String[] args) {
		// byte, short, int, long
		byte apple; // ���� ��ȯ ��ų �� �ִ� -> ����
					// ���� ��ȯ ��ų �� ���� -> ���
		// ���� ����
		apple = 10;
		System.out.println(apple);
		apple = 20;
		System.out.println(apple);
		//apple = 200; err -128~127������ ����
		apple = 127;
		
		//type variable ���Կ����� ���ͷ�
		short banana = 20; // ����� ���ÿ� �� �Ҵ� ���� 
		int orange = 30;
		long kiwi = 22292999;
		//byte, short ���� �Ⱦ�, int �Ϲ������� ���� ���
		
		//boolean(1), char(2byte), float(�Ҽ���, 4byte), double(8byte�Ҽ���)
		boolean t1 = true;
		char t2 = 'A';
		char t3 = 'B';
		// ���� �ڵ�� ������ ���Ѵ�. �������� ������
		char t4 = 65;
		System.out.println((int)(t3+1));
		System.out.println((char)(t3+1));
		
		// char�� ������ ���� 0~2^16
		System.out.println((int)Character.MAX_VALUE);
		System.out.println((int)Character.MIN_VALUE);
		
		float t5 = 3.14f; // float Ÿ���� �ݵ�� ���� �ڿ�f ���̱�
		double t6 = 3.14; // f �ʿ����, �� �� ������ �۾� �� ���, float�� ������ �ֱ⿡ 
		System.out.println(t5);
		
		double sum = 0.0;
		
		for (int i = 0; i<100; i++) {
			sum = sum + 0.1;
		}
		System.out.println(sum); // ��������
	}
}

// ex8)����Ư��
public class Hello {
	public static void main(String[] args) {
		// 1. �����̸� �ߺ��� �� ����
		int apple;
		// 2. ��ҹ��� ���� �ȴ�
		int Apple;
		// 3. ù���ڰ� ���ڰ� �ƴ϶�� ���� ��밡��
		int Apple123;
		// int 9Apple (x)
		
		// 4. _ $ ���� Ư������ ��� �Ұ�
		int apple_num;
		int _34; // ���� ��Ŀ��� ���
		
		// 5. �ѱ� ��� ����(������ ���Ѵ�.)
		int ���;
		
		// 6. �� �ܾ� �̻� �ռ��ÿ��� ī��ǥ��� ���
		int bananaNum;
	}
}

// ex9)
public class Hello {
	public static void main(String[] args) {
		int n = 10;
		n = 20; // ������ ����, 20
		n = n + 10; // 30
		// ���� ���� ������ - ������ �ӵ� ����, ����ӵ� ����
		n += 10; // 40
		
		// ���׿�����
		n++; // ����ӵ� ���� ���� assembly - add, move����
		++n; // inc����
		
		n=10;
		int a, b;
		a = n++; // ����->����, a=10 n=11
		n=10;
		b = ++n; // ����->����, b=11 n=11
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

// ex11) ��� if, for, while, switch >>> do while(���x)
public class Hello {
	public static void main(String[] args) {
		// if
		if(true) {
			System.out.println(1);
		}
		// unreached�ڵ�
		if(false) { 
			System.out.println(2);
		}
		// ��� ����� ��� �ȿ� ����� �� ����
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
		// if else �ȿ� ���� ������ ����ؾ���, �߸��� �ڵ�
		int password = 1234;
		if(password != 1234) {
			System.out.println("Ʋ��");
		} else {
			System.out.println("����");
			System.out.println("�α��� �Ǿ����ϴ�.");
			System.out.println("���� ���� Ȯ��");
		}
		// �̷�������
		int password1 = 1234;
		if(password1 != 1234) {
			System.out.println("Ʋ��");
			//break
		}
			System.out.println("����");
			System.out.println("�α��� �Ǿ����ϴ�.");
			System.out.println("���� ���� Ȯ��");
			
		int nn = 10;
		if(nn < 0) {
			nn = -nn;
		}else {
			nn = +nn; // ���� �� �ʿ������ �ùٸ� �ڵ�. ����Ǵ� �ð��� ����ȭ �Ǳ⿡ �Ϲ������� �־���
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
		//����ӵ� ����ȭ �ϱ� ���� �� ���� ������ if else ��� switch���
	}
}

// ex14)
public class Hello {
	public static void main(String[] args) {
		// ����1
		for (int i = 0; i <	4; i++) {
		// break�� Ż��, continue�� i++	
			System.out.println(i);
		}
		// ����2
		for (int i = 1; i <= 4; i++) {
			System.out.println(i);
		}
		// ����3 - ����ȭ�� ���õ�
		for (int i = -3; i <= 3; i++) {
			System.out.println(1);
		} 
	}
}

// ex15) ������ ����
public class Hello {
	public static void main(String[] args) {
		// for���� ���ø� �������� ���α� �������� ���� �ϵ���
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
		
		//2�� 8��
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
		for (int i = 0; i < 3; i++) { // ����
			for (int j = 0; j < 4; j++) { // ����
				System.out.print("*");
			}
			System.out.println(); // �ٹٲ�
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
		
		// ���׿�����
		int result;
		if(3>2) {
			result = 10;
		}else {
			result = 20;
		}
		// �� ������ ��� ������ ���׿������� �����Ѵ�.
		result = (3>2)? 10: 20;
		
//		int func() {
//			return 3>2 ? 100:200;
//		}
	}
}

// ex17) while (����ϰ� ���: for) �ݺ�Ƚ�� ó������ �𸦶� ���
public class Hello {
	public static void main(String[] args) {
//		int num = 0;
//		while(true) {
//			num++;
//			System.out.println(num);
//		}
		// �ݺ�Ƚ���� �� ���� for�� ����ϱ�
		int num = 0;
		while(num < 4) {
			System.out.println(num);
			num ++;
		}
		//break
		num = 0;
		while(true) {
			if(num == 4) {
				System.out.println("break ��");
				break; // while���� ��������
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
		// 1. switch�ȿ� ������ ����� �� �ִ�.
		// 2. case�ڿ� ������ ����� �� ����.
		// 3. break�� �����ϸ� switch�� ���������� ����.
		// 4. �����ϴ� �б⹮�� ���� ���� default�� �̵��Ѵ�.
		// 5. ����, ����, ���ڿ� ��� �бⰡ ���� 
		// 6. �ǵ������� break�����ϱ⵵ �Ѵ�.
		char ch = '��';
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

// ex22) switch Ȱ��
public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		// 0~9���� �����ϰ�
		int num = rnd.nextInt(30);
		switch(num%2) {
		case 0: {
			for (int i = 0; i < 10; i++) {
				System.out.println(num + "*" + i + "="+ num*i);
			}
			
		} break; // ���� �̻��� ��쿡�� �߰�ȣ ���� �ڿ� �ٷ� break
		case 1:{
			int sum = 0;
			for (int i = 1; i <= num; i++) {
				sum += i;
			}
			System.out.println(num + "������ ����"+sum);
		} break;
		default:
			break;
		}
	}
}

// ex23) �迭(array)
public class Hello {
	public static void main(String[] args) {
		// 1.  ����
		int[] arr = new int[10]; // A[] arr = new A[1]
		
		// 2. ���� ���ÿ��� ���
		int[] brr = new int[] {10, 20, 30};
		
		// 3.
		int[] crr = {40, 50, 60};
		
		// arr�� ������ 10�� �ִ�.
		
		arr[0] = 10;
		System.out.println(arr[0]);
		System.out.println(arr[1]); // �� ������ �ʱ�ȭ 0 -> �ӵ� ���� ����
		
		arr[9] = 20;
		System.out.println(arr[9]);
		
		// ArrayIndexOutOfBoundsException, ���α׷� �ߴܵ�
		//arr[-5] = 100; 
		//arr[10] = 100;
		System.out.println("ȣ����");
		
		// �ε����� ���� ��� �� ������� ����
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
		}System.out.println(); // �ٹٲޱ��� �ϳ��� ������
		System.out.println("������");
	}
}

// ex24)
public class Hello {
	public static void main(String[] args) {
		Random rnd = new Random();
		int[]  arr = new int[10];
		// ������ ���Ű� ����� ���� ����
		for (int i = 0; i < arr.length; i++) {
			//������ ����
			arr[i] = rnd.nextInt(20);
		}
		for (int i = 0;  i < arr.length; i++) {
			// ������ ���
			System.out.print(arr[i]+" ");
		}System.out.println();
		
		// �Ǿ�+�ǵ�, �״��� ��+�״��� ��, ...
		int sum = 0;
		for (int i = 0; i < arr.length/2; i++) {
			sum += arr[i] + arr[arr.length-i-1];
			System.out.print(sum+" ");
			sum = 0;
			
		}

		
	}
}

// Ŭ������ ù���ڴ� �빮��
class Airplane {
	// 1. �ʵ�(����) >> �Ӽ�
	// ��� ����
	int a; 
	float b;
	int seat;
	// int[] arr; �޸𸮸� � ��û? ����. new�� �ȸ���� �Ҵ�Ǵ� �޸� ����
	int[] arr = new int[4];
	
	int num = 99;
	// 2. ������
	// 3. �޼ҵ�(�Լ�)
}
// ex25) Ŭ����
public class Hello {
	public static void main(String[] args) {
		// ���� ����Ⱑ �������
		Airplane air = new Airplane();
		Airplane air2 = new Airplane();
		
		// air.a = 10; dot-ü�̴�
		air.b = 20.0f;
		air.seat = 30;
		
		System.out.println(air.a); // 0���� �ʱ�ȭ��
		System.out.println(air.b); // 20.0
		
		air2.seat = 40;
		//air�� air2�� ���δٸ� �޸��̴�.
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
		
		// ������ ������ ������� ���ο� �޸� �Ҵ��
		air.arr = new int[8];
				
		// �ΰ� ����
		// int[]ar;
		// ar = new int[10];
		// ar�� ����ߴٰ� ġ�� ������ 10���� �����. ���ο� 20���� ����
		// ar = new int [20];
		
		// �޸� �ݳ� �ڵ�
		// delete ar; << �ڹٿ����� ���α׷��Ӱ� �Ű澵 �κ��� �ƴϴ�.
		
		// ���� ���⸸ ���� �ٸ� �޸𸮾ȿ� ����
		System.out.println(air.num); // 99
		System.out.println(air2.num); // 99
	}
}

class Tiger {
	// 1. void f1() {} / ���Ͼ��� f1(�μ����� ����) {}
	// 2. void f1(int a) {} / ���Ͼ��� f1(�μ����� ����) {}
	// 3. int f1() {} / �����ִ� f1(�μ����� ����) {}
	// 3. int f1(int a) {} / �����ִ� f1(�μ����� ����) {}
	
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
		// �ڵ��� ��Ȱ��
		// �Լ�(�޼ҵ�): ���� ���Ǵ� �ڵ带 �����ؼ� ��Ȱ���Ѵ�.
		Tiger t1 = new Tiger();
		System.out.println(1000);
		t1.method01(); // �Լ��� ȣ���Ѵ�. method01�� ���α׷� �бⰡ �Ͼ
		System.out.println(2000);
		
		Tiger t2 = new Tiger();
		t2.method01(); // �Լ� �޸𸮴� �� �ѹ��� �������
		t1.method02();
		t2.method02();
	}
}

// ex27) class2
class Tiger {
	void m1() {
		System.out.println("��");
	}
	void m2(int num) {
		//num�� ��������
		System.out.println("��" + num);
	}
	void m3(int num) {
		for (int i = 0; i < num; i++) {
			System.out.print("��");
		}
	}
	// �ΰ��� �μ��� ���� �� type�� �ٿ��־����
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
		// ����, ����
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
	// ���� ���� �ؾ���.
	int func02() {
		return 100;
	}
	// �޼ҵ忡�� return Ű���带 ������ �Լ��� �ߴܵȴ�. 
	
	int func03() {
		if (3>2) {
			return 100;
		} else if ( false ) {
			return 200;
		}else {
			System.out.println(1000); // � ������ �ڵ尡 ���� �Ǵ��� return�� ��������
			//return 300;
		}
		return 2000;
	}
	 // void ������ return Ű���带 ����� �� �ִ�.
	void func04() {
		for (int i = 0; i < 10; i++) {
			if(i==5) {
				break; // for�� Ż�� 
				// return; func04 �ߴ�
			}
		}
		System.out.println("for �ߴܵ�");
	}
	int func05(int num) {
		// return num * num;
		int result = num * num;
		return result;
	}
	int func06(int num) {
		return num * num;
	}
	// ��Ģ�� ����� (������ -1���� ���) 
	// -1�� ���ϵ� ���� ������ ����̴�. 
	int func07(int num) {
		if(num < 0) {
			System.out.println("������");
			return -1; 
		}
		if (num % 2 == 0) {
			System.out.println("¦");
		} else {
			System.out.println("Ȧ");
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
		
		// �� ������ -> ���ϰ��� ���µ� ����Ϸ��ϱ� ����
		// System.out.println(t1.func01());
		
		t1.func04();
		t1.func05(5);
		t1.func07(-4);
		
		if(t1.func07(-4)==-1) {
			// ��¹��� main���� ��� ������ ������
			// �Լ����� ���� ������ �ѹ� ����θ� ����ϱ⿡ ������ ���� ����
			System.out.println("�����Դϴ�.");
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
	// ��ȣȣ�� - ���� ����
	void f4() {
		System.out.println(4);
		f5();
	}
	void f5() {
		System.out.println(5);
		f4();
	}
	// ��� ȣ��(recursive call)
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
		// �̸� ��ø �� �������� ���� ���
		// �μ����� ���� ���ȴ�.
		int result = a + b;
		System.out.println(result); // 500
		// �ʵ��� a, b�� ����ϰ� ������?
		// this ���
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
		// String: ���ڿ��� ���������� �����Ѵ�. ù���� �빮��!( =Ŭ����)
		// �������� ���µ�? => ǥ������ �����Ǵ� Ŭ����
		// ����ɸ��� method�� ���� ������
		
		String s1 = new String();
		s1 = "ȣ����";
		System.out.println(s1);
		System.out.println(s1.length());
		
		// ��� ǥ��
		String s2 = "�޹���";
		System.out.println(s2);
		
		Math m;
	}
}

// ex32)
class Tiger {
	// String�� �μ��� ���� �� �ִٴ� ���� class�� �޴°�
	// �μ��� ���� �� �ִ°� : primitive type + class
	void m1(float a, String s) {
		System.out.println(a+" "+s);
		System.out.println(s.length());
	}
	String m2() {
		String s = "ȣ����";
		return s;
	}
	String m3() {
		return null; // �ʱ⿡ null�� ����
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.m1(3.14f, "ȣ����");
		
		String s = t1.m2();
		System.out.println(s);
		
		// ������ ��ü�� ������ �ȴٸ� ���� �̸��� �����س�����
		// ��ü�� ������ ���� �ƴ�
		String s2;
		// s2.length(); ����
		
		// ���� s2�� ��ü�� �ƴϴٶ�� ���� ��������� ǥ��
		String s3 = null;
		s3 = "�ڳ���";
		// �����ϰ� ����ϴٰ�..
		s3 = null;
	}
}

// ex33)
class Tiger {

}
class Lion {
	// Lion�� �ɱ�?
	// Tiger t = new Tiger() => t�� newTiger()�ϱ� newTiger()�Ѱ��ָ��
	void m1(int a, String s, Tiger t, Lion l) {
		if(s != null) {
		}
	}
	Tiger m2() {
		return null;
	}
	Tiger m3() {
		return new Tiger(); // Ŭ���� ��ü ���� ����
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
		// String���� null�� �־��൵ ��-> ����� ���Ϸ���
		t1.m1(10, "ȣ����", new Tiger(), new Lion());
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
		// System.out.println(t3.hashCode()); err=>�ؽ��ڵ带 �� �� ���� ���� ���� �Ұ���
		t3 = t1; // �ؽ��ڵ� �� �ο� 
		//�޸𸮸� �����Ѵ�.(�����Ѵ�)
		System.out.println(t3.hashCode());
		System.out.println(t1.num);
		System.out.println(t3.num);
		t1.num = 200;
		System.out.println(t3.num);// t1�� �ٲ㵵 ��ȭ��
	}
}
// ex35)
class Tiger {
	int number;
}
class Lion {
	// Tiger bbb = aaa; �ڷ� ����
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

// ex36) �����ε�(Overloading): �Լ��̸��� �����ϰ� �۸� ������ ���
class Tiger {
	void showMeTheMoney() {
		System.out.println(1);
	}
	// �μ� ���� ���� �ٸ� �� ������ �̸��� �Լ� ��� ����
	void showMeTheMoney(int a) {
		System.out.println(2);
	}
	void showMeTheMoney(int a, int b) {
		System.out.println(3);
	}
	// �μ� ���� ���Ƶ� Ÿ���� �ٸ� �� ������ �̸��� �Լ� ��� ����
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
		float f = 3; // ��ȣ�ϰ� 3.0f�� �Ⱦ���
		t1.showMeTheMoney((float)3); // type casting�� �Ҽ��� ����
		// type casting�� �ٿ� 3.0f ��Ȯ�ϰ� ���°� ����
		
	}
}

//ex37) �Լ� �����ε� ��
class Tiger {
	int getRectangle(int w, int h) {
		return w * h;
	}
	// �۸�-> �����ε��� ������ ���� getRectangle2 �̷������� ����
	int getRectangle(int x1, int y1, int x2, int y2){
		int width = x2-x1+1;
		int height = y2-y1+1;
		return width * height;
	}
	// ��, ���� ���� �ٸ���쿡�� �����ε� �Ұ���
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.getRectangle(10, 5));
		System.out.println(t1.getRectangle(10, 5, 20, 15));
	}
}
// ex38) ������ 
// 1. ��� ����: �ʵ� �ʱ�ȭ
// 2. ������ �޼ҵ� => �Լ��̴�.
// 3. �Լ��� �̸��� �ݵ�� Ŭ���� �̸��� ����
// 4. �μ��� ���� ���� �� ������, return�� ���� �� ����.
// 5. �μ� ������ ���� �����ڸ� ����Ʈ �����ڶ�� ��.
// 6. ȣ���� newŰ���带 ����� �� �� 1�� ȣ���.
// 	  ���α׷��Ӱ� ���Ƿ� ȣ���� �� ����.
// 7. �Լ��̱⶧���� �����ε��� �� �� ����
// 8. �������ڵ带 �ۼ����� ������ �ڵ����� �ۼ���.
//	  <-> ������ �ڵ带 �ۼ��ϸ� �ڵ����� ������ �ڵ尡 ��������� ����
class Tiger {
	// �ʵ�
	int age;
	
	// ����Ʈ ������
	Tiger() {
		System.out.println("������ ��");
		age = 100;
	}
	// �޼ҵ�
}
public class Hello {
	public static void main(String[] args) {
		System.out.println(1);
		Tiger t1 = new Tiger(); // new ������ ������ ȣ���. Tiger()�Լ� ȣ���Ͻÿ�.
		System.out.println(2);
		
		// ��ü�� �ѹ� �� �����?
		Tiger t2 = new Tiger(); // �� ������ ȣ��
		System.out.println(3);
		
		for (int i = 0; i < 3; i++) {
			Tiger temp = new Tiger();
			System.out.println(temp.hashCode());
		}
	}
}
// ex39)
class Tiger{
	// �����ڿ��� �� ������ �� �ֵ��� int age = 100; �̷�������x
	int age;                // �ʱ�ȭ���1(��������)
	Tiger() {				// �ʱ�ȭ���2(���߽���)
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
	int age = 10; // �ʱ⿡ ���� �־������ ����� ������ 10
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
	
	// �������� �ڵ����� ������
	// ������ �ڵ����� �ȸ�������� ������ Tiger t1 = new Tiger(); ������
	Tiger(){} // �׳� ������, �Ϲ������� �̸� �����ش�.
	Tiger(int data) {
		//name = null;
		name = "�͸�";
		age = data; 
	}
	Tiger(String n, int data) {
		name = n;
		age = data;
	}
	//����� ����� �� �ִ� �����Լ��� �����
	void showData() {
		System.out.println(name+" "+age);
	}
	
	// �ش��Լ� �巡���ϰ� ��Ŭ��->source->generate toString
	@Override
	public String toString() {
		return "Tiger [name=" + name + ", age=" + age + "]";
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger(100);
		System.out.println(t1.name+" "+t1.age);
		Tiger t2 = new Tiger("ȫ�浿", 200);
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
	// ��ǰ ���
	// �ۿ��� ���������� ����ϴ� ���� �ݱ�
	// data, �������� ������ ���� �Ǵ� ���� ����
	// data ���� �ʿ�
	private int age; // �ڿ��ִ� �ʵ�� Ŭ���� �ȿ����� ����ϱ�
	// �� �������� ����� �� ���� ���� public. ���� default Ű���� ���,  
	private String name; 
	
	// getter setter �޼ҵ�
	// get(read), set(write)���� �ܺ��� �� �����ϴ°Ϳ� ���� ����Ǽ� 4���� ����
	// �ܺο��� �����ص� �ǰڴ� ���� �͵� ���������� ���� ����
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
	
	// f1, f2�� f3�� �������� ���°��̱⿡ private���� ����
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
		// ����ʵ�� ��ü�� �������Ѽ�
		// ���� ����ϴ� ���� ���� xx
		// System.out.println(t1.age);
		// Ŭ�������� �Ӽ��� ������ �巯�� ����
		// t1.money = 200;
		// ��ü�� ����� ����� Ŭ���� �ȿ� �ʵ峻���� �𸣰� ����� �� �˾ƾ���
		// �Լ��� ��������ν�
		
		// t1.f1(); private�̶� ���� �Ұ�
		t1.setAge(1000);
		System.out.println(t1.getAge());
		
	}
}

//ex43) static (���赵 �ȿ� ����ִ� ����ž �Ѱ��� ����� ��������. �Ź� ��ü �����Ҷ����� �׸��� ����)
class Tiger {
	
	static int n1; // �ʵ�� static Ȱ�밡��, ��� ��ü�� n1�� �������� ����Ѵ�.
	int n2;
	// static-�������� �Ǹ� Ŭ���� �ܺη� ���������� �ڵ� 
	// ��� ��ü�� ����ž�� �������� ����Ѵ�.
	static void ����ž() {
		System.out.println("��");
	}
	void fly() {
		
	}
}
public class Hello {
	public static void main(String[] args) {
		// �ؿ� �ּ��ؼ� ��ü ���� ���ϸ� fly ��� �Ұ�
		// Tiger t1 = new Tiger();
		Tiger.����ž(); // ��ü ���� ���ص� ��밡��
		// ������ �� �ܺο��� �̹� �����ϱ� ������
		// fly���� ������ ��ü �������Ѽ� �����
		Tiger t1 = new Tiger();
		t1.fly();
		t1.����ž(); // ��ü�ε� ����ž ���� ����
		System.out.println(Tiger.n1);
		System.out.println(t1.n2);
	}
}

// ex43-1)
class Tiger {
	// �ʵ�� ��ü ����´�� ����µ� 
	// �Լ��� �ѹ��� �������
	// �׷��� �� �ѹ��� ��������� static�� ����ؾ��ұ�?
	// ��ü�� ������Ű�� new ������ ����� �ſ� ����
	// static->�ý����� �ӵ��� �䱸�� �� �����
	static void f1() {
		
	}
	void f2() {
		
	}
}
public class Hello {
	// �Ʒ� �ڵ� ��� �ۼ� ����
	int age;
	Hello() {
		
	}
	void  f1() {
		
	}
	// ������(Entry Point)
	// static - ��ü�� ������Ű�� �ʾƵ� �޸𸮸� ����
	// main ȣ���� OS
	// Hello h = new Hello();
	// h.main();
	// Hello.main()
	public static void main(String[] args) {
		// ��ü ���� ����� ���� ���.
		Tiger t1 = new Tiger();
		Tiger t2 = new Tiger();
	}
	// ���� �Ʒ� �ڵ� �ۼ��ص� ����
	void f2() {
		
	}
}

// ex43-2)
class Tiger {
	int n1;
	static int n2;
	static void f1() {
		// n1 = 100; ���� �޸𸮸� ��� ������ ������ ���� 
		n2 = 200;
		// f2();
		f3();
		// static�ȿ����� static�� ��밡��
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
		Hello h = new Hello(); // hello ��ü �ΰ�-> window��ü ����, ���� ����
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
		// �������� ����ϱ⿡ count ���� ����
		System.out.println("������ ��ü ����: "+Tiger.count);
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
		// Tiger t1 = new Tiger(); tiger��ü���� �Ұ�-> private
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
		// this = ???; new ������
		// this = t1; new �� ��
		// this = t2
		System.out.println(this.hashCode()); // 1586600255
	}
	// Tiger this; ������ �ڵ� ���������� �������
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.hashCode()); // 1586600255
		
		Tiger t2 = new Tiger();
		System.out.println(t2.hashCode());
	}
}

// ex46-1) this��� 1
// �Լ��� ���� �μ��� �ʵ带 �����ϱ� ���� �뵵
// �ڵ�����: ������, getter setter, toString
class Tiger {
	String name;
	int age;
	// �������� �������� �ڵ�, �μ����� ������ �ǹ��ϴ��� ��
	//	Tiger(String n, int a) {
	//		
	//	}
	// �ʵ��� �μ� �̸� �Ȱ��� ����ϴ°� ��Ģ���� 
	
	Tiger(String name, int age) {
		this.name = name; // �ʵ� <= �μ�
		this.age = age; // �ʵ� <= �μ�
	}
	
	void f1() {
		// System.out.println(name+""+age);
		System.out.println(this.name+""+this.age);
		// �μ����̶� ������ �ʿ䵵 ���µ� �� ���̳� 
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
		Tiger t1 = new Tiger("ȣ����", 10);
		System.out.println(t1);
		t1.f3("������",20);
		System.out.println(t1);
	}
}

// ex46-2) this���2
// chaining�� �������� ��
class Tiger {
	// Tiger this;
	Tiger f1() {
		System.out.println("��ħ");
		// return null;
		// return new Tiger();
		return this;
	}
	
	Tiger f2() {
		System.out.println("����");
		return this; // �ڿ� ü�̴��� �� �� �ִٴ� ��
	}
	void f3() {
		System.out.println("����");
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		t1.f1().f2().f3(); // f1�� newTiger���������ϱ�
		// ü�̴�
		t1.f1().f1().f1().f2().f1().f3();
		// �ؿ� ó�� �ص� �Ǵµ� �� ü�̴���?
		t1.f1();
		t1.f2();
		t1.f3();
		// ������ ����. �������� �ִ� �ڵ尡 ����� �� ����
		// ������ ���� ���� ü�̴� ���
		// �ϰ����� �۾��� ���� ��ų �� 
		t1.f1();
		System.out.println("������");
		t1.f2();
		t1.f3();
	}
}

// ex46-3)this��� 3
class Man {
	void f1() {
		Woman w = new Woman();
		// this -> �ٸ� Ŭ������ ���� ������ ���� �� ���
		boolean result = w.marry(this);
		System.out.println(result ? "^^":"��.��");
	}
	String ����() {
		return "����";
	}
}
class Woman {
	boolean marry(Man info) {
		String str = info.����();
		return str == "����" ? false : true;
	}
}
public class Hello {
	public static void main(String[] args) {
		Man t1 = new Man();
		t1.f1();
		
		Control con = new Control();
		// ���⼭ this�� hello��ü ������ ��
		con.makeButton(this, "�ؽ�Ʈ", "����") {
			this.ĥ�ϴ�();
		}
	}
	void ĥ�ϴ�() {}
	// ù��° �μ��� this�� ������ 
	// ���� Ŭ������ ���� ������ �����ִ� ���̴�.
}

// ex47) ���
class Aaa { // �θ�
	void f1() {
		System.out.println(1);
	}
	// �Լ� ����(prototype) - void f3() 
	void f3() {
		System.out.println(31);
	} // ���������δ� ȣ�� �Ұ� �ڽĿ� f3 �ֱ� ����
	
	String f5(int a, int b, String t) {
		return null;
	}
}
class Bbb extends Aaa { // �ڽ�
	void f2() {
		System.out.println(2);
	}
	// �������̵� (overriding) - �θ��̸��� �Ȱ���
	void f3() {
		System.out.println(32);
	}
	void f4() {
		f3(); // �ٷ� ���� 32, = this.f3();
		super.f3(); // �θ��� f3 31
	}
	// �������̵� �ؼ� ����ϱ� 
	// �������̵� �� �Լ���� ���� �˸��� ���� @Override ������ 
	@Override
	String f5(int a, int b, String t) {
		return null;
	}
	// �������̵� �Ѵٰ� �س��� �μ� ����� �� �Ⱦ��� ����
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
class Aaa { // ����
	void f1() {
		System.out.println(1);
	}
}
class Bbb extends Aaa { // �θ�
	
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
// �����ڰ� ȣ��Ǵ� ���� ����: �θ� >> �ڽ� --- �߸��� �ؼ�
// �ڽ� - �θ���
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
		// �θ� �����ڸ� ���ϴ� �ڵ尡 �����Ǿ���.
		// ���࿡ ������ ���ߴٸ�
		super(100); // �μ� �����ָ� �ؿ� Aaa
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
// ���������� �ۼ��ϴ� ��� class�� �ڽ� Ŭ����
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

// ex51) this��� 4
class Tiger {
	int num;
	int age;
	Tiger() {
		age = 1000; // �̷��� ���� ��� �����ڰ� �� �⺻ 1000�� �� -> this�� Tiger()�� �θ��ϱ�
		System.out.println(1);
	}
	Tiger(int a) {
		this(); // �ݵ�� �ڵ��� ù�ٿ� �;���
		num = a;
		System.out.println(2);	
	}
	Tiger(int b, int c) {
		// ���� Tiger(int a)�� ���ϰ� �ʹٸ�
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