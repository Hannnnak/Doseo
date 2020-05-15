<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>회원제 게시판 예제</title>
</head>
<body>
	<h3>대문(index)</h3>
	<p>http://localhost/doseo/index.jsp</p>
	<ul>
<hr>

<c:if test="${! empty authUser}">
	${authUser.name}님, 안녕하세요.<hr>
	<a href="logout.do">[로그아웃하기]</a>
	<a href="changePwd.do">[암호변경하기]</a>
	<a href="./review/write.do">[후기 쓰기]</a>
	<a href="./review/list.do">[후기 목록조회]</a>
</c:if>
<c:if test="${empty authUser}">
	<a href="join.do">[회원가입하기]</a>
	<a href="login.do">[로그인하기]</a>
	<a href="./review/list.do">[후기 목록조회]</a>
</c:if>


</body>
</html>