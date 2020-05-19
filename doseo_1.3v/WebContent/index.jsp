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
	<h1>대문(index)</h1>
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
			<br/>
			<li><a href="./mypage.dom">마이페이지</a></li>
			<br/>
			<li><a href="./review/write.dom">글등록</a></li>
			<li><a href="./review/list.dom">글목록조회</a></li>
			<br/>
			<li><a href="./qnawrite.dom">문의글등록</a></li>
			<br/>
			<li><a href='./admin_product/write.dom'>상품등록</a></li>
			<li><a href='./admin_product/list.dom'>상품목록</a></li>
		</c:if>
		
		<%-- 관리자 로그인시 출력 내용 --%>
		<c:if test="${! empty AUTHUSER2}">
			<li><a href="">관리자페이지이동</a></li>
		</c:if>	
	</ul>
</body>
</html>     








