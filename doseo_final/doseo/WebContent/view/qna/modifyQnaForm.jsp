<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 수정</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<jsp:include page="../../header.jsp"/>
</head>
<style>
body {
	margin: 0 20px 0 20px;
}
</style>
<body>
<form action="qnamodify.dom?qNo=${modReq.qNo}" method="post">
<input type="hidden" name="no" value="${modReq.qNo}">
	<table class="table table-hover" >
		<thead>
			<tr style="background-color: lightgrey">
				<th style="text-align:center;" colspan="4">공지사항 수정</th>
			</tr>
		</thead>
			<tr>
				<td style="text-align:center;">공지사항 제목 수정 <br> <input type="text" name="qTitle" value="${modReq.qTitle}" >
					<c:if test="$[errors.qTitle]"> 제목을 입력하세요 </c:if></td>
			</tr>
		<tbody>
			<tr>
				<td style="text-align:center;">공지사항 내용 수정 <br> <textarea name="qContents" rows="5" cols="30">${modReq.qContents}</textarea></td>
			<c:if test="$[errors.qTitle]"> 제목을 입력하세요 </c:if></td>
			</tr>
		</tbody>
	</table>
	<div class="row justify-content-center">
		<input type="submit" value="글 수정" class="btn btn-outline-primary">
	</div>
</form>
<jsp:include page="../../footer.jsp"/>
</body>
</html>