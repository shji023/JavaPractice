package Pack01;

import java.util.Random;

/*
class Tiger{

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
class Tiger{
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
class Tiger{
	int number;
}
class Lion{
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
class Tiger{
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

// ex37) �Լ� �����ε� ����
class Tiger{
	int getRectangle(int w, int h) {
		return w * h;
	}
	// �۸�-> �����ε��� ������ ���� getRectangle2 �̷������� ����
	int getRectangle(int x1, int y1, int x2, int y2){
		int width = x2-x1+1;
		int height = y2-y1+1;
		return width * height;
	}
}
public class Hello {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		System.out.println(t1.getRectangle(10, 5));
		System.out.println(t1.getRectangle(10, 5, 20, 15));
	}
}
