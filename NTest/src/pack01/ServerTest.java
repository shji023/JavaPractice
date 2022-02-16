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
         serverSocket = new ServerSocket(5001); // listen 상태 소켓을 생성
         socketList = new LinkedList<>();
         socketMap = new HashMap<>();
         id = 0; //아이디
         System.out.println("서버 실행");
         while (true) {
            // 클라이언트가 다중으로 접속하기 위한 무한반복문
            
            socket = serverSocket.accept();
            // connect 요청이 들어오면 연결 (올때까지 block)
            
            Platform.runLater(()->{
                  ++id;
                     SPJ.lab.setText("인원수: "+id+"\n");
                  });
            System.out.println("클라이언트 접속");
            System.out.println(socket);
            socketMap.put(socket,id);
            socketList.add(socket);
            
            // 클라이언트마다 스레드를 생성
            // Thread가 없을경우 readUTF() 메서드에서 block이 발생하기 때문에 독립적으로 분할한다.  
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
               sendMsg(client,name+"님이 접속했습니다.");
            }
            else if(!msg.equals("")) {
               sendMsg(client,name+": "+msg);
               System.out.println(msg);
            }
            else {
               System.out.println("빈 내용을 입력하지 말아주세요!");
            }
         }
      } catch (IOException e) {
    	  if(nameCheck) {
    		  System.out.println(name+"님 접속 종료");

    		  Platform.runLater(()->{
    			  --id;
    			  SPJ.lab.setText("인원수: "+id+"\n");
    		  });
    	  }
    	  else {
    		  sendMsg(client, name+"님이 접속 종료 했습니다.");

    		  Platform.runLater(()->{
    			  --id;
    			  SPJ.lab.setText("인원수: "+id+"\n");
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

public class ServerTest extends Application { // 클라이언트를 종료하고 서버를 종료해야한다.
   Label lab;
   Button btn1;
   public void start(Stage stage) throws Exception {
      VBox root = new VBox();
      root.setPrefSize(400, 300);
      root.setSpacing(5);
      lab = new Label("인원수: 0");
      btn1 = new Button("서버 오픈");
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

      System.out.println("서버 종료");
   }
}
