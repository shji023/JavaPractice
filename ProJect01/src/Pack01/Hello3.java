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
		root.setPrefSize(400, 300); // ������ ����
		root.setSpacing(10); // ����
		//-----------------------------------
		// �������̽��� �����ϸ鼭 �׾ȿ��ٰ� ���ϴ� �ڵ带 ¥��
		Button btn1 = new Button("��ư3");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Ŭ����");
			}
		});

		root.getChildren().addAll(btn1);
		
		//-----------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("Title"); // title ����
		arg0.show(); // scene���� ��ϵ� ���� ȭ�鿡 ���
	}
	public static void main(String[] args) {
		launch(); // ���ŷ
		System.out.println("Exit"); // â�� �ݱ� ������ 2�� �ȳ�Ÿ��
	}
}
*/

// ex89)
public class Hello3 {
	public static void main(String[] args) {
		System.out.println("����� ��ο�");
		Scanner sc = new Scanner(System.in);
		sc.nextInt();		
		System.out.println("��ο� ����");
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

// ex88-1)
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(2);
		VBox root = new VBox(); // ���������� �ڽĵ��� ���η� ��ġ�϶� 
		root.setPrefSize(400, 300); // ������ ����
		//-----------------------------------
		
		// ������ ������ Ŭ���� �ȿ� ���� ������ �ʴ� ��ġ�� ����Ѵ�.  
		//-----------------------------------
		// 
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("Title"); // title ����
		arg0.show(); // scene���� ��ϵ� ���� ȭ�鿡 ���
		
		
		arg0.show();
		System.out.println(3);
	}
	public static void main(String[] args) {
		System.out.println(1);
		launch(); // ���ŷ
		System.out.println("Exit"); // â�� �ݱ� ������ 2�� �ȳ�Ÿ��
	}
}

//ex88-2)
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		System.out.println(2);
		VBox root = new VBox(); // ���������� �ڽĵ��� ���η� ��ġ�϶� 
		HBox root2 = new HBox(); // ���η� ��ġ
		root.setPrefSize(400, 300); // ������ ����
		root.setSpacing(10); // ����
		//-----------------------------------
		// ���1
		Button btn1 = new Button("��ư1");
		root.getChildren().add(btn1);
		Button btn2 = new Button("��ư2");
		root.getChildren().add(btn2); // ���η� ��ġ
		
		// ���2
		Button btn3 = new Button("��ư3");
		Button btn4 = new Button("��ư4");
		Button btn5 = new Button("��ư5");
		root.getChildren().addAll(btn3, btn4, btn5);
		//-----------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("Title"); // title ����
		arg0.show(); // scene���� ��ϵ� ���� ȭ�鿡 ���
		
		
		arg0.show();
		System.out.println(3);
	}
	public static void main(String[] args) {
		System.out.println(1);
		launch(); // ���ŷ
		System.out.println("Exit"); // â�� �ݱ� ������ 2�� �ȳ�Ÿ��
	}
}

//ex88-3)
//��ӹ��� Ŭ������ ��������� �� �ְ� �͸�Ŭ������ ����� �� �� �ִ�.
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
		// ���� t��ü ������Ű�� ���� �ٷ� ����
		// eventHandler �����ϱ� ���� ���� ����
		Tiger tiger = new Tiger();
		tiger.f100(new A<Integer>() {
			@Override
			public void f1() {
				System.out.println("test");
			}
		});
		VBox root = new VBox(); // ���������� �ڽĵ��� ���η� ��ġ�϶� 
		HBox root2 = new HBox(); // ���η� ��ġ
		root.setPrefSize(400, 300); // ������ ����
		root.setSpacing(10); // ����
		//-----------------------------------
		// �������̽��� �����ϸ鼭 �׾ȿ��ٰ� ���ϴ� �ڵ带 ¥��
		Button btn1 = new Button("��ư3");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Ŭ����");
			}
		});
		Button btn2 = new Button("��ư3");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Ŭ����");
			}
		});
		root.getChildren().addAll(btn1, btn2);
		
		//-----------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("Title"); // title ����
		arg0.show(); // scene���� ��ϵ� ���� ȭ�鿡 ���
		
		
		arg0.show();

	}
	public static void main(String[] args) {

		launch(); // ���ŷ
		System.out.println("Exit"); // â�� �ݱ� ������ 2�� �ȳ�Ÿ��
	}
}

