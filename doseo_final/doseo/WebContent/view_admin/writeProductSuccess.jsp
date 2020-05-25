<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품등록 성공</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style type="text/css">
	#alert {
		margin: 200px 500px 0 500px;
		text-align: center;
		line-height: 100px;	
	}
	
	#atags {
		margin: 10px 0 0 20px;
	}
</style>
</head>
<body>
<div id="atags">
	<a href="http://localhost/doseo/view_admin/adminForm.jsp">홈</a>
	&nbsp;|&nbsp;
	<a onclick="history.back()">이전 페이지</a>
	&nbsp;|&nbsp;
	<a href="./write.dom">책 더 등록하기</a>
	&nbsp;|&nbsp;
	<a href="./list.dom">목록으로</a>
</div>
<h2 id="alert">
상품이 정상적으로 등록되었습니다.
</h2>
</body>
</html>