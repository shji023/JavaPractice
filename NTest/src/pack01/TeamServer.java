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
   // 필드 생성
   Socket socket;
   // 클라이언트 accept받는 socket
   ServerSocket serverSocket;
   LinkedList<Socket> socketList;
   // accept받아 생성된 클라이언트 소켓과 소유주 이름을 저장하기위한 해쉬맵
   HashMap<Socket, String> socketMap = new HashMap<Socket, String>();

   TeamServer SPJ;
   int cnt;
   ConnectThread(TeamServer SPJ){
      this.SPJ = SPJ;
   }
   @Override
   public void run() {
      try {
         serverSocket = new ServerSocket(5002); // listen 상태 소켓을 생성
         socketList = new LinkedList<>();

         cnt = 0; //아이디
         System.out.println("서버 실행");
         while (true) {
            // 클라이언트가 다중으로 접속하기 위한 무한반복문
            socket = serverSocket.accept();
            // connect 요청이 들어오면 연결 (올때까지 block)
            Platform.runLater(()->{
               ++cnt;
               SPJ.lab.setText("인원수: "+cnt+"\n");
            });
            //            System.out.println("클라이언트 접속");
            //            System.out.println(socket);

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
      // 처음에 이름을 받았는지 확인하기위한 변수
      Boolean nameCheck = true;

      try {
         while (true) {
            // 여기서 메세지는 클라이언트 이름
            String msg = in.readUTF();
            if(nameCheck) {

               if (msg.length() == 0) {
                  socketMap.put(client, client.toString().substring(13, 26));
               } else {
                  socketMap.put(client,msg);
               }
               sendMsg(client,socketMap.get(client) + "님이 접속하였습니다.");
               // buffer를 사용할 경우 String 전체를 수정하지 않아도 됨.
               StringBuffer sb = new StringBuffer();
               // !# 경우 시스템 메세지 명령어 임.
               sb.append("!#");
               // key(Socket), value(name)에서 Socket값만 빼서 
               Set<Socket> keys = socketMap.keySet();
               Iterator<Socket> sk = keys.iterator();
               // hasNext를 쓰기 위해서 iterator 사용
               // [1, 2, 3] [김익한, 이권철, 김미현]
               while(sk.hasNext()) {
                  // socketmap[1] == 김익한
                  // socketmap[2] == 이권철
                  // ...
                  // 4 번은 존재 하지 않아서 탈출 함.
                  sb.append(socketMap.get(sk.next())+"\n");
               }
               // sb결과물
               // !#김익한 
               // 이권철
               // 김미현
               // stringbuffer에서 string으로 변경
               sendMsg(client,sb.toString());

               // 서버쪽 UI 업데이트를 한다.
               Platform.runLater(()->{
                  SPJ.listView.getItems().add(socketMap.get(client));
               });
               nameCheck = false;
            }
            // 메세지기 존재할 경우
            else if(!msg.equals("")) {
               sendMsg(client,socketMap.get(client)+": "+msg);
            }
            else {
               System.out.println("빈 내용을 입력하지 말아주세요!");
            }
         }
      } catch (IOException e) {
         sendMsg(client,socketMap.get(client) + "님이 접속 종료하였습니다.");

         Platform.runLater(()->{
            --cnt;

            SPJ.listView.getItems().remove(socketMap.get(client));
            SPJ.lab.setText("인원수: "+cnt+"\n");
            socketMap.remove(client);
            socketList.remove(client);

            StringBuffer sb = new StringBuffer();
            sb.append("!#");

            Set<Socket> keys = socketMap.keySet();
            Iterator<Socket> sk = keys.iterator();
            // 나갔을 때 참가자 정보를 갱신하기 위해서 다시 보냄.
            while(sk.hasNext()) {
               sb.append(socketMap.get(sk.next())+"\n");
            }
            sendMsg(client,sb.toString());
            System.out.println(sb);
         });
      }
   }

   // recv 언제 데이터가 들어올지 몰라서 항상 while => 블로킹이 걸려서 => thread
   // send thread 사용ㄴ
   public void sendMsg(Socket client, String msg){
      // 현재 참가자들의 소켓에 하나씩 데이터를 보내 줌.
      socketList.stream().forEach(so->{
         try {
            DataOutputStream ou = new DataOutputStream(so.getOutputStream());
            ou.writeUTF(msg);
         } catch (IOException e) {
            e.printStackTrace();
         }
      });
   }
}

// UI켜주는거랑 server 소켓 쓰레드 실행해줌.
public class TeamServer extends Application { // 클라이언트를 종료하고 서버를 종료해야한다.
   // 참가자 수를 수정할 때, 다른 클래스에서 수정하기 때문에 필드에 선언 했음.
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

      // 서버를 실행하는 버튼
      btn1.setOnAction(new EventHandler<ActionEvent>() {
         @Override
         public void handle(ActionEvent arg0) {
            // TODO Auto-generated method stub
            ConnectThread ct = new ConnectThread(TeamServer.this);
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