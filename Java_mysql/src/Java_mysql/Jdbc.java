package Java_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class Jdbc {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://192.168.0.79:3307/db01?useUnicode=true&serverTimezone=Asia/Seoul&autoReconnect=true&useSSL=false";
	String user = "lion";
	String pass = "1234";

	public Jdbc() {

		try {
			Class.forName(driver);
			System.out.println("mysql����̹� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("mysql����̹� ����");
		}

	}

	/////////////////////// Ŀ�ؼǿ���
	public Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, pass);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("db��������");
		}

		return conn;
	}

	///////////////////////// insert
	public void insert() {
		Scanner sc = new Scanner(System.in);

		String name, age, salary;

		String sql = "";

		System.out.println("�̸�?");
		name = sc.nextLine();
		System.out.println("����?");
		age= sc.nextLine();
		System.out.println("����?");
		salary = sc.nextLine();

		sql = "insert into table01 values(null,?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			// ?,?,?���ڰ� �ϼ�
			pstmt.setString(1, name);
			pstmt.setString(2, age);
			pstmt.setString(3, salary);

			// ������Ʈ
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//////////////////////////////////////// select
	public void select() {
		System.out.println("������\t �̸� \t����\t����");
		System.out.println("------------------------------");

		String sql = "select * from table01";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("age") + "\t"
						+ rs.getString("salary"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
	
	public void selectOne(int a) {
		System.out.println("������\t �̸� \t����\t����");
		System.out.println("------------------------------");

		String sql = "select * from table01 where id=";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql+a);

			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("age") + "\t"
						+ rs.getString("salary"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	//////////////////////////////////////// delete
	public void delete() {
		Scanner sc = new Scanner(System.in);
		String no;
		String sql = "";

		System.out.println("�� ���� �����Ͻðھ��?");
		no = sc.nextLine();

		sql = "delete from table01 where id=" + no;

		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null;

		conn = getConnection();
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("���� ���̵� ��ϴ�");
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

	/////////////////////////////// update
	public void update() {
		Scanner sc = new Scanner(System.in);
		String name, age, salary, id;

		System.out.println("������ ��ȣ �Է�");
		id = sc.nextLine();
		System.out.println("������ �̸� �Է�");
		name = sc.nextLine();
		System.out.println("������ ���� �Է�");
		age = sc.nextLine();
		System.out.println("������ ���� �Է�");
		salary = sc.nextLine();

		String sql = "update table01 set name=?, age=?, salary=? where id=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, age);
			pstmt.setString(3, salary);
			pstmt.setString(4, id);

			int a = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Jdbc mdb = new Jdbc();

		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		int n = 0;
		int user;

		while (true) {
			System.out.println("1.insert 2.select 3.delete 4.update 0.����");
			n = Integer.parseInt(sc.nextLine());

			if (n == 1) 
				mdb.insert();
			else if (n == 0) {
				System.out.println("����");
				break;
			} else if (n == 2) {
				System.out.println("��ü�� �ҷ������� 0, Ư�� id�� �ҷ������� id�Է�");

				user = Integer.parseInt(sc1.nextLine());
				if (user == 0) {
					mdb.select();
				} else {
					mdb.selectOne(user);
				}
			}
			else if (n == 4)
				mdb.update();
			else if(n==3)
				mdb.delete();
		}

	}

}