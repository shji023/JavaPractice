package pack01;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Set;
import java.util.Iterator;

//���Ϲ�ȣ�� ���� ��ȣ�̱� ������ ��ĥ ���� ���� Ű ������ ����ϱ� �����ϴ�.
class ConnectThread extends Thread {
   // �ʵ� ����
   Socket socket;
   // Ŭ���̾�Ʈ accept�޴� socket
   ServerSocket serverSocket;
   LinkedList<Socket> socketList;
   // accept�޾� ������ Ŭ���̾�Ʈ ���ϰ� ������ �̸��� �����ϱ����� �ؽ���
   HashMap<Socket, String> socketMap = new HashMap<Socket, String>();

   TeamServer SPJ;
   int cnt;
   ConnectThread(TeamServer SPJ){
      this.SPJ = SPJ;
   }
   @Override
   public void run() {
      try {
         serverSocket = new ServerSocket(5002); // listen ���� ������ ����
         socketList = new LinkedList<>();

         cnt = 0; //���̵�
         System.out.println("���� ����");
         while (true) {
            // Ŭ���̾�Ʈ�� �������� �����ϱ� ���� ���ѹݺ���
            socket = serverSocket.accept();
            // connect ��û�� ������ ���� (�ö����� block)

            //            System.out.println("Ŭ���̾�Ʈ ����");
            //            System.out.println(socket);

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
      // ó���� �̸��� �޾Ҵ��� Ȯ���ϱ����� ����
      Boolean nameCheck = true;

      try {
         Set<Socket> keys;
         Iterator<Socket> sk;
         while (true) {
            // ���⼭ �޼����� Ŭ���̾�Ʈ �̸�
            String msg = in.readUTF();
            if(nameCheck) {
               keys = socketMap.keySet();
               sk = keys.iterator();
               while(sk.hasNext()) {
                  // socketmap[1] == ��ö��
                  // socketmap[2] == ��μ�
                  // ...
                  // 4 ���� ���� ���� �ʾƼ� Ż�� ��.
                  try {
                     if(msg.equals(socketMap.get(sk.next()))) {
                        client.close();
                        return;
                     }
                  }
                  //���� ĳġ�� ���� ���� ��������
                  catch(Exception e){
                     return;
                  }
               }
               if (msg.length() == 0) {
                  socketMap.put(client, client.toString().substring(13, 26));
               } else {
                  socketMap.put(client,msg);
               }
               Platform.runLater(()->{
                  ++cnt;
                  SPJ.lab.setText("�ο���: "+cnt+"\n");
               });
               sendMsg(client,socketMap.get(client) + "���� �����Ͽ����ϴ�.");
               // buffer�� ����� ��� String ��ü�� �������� �ʾƵ� ��.

               keys = socketMap.keySet();
               sk = keys.iterator();

               StringBuffer sb = new StringBuffer();
               // !# ��� �ý��� �޼��� ��ɾ� ��.


               sb.append("!#");
               // key(Socket), value(name)���� Socket���� ���� 
               //               Set<Socket> keys = socketMap.keySet();
               //               Iterator<Socket> sk = keys.iterator();
               // hasNext�� ���� ���ؼ� iterator ���
               // [1, 2, 3] [�ּ���, ������, ������]
               while(sk.hasNext()) {
                  // socketmap[1] == ��Ÿ��
                  // socketmap[2] == ����
                  // ...
                  // 4 ���� ���� ���� �ʾƼ� Ż�� ��.
                  sb.append(socketMap.get(sk.next())+"\n");
               }
               // sb�����
               // !#���ּ� 
               // ����
               // ���ؿ�
               // stringbuffer���� string���� ����
               sendMsg(client,sb.toString());

               // ������ UI ������Ʈ�� �Ѵ�.
               Platform.runLater(()->{
                  SPJ.listView.getItems().add(socketMap.get(client));
               });
               nameCheck = false;
            }
            else if (msg.startsWith("/w")) {
               sendMsg(client,msg);
            }
            // �޼����� ������ ���
            else if(!msg.equals("")) {
               sendMsg(client,socketMap.get(client)+": "+msg);
            }

            else {
               System.out.println("�� ������ �Է����� �����ּ���!");
            }
         }
      } catch (IOException e) {
         sendMsg(client,socketMap.get(client) + "���� ���� �����Ͽ����ϴ�.");

         Platform.runLater(()->{
            --cnt;

            SPJ.listView.getItems().remove(socketMap.get(client));
            SPJ.lab.setText("�ο���: "+cnt+"\n");
            socketMap.remove(client);
            socketList.remove(client);

            StringBuffer sb = new StringBuffer();
            sb.append("!#");
            Set<Socket> keys;
            Iterator<Socket> sk;
            keys = socketMap.keySet();
            sk = keys.iterator();
            // ������ �� ������ ������ �����ϱ� ���ؼ� �ٽ� ����.
            while(sk.hasNext()) {
               sb.append(socketMap.get(sk.next())+"\n");
            }
            sendMsg(client,sb.toString());
            System.out.println(sb);
         });
      }
   }



   public static <K, V> K getKey(Map<K, V> map, V value) {

      for (K key : map.keySet()) {
         if (value.equals(map.get(key))) {
            return key;
         }
      }
      return null;
   }





   //    recv ���� �����Ͱ� ������ ���� �׻� while => ���ŷ�� �ɷ��� => thread
   //    send�� thread�� ������� �ʴ´�.
   public void sendMsg(Socket client, String msg){
      // ���� �����ڵ��� ���Ͽ� �ϳ��� �����͸� ���� ��.


      String mstmp;

      if(msg.startsWith("/w")) {
         try {
            //System.out.println("�Ӹ�");

            //ww[Ŭ���̾�Ʈ �г���].���Ͽ��ٰ� ����
            //���� Ŭ���̾�Ʈ ���� ��������

            mstmp=msg.substring(msg.indexOf("[")+1,msg.indexOf("]"));
            System.out.println(mstmp);
            if(getKey(socketMap,mstmp)!=null) {
               DataOutputStream ou = new DataOutputStream(getKey(socketMap,mstmp).getOutputStream());
               ou.writeUTF("(�ӼӸ�)"+socketMap.get(client)+": "+ msg.substring(msg.indexOf("]")+1));
            }
            else {
               DataOutputStream ou = new DataOutputStream(client.getOutputStream());
               ou.writeUTF("�ӼӸ� �������� ����� ���� ���� �ƴմϴ�.");
               return;
            }
            //DataOutputStream ou = new DataOutputStream(client.getOutputStream());
            //DataOutputStream ou = new DataOutputStream(.getOutputStream());
            //ou.writeUTF("�Ӹ����");

            //client.writeUTF(msg);

            return;

         } catch (IOException e) {
            e.printStackTrace();
            return;
         }

      }


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

// UI���ִ°Ŷ� server ���� ������ ��������.
public class TeamServer extends Application { // Ŭ���̾�Ʈ�� �����ϰ� ������ �����ؾ��Ѵ�.
   // ������ ���� ������ ��, �ٸ� Ŭ�������� �����ϱ� ������ �ʵ忡 ���� ����.
   Label lab;
   Button btn1;
   public ListView<String> listView;
   public void start(Stage stage) throws Exception {
      VBox root = new VBox();
      root.setPrefSize(400, 300);
      root.setSpacing(5);
      lab = new Label("�ο���: 0");
      btn1 = new Button("���� ����");
      listView = new ListView<String>();

      // ������ �����ϴ� ��ư
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

      System.out.println("���� ����");
   }
}