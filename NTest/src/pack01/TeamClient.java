package pack01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
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

public class TeamClient extends Application {
   Socket cs;
   TextArea textArea, textArea2;
   Scene scene1, scene2;

   @Override
   public void start(Stage stage) throws Exception {
      // 
      VBox root = new VBox();
      HBox root2 = new HBox();
      HBox root3 = new HBox();
      HBox root4 = new HBox();
      VBox win = new VBox();

      Button startButton = new Button("�α���");
      Button backButton = new Button("�ڷΰ���");
      Button stopButton = new Button("��������");
      Button sendButton = new Button("����");

      win.setPrefSize(400, 300);
      root.setPrefSize(400, 300);
      root.setSpacing(5);

      textArea = new TextArea();
      textArea.setEditable(false);
      textArea.setPrefSize(300, 200);


      textArea2 = new TextArea();
      textArea2.setPrefSize(100, 200);

      TextField textInput = new TextField();
      TextField userName = new TextField();
      
      TextField socketIp = new TextField();
      socketIp.setPromptText("IP�� �Է����ּ���.");
      TextField socketPort = new TextField();
      socketPort.setPromptText("Port�� �Է����ּ���.");
      
      userName.setPrefWidth(100);
      userName.setPromptText("�г����� �Է��ϼ���");

      // ���� ����
      startButton.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent arg0) {
            try {
               // �����ϱ� ��ư�� ������ ä��â���� ��ȯ ��.
               stage.setScene(scene2);
               //userName.setDisable(true);
               new Thread() {
                  public void run() {
                     try {
                        String ipNum = socketIp.getText();
                        String portNum = socketPort.getText();
                        cs = new Socket();
//                        cs.connect(new InetSocketAddress("192.168.1.33", 5002));
                        cs.connect(new InetSocketAddress(ipNum, Integer.parseInt(portNum)));
                        DataOutputStream os  = new DataOutputStream( cs.getOutputStream());
                        String s = userName.getText();

                        if (s.startsWith("!#")) {
                           System.out.println("�Է��Ҽ� �����ϴ�.");
                        }
                        os.writeUTF(s);
                        receive();

                     } catch (Exception e) {
                        e.printStackTrace();
                     }
                  };
               }.start();
            } catch (Exception e) {
               e.printStackTrace();
            }
            backButton.setDisable(true);
            stopButton.setDisable(false);

         }
      });

      // �Է� �ؽ�Ʈ ���� ���
      textInput.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent arg0) {
            try {
               DataOutputStream os  = new DataOutputStream( cs.getOutputStream());
               String s = textInput.getText();
               
               // ������ �ؽ�Ʈ ���� 
               os.writeUTF(s);
               // ���� �� �ؽ�Ʈ�ʵ� ��� ��.
               textInput.setText("");
            } catch (Exception e) {e.printStackTrace();}
         }
      });


      // ���� ���� ���
      stopButton.setOnAction(new EventHandler<ActionEvent>() {

         @Override
         public void handle(ActionEvent arg0) {
            try {
               // ������ ����.
               cs.close();
            } catch (Exception e) {}
            // ��ư�� Ȱ��ȭ ����
            backButton.setDisable(false);
            stopButton.setDisable(true);
         }
      });
      
      // ������ ��ư
      // ���� �Ӹ��ƴ϶� ���콺 Ŭ�����ε� �����͸� ������ ���ؼ� �߰� ��.
      sendButton.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent arg0) {
            try {
               DataOutputStream os  = new DataOutputStream( cs.getOutputStream());
               String s = textInput.getText();

               os.writeUTF(s);
               textInput.setText("");
            } catch (Exception e) {   e.printStackTrace(); }
         }
      });

      // �ڷΰ��� ��ư
      // �ٽ� socket �����ϴ� â���� �Ѿ� ��. => winâ���� �Ѿ. 
      backButton.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent arg0) {
            // scene1�� socket ����(�α���) â ��.
            stage.setScene(scene1);
            userName.setText("");
            stopButton.setDisable(true);
         }
      });

      backButton.setDisable(true);

      win.getChildren().addAll(socketIp, socketPort, userName, startButton);
      // �α��� â���� ��ü�� ����� ���� ���� ��.
      win.setPadding(new Insets(100, 100, 100, 100));


      root2.getChildren().addAll(stopButton, backButton);
      root3.getChildren().addAll(textInput,sendButton);
      root4.getChildren().addAll(textArea, textArea2);
      root.getChildren().addAll(root2, root4, root3);

      // �α��� â
      scene1 = new Scene(win);
      // ���� â
      scene2 = new Scene(root);

      //Scene scene = new Scene(root);
      stage.setScene(scene1);
      stage.setTitle("");
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

            Platform.runLater(()->{
               // ������ �Է¿��� !#�̺�����
               // textArea2(������ ����Ʈ)�� ����.
               if ( message.startsWith("!#") == false) {   
                  textArea.appendText(message);
                  textArea.appendText("\n");
               }
               else {   
                  // ������
                  // ===
                  // ������
                  // �̱�ö
                  // ���� ������Ʈ �ɶ����� ����
                  textArea2.setText("");
                  // !#�� ���� �������� ���
                  textArea2.appendText(message.substring(2));
               }
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