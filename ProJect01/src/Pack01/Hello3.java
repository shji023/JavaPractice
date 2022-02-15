package Pack01;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		HBox root = new HBox();
		root.setPrefSize(400, 300); // 사이즈 설정
		root.setSpacing(10); // 간격
		//-----------------------------------
		// 인터페이스를 전달하면서 그안에다가 원하는 코드를 짜자
		Button btn1 = new Button("버튼3");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("클릭됨");
			}
		});

		root.getChildren().addAll(btn1);
		
		//-----------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("Title"); // title 설정
		arg0.show(); // scene으로 등록된 것을 화면에 출력
	}
	public static void main(String[] args) {
		launch(); // 블로킹
		System.out.println("Exit"); // 창을 닫기 전까지 2가 안나타남
	}
}
*/

// ex89)
public class Hello3 {
	public static void main(String[] args) {
		System.out.println("여기는 헬로우");
		Scanner sc = new Scanner(System.in);
		sc.nextInt();		
		System.out.println("헬로우 종료");
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

// ex88-1)
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(2);
		VBox root = new VBox(); // 내부적으로 자식들을 세로로 배치하라 
		root.setPrefSize(400, 300); // 사이즈 설정
		//-----------------------------------
		
		// 실제로 보여질 클래스 안에 눈에 보이지 않는 배치를 등록한다.  
		//-----------------------------------
		// 
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("Title"); // title 설정
		arg0.show(); // scene으로 등록된 것을 화면에 출력
		
		
		arg0.show();
		System.out.println(3);
	}
	public static void main(String[] args) {
		System.out.println(1);
		launch(); // 블로킹
		System.out.println("Exit"); // 창을 닫기 전까지 2가 안나타남
	}
}

//ex88-2)
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(2);
		VBox root = new VBox(); // 내부적으로 자식들을 세로로 배치하라 
		HBox root2 = new HBox(); // 가로로 배치
		root.setPrefSize(400, 300); // 사이즈 설정
		root.setSpacing(10); // 간격
		//-----------------------------------
		// 방법1
		Button btn1 = new Button("버튼1");
		root.getChildren().add(btn1);
		Button btn2 = new Button("버튼2");
		root.getChildren().add(btn2); // 세로로 배치
		
		// 방법2
		Button btn3 = new Button("버튼3");
		Button btn4 = new Button("버튼4");
		Button btn5 = new Button("버튼5");
		root.getChildren().addAll(btn3, btn4, btn5);
		//-----------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("Title"); // title 설정
		arg0.show(); // scene으로 등록된 것을 화면에 출력
		
		
		arg0.show();
		System.out.println(3);
	}
	public static void main(String[] args) {
		System.out.println(1);
		launch(); // 블로킹
		System.out.println("Exit"); // 창을 닫기 전까지 2가 안나타남
	}
}

//ex88-3)
//상속받은 클래스를 만들어사용할 수 있고 익명클래스를 사용할 수 도 있다.
interface A<T> {
	void f1();
}
class Tiger {
	void f100(A<Integer> tt) {
		tt.f1();
	}
}
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
//		A<Integer> t = new A<Integer>() {
//			@Override
//			public void f1() {
//				
//			}
//		};
		// 굳이 t객체 생성시키지 말고 바로 대입
		// eventHandler 이해하기 위한 예제 문법
		Tiger tiger = new Tiger();
		tiger.f100(new A<Integer>() {
			@Override
			public void f1() {
				System.out.println("test");
			}
		});
		VBox root = new VBox(); // 내부적으로 자식들을 세로로 배치하라 
		HBox root2 = new HBox(); // 가로로 배치
		root.setPrefSize(400, 300); // 사이즈 설정
		root.setSpacing(10); // 간격
		//-----------------------------------
		// 인터페이스를 전달하면서 그안에다가 원하는 코드를 짜자
		Button btn1 = new Button("버튼3");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("클릭됨");
			}
		});
		Button btn2 = new Button("버튼3");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("클릭됨");
			}
		});
		root.getChildren().addAll(btn1, btn2);
		
		//-----------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("Title"); // title 설정
		arg0.show(); // scene으로 등록된 것을 화면에 출력
		
		
		arg0.show();

	}
	public static void main(String[] args) {

		launch(); // 블로킹
		System.out.println("Exit"); // 창을 닫기 전까지 2가 안나타남
	}
}

