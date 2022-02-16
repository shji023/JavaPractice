package pack01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Client extends Application {
	Socket cs; // 필드로 정의, 모든데에서 다쓰기 때문에
	TextArea textArea;
	
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		root.setPrefSize(400, 300);
		root.setSpacing(5);

		textArea = new TextArea();
		textArea.setEditable(false);
		
		TextField textInput = new TextField();
		TextField userName = new TextField();
		userName.setPrefWidth(100);
		userName.setPromptText("닉네임을 입력하세요");

		
		
		Button btn1 = new Button("접속버튼");
		// 블로킹이 아니기 때문에 쓰레드를 만들 필요가 없다.
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					cs = new Socket();
					cs.connect(new InetSocketAddress("192.168.0.3",5001));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		
		//Button btn2 = new Button("데이터 전송");
		textInput.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// 전송할 수 있는 타입은 딱한가지 byte타입
				try {
					OutputStream os = cs.getOutputStream();
					String s = userName.getText() + " : " + textInput.getText();
					byte[]data = s.getBytes(); // 문자열을 바이트로 변환이 되어 배열로
					os.write(data);
					textInput.setText("");
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
		

		root.getChildren().addAll(userName, btn1, btn3, textInput, textArea);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Client");
		stage.show();

	}

	// 클라이언트 프로그램 종료
	public void stopClient() {
		try {
			if(cs != null && !cs.isClosed()) {
				cs.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	// 서버로부터 메시지 받음
	public void receive() {
		while(true) {
			try {
				InputStream in= cs.getInputStream();
				byte[] buffer = new byte[512];
				int length = in.read(buffer);
				if (length == -1) throw new IOException();
				String message = new String(buffer,0,length,"UTF-8");
				Platform.runLater(()->{
					textArea.appendText(message);
				});
			}catch(Exception e) {
				stopClient();
				break;
			}
		}
	}
	public static void main(String[] args) {
		launch();
	}

}