//ex88-4) ä�� ���α׷� ui
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
		// ���� t��ü ������Ű�� ���� �ٷ� ����
		// eventHandler �����ϱ� ���� ���� ����
		Tiger tiger = new Tiger();
		tiger.f100(new A<Integer>() {
			@Override
			public void f1() {
				System.out.println("test");
			}
		});
		VBox root = new VBox(); // ���������� �ڽĵ��� ���η� ��ġ�϶� 
		root.setPrefSize(400, 300); // ������ ����
		root.setSpacing(10); // ����
		//-----------------------------------
		// �������̽��� �����ϸ鼭 �׾ȿ��ٰ� ���ϴ� �ڵ带 ¥��
		Button btn1 = new Button("��ư3");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Ŭ����");
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
		arg0.setTitle("Title"); // title ����
		arg0.show(); // scene���� ��ϵ� ���� ȭ�鿡 ���
		
		
		arg0.show();

	}
	public static void main(String[] args) {

		launch(); // ���ŷ
		System.out.println("Exit"); // â�� �ݱ� ������ 2�� �ȳ�Ÿ��
	}
}

//ex88-5) 
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		HBox root = new HBox(); // ���������� �ڽĵ��� ���η� ��ġ�϶� 
		root.setPrefSize(400, 300); // ������ ����
		root.setSpacing(10); // ����
		//-----------------------------------
		// �������̽��� �����ϸ鼭 �׾ȿ��ٰ� ���ϴ� �ڵ带 ¥��
		Button btn1 = new Button("��ư1");
		Button btn2 = new Button("��ư2");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				btn2.setText("ȫ�浿"); // 1���� ���� 2���� �����Ѵ�.
			}
		});
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// btn1.setVisible(false); // �Ⱥ��̰��Ѵ�
				// btn1.setDisable(true); // ���������Ѵ�
				btn1.setVisible(!btn1.isVisible());
			}
		});
		root.getChildren().addAll(btn1, btn2);
		
		//-----------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("Title"); // title ����
		arg0.show(); // scene���� ��ϵ� ���� ȭ�鿡 ���
	}
	public static void main(String[] args) {

		launch(); // ���ŷ
		System.out.println("Exit"); // â�� �ݱ� ������ 2�� �ȳ�Ÿ��
	}
}

//ex88-6) 
public class Hello3 extends Application {
	@Override
	public void start(Stage arg0) throws Exception {
		HBox root = new HBox(); // ���������� �ڽĵ��� ���η� ��ġ�϶� 
		root.setPrefSize(400, 300); // ������ ����
		root.setSpacing(10); // ����
		//-----------------------------------
		// �������̽��� �����ϸ鼭 �׾ȿ��ٰ� ���ϴ� �ڵ带 ¥��
		Button btn1 = new Button("��ư1");
	
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				//Thread t = new Thread() { �̷��� �ص���
				new Thread() {
					@Override
					public void run() {
						System.out.println("������ ����");
						// btn1.setText("ȣ����"); ������ �� �Ӽ��� ���� �� ���α׷� �ߴܵ�
						Platform.runLater(()->{
							btn1.setText("ȣ����");
						});
						System.out.println("������ ����");
					}
				}.start();
				//t.start();
			}
		});

		root.getChildren().addAll(btn1);
		
		//-----------------------------------
		Scene scene = new Scene(root);
		arg0.setScene(scene);
		arg0.setTitle("Title"); // title ����
		arg0.show(); // scene���� ��ϵ� ���� ȭ�鿡 ���
	}
	public static void main(String[] args) {

		launch(); // ���ŷ
		System.out.println("Exit"); // â�� �ݱ� ������ 2�� �ȳ�Ÿ��
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
		System.out.println("������ ����");
		System.out.println("������ ��");
		// btn.setText("btn1�� ���� �Ӽ������� �� �� ����");
		// ��� 1. ��ư�� �μ��� �Ѱ��� 
		Platform.runLater(()->{
			Hello3.btn1.setText("gȣ����");
			//Hello3.btn2.setText("gȣ����");
		});
		
		// ��� 2. ��Ʈ���� ������ ���� ���� ��� ? 
	}
}
public class Hello3 extends Application {
	Button btn1;  // new�� ����
	@Override
	public void start(Stage stage) throws Exception {
		HBox root = new HBox();
		root.setPrefSize(400, 300); // ������ ����
		root.setSpacing(10); // ����
		//-----------------------------------
		// �������̽��� �����ϸ鼭 �׾ȿ��ٰ� ���ϴ� �ڵ带 ¥��
		// Button btn1 = new Button("��ư1");
		btn1 = new Button("��ư1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				//Tiger t = new Tiger(btn1);
				// thisŬ������ ���� �־����
				Tiger t1 = new Tiger(Hello3.this);
				t1.start();
			}
		});

		root.getChildren().addAll(btn1);
		
		//-----------------------------------
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Title"); // title ����
		stage.show(); // scene���� ��ϵ� ���� ȭ�鿡 ���
	}
	public static void main(String[] args) {
		launch(); // ���ŷ
		System.out.println("Exit"); // â�� �ݱ� ������ 2�� �ȳ�Ÿ��
	}
}
*/