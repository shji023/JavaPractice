<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<title>설문조사 페이지</title>
</head>

<body>
	<h1>설문조사</h1>
	<form method="POST" action="survey">
      <h3>1. 응답자 성함</h3><br/>   
      <input type="text" name="name" value=""/><br/>
      
      <h3>2. 응답자 나이</h3><br/>   
      <input type="text" name="age" value=""/><br/>
      
      <h3>3. 응답자 연락처</h3><br/>   
      <input type="text" name="phone" value=""/><br/>
      
      <h3>4. 응답자 거주지</h3><br/>   
      <input type="text" name="living_region" value=""/><br/>
      
      <h3>5. 당신의 역할은 무엇입니까?</h3><br/>      
      <input type="radio" name="role" value="서버" checked="checked">서버
      <input type="radio" name="role" value="프론트">프론트
      <input type="radio" name="role" value="풀스택">풀스택
      <input type="radio" name="role" value="DB">DB<br/>
      
      <h3>6. 많이 사용하는 개발도구는 무엇입니까?</h3><br/>      
      <input type="radio" name="tool" value="이클립스" checked="checked">이클립스
      <input type="radio" name="tool" value="인텔리J">인텔리J
      <input type="radio" name="tool" value="서브라임">서브라임
      <input type="radio" name="tool" value="비주얼코드">비주얼코드<br/>
      
      <h3>7. 하고 싶은 말을 적어주세요.</h3><br/>   
      <input type="text" name="wts" value=""/><br/>
      
      <input type="submit" value="전송"/><br/>
   </form>
</body>