<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>후기 상세보기</title>
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
<div>
		<button class="btn btn-outline-primary float-left" style="margin:10px;"><a href="reviewlist.dom">목록</a></button>
	<c:if test="${empty AUTHUSER && empty AUTHUSER2 }">
		<button class="btn btn-outline-primary float-right" style="margin:10px;"><a href="../doseo/login.dom">후기 작성</a></button>
	</c:if>

	<c:if test="${AUTHUSER.id == reviewData.review.writer.id}">
		<button class="btn btn-outline-primary float-right" style="margin:10px;"><a href="reviewdelete.dom?no=${reviewData.review.number}">후기 삭제</a></button>
		<button class="btn btn-outline-primary float-right" style="margin:10px;"><a href="reviewmodify.dom?no=${reviewData.review.number}">후기 수정</a></button>
	</c:if>
	<c:if test="${!empty AUTHUSER2}">
		<button class="btn btn-outline-primary float-right" style="margin:10px;"><a href="reviewdelete.dom?no=${reviewData.review.number}">후기 삭제</a></button>
	</c:if>
</div>

<table class="table table-hover">
	<thead>
				<tr style="background-color: lightgrey">
					<th style="text-align:left;">조회수 : ${reviewData.review.readCount}</th>
					<th colspan="3"></th>			
					<th style="text-align:right;">평점 : ${reviewData.review.rating}</th>
				</tr>
				<tr style="background-color: lightgrey">
					<th style="text-align:left;">작성자 : ${reviewData.review.writer.name}</th>
					<th style="text-align:right;" colspan="3">제목 : <c:out value='${reviewData.review.title}' /></th>	
					<th style="text-align:right;">작성일 : ${reviewData.review.regDate}</th>		
				</tr>
	</thead>
	<tbody>
				<tr>
					<td colspan="5" style="text-align:center;"><u:pre value='${reviewData.content}'/></td>
				</tr>
	</tbody>
</table>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<jsp:include page="../../footer.jsp"/>
</body>
</html>