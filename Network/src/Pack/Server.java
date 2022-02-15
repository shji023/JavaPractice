package Pack;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Server extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(5);
		
		Button btn1 = new Button("��������");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				try {
					ServerSocket ss = new ServerSocket();
					System.out.println("���μ��� ���� ����");
					ss.bind(new InetSocketAddress("localhost",5001));
					System.out.println("���ε� �Ϸ�");
					// ���ŷ �Լ��̴�. �������� ������ ���ָ� Ǯ�� 
					// ��ư���� ���������� ���ϴϱ� ������ư�� ������ ����
					// ���ѷ����� ����
					ss.accept();
					System.out.println("������ ������ �õ�����");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		root.getChildren().add(btn1);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Server");
		stage.show();

	}
	public static void main(String[] args) {
		launch();
//		System.out.println("Server Start");
//		try {
//			ServerSocket ss = new ServerSocket();
//			System.out.println("���μ��� ���� ����");
////			if ( ss == null ) {
////				System.out.println("������ ������ �� ����.");
////				exit(0);
////			}
//			// �ڱ��ڽſ��� ������ ����س��°� - ���ε� 
//			// ������ �������ϸ� ������ �ֵ���
//			// Ŭ���̾�Ʈ�� ���ε� �ʿ�x
//			// ss.bind("ip�ּ�", ��Ʈ��ȣ); // 127.0.0.1
//			ss.bind(new InetSocketAddress("localhost",5001));
//			System.out.println("���ε� �Ϸ�");
//			// ���ŷ �Լ��̴�. �������� ������ ���ָ� Ǯ�� 
//			ss.accept();
//			System.out.println("������ ������ �õ�����");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////		Scanner sc = new Scanner(System.in);
////		sc.nextInt();		
//		new Scanner(System.in).nextInt();
//		System.out.println("Server End");
	}

}
