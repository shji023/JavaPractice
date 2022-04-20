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
		console.log("클릭됨");
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
		// 곱할 수 2개
		let a = $("#span1").text();
		let b = $("#span2").text();
		console.log(a, b);
		
		// 닉네임
		let alias4 = $('input[name=alias]').val();
		console.log(alias4);
		
		// 답안
		let attempt4 = $('input[name=attempt]').val();
		console.log(attempt4);
		
		let formData = {
			user:{alias:alias4},
			multiplication:{factorA:a, factorB:b},
			resultAttempt:attempt4
		};
		console.log(formData);
		console.log(typeof formData);
		
		//user
		//alias
		// multiplication
		// resultAttempt
		
		
		let temp = JSON.stringify(formData);
		console.log(JSON.stringify(formData));
		console.log(typeof temp);
		
		$.ajax({
			url:"http://localhost:8081/t2",
			type:"POST",
			data:JSON.stringify(formData),
			datatype:"json",
			contentType:"application/json",
		}).then(function(data){
			let s3 = document.getElementById("span3");
			s3.textContent = data;
		}); 
	}
</script>
<body>
	<h1>I want to go home.</h1>
	<a href="t1">기본 컨트롤러 확인</a>
	<button onClick="f1()">문제요청</button>
	<span id="span1"></span>곱하기
	<span id="span2"></span>는 ?
	
	<form id="form1" name="form1" method="post">
		별칭 : <input type="text" name="alias" value="tiger"/>
		정답 : <input type="text" name="attempt" value="200"/>
		<input type="button" value="전송" onClick="f2();" />
	</form>
	<span id="span3"></span>ㅎㅎ
</body>
</html>