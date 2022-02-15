package Pack;

import java.io.InputStream;
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

class ClientThread extends Thread {
	Socket socket;
	ClientThread(Socket socket) {
		this.socket = socket;
	}
	// 데이터를 받는 쓰레드 또 필요하다.
	@Override
	public void run() {
		try {
			InputStream is = socket.getInputStream();
			byte[]recvData = new byte[512];
			// read 블로킹 함수
			while(true) { // 계속 데이터를 read 무한으로
				int size = is.read(recvData);
				if(size == -1) {
					System.out.println("클라이언트 접속 종료");
					break;
				}
				String s = new String(recvData, 0, size); // 읽을 데이터의 크기
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
class ConnectThread extends Thread {
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket();
			System.out.println("메인서버 소켓 생성");
			ss.bind(new InetSocketAddress("localhost",5001));
			System.out.println("바인딩 완료");
			// 블로킹 함수이다. 누군가가 접속을 해주면 풀림 
			// 버튼에서 빠져나오지 못하니까 다음버튼을 누르지 못함
			// 무한루프에 빠짐
			// 쓰레드로 해결
			Socket socket = ss.accept(); // 데이터를 주고 받을 소켓
			System.out.println("누군가 접속을 시도했음");
			ClientThread ct = new ClientThread(socket);
			ct.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
public class Server extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(5);
		
		Button btn1 = new Button("서버오픈");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				ConnectThread ct = new ConnectThread();
				ct.start();
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
//			System.out.println("메인서버 소켓 생성");
////			if ( ss == null ) {
////				System.out.println("소켓을 생성할 수 없다.");
////				exit(0);
////			}
//			// 자기자신에게 정보를 기록해놓는거 - 바인딩 
//			// 누군가 접속을하면 기준이 있도록
//			// 클라이언트는 바인딩 필요x
//			// ss.bind("ip주소", 포트번호); // 127.0.0.1
//			ss.bind(new InetSocketAddress("localhost",5001));
//			System.out.println("바인딩 완료");
//			// 블로킹 함수이다. 누군가가 접속을 해주면 풀림 
//			ss.accept();
//			System.out.println("누군가 접속을 시도했음");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
////		Scanner sc = new Scanner(System.in);
////		sc.nextInt();		
//		new Scanner(System.in).nextInt();
//		System.out.println("Server End");
	}

}