//ex88-4) 채팅 프로그램 ui
interface A<T> {
	void f1();
}
class Tiger {
	void f100(A<Integer> tt) {
		tt.f1();
	}
}
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
//		A<Integer> t = new A<Integer>() {
//			@Override
//			public void f1() {
//				
//			}
//		};
		// 굳이 t객체 생성시키지 말고 바로 대입
		// eventHandler 이해하기 위한 예제 문법
		Tiger tiger = new Tiger();
		tiger.f100(new A<Integer>() {
			@Override
			public void f1() {
				System.out.println("test");
			}
		});
		VBox root = new VBox(); // 내부적으로 자식들을 세로로 배치하라 
		root.setPrefSize(400, 300); // 사이즈 설정
		root.setSpacing(10); // 간격
		//-----------------------------------
		// 인터페이스를 전달하면서 그안에다가 원하는 코드를 짜자
		Button btn1 = new Button("버튼3");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("클릭됨");
			}
		});
		TextArea textArea = new TextArea();
		
		TextField textField = new TextField();
		textField.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				String s = textField.getText();
				textField.setText("");
				System.out.println(s);
				textArea.appendText(s+"\n");
			}
		});
		root.getChildren().addAll(btn1, textField, textArea);
		
		//-----------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("Title"); // title 설정
		arg0.show(); // scene으로 등록된 것을 화면에 출력
		
		
		arg0.show();

	}
	public static void main(String[] args) {

		launch(); // 블로킹
		System.out.println("Exit"); // 창을 닫기 전까지 2가 안나타남
	}
}

//ex88-5) 
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		HBox root = new HBox(); // 내부적으로 자식들을 세로로 배치하라 
		root.setPrefSize(400, 300); // 사이즈 설정
		root.setSpacing(10); // 간격
		//-----------------------------------
		// 인터페이스를 전달하면서 그안에다가 원하는 코드를 짜자
		Button btn1 = new Button("버튼1");
		Button btn2 = new Button("버튼2");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				btn2.setText("홍길동"); // 1번을 눌러 2번을 제어한다.
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// btn1.setVisible(false); // 안보이게한다
				// btn1.setDisable(true); // 못누르게한다
				btn1.setVisible(!btn1.isVisible());
			}
		});
		root.getChildren().addAll(btn1, btn2);
		
		//-----------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("Title"); // title 설정
		arg0.show(); // scene으로 등록된 것을 화면에 출력
	}
	public static void main(String[] args) {

		launch(); // 블로킹
		System.out.println("Exit"); // 창을 닫기 전까지 2가 안나타남
	}
}

//ex88-6) 
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		HBox root = new HBox(); // 내부적으로 자식들을 세로로 배치하라 
		root.setPrefSize(400, 300); // 사이즈 설정
		root.setSpacing(10); // 간격
		//-----------------------------------
		// 인터페이스를 전달하면서 그안에다가 원하는 코드를 짜자
		Button btn1 = new Button("버튼1");
	
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				//Thread t = new Thread() { 이렇게 해도됨
				new Thread() {
					@Override
					public void run() {
						System.out.println("스레드 시작");
						// btn1.setText("호랑이"); 쓰레드 안 속성값 변경 시 프로그램 중단됨
						Platform.runLater(()->{
							btn1.setText("호랑이");
						});
						System.out.println("스레드 종료");
					}
				}.start();
				//t.start();
			}
		});

		root.getChildren().addAll(btn1);
		
		//-----------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("Title"); // title 설정
		arg0.show(); // scene으로 등록된 것을 화면에 출력
	}
	public static void main(String[] args) {

		launch(); // 블로킹
		System.out.println("Exit"); // 창을 닫기 전까지 2가 안나타남
	}
}

//ex88-7)
class Tiger extends Thread {
//	Button btn;
	Hello3 hello;
//	Tiger(Button btn) {
//		this.btn = btn;
//	}
	Tiger(Hello3 hello) {
	this.hello = hello;
}
	@Override
	public void run() {
		System.out.println("스레드 시작");
		System.out.println("스레드 끝");
		// btn.setText("btn1을 몰라서 속성변경을 할 수 없음");
		// 방법 1. 버튼을 인수로 넘겨줌 
		Platform.runLater(()->{
			Hello3.btn1.setText("g호랑이");
			//Hello3.btn2.setText("g호랑이");
		});
		
		// 방법 2. 컨트롤을 여러개 받을 때는 어떻게 ? 
	}
}
public class Hello3 extends Application {
	Button btn1;  // new로 생성
	@Override
	public void start(Stage stage) throws Exception {
		HBox root = new HBox();
		root.setPrefSize(400, 300); // 사이즈 설정
		root.setSpacing(10); // 간격
		//-----------------------------------
		// 인터페이스를 전달하면서 그안에다가 원하는 코드를 짜자
		// Button btn1 = new Button("버튼1");
		btn1 = new Button("버튼1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				//Tiger t = new Tiger(btn1);
				// this클래스로 감싸 주어야함
				Tiger t1 = new Tiger(Hello3.this);
				t1.start();
			}
		});

		root.getChildren().addAll(btn1);
		
		//-----------------------------------
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Title"); // title 설정
		stage.show(); // scene으로 등록된 것을 화면에 출력
	}
	public static void main(String[] args) {
		launch(); // 블로킹
		System.out.println("Exit"); // 창을 닫기 전까지 2가 안나타남
	}
}
*/