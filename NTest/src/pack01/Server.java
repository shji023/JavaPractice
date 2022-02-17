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
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Set;
import java.util.Iterator;

//소켓번호는 고유 번호이기 때문에 겹칠 일이 없어 키 값으로 사용하기 용이하다.
class ConnectThread extends Thread {
   Socket socket;
   Scanner sc;
   ServerSocket serverSocket;
   LinkedList<Socket> socketList;
   HashMap<Socket, String> socketMap = new HashMap<Socket, String>();

   Server SPJ;
   int id;
   ConnectThread(Server SPJ){
      this.SPJ = SPJ;
   }
   @Override
   public void run() {
      try {
         serverSocket = new ServerSocket(5001); // listen 상태 소켓을 생성
         socketList = new LinkedList<>();

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


      try {

         while (true) {
            String msg = in.readUTF();
            if(nameCheck) {
               socketMap.put(client,msg);
               sendMsg(client,socketMap.get(client) + "님이 접속하였습니다.");
               System.out.println(socketMap.get(client));
               
               
               StringBuffer sb = new StringBuffer();
               sb.append("#!");


               Set<Socket> keys = socketMap.keySet();
               Iterator<Socket> sk = keys.iterator();
               while(sk.hasNext()) {
//                  socketMap.get(sk.next());
//                  System.out.println(sk.next());
//                  System.out.println(socketMap.get(sk.next()));
                  
                  sb.append(socketMap.get(sk.next())+"\n");
               }
               sendMsg(client,sb.toString());
               System.out.println(sb);
               
               
               
               Platform.runLater(()->{
                  //                  System.out.println(SPJ.listView);
                  //                  System.out.println(SPJ.listView.getItems());
                  SPJ.listView.getItems().add(socketMap.get(client));
               });
               nameCheck = false;
            }
            else if(!msg.equals("")) {
               sendMsg(client,socketMap.get(client)+": "+msg);
            }
            else {
               System.out.println("빈 내용을 입력하지 말아주세요!");
            }
         }
      } catch (IOException e) {
         if(nameCheck) {
            System.out.println(client+"님 접속 종료");

            Platform.runLater(()->{
               --id;
               SPJ.lab.setText("인원수: "+id+"\n");
               socketMap.remove(client);
               socketList.remove(client);
            });
         }else {
            System.out.println(socketMap.get(client) +"님 접속 종료");
            sendMsg(client,socketMap.get(client) + "님이 접속 종료하였습니다.");
            
//            Set<Socket> keys = socketMap.keySet();
//            Iterator<Socket> sk = keys.iterator();
//            StringBuffer sb = new StringBuffer();
//            sb.append("#!");

            Platform.runLater(()->{
               --id;

               //               System.out.println(SPJ.listView.getItems().indexOf(socketMap.get(client)));
               SPJ.listView.getItems().remove(socketMap.get(client));
               SPJ.lab.setText("인원수: "+id+"\n");
               socketMap.remove(client);
               socketList.remove(client);

               StringBuffer sb = new StringBuffer();
               sb.append("#!");


               Set<Socket> keys = socketMap.keySet();
               Iterator<Socket> sk = keys.iterator();
               while(sk.hasNext()) {
//                  socketMap.get(sk.next());
//                  System.out.println(sk.next());
//                  System.out.println(socketMap.get(sk.next()));
                  
                  sb.append(socketMap.get(sk.next())+"\n");
               }
               sendMsg(client,sb.toString());
               System.out.println(sb);
               
               
            });

         }




         //         Set<Socket> keys = socketMap.keySet();
         //         Iterator<Socket> sk = keys.iterator();
         //         while(sk.hasNext()) {
         //            //socketMap.get(sk.next());
         //            System.out.println(socketMap.get(sk.next())+" 화이팅");
         //         }
      }
   }
   public void sendMsg(Socket client,String msg){

      socketList.stream().forEach(so->{
         try {

            DataOutputStream ou = new DataOutputStream(so.getOutputStream());
            ou.writeUTF(msg);

         } catch (IOException e) {
         }
      });
   }

}

public class Server extends Application { // 클라이언트를 종료하고 서버를 종료해야한다.
   Label lab;
   Button btn1;
   public ListView<String> listView;
   public void start(Stage stage) throws Exception {
      VBox root = new VBox();
      root.setPrefSize(400, 300);
      root.setSpacing(5);
      lab = new Label("인원수: 0");
      btn1 = new Button("서버 오픈");
      listView = new ListView<String>();
      btn1.setOnAction(new EventHandler<ActionEvent>() {

         @Override
         public void handle(ActionEvent arg0) {
            // TODO Auto-generated method stub
            ConnectThread ct = new ConnectThread(Server.this);
            ct.start();
         }
      });

      root.getChildren().addAll(btn1, lab,listView);
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