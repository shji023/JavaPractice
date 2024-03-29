package pack01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Client_old extends Application {
	Socket cs;
	TextArea textArea;
	
	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		HBox root2 = new HBox();
		HBox root3 = new HBox();
		root.setPrefSize(400, 300);
		root.setSpacing(5);

		textArea = new TextArea();
		textArea.setEditable(false);
		
		TextField textInput = new TextField();
		TextField userName = new TextField();
		userName.setPrefWidth(100);
		userName.setPromptText("닉네임을 입력하세요");

		
		// 서버 접속
		Button startButton = new Button("접속버튼");
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					userName.setDisable(true);
//					cs = new Socket();
//					cs.connect(new InetSocketAddress("localhost",5001));
//					ConnectThread ct = new ConnectThread();
//					ct.start();	
					new Thread() {
						public void run() {
							try {
								cs = new Socket();
								cs.connect(new InetSocketAddress("192.168.0.79",5001));
								receive();

							} catch (Exception e) {
								// TODO: handle exception
							}
						};
					}.start();
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		
		// 입력 테스트 전송
		textInput.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// 전송할 수 있는 타입은 딱한가지 byte타입
				try {
					DataOutputStream os =new DataOutputStream(cs.getOutputStream());
					String s = userName.getText() + " : " + textInput.getText();
					byte[]data = s.getBytes();
					os.write(data);
					textInput.setText("");
					System.out.println("데이터 보냄");
				} catch (Exception e) {e.printStackTrace();}
				
			}
		});
		

		// 접속 종료
		Button stopButton = new Button("접속종료");
		stopButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				try {
					DataOutputStream os =  new DataOutputStream(cs.getOutputStream());
					String s = userName.getText() + "님이 접속 종료했습니다. ";
					byte[]data = s.getBytes(); 
					os.write(data);
					cs.close();
					} catch (Exception e) {}
			}
		});
		// 보내기 버튼
		Button sendButton = new Button("전송");
	      sendButton.setOnAction(new EventHandler<ActionEvent>() {
	         @Override
	         public void handle(ActionEvent arg0) {
	            try {
	               DataOutputStream os =new DataOutputStream(cs.getOutputStream());
	               String s = textInput.getText();
	               byte[] data = s.getBytes(); // 생략된건 보류하고.
	               //String s = new String(recvData, 0, size); 
	               os.write(data);
	               System.out.println("데이터보냄");
	            } catch (Exception e) {   e.printStackTrace(); }
	         }
	      });
		
		root2.getChildren().addAll(startButton,stopButton);
		root3.getChildren().addAll(textInput,sendButton);
		root.getChildren().addAll(userName, root2, textArea, root3);

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
				DataInputStream in= new DataInputStream(cs.getInputStream());
				byte[] buffer = new byte[512];
				int length = in.read(buffer);
				if (length == -1) throw new IOException();
				String message = new String(buffer,0,length,"UTF-8");
				System.out.println(message);
				Platform.runLater(()->{
					textArea.appendText(message);
					textArea.appendText("\n");
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