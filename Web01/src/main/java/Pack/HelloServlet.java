package Pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8080/Web01/ -> html 호출
//http://localhost:8080/Web01/hello -> 현재 클래스 호출
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HelloServlet() {
        super();
    }

	protected void doGet(
			HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet Call"); // 웹 브라우저의 요청이 있으면 자바 코드를 호출한다!
		// out을 이용해서 html을 만든다
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
