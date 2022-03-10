<%@page import="Pack01.Person"%>
<%@page import="java.util.LinkedList" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	int num = (int)request.getAttribute("num");
	out.println(num+"<br />");
	
	String str = (String)request.getAttribute("str");
	out.println(str+"<br />");
	
	int[] list = (int[])request.getAttribute("ar");
/*	for (int i=0; i<list.length; i++){
		out.println(list[i]+"<br />");
	} */
	for (int v:list) {
		out.println(v+"<br />");
	} 
/* 
	Person p = (Person)request.getAttribute("person");
	out.println(p.getId());
	out.println(p.getPwd()); */
	
	@SuppressWarnings("unchecked")
	LinkedList<Integer> list01 = 
			(LinkedList<Integer>)request.getAttribute("list01");
	out.println(list01.get(0));
	out.println(list01.get(1));
	out.println(list01.get(2));
	
	@SuppressWarnings("unchecked")
	LinkedList<String> list02 = 
			(LinkedList<String>)request.getAttribute("list02");
	out.println(list02.get(0));
 	out.println(list02.get(1));
	out.println(list02.get(2));
	 
	@SuppressWarnings("unchecked")
	LinkedList<Person> list03 = 
			(LinkedList<Person>)request.getAttribute("list03");
	out.println(list03.get(0).getId());
 	out.println(list03.get(1).getId());
	out.println(list03.get(2).getId()); 
	out.println(list03.get(0).getPwd());
 	out.println(list03.get(1).getPwd());
	out.println(list03.get(2).getPwd()); 
%>

	<c:forEach var="value" items="${list}" varStatus="status">
		<h3>${status.index}:${value}</h3>
	</c:forEach>
</body>
</html>