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
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import javax.print.DocFlavor.INPUT_STREAM;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 



public class Server_old {
    Socket socket;
    Scanner sc;
    ServerSocket serverSocket;
    LinkedList<Socket> socketList;
    Map<Socket, Integer> socketMap;
    public Server_old() {
        try {
            serverSocket = new ServerSocket(); // listen 상태 소켓을 생성
            serverSocket.bind(new InetSocketAddress("192.168.0.79",5001));
            socketList = new LinkedList<>();
            socketMap = new HashMap<>();
            int id = 0; //아이디
            System.out.println("서버 실행");
                while (true) {
                  // 클라이언트가 다중으로 접속하기 위한 무한반복문
 
                    socket = serverSocket.accept();
                     // connect 요청이 들어오면 연결 (올때까지 block)
 
                    System.out.println("클라이언트 접속");
                    System.out.println(socket);
                    socketMap.put(socket,++id);
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
    
    
    //------------------------------------------------------------------------
    
    
    public void revMsg(DataInputStream in,Socket client){
            try {
//            	// InputStream is = socket.getInputStream();
//    			byte[]recvData = new byte[512];
                while (true) {
                    String msg = in.readUTF();
                    System.out.println(msg);
                    if(!msg.equals("")) {
                      sendMsg(client,msg);
                    }
//                	int size = in.read(recvData);
//                	if(size == -1) {
//    					System.out.println("클라이언트 접속 종료");
//    					break;
//    				}
//    				String s = new String(recvData, 0, size); // 읽을 데이터의 크기
//    				if(!s.equals("")) {
//                      sendMsg(client,s);
//                    }
                }
 
            } catch (IOException e) {
            }
    }
    
    
    
    
    public void sendMsg(Socket client,String msg){
      Integer id = socketMap.get(client);
      socketList.stream().forEach(so->{
    	  try {

    		  DataOutputStream ou = new DataOutputStream(so.getOutputStream());
    		  //          ou.writeUTF(id+"번님 : "+msg);
    		  //OutputStream os = socket.getOutputStream();
    		  //byte[]data = msg.getBytes();
    		  System.out.println("msg : "+msg);
    		  ou.writeUTF(msg);


    		  //System.out.println("전송");
    	  } catch (IOException e) {
    	  }
      });
    }
    
   //---------------------------------------------------------------
    
    
    
    
    public static void main(String[] args){
        new Server_old();
    }
}

