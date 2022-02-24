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
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
//		out.println("<html>");
//			out.println("<head>");
//			out.println("</head>");
//			out.println("<body>");
//				out.println("<h1>몽키</h1>");
//			out.println("</body>");
//		out.println("</html>");
		// 동적으로 만들 수 있게되었지만 html만드는 과정이 매우 불편
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// 하나의 프린트 문에서 문자열 연결
		out.println(
				"<html>"+
					"<head>"+"</head>"+
				    "<body>"+"<h1>monkey</h1>"+"</body>"
		        +"</html>");
		out.close(); //원칙
	}
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
