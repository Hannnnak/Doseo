<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<jsp:include page="../../header.jsp"/>
</head>
<style>
body {
	margin: 0 20px 0 20px;
}
</style>
<body>
<form name="articleFrm" id="articleFrm" 	method="POST" action="qnawrite.dom">
	<table class="table table-hover">
		<thead>
			<tr style="background-color: lightgrey">
				<th style="text-align:center;" colspan="4">공지사항 등록</th>
			</tr>
		</thead>
			
		<tbody>
			<tr>
				<td style="text-align:center;">
					제목 : <input type="text" name="qTitle" required="required"/>
									<c:if test="">제목을 입력하세요</c:if>
				</td>
			</tr>
			<tr>
				<td style="text-align:center;">
					내용 : <textarea name="qContents" rows="5" cols="30"  required="required"></textarea>
									<c:if test="">내용을 입력하세요</c:if>
				</td>
			</tr>
		</tbody>
	</table>
<div class="row justify-content-center">
	<input type="submit" class="btn btn-outline-primary" value="글 등록" style="margin:3px"/>
	<input type="reset" class="btn btn-outline-secondary" value="취소" style="margin:3px"/>
</div>
</form>
<jsp:include page="../../footer.jsp"/>
</body>
</html>













