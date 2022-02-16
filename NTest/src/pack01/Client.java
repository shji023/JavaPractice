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
	Socket cs;
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
		userName.setPromptText("�г����� �Է��ϼ���");

		
		// ���� ����
		Button startButton = new Button("���ӹ�ư");
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
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
		
		// �Է� �׽�Ʈ ����
		textInput.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// ������ �� �ִ� Ÿ���� ���Ѱ��� byteŸ��
				try {
					OutputStream os = cs.getOutputStream();
					String s = userName.getText() + " : " + textInput.getText();
					byte[]data = s.getBytes();
					os.write(data);
					textInput.setText("");
					System.out.println("������ ����");
				} catch (Exception e) {e.printStackTrace();}
				
			}
		});
		

		// ���� ����
		Button stopButton = new Button("��������");
		stopButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				try {
					OutputStream os = cs.getOutputStream();
					String s = userName.getText() + "���� ���� �����߽��ϴ�. ";
					byte[]data = s.getBytes(); 
					os.write(data);
					cs.close();
					} catch (Exception e) {}
			}
		});
		

		root.getChildren().addAll(userName, startButton, stopButton, textInput, textArea);
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Client");
		stage.show();

	}

	// Ŭ���̾�Ʈ ���α׷� ����
	public void stopClient() {
		try {
			if(cs != null && !cs.isClosed()) {
				cs.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	// �����κ��� �޽��� ����
	public void receive() {
		while(true) {
			try {
				InputStream in= cs.getInputStream();
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