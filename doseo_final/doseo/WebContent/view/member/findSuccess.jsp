<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<jsp:include page="../../header.jsp"/>
</head>
<body>

<div class="row justify-content-center">
		<h3>${param.name}님</h3><br>
		<h3> 당신의 아이디는: ${FIND.id} 입니다.</h3>
	</div>	
		<br>
	<div class="row justify-content-center">
		<input type="button" class="btn btn-outline-secondary" value="로그인" onclick="location.href='login.dom'">
		<input type="button" class="btn btn-outline-primary" value="메인페이지 가기" onclick="location.href='main.dom'">
	</div>
<jsp:include page="../../footer.jsp"/>
</body>
</html>








