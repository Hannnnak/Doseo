<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>index.jsp</h1>
<h2>Doseo 시작페이지</h2>
	<ul>
		<%-- 미로그인시 출력 내용 --%>
		<c:if test="${empty AUTHUSER }">
			<li><a href="./join.dom">회원가입</a></li>
			<li><a href="./login.dom">로그인</a></li>
		</c:if>
		<%-- 로그인시 출력 내용 --%>
		<c:if test="${! empty AUTHUSER }">
			<li><a href="./logout.dom">로그아웃</a></li>
			<li><a href='./mypage.dom'>마이페이지</a></li>
		</c:if>
	</ul>
</body>
</html>