package Pack;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {
		System.out.println("Server Start");
		try {
			ServerSocket ss = new ServerSocket();
			System.out.println("���μ��� ���� ����");
//			if ( ss == null ) {
//				System.out.println("������ ������ �� ����.");
//				exit(0);
//			}
			// �ڱ��ڽſ��� ������ ����س��°� - ���ε� 
			// ������ �������ϸ� ������ �ֵ���
			// Ŭ���̾�Ʈ�� ���ε� �ʿ�x
			// ss.bind("ip�ּ�", ��Ʈ��ȣ); // 127.0.0.1
			ss.bind(new InetSocketAddress("localhost",5001));
			System.out.println("���ε� �Ϸ�");
			// ���ŷ �Լ��̴�. �������� ������ ���ָ� Ǯ�� 
			ss.accept();
			System.out.println("������ ������ �õ�����");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		Scanner sc = new Scanner(System.in);
//		sc.nextInt();		
		new Scanner(System.in).nextInt();
		System.out.println("Server End");
	}

}
