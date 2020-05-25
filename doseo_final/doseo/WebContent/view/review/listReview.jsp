<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>후기 목록</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<jsp:include page="../../header.jsp"/>
<style type="text/css">
	li {
	   list-style: none;
   }
</style>
</head>
<body>
<div class="container">
	<b style="font-size:20px;">후기 [${reviewPage.total}]</b>
	<c:if test="${empty AUTHUSER && empty AUTHUSER2 }">
	<button class="btn btn-outline-primary float-right" style="margin:10px;"><a href="../doseo/login.dom">후기 작성</a></button>
	</c:if>
	<c:if test="${! empty AUTHUSER}">
	<button class="btn btn-outline-primary float-right" style="margin:10px;"><a href="./reviewwrite.dom">후기 작성</a></button>
	</c:if>
	<c:if test="${! empty AUTHUSER2}">
	</c:if>
<table class="table table-hover" width="100%">
		<thead>
			<tr style="background-color: lightgrey">
				<th>글 번호</th>
				<th>평점</th>
				<th>도서명</th>
				<th>후기 제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
	
<c:if test="${reviewPage.hasNoReviews()}">
	<tr>
		<td colspan=7">게시글이 없습니다.</td>
	</tr>
</c:if>
<c:forEach var="review" items="${reviewPage.content}">
	<tbody>
	<tr>
		<td>${review.number}</td>
		<td>${review.rating}</td>
		<td>${review.bookname}</td>
		<td><a href="reviewread.dom?no=${review.number}&pageNo=${reviewPage.currentPage}" style="text-decoration:none; color:black">
		<c:out value="${review.title}"/></a></td>
		<td>${review.writer.name}</td>
		<td>${review.regDate}</td>
		<td>${review.readCount}</td>
	</tr>
</tbody>
</c:forEach>
</table>
</div>
<table style="margin-left: auto; margin-right: auto;">
	<c:if test="${reviewPage.hasReviews()}">
		<tr>
			<th colspan="5">
				<c:if test="${reviewPage.startPage > 5}">
				<li class="page-item"><a href="reviewlist.dom?pageNo=${reviewPage.startPage - 5}" class="page-link">이전</a></li>
				</c:if>
					
				<c:forEach var="pNo" 
				   begin="${reviewPage.startPage}" 
				   end="${reviewPage.endPage}">
				<li class="page-item"><a href="reviewlist.dom?pageNo=${pNo}" class="page-link">${pNo}</a></li>	
				</c:forEach>
					
				<c:if test="${reviewPage.endPage < reviewPage.totalPages}">
				<li class="page-item"><a href="reviewlist.dom?pageNo=${reviewPage.startPage + 5}" class="page-link">다음</a></li>
				</c:if>
			</th>
		</tr>
	</c:if>	
</table>
</body>
<jsp:include page="../../footer.jsp"/>
</html>