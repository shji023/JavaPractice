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
		arg0.setTitle("호랑이");
		arg0.show();
		System.out.println(3);
	}
	public static void main(String[] args) {
		System.out.println(1);
		launch(); // 블로킹
		System.out.println("Exit"); // 창을 닫기 전까지 2가 안나타남
	}
}
/*
// swing과 충돌 나는지 확인
// ex86) UI
// Swing라이브러리 => JavaFx
// Hello3에서 에러나는 이유: 부모가 추상클래스이기에 꼭 구현을 해야한다.
// 작동되면 흰색 창이 하나 켜짐 
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		arg0.show();
	}
	public static void main(String[] args) {
		System.out.println(1);
		launch(); // 내부적으로 start 호출
	}
}

// ex87 Q&A)
// Application >> launch(static) {start()}
//		       >> abstract start()
abstract class MyApp {
	static void launch() {
		// Hello3 h = new Hello3(); 성립은 되는데 쓸 수 없음
		// h.start();
		try {
			Class<?> cls = Class.forName("Pack01.Hello3");	
			Constructor<?> constructor = cls.getConstructor();
			Object obj = constructor.newInstance();
			Method start = cls.getMethod("start", String.class);
			System.out.println(start);
			
			// start 함수 호출
			start.invoke(obj, "호랑이");
			
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
		// static이냐? 당연히 static임
		launch(); // 내부적으로 start 호출
	}
}
*/