<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>      
<%@ taglib prefix="u"  tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	articleDATA=${articleDATA} //ArticleData클래스
	<br/>
	pageNo=${pageNo}//보고싶은페이지(릴레이용)
  <hr/>
	<a href="./index.jsp">HOME</a>
	<hr/>
	<h3>게시글 상세보기 -readAricle.jsp(p662)</h3>
	<p>http://localhost/board/article/read.dom</p>
	
	<table border="1" width="400">
		<tbody>
			<tr>
				<th width="100">번호</th>
				<td width="300">${articleDATA.article.number}</td>
			</tr>
			<tr>
				<th width="100">작성자</th>
				<td width="300">${articleDATA.article.writer.name}</td>
			</tr>
			<tr>
				<th width="100">제목</th>
				<td width="300">
					EL방식 : ${articleDATA.article.title}<br/>
				  JSTL : <c:out value="${articleDATA.article.title}"/>
				  <br/>
				</td>
			</tr>
			<tr>
				<th width="100">내용</th>
				<td width="300">
				EL방식 : ${articleDATA.content.content}<br/>
				커스텀태그: <u:pre value="${articleDATA.content.content}" />
				</td>
			</tr>
			<tr>
				<th colspan="4"><%-- p662 29 --%>
				  <%-- 목록보기를 클릭하면 조회하던 페이지로 이동
				  		만약 조회하던 페이지가 없으면 1페이지로 이동
				  <c:set var="변수명" value="값"/>
				  <c:set var="변수명" value="조건?참일경우값:거짓일경우값"/>
				  <c:set var="pageNo" value="조회하던 페이지가 없니?'1':조회하던 페이지"/>
				         pageNo변수에는 '1' 또는  조회하던페이지가 저장
				  --%>
				  <c:set var="pageNo" value="${empty pageNo?'1':pageNo}"/>
					<a href="./list.dom?pageNo=${pageNo}">목록보기</a>
					
					<%-- session.setAttribute("AUTHUSER", user); 세션
					            글수정과 삭제권한은 로그인한 유저 +
					           로그인한 유저도 자신의 글에 한해 수정과 삭제가 가능
					     (세션에서)로그인유저id == (MODEL에서)글작성자 id --%>
					<c:if test="${AUTHUSER.id == articleDATA.article.writer.id}">
						<a href="modify.dom?no=${articleDATA.article.number}">글 수정</a>  
						<a href="delete.dom?no=${articleDATA.article.number}">글 삭제</a>
					</c:if>
				</th>
			</tr>
		</tbody>
	</table>
</body>
</html>









