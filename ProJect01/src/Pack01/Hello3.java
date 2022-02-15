package Pack01;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;
/*
class Tiger {
}
class Aaa {
	void f1() {}
}

class Bbb extends Aaa {
	void f2() {}
}
public class Hello3 {
	public static void main(String[] args) {
		
	}
}
*/

// ex88-1)
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(2);
		arg0.setTitle("ȣ����");
		arg0.show();
		System.out.println(3);
	}
	public static void main(String[] args) {
		System.out.println(1);
		launch(); // ���ŷ
		System.out.println("Exit"); // â�� �ݱ� ������ 2�� �ȳ�Ÿ��
	}
}
/*
// swing�� �浹 ������ Ȯ��
// ex86) UI
// Swing���̺귯�� => JavaFx
// Hello3���� �������� ����: �θ� �߻�Ŭ�����̱⿡ �� ������ �ؾ��Ѵ�.
// �۵��Ǹ� ��� â�� �ϳ� ���� 
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		arg0.show();
	}
	public static void main(String[] args) {
		System.out.println(1);
		launch(); // ���������� start ȣ��
	}
}

// ex87 Q&A)
// Application >> launch(static) {start()}
//		       >> abstract start()
abstract class MyApp {
	static void launch() {
		// Hello3 h = new Hello3(); ������ �Ǵµ� �� �� ����
		// h.start();
		try {
			Class<?> cls = Class.forName("Pack01.Hello3");	
			Constructor<?> constructor = cls.getConstructor();
			Object obj = constructor.newInstance();
			Method start = cls.getMethod("start", String.class);
			System.out.println(start);
			
			// start �Լ� ȣ��
			start.invoke(obj, "ȣ����");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		//start();
	}
	abstract void start(String s);
}
public class Hello3 extends MyApp {
	@Override
//	public void start(Stage arg0) throws Exception {
//		arg0.show();
//	}
	public void start(String s) {
		System.out.println(s);
	}
	public static void main(String[] args) {
		System.out.println(1);
		// static�̳�? �翬�� static��
		launch(); // ���������� start ȣ��
	}
}
*/