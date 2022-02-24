package Pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/Web01/ -> html ȣ��
//http://localhost:8080/Web01/hello -> ���� Ŭ���� ȣ��
@WebServlet("/hello")
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
		PrintWriter out = response.getWriter();
		out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
				out.println("<h1>Monkey</h1>");
			out.println("</body>");
		out.println("</html>");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
