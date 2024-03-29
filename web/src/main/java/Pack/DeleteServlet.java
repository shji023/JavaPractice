package Pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = null;
		PreparedStatement pstmt=null;
		int n=0;
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("idx");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://13.125.251.30:3307/db01";
			con = DriverManager.getConnection(url, "lion", "1234");
			String sql = "delete from user where idx=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			n= pstmt.executeUpdate();
		}catch(ClassNotFoundException ce){
			System.out.println(ce.getMessage());
		}catch(SQLException se){
			System.out.println(se.getMessage());
		}finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			}catch(SQLException se){
				System.out.println(se.getMessage());
			}
		}
		if(n>0){
			pw.println ("<html><body><script>");
            pw.println ("alert('계정이 삭제되었습니다.');</script></body></html>");
			response.sendRedirect("list.do");
		}else{
			pw.println("<html>");
			pw.println("<head></head>");
			pw.println("<body>");
			pw.println("회원삭제에 실패했습니다.");
			pw.println("<a href='javascript:history.go(-1)'>이전페이지로 가기</a>");
			pw.println("</body>");
			pw.println("</html>");
			pw.close();
		}
	}
}