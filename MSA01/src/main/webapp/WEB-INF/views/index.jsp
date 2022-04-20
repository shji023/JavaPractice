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
			console.log(data.factorA);
			console.log(data.factorB);
			let s1 = document.getElementById("span1");
			let s2 = document.getElementById("span2");
			s1.textContent = data.factorA;
			s2.textContent = data.factorB;
		});
	}
	function f2(){
		let formData = {a:'monkey',b:100};
		console.log(formData);
		$.ajax({
			url:"http://localhost:8081/t2",
			type:"POST",
			data:formData
		}).then(function(data){
			console.log(data);
		});
	}
</script>
<body>
	<h1>I want to go home.</h1>
	<a href="t1">�⺻ ��Ʈ�ѷ� Ȯ��</a>
	<button onClick="f1()">������û</button>
	<span id="span1"></span>���ϱ�
	<span id="span2"></span>�� ?
	
	<form id="form1" name="form1" method="post">
		��Ī : <input type="text" name="alias" value="tiger"/>
		���� : <input type="text" name="attempt" value="200"/>
		<input type="button" value="����" onClick="f2();" />
	</form>
</body>
</html>