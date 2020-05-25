<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 수정</title>
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
<form action="reviewmodify.dom" method="post">
<input type="hidden" name="no" value="${modReq.reviewNumber}">
<div class="container">
	<table class="table table-hover">
		<thead>
			<tr style="background-color: lightgrey">
				<th style="text-align:center;">도서 후기 수정</th>
			</tr>
		</thead>
		<tbody>
			<tr style="text-align:center;"><td>제목 수정 : <input type="text" name="title" value="${modReq.title}">
					<c:if test="${errors.title}">제목을 입력하세요.</c:if></td></tr>
			<tr style="text-align:center;"><td>내용 수정 : <textarea name="content" rows="5" cols="30">${modReq.content}</textarea></td></tr>
		</tbody>
	</table>
</div>
<div class="row justify-content-center">
	<input type="submit" class="btn btn-outline-primary btn-lg" value="후기 수정" style="margin:10px;">
</div>
</form>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<jsp:include page="../../footer.jsp"/>
</body>
</html>