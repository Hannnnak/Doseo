<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
	<%//request.setAttribute("errors",errors);
	
		//로그인이 성공되면 
	  //session.setAttribute("AUTHUSER", user);
	%>
	<h3>대문(index)</h3>
	<p>http://localhost/board</p>
	<p>http://localhost/board/index.jsp</p>
	<ul>
		<%-- 미로그인시 출력 내용 --%>
		<c:if test="${empty AUTHUSER && empty AUTHUSER2 }">
			<li><a href="./join.dom">회원가입</a></li>
			<li><a href="./login.dom">로그인</a></li>
		</c:if>
		
		<%-- 로그인시 출력 내용 --%>
		<c:if test="${! empty AUTHUSER }">
			<li>${AUTHUSER.name} 님, 안녕하세요</li>
			<li><a href="./logout.dom">로그아웃</a></li>
			<li><a href="./changePwd.dom">암호변경</a></li>
			<li><a href="./article/write.dom">글등록</a></li>
			<li><a href="./article/list.dom">글목록조회</a></li>
		</c:if>
		
		<%-- 관리자 로그인시 출력 내용 --%>
		<c:if test="${! empty AUTHUSER2}">
			<li>${AUTHUSER2.name} 님, 안녕하세요 관리자모드</li>
			<li><a href="./logout.dom">로그아웃</a></li>
			<li><a href="./changePwd.dom">암호변경</a></li>
			<li><a href="./article/write.dom">글등록</a></li>
			<li><a href="./list.dom">회원목록조회</a></li>
			<li><a href="">관리자페이지이동</a></li>
		</c:if>
		
		
	</ul>
</body>
</html>     








