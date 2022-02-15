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
	Socket cs; // 필드로 정의, 모든데에서 다쓰기 때문에
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(5);
		
		Button btn1 = new Button("접속버튼");
		// 블로킹이 아니기 때문에 쓰레드를 만들 필요가 없다.
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
		
		Button btn2 = new Button("데이터 전송");
		btn2.setOnAction(new EventHandler<ActionEvent>() {
			int count = 0;
			@Override
			public void handle(ActionEvent arg0) {
				// 전송할 수 있는 타입은 딱한가지 byte타입
				try {
					OutputStream os = cs.getOutputStream();
					String s = "apple"+count++;
					byte[]data = s.getBytes(); // 문자열을 바이트로 변환이 되어 배열로
					os.write(data);
					System.out.println("데이터 보냄");
				} catch (Exception e) {e.printStackTrace();}
				
			}
		});
		
		Button btn3 = new Button("접속종료");
		btn3.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				try {cs.close();} catch (Exception e) {}
			}
		});
		root.getChildren().addAll(btn1, btn2, btn3);
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
//		Socket cs = new Socket();// 통신소켓 생성
//		try {
//			System.out.println("숫자를 입력하면 접속을 시도합니다.");
//			new Scanner(System.in).nextInt();
//			cs.connect(new InetSocketAddress("localhost",5001));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("숫자를 입력하면 클라이언트를 종료합니다.");
//		new Scanner(System.in).nextInt();
//		System.out.println("Client End");
	}

}
