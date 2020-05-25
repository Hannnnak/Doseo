<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 쓰기</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<jsp:include page="../../header.jsp"/>
</head>
<style>
body {
	margin: 0 20px 0 20px;
}
</style>
<body>
<form action="reviewwrite.dom" method="post">
<div class="container">
	<table class="table table-hover">
	<thead>
		<tr style="background-color: lightgrey">
			<th style="text-align:center;">도서 후기</th>
		</tr>
	</thead>
	<tbody>
		<tr style="text-align:center;"><td>구매한 도서명: <input type="text" name="bookname" value="${param.bookname}">
		<c:if test="${errors.title}">도서명을 입력하세요.</c:if></td></tr>
		<tr style="text-align:center;"><td>평점 : <input type="text" name="rating" value="${param.rating}">
		<c:if test="${errors.title}">평점을 입력하세요.</c:if></td></tr>
		<tr style="text-align:center;"><td>제목 : <input type="text" name="title" value="${param.title}">
		<c:if test="${errors.title}">제목을 입력하세요.</c:if></td></tr>
		<tr style="text-align:center;"><td>내용 : <textarea name="content" rows="5" cols="30">${param.content}</textarea>
		<c:if test="${errors.title}">내용을 입력하세요.</c:if></td></tr>
	</tbody>
	</table>
</div>
<div class="row justify-content-center">
<input type="submit"  class="btn btn-outline-primary btn-lg" value="후기 등록">
</div>
</form>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<jsp:include page="../../footer.jsp"/>
</body>
</html>