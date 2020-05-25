<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
	<a href="./index.jsp">HOME</a>
	<hr/>
	<h3>joinSuccess.jsp(p601)</h3>
	<p>http://localhost/board/join.do</p>
	<h1>${param.name}님,  회원이 되신 것을 환영해요!!!!</h1>
	param.name=${param.name}<br/>
	
	param.id=${param.id}
	param.password=${param.password}
	param.birth=${param.birth}
	param.phone=${param.phone}
	param.email=${param.email}
	param.address=${param.address}
	param.id=${paramValues.id}
	param.password=${paramValues.password}
	param.birth=${paramValues.birth}
	param.phone=${paramValues.phone}
	param.email=${paramValues.email}
	param.address=${paramValues.address}
	
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
</html>








