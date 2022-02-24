<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>   

<h2>연결테스트 </h2>

<%
  Connection conn=null;

  try{
	 String jdbcUrl = "jdbc:mysql://localhost:3306/test?useUnicode=true&serverTimezone=Asia/Seoul&autoReconnect=true&useSSL=false";
     String dbId = "root";
     String dbPass = "1234";
	
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 conn = DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
	 out.println("제대로 연결되었습니다.");
  }catch(Exception e){ 
	  e.printStackTrace();
  }
%>