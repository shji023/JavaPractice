package Pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 1. parameter로 전송된 id얻기.
		String idx=req.getParameter("idx");
		//String id=req.getParameter("id");
		// 2. id에 해당하는 정보를 db에서 조회해서 출력.
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("<head></head>");
		pw.println("<body>");

		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rs=null;

		try{
			// 2. 전송된 값을 db에 저장.
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://13.125.251.30:3307/db01?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
			con = DriverManager.getConnection(url, "lion", "1234");

			String sql = "select * from user where idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, idx);

			//sql구문 실행하기
			rs = pstmt.executeQuery();
			rs.next();
			String id = rs.getString("id");
			String idx2 = rs.getString("idx");
			String pwd = rs.getString("pwd");
			String email=rs.getString("email");
			String phone=rs.getString("phone");
			pw.println("<form method='post' action='updateok.do'>");
			pw.println("<input type='hidden' name='idx' value='" + idx2 + "'/>");
			pw.println("<input type='hidden' name='id' value='" + id + "'/>");
			pw.println("아이디<input type='text' name='id' value='" + id + "' disabled='disabled'/><br/>");
			pw.println("비밀번호<input type='text' name='pwd' value='" + pwd + "'/><br/>");
			pw.println("email<input type='text' name='email' value='" + email + "'/><br/>");
			pw.println("phone<input type='text' name='phone' value='" + phone + "'/><br/>");
			pw.println("<input type='submit' value='저장'/><br/>");
			pw.println("</form>");
		}catch(ClassNotFoundException ce){
			System.out.println(ce.getMessage());
		}catch(SQLException se){
			System.out.println(se.getMessage());
		}finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
}