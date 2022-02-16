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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientTest extends Application {
	Socket cs;
	TextArea textArea;
	Scene scene1, scene2;

	@Override
	public void start(Stage stage) throws Exception {
		VBox root = new VBox();
		HBox root2 = new HBox();
		HBox root3 = new HBox();
		VBox win = new VBox();

		win.setPrefSize(400, 300);
		root.setPrefSize(400, 300);
		root.setSpacing(5);

		textArea = new TextArea();
		textArea.setEditable(false);
		
		TextField textInput = new TextField();
		TextField userName = new TextField();
		userName.setPrefWidth(100);
		userName.setPromptText("�г����� �Է��ϼ���");
// scene1 -----------------------------------------------------------------
// scene2 -----------------------------------------------------------------
		// ���� ����
		Button startButton = new Button("���ӹ�ư");
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				try {
					stage.setScene(scene2);
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
								DataOutputStream os  = new DataOutputStream( cs.getOutputStream());
								String s = userName.getText();
								
								os.writeUTF(s);
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
					 
					DataOutputStream os  = new DataOutputStream( cs.getOutputStream());
					String s = textInput.getText();
					
					os.writeUTF(s);
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
					DataOutputStream os  = new DataOutputStream( cs.getOutputStream());
					String s = userName.getText() + "���� ���� �����߽��ϴ�. ";
					
					os.writeUTF(s);
					cs.close();
					} catch (Exception e) {}
			}
		});
		// ������ ��ư
		Button sendButton = new Button("����");
	      sendButton.setOnAction(new EventHandler<ActionEvent>() {
	         @Override
	         public void handle(ActionEvent arg0) {
	            try {
	            	DataOutputStream os  = new DataOutputStream( cs.getOutputStream());
					 String s = textInput.getText();
	              
	               os.writeUTF(s);
	               textInput.setText("");
	               System.out.println("������ ����");
	            } catch (Exception e) {   e.printStackTrace(); }
	         }
	      });
		
	      
	      win.getChildren().addAll(userName, startButton);
	      win.setPadding(new Insets(100, 100, 100, 100));


	      root2.getChildren().addAll(stopButton);
	      root3.getChildren().addAll(textInput,sendButton);
	      root.getChildren().addAll(root2, textArea, root3);

	      scene1 = new Scene(win);
	      scene2 = new Scene(root);

	      //Scene scene = new Scene(root);
	      stage.setScene(scene1);
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
				DataInputStream in=new DataInputStream(cs.getInputStream());
				String message = in.readUTF();
				
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