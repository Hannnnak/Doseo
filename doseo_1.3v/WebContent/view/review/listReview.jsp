<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>후기 목록</title>
<link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
<a href="../index.jsp">HOME</a>
<hr>
<div class="container">
	<b style="font-size:20px;">후기 [${reviewPage.total}]</b>
	<button class="btn btn-warning float-right" style="margin:10px;"><a href="write.dom">후기 작성</a></button>
<table width="100%">
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
		<td>[평점입력예정]</td>
		<td>[상세페이지에서 받아올 예정]</td>
		<td>
		<a href="read.dom?no=${review.number}&pageNo=${reviewPage.currentPage}">
		<c:out value="${review.title}"/>
		</a>
		</td>
		<td>${review.writer.name}</td>
		<td>${review.regDate}</td>
		<td>${review.readCount}</td>
	</tr>
</tbody>
</c:forEach>
</table>
</div>

<div class="row justify-content-center">
	<c:if test="${reviewPage.hasReviews()}">
	<ul class="pagination">
		<li class="page-item"><c:if test="${reviewPage.startPage > 5}">
			<a href="list.dom?pageNo=${reviewPage.startPage - 5}">[이전]</a></c:if></li>
		<li class="page-item"><c:forEach var="pNo" 
					   begin="${reviewPage.startPage}" 
					   end="${reviewPage.endPage}">
			<a href="list.dom?pageNo=${pNo}">[${pNo}]</a>	</c:forEach></li>
		<li class="page-item"><c:if test="${reviewPage.endPage < reviewPage.totalPages}">
			<a href="list.dom?pageNo=${reviewPage.startPage + 5}">[다음]</a>	</c:if></li>
	</ul>
	</c:if>
</div>
	
<div class="row justify-content-center">
	<select style="width:100px;">
		<option selected="selected">평점</option>
		<option>도서명</option>
		<option>후기 제목</option>
		<option>작성자</option>
		<option>작성일</option>
	</select>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="text" style="width:300px;" value="자바스크립트로 기능 구현 예정">
</div>

</body>
</html>