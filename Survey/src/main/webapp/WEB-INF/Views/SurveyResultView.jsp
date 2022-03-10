<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@page import="Pack01.Dao" %>
<%@page import="Pack01.DTO" %>
<%@page import="java.util.LinkedList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h3>여기는 SurveyResultView</h3>
	<table border="1">
		<%
		ResultSet rs = (ResultSet) request.getAttribute("surveyList");
		while (rs.next()) {
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String phone = rs.getString("phone");
			String region = rs.getString("region");
			String role = rs.getString("role");
			String tool = rs.getString("tool");
			String wts = rs.getString("wts");

			out.println("<tr>");
			out.println("<td>" + name + "</td>");
			out.println("<td>" + age + "</td>");
			out.println("<td>" + phone + "</td>");
			out.println("<td>" + region + "</td>");
			out.println("<td>" + role + "</td>");
			out.println("<td>" + tool + "</td>");
			out.println("<td>" + wts + "</td>");
			out.println("</tr>");
		}
		%>
	</table>

</body>
</html>