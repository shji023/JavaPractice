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
// ex66)final(������)
class Tiger {
	// 1. �ʵ� final (���� �ʱ�ȭ ��Ű�� ���� ���Ⱑ ������)
	// ���ȭ �Ǿ� ������. (������ �������� ����̴�.)
	// const
	final int num = 10;
	// �� �ʵ忡�� �ʱ� ���� ���־������� �ѹ� ���� ������
	void f1() {
		// this.num = 20; err
	}
	void f2() {
		// this.num = 20; err
	}
}
public class Hello2 {
	public static void main(String[] args) {
		Tiger t1 = new Tiger();
		// t1.num = 20; ����
	}
}
/*
// ex52) ������ ��ĳ���� ***** �ſ��߿� 
class Aaa {
	void f1() {}
}

class Bbb extends Aaa {
	void f2() {}
}
public class Hello2 {
	public static void main(String[] args) {
		// ����ϰ� �ƹ� ���谡 ����
		Aaa t1 = new Aaa(); // �θ� = �θ�
		t1.f1();
		
		// ��ĳ����(UpCasting)
		Aaa t2 = new Bbb(); // �θ� = �ڽ�
		t2.f1(); // f2()�޸𸮰� �ִµ� ����� ���һ�
		
		// �ٿ�ĳ����(�ڹٿ��� ������)
		// Bbb t3 = new Aaa(); �ڽ� = �θ�
		
		Bbb t4 = new Bbb(); // �ڽ� = �ڽ�
		t4.f1();
		t4.f2();
	}
}

class Aaa {
	void f1() {}
	void f3() {
		System.out.println("�θ�f3");
	}
	void f4() {
		System.out.println("�θ�f4");
	}
}

class Bbb extends Aaa {
	void f2() {}
	void f4() {
		System.out.println("�ڽ�f4");
	}
}
public class Hello2 {
	public static void main(String[] args) {
		Aaa t = new Bbb();
		t.f3(); // �θ�f3
		t.f4(); // �ڽ�f4
		
		// ���� ������ ó�� ���ص� ����� �Ȱ����� �� ���� ���� ����ұ�?
		Bbb t2 = new Bbb();
		t2.f3(); // �θ�f3
		t2.f4(); // �ڽ�f4
	}
}

// ex53)
class Animal {
	void cry() {
		System.out.println("�Ҹ��� �� �� ����");
	}
}
class Tiger extends Animal {
	@Override
	void cry() {
		System.out.println("����");
	}
}
class Cat extends Animal {
	@Override
	void cry() {
		System.out.println("�߿�");
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
		
		// �� �ؿ� ó�� �ᵵ �Ǵµ� Animal�� ����?
		Tiger t4 = new Tiger();
		t4.cry();
		Cat t5 = new Cat();
		t5.cry();
		Snake t6 = new Snake();
		t6.cry();
		
		// �迭 ���ΰ� ���ϳ�
//		String s0, s1, s2, s3;
//		s0 = "ȣ����0";
//		s1 = "ȣ����1";
//		s2 = "ȣ����2";
//		s3 = "ȣ����3";
		
		// ��ü4���� ������ų �� �ִ� ���� 4���� ���� ��
		// ���ڿ� ��ü�� ������� ���� �ƴ�
		String[] arr = new String[4];
		arr[0] = "ȣ����0";
		arr[1] = "ȣ����1";
		arr[2] = "ȣ����2";
		arr[3] = "ȣ����3";
		
		String[] ar = new String[] {"ȣ����0","ȣ����1","ȣ����2","ȣ����3"};
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		// ���� ��ü ��������� x
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
		System.out.println("�Ҹ��� �� �� ����");
	}
}
class Tiger extends Animal {
	@Override
	void cry() {
		System.out.println("����");
	}
}
class Cat extends Animal {
	@Override
	void cry() {
		System.out.println("�߿�");
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
			// ��ĳ������ ����ϰԵǸ� switch���� �����
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
		// ��ĳ���� Ȱ������ ���
		// ��ĳ���� �����ϸ� switch�� ����� �� �ִ� ��� ����
		Animal[] ani = new Animal[] {new Tiger(), new Cat(), new Snake()};
		for (int i = 0; i < 6; i++) {
			ani[rnd.nextInt(3)].cry();	
		}
		
	}
}

// ex55) ������
class Animal {
	void cry() {
		System.out.println("�Ҹ� ���� ����");}
}

class Tiger extends Animal {
	void cry() {System.out.println("����");}
}
class Cat extends Animal{
	void cry() {System.out.println("�߿�");}
}
class Snake extends Animal{
}
// Lion �߰��ص� zoo ���� ����
class Lion extends Animal{
	void cry() {System.out.println("���");}
}
// zoo��� Ŭ������ �ϼ��� �ǰ� ���� ������ �ڵ带 ���� ���ϴ°� ����
// �ܺο��� ������ �߰� �ɶ����� �ڵ尡 ������ �Ǹ� ....����
class Zoo extends Animal{
	void sound(Animal t) {
		t.cry(); // �پ��� ������ ����� ���� �� ���� -> ������ ���α׷�
	}
	// �ؿ� �� ���� ���� ����ó�� �θ� �޾ƶ� �׷� �Ȱ���
	// ��ĳ����
	// ���� ��� ��Ģ
	// ��ĳ������ �ϸ� ������ ���α׷��� �ڵ����� 
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
// 4. �߻�޼ҵ尡 �ִ� �߻�Ŭ�������� abstract �ٿ�����
abstract class Aaa {
	// 1. �������̵��� ��ǥ�� �Ѵ�.
	// 2. ���� ������ �ڵ带 �ۼ��� ������ ����.
	// void f1() {}
	// 3. void f1(); �̷��� �߰�ȣ ����-> �̿ϼ� �ڵ� -> '�߻�'->abstract ����
	abstract void f1();
}
// �߻� Ŭ������ ��ӹ޴� �ڼ��� �ݵ�� �ڵ带 �����ؾ���. �ϼ����Ѿ���
class Bbb extends Aaa {
	@Override
	void f1() {
		System.out.println("bbb");
	}
}
public class Hello2 {
	public static void main(String[] args) {
		Aaa a = new Bbb();
		
		// 5. �߻�Ŭ������ �̿ϼ� �ڵ��̱⿡ ��ü�� ������ų �� ����
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
		
		String s1 = "����ȭ ���� �Ǿ����ϴ�.";
		// ex1) int String.length()
		System.out.println(s1.length()); // 13
	
		// ex2) char String.charAt(int index)
		System.out.println(s1.charAt(5)); // ��
		
		// ex3) int String.indexOf(int ch)
		System.out.println(s1.indexOf("��")); // 5
		// ����, Ȥ�� -1 ���� ���ϵȴ� << �˻�����
		System.out.println(s1.indexOf("��")); // -1
		System.out.println(s1.indexOf("��")==-1?"�˻�����":"�˻�����"); // �˻�����
	
		// ex4)
		// String replace {
		//		CharSequence target,
		//		CharSequence replacement}
		s1.replace("����", "������");
		// ���� : ���� �����͸� �����ϴ°� ���� �ʴ°�?
		// String Ŭ������ ����� ������ �������� �ʴ´�.
		// StringBuffer Ŭ������ ���� �����͸� ������ �� �ִ�.
		System.out.println(s1); // ����ȭ ���� �Ǿ����ϴ�.
		// s1 = "ȣ����";
		// System.out.println(s1); // ȣ���� -> ���������Ͱ� ����� ���� �ƴ�
		// 1. s1�� �޸𸮰� �����ȴ�
		// 2. s1�� �޸𸮴� ���Ҵ� �޴´�. (��ü�� �������� ���ο� ��ü�� ������� ����)
		String s2 = s1.replace("����", "������");
		System.out.println(s2); // ����ȭ ������ �Ǿ����ϴ�.
		System.out.println(s1.replace("����","�Ĺ���")); // ����ȭ �Ĺ��� �Ǿ����ϴ�.
		System.out.println(s1); //����ȭ ���� �Ǿ����ϴ�.
		
		// ex5) sub string
		System.out.println(s1.substring(3)); // �ε���3 ���� �� �ڿ��ִ� ���� ����
		System.out.println(s1.substring(3, 5)); // �ε��� 3���� 5���� start~end-1
		
		// ex6)
		s1 = "Apple";
		System.out.println(s1.toLowerCase()); // �ҹ��ڷ� 
		System.out.println(s1.toUpperCase()); // �빮�ڷ�
		
		// ex7)
		s1 = "  A p p l e  ";
		System.out.println(1000);
		// �� �� ���� ����, �߰��� �ִ� ������ ����
		System.out.println(s1.trim());
		System.out.println(2000);
 	}
}

// ex58) ����( bit ���� ) => 2(��ǻ��), 10(�ΰ�), 16(����)
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
	
	// ���ڸ��� ����
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
		
		// ���ڸ��� 4��Ʈ 
		// ���ڸ��� 8��Ʈ - 1byte 
		// int�� 4byte�����̱⿡ 4byte�� ���� �� ���� (FF FF FF FF)
		int num4 = 0x63CE7BCD;
		System.out.println(num4); // 1674476493
		// 0110 0011 1100 1110 0111 1011 1100 1101
		
		// 0x7f ff ff ff >> 0 ~ 80 00 00 00, 80 00 00 00 ~ FF FF FF FF
		int num;
		// 16������ ������� ���ڿ��� ����
		// 110 0011 1100 1110 0111 1011 1100 1101
		System.out.println(Integer.toBinaryString(num4));
		int num5 = 0xab;
		// 10101011 => �� ���� ���� 
		// 0000 0000 0000 0000 0000 0000 1010 1011 => �� ���·� 
		System.out.println(Integer.toBinaryString(num5));
	}
}

// ex60) 32bit �ش��ϴ� ���ڿ� �����
public class Hello2 {
	static String hexaToBinary(int n) {
		String s = Integer.toBinaryString(n);
		// System.out.println(s);
		// System.out.println(s.length()); // 31
		
		// 32�� �ش��ϴ� ���ڿ��� �����.
		while(s.length()<32) {
			s = "0"+s;
		}
		// System.out.println(s.length()); // 32
		// System.out.println(s);
		// string buffer - ������ ���� ���� 
		StringBuffer sb = new StringBuffer(s);
		System.out.println(sb);
		// StringBuffer: insert(); ����, �߰��� ���� �߰��ϱ� ����
		// �ڿ������� �ε��� ����ϱ� 
		// �տ������� �ϸ� �����ϰ� x
		for (int i = 0; i < 7; i++) {
			sb.insert((7-i)*4, " ");
		}
		// return sb; ���� Ÿ�� ����ġ String, StringBuffer
		return sb.toString();
	}
	public static void main(String[] args) {
		// >> ���� ���ϴ� �������� 2���� ���
		int num = 0x63CE7BCD;
		System.out.println(hexaToBinary(num));
	}
}

// ex60) 32bit �ش��ϴ� ���ڿ� �����
public class Hello2 {
	static String hexaToBinary(int n) {
		String s = Integer.toBinaryString(n);
		// System.out.println(s);
		// System.out.println(s.length()); // 31
		
		// 32�� �ش��ϴ� ���ڿ��� �����.
		while(s.length()<32) {
			s = "0"+s;
		}
		// System.out.println(s.length()); // 32
		// System.out.println(s);
		// string buffer - ������ ���� ���� 
		StringBuffer sb = new StringBuffer(s);
		System.out.println(sb);
		// StringBuffer: insert(); ����, �߰��� ���� �߰��ϱ� ����
		// �ڿ������� �ε��� ����ϱ� 
		// �տ������� �ϸ� �����ϰ� x
		for (int i = 0; i < 7; i++) {
			sb.insert((7-i)*4, " ");
		}
		// return sb; ���� Ÿ�� ����ġ String, StringBuffer
		return sb.toString();
	}
	public static void main(String[] args) {
		// >> ���� ���ϴ� �������� 2���� ���
		int num = 0x63CE7BCD;
		System.out.println(hexaToBinary(num));
		
		System.out.println(hexaToBinary(0xab));
		int num2 = 100;
		
		// ó��      �߰�   ��
		// 00 1f 7f 80 af ff
	}
}

// ex61) & | >> << ~ ^
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
		System.out.println(hexaToBinary(0xffff0000)); // mask data (�ɷ��� �� �߰�����)
		System.out.println(hexaToBinary(n1 & 0xffff0000));
		
		// ������ �ռ�
		System.out.println(hexaToBinary(n1 | 0xffff0000));
		
		int a = 0x000000f3;
		int b = 0x00003600;
		int c = 0x00EC0000;
		int d = a | b | c;
		System.out.println(hexaToBinary(d));
		System.out.println("---------------------");
		int e = 0xf09;
		System.out.println(hexaToBinary(e));
		System.out.println(hexaToBinary(e<<4)); // ������ 4ĭ�� �������� �̵�
		System.out.println(hexaToBinary(e>>4)); // ������ 4ĭ�� ���������� �̵�
		
		System.out.println("---------------------");
		int data = 0xabcd;
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// �ڿ��� �ټ����� ��Ʈ�� 10������ ���ϱ� - 13
		// �� ���� 6���� ��Ʈ�� 10������ ���ϱ� - 30
		// �� ���� 5���� ��Ʈ�� 10������ ���ϱ� - 21
		System.out.println(hexaToBinary(data));
		
		// �ڿ��� �ټ��� ��Ʈ �ɷ�����
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 0000 0000 0001 1111 -> 0x1f
		System.out.println(data & 0x1f); // 13
		
		// �� �� ������ ��Ʈ �ɷ�����
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 0000 0111 1110 0000 -> 0x1f
		System.out.println(data & 0x7E0); // 960, 30 ���;ߵǴµ� �ڿ� 0�� �����ϰ��־ ū ���ڰ� ���� ->shift���� �ʿ�
		System.out.println((data & 0x7E0) >> 6);
		
		// �� �� �ټ��� ��Ʈ �ɷ�����
		// 0000 0000 0000 0000 1010 1011 1100 1101
		// 0000 0000 0000 0000 1111 1000 0000 0000 -> 0x1f
		System.out.println(data & 0xF800); 
		System.out.println((data & 0xF800) >>11);
		System.out.println((data & 0x0000F800) >>11); // �̷������� �տ� 0000 ä���� �������� ������
		System.out.println("---------------------");
		System.out.println(hexaToBinary(~data)); // ��Ʈ ����
		// exclusive or ������ 0, �ٸ��� 1
		System.out.println(hexaToBinary(data)); 
		System.out.println(hexaToBinary(0x0000ffff));
		System.out.println(hexaToBinary(data^0x0000ffff));
	}
}

// ex62)
class Aaa {
	void f1() {}
}

class Bbb extends Aaa {
	void f2() {}
}
public class Hello2 {
	public static void main(String[] args) {
		int num = 100;
		// ������ �ٲ���� �� �ӵ��� �޶���
		int r1  = num * 3; // num + num + num
		int r2 = 3 * num; // 3 + 3 + 3
		
		System.out.println(r1);
		System.out.println(r2);
		
		int test = 6;   //   0110(6)
						//  01100(12) test << 1
						// 011000(24) test << 2
		System.out.println(test << 1); // 6 * 2�� 1��
		System.out.println(test << 2); // 6 * 2�� 2��
		System.out.println(test << 3); // 6 * 2�� 3��
		System.out.println(test << 4); // 6 * 2�� 4��
		
		int a = 23;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				System.out.println(a*800);
				System.out.println((a<<9) + (a<<8) + (a<<5));
			}
		}
	}
}

//ex64)
class Aaa {
	void f1() {}
}

interface Bbb {
	void f2();
}
interface Ccc {
	void f3();
}
class Ddd extends Aaa implements Bbb, Ccc{
	public void f2() {}
	public void f3() {}
}

@FunctionalInterface // �̱��� �Լ��� �Ѱ��ִٴ� ��
interface Eee {
	void f1();
}
public class Hello2 {
	public static void main(String[] args) {
		String s;
		Thread t;
	}
}

// ex65)
// Tiger Ŭ������ �־�Ǵµ� �ǵ������� ParentTiger interface implements�Ͽ� �ۼ�
// ��? => ��ĳ���ð� ���õ� ������ �����ϱ� ����
interface ParentsTiger {
	void f1();
}

class Tiger implements ParentsTiger{
	public void f1() {
		
	}
}
class Lion implements ParentsTiger{
	public void f1() {
		
	}
}
public class Hello2 {
	public static void main(String[] args) {
		ParentsTiger t1 = new Tiger();
	}
}
*/