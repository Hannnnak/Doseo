<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 쓰기</title>
<link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
<a href="../index.jsp">HOME</a>
<hr>
<form action="write.do" method="post">
<div class="container">
	<table class="table table-hover">
	<thead>
		<tr style="background-color: lightgrey">
			<th style="text-align:center;">구매 후기</th>
		</tr>
	</thead>
	<tbody>
		<tr style="text-align:center;"><td>구매한 도서명[상세페이지에서 받아올 예정]</td></tr>
		<tr style="text-align:center;"><td>평점 : 0.0[자바스크립트로 구현할 예정]</td></tr>
		<tr style="text-align:center;"><td>제목 : <input type="text" name="title" value="${param.title}">
		<c:if test="${errors.title}">제목을 입력하세요.</c:if></td></tr>
		<tr style="text-align:center;"><td>내용 : <textarea name="content" rows="5" cols="30">${param.title}</textarea>
		</td></tr>
	</tbody>
	</table>
</div>
<div class="row justify-content-center">
<input type="submit"  class="btn btn-warning btn-lg" value="후기 등록">
</div>
</form>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
</body>
</html>