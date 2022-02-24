<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<% request.setCharacterEncoding("utf-8");%>

<% 
   String idt = request.getParameter("id");
   String passwd= request.getParameter("passwd");
   String name = request.getParameter("name");
   String age = request.getParameter("age");

   Connection conn=null;
   PreparedStatement pstmt=null;
   String str="";
   try{
 	 String jdbcUrl="jdbc:mysql://localhost:3306/test?useUnicode=true&serverTimezone=Asia/Seoul&autoReconnect=true&useSSL=false";
     String dbId="root";
     String dbPass="1234";
 	 
 	 Class.forName("com.mysql.cj.jdbc.Driver");
 	 conn=DriverManager.getConnection(jdbcUrl,dbId ,dbPass );
 	
 	 String sql= "insert into user values (null,?,?,?)";
 	 pstmt=conn.prepareStatement(sql);
     pstmt.setString(1,passwd);
 	 pstmt.setString(2,name);
 	 pstmt.setString(3,age);
 	 pstmt.executeUpdate();
 	 
 	 out.println("member 테이블에 새로운 레코드를 추가했습니다.");

 	}catch(Exception e){ 
 		e.printStackTrace();
 		out.println("member 테이블에 새로운 레코드를 추가에 실패했습니다");
 	}finally{
 		if(pstmt != null) 
 			try{pstmt.close();}catch(SQLException sqle){}
 		if(conn != null) 
 			try{conn.close();}catch(SQLException sqle){}
 	}
 %>