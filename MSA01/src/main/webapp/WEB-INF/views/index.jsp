<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<script src="//code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript">
	function f1(){
		console.log("Ŭ����");
		$.ajax({
			url:"http://localhost:8081/t1",
			type:"GET"
		}).then(function(data){
			console.log(data);
		});
	}
</script>
<body>
	<h1>I want to go home.</h1>
	<a href="t1">�⺻ ��Ʈ�ѷ� Ȯ��</a>
	<button onClick="f1()">Ŭ�� Ȯ�ο�</button>
</body>
</html>