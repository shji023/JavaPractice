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
		
		String s1 = "����ȭ ���� �Ǿ����ϴ�.";
		// ex1) int String.length()
		System.out.println(s1.length());
	
		// ex2) char String.charAt(int index)
		System.out.println(s1.charAt(5));
		
		// ex3) int String.indexOf(int ch)
		System.out.println(s1.indexOf("��"));
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
*/