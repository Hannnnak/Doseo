<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="./index.jsp">HOME</a>
	<hr/>
	<h3>modifySuccess.jsp</h3>
	<p>http://localhost/doseo/modify.dom</p>
	<h1>${param.name}님, 회원정보수정완료</h1>
	param.name=${param.name}<br/>
	param.jname=${param.jname}
</html>