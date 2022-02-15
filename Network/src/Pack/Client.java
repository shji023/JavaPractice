package Pack;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Client extends Application {
	Socket cs; // �ʵ�� ����, ��絥���� �پ��� ������
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(5);
		
		Button btn1 = new Button("���ӹ�ư");
		// ���ŷ�� �ƴϱ� ������ �����带 ���� �ʿ䰡 ����.
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					cs = new Socket();
					cs.connect(new InetSocketAddress("localhost",5001));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		
		Button btn2 = new Button("������ ����");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// ������ �� �ִ� Ÿ���� ���Ѱ��� byteŸ��
				try {
					OutputStream os = cs.getOutputStream();
					String s = "apple";
					byte[]data = s.getBytes(); // ���ڿ��� ����Ʈ�� ��ȯ�� �Ǿ� �迭��
					os.write(data);
					System.out.println("������ ����");
				} catch (Exception e) {e.printStackTrace();}
				
			}
		});
		root.getChildren().addAll(btn1, btn2);
//		btn1.setOnAction(new EventHandler<ActionEvent>() {
//			@Override
//			public void handle(ActionEvent arg0) {
//				new Thread() {
//					@Override
//					public void run() {
//						try {
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				}.start();
//			}
//		});
		//root.getChildren().add(btn1);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Client");
		stage.show();

	}
	public static void main(String[] args) {
		launch();
//		System.out.println("Client Start");
//		Socket cs = new Socket();// ��ż��� ����
//		try {
//			System.out.println("���ڸ� �Է��ϸ� ������ �õ��մϴ�.");
//			new Scanner(System.in).nextInt();
//			cs.connect(new InetSocketAddress("localhost",5001));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("���ڸ� �Է��ϸ� Ŭ���̾�Ʈ�� �����մϴ�.");
//		new Scanner(System.in).nextInt();
//		System.out.println("Client End");
	}

}
