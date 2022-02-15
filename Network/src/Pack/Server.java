package Pack;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		System.out.println("Server Start");
		try {
			ServerSocket ss = new ServerSocket();
			System.out.println("메인서버 소켓 생성");
//			if ( ss == null ) {
//				System.out.println("소켓을 생성할 수 없다.");
//				exit(0);
//			}
			// 자기자신에게 정보를 기록해놓는거 - 바인딩 
			// 누군가 접속을하면 기준이 있도록
			// 클라이언트는 바인딩 필요x
			// ss.bind("ip주소", 포트번호); // 127.0.0.1
			ss.bind(new InetSocketAddress("localhost",5001));
			System.out.println("바인딩 완료");
			// 블로킹 함수이다. 누군가가 접속을 해주면 풀림 
			ss.accept();
			System.out.println("누군가 접속을 시도했음");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Scanner sc = new Scanner(System.in);
//		sc.nextInt();		
		new Scanner(System.in).nextInt();
		System.out.println("Server End");
	}

}
