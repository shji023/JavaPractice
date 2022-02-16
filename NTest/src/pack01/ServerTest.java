package pack01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;




class ConnectThread extends Thread {
   Socket socket;
   Scanner sc;
   ServerSocket serverSocket;
   LinkedList<Socket> socketList;
   Map<Socket, Integer> socketMap;
   ServerTest SPJ;
   int id;
   ConnectThread(ServerTest SPJ){
      this.SPJ = SPJ;
   }
   @Override
   public void run() {
      try {
         serverSocket = new ServerSocket(5001); // listen ���� ������ ����
         socketList = new LinkedList<>();
         socketMap = new HashMap<>();
         id = 0; //���̵�
         System.out.println("���� ����");
         while (true) {
            // Ŭ���̾�Ʈ�� �������� �����ϱ� ���� ���ѹݺ���
            
            socket = serverSocket.accept();
            // connect ��û�� ������ ���� (�ö����� block)
            
            Platform.runLater(()->{
                  ++id;
                     SPJ.lab.setText("�ο���: "+id+"\n");
                  });
            System.out.println("Ŭ���̾�Ʈ ����");
            System.out.println(socket);
            socketMap.put(socket,id);
            socketList.add(socket);
            
            // Ŭ���̾�Ʈ���� �����带 ����
            // Thread�� ������� readUTF() �޼��忡�� block�� �߻��ϱ� ������ ���������� �����Ѵ�.  
            new Thread(()->{
               try {
                  DataInputStream in = new DataInputStream(socket.getInputStream());
                  revMsg(in,socket);
               } catch (IOException e) {
                  
               }
            }).start();
         }
      } catch (IOException e) {
      }
   }

   public void revMsg(DataInputStream in,Socket client){
      Boolean nameCheck = true;
      String name = "";
      try {
         
         while (true) {
            String msg = in.readUTF();
            if(nameCheck) {
               name = msg;
               nameCheck = false;
               sendMsg(client,name+"���� �����߽��ϴ�.");
            }
            else if(!msg.equals("")) {
               sendMsg(client,name+": "+msg);
               System.out.println(msg);
            }
            else {
               System.out.println("�� ������ �Է����� �����ּ���!");
            }
         }
      } catch (IOException e) {
    	  if(nameCheck) {
    		  System.out.println(name+"�� ���� ����");

    		  Platform.runLater(()->{
    			  --id;
    			  SPJ.lab.setText("�ο���: "+id+"\n");
    		  });
    	  }
    	  else {
    		  sendMsg(client, name+"���� ���� ���� �߽��ϴ�.");

    		  Platform.runLater(()->{
    			  --id;
    			  SPJ.lab.setText("�ο���: "+id+"\n");
    		  });
    	  }
      }
   }
   public void sendMsg(Socket client,String msg){
      Integer id = socketMap.get(client);
      socketList.stream().forEach(so->{
         try {

            DataOutputStream ou = new DataOutputStream(so.getOutputStream());
            ou.writeUTF(msg);

         } catch (IOException e) {
         }
      });
   }




}

public class ServerTest extends Application { // Ŭ���̾�Ʈ�� �����ϰ� ������ �����ؾ��Ѵ�.
   Label lab;
   Button btn1;
   public void start(Stage stage) throws Exception {
      VBox root = new VBox();
      root.setPrefSize(400, 300);
      root.setSpacing(5);
      lab = new Label("�ο���: 0");
      btn1 = new Button("���� ����");
      btn1.setOnAction(new EventHandler<ActionEvent>() {

         @Override
         public void handle(ActionEvent arg0) {
            // TODO Auto-generated method stub
            ConnectThread ct = new ConnectThread(ServerTest.this);
            ct.start();
         }
      });
      
      root.getChildren().addAll(btn1, lab);
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Server");
      stage.show();
   }

   public static void main(String[] args) {
      launch();      

      System.out.println("���� ����");
   }
}
