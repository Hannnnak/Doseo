<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 삭제 성공</title>
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
	<a href="list.dom?pageNo=${pageNo}">목록으로 돌아가기</a>
</div>
<hr>
<h2 id="alert">
	상품이 삭제되었습니다. 
</h2>

<c:set var="pageNo" value="${empty param.pageNo?'1':param.pageNo}"/>

			
</body>
</html>