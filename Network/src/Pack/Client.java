package Pack;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		System.out.println("Client Start");
		Socket cs = new Socket();// 통신소켓 생성
		try {
			System.out.println("숫자를 입력하면 접속을 시도합니다.");
			new Scanner(System.in).nextInt();
			cs.connect(new InetSocketAddress("localhost",5001));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("숫자를 입력하면 클라이언트를 종료합니다.");
		new Scanner(System.in).nextInt();
		System.out.println("Client End");
	}

}
