package Pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8080/Web01/ -> html ȣ��
// http://localhost:8080/Web01/hello -> ���� Ŭ���� ȣ��
// @WebServlet("/") - index����Ŵ
// @WebServlet("/hello") 
// 1.@WebServlet("/tiger")
// 2.
// <servlet-name>tiger</servlet-name>
// <servlet-class>Pack.HelloServlet</servlet-class>
// 1�� 2 ����. ���� ���� ����ұ�? �����̳�(xml)�� �����Ұ��̳� ���α׷���(java)�� ������ ���̳� 
// 2�� ���� �ڵ�� ��� 
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HelloServlet() {
        super();
    }

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet Call"); // �� �������� ��û�� ������ �ڹ� �ڵ带 ȣ���Ѵ�!
		// out�� �̿��ؼ� html�� �����
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
//		out.println("<html>");
//			out.println("<head>");
//			out.println("</head>");
//			out.println("<body>");
//				out.println("<h1>��Ű</h1>");
//			out.println("</body>");
//		out.println("</html>");
		// �������� ���� �� �ְԵǾ����� html����� ������ �ſ� ����
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// �ϳ��� ����Ʈ ������ ���ڿ� ����
		out.println(
				"<html>"+
					"<head>"+"</head>"+
				    "<body>"+"<h1>monkey</h1>"+"</body>"
		        +"</html>");
		out.close(); //��Ģ
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
