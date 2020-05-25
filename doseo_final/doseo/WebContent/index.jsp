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
<jsp:include page="main.jsp"/>	
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
			<li><a href="./find.dom">아이디찾기</a></li>
			<li><a href="./findPw.dom">비밀번호찾기</a></li>		
		</c:if>
		
		<%-- 로그인시 출력 내용 --%>
		<c:if test="${! empty AUTHUSER }">
			<li>${AUTHUSER.name} 님, 안녕하세요</li>
			<li><a href="./logout.dom">로그아웃</a></li>
			<li><a href="./mypage.dom">마이페이지</a></li>
			<br/>
			<li><a href="./review/write.dom">리뷰등록</a></li>
			<li><a href="./review/list.dom">리뷰목록조회</a></li>
			<br/>
			<li><a href="./qnalist.dom">공지사항보기</a></li>
			<br/>
			<li><a href="./cart.dom">장바구니가기</a></li>
		</c:if>
		
		<%-- 관리자 로그인시 출력 내용 --%>
		<c:if test="${! empty AUTHUSER2}">
			<li><a href='./admin_product/write.dom'>관리자-상품등록</a></li>
			<li><a href='./admin_product/list.dom'>관리자-상품목록</a></li>
			<hr/>
			<li><a href="./qnawrite.dom">공지사항등록</a></li>
			<li><a href="./qnalist.dom">공지사항보기</a></li>
			<hr/>
			<li><a href="./list.dom">관리자-회원리스트</a></li>
			<li><a href="./logout.dom">로그아웃</a></li>
		</c:if>	
	</ul>
	
</body>
</html>