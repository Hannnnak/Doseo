<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<jsp:include page="../../header.jsp"/>
</head>
<body>
<div class="row justify-content-center">
		<h3 style="text-aling:center;">공지사항을 삭제했습니다.</h3>
</div><br>

<div class="row justify-content-center">
	<a href="qnalist.dom?pageqNo=${pageNo}" class="btn btn-outline-primary" style="margin:3px">공지사항 목록</a>
</div>
<jsp:include page="../../footer.jsp"/>
</body>
</html>