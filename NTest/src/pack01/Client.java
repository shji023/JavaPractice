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
	Socket cs; // �ʵ�� ����, ��絥���� �پ��� ������
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

		
		
		Button btn1 = new Button("���ӹ�ư");
		// ���ŷ�� �ƴϱ� ������ �����带 ���� �ʿ䰡 ����.
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
		
		//Button btn2 = new Button("������ ����");
		textInput.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				// ������ �� �ִ� Ÿ���� ���Ѱ��� byteŸ��
				try {
					OutputStream os = cs.getOutputStream();
					String s = userName.getText() + " : " + textInput.getText();
					byte[]data = s.getBytes(); // ���ڿ��� ����Ʈ�� ��ȯ�� �Ǿ� �迭��
					os.write(data);
					textInput.setText("");
					System.out.println("������ ����");
				} catch (Exception e) {e.printStackTrace();}
				
			}
		});
		

		Button btn3 = new Button("��������");
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