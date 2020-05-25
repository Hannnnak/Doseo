<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style type="text/css">
	body {
		margin: 200px 500px 0 500px;
		text-align: center;
		line-height: 100px;	
	}
</style>
</head>
<body>
		 <input type="button" class="btn btn-outline-secondary btn-block" value="메인페이지" onclick="location.href='/doseo/main.dom'">
         <input type="button" class="btn btn-outline-secondary btn-block" value="회원리스트" onclick="location.href='/doseo/listad.dom'">
         <input type="button" class="btn btn-outline-secondary btn-block" value="상품리스트" onclick="location.href='/doseo/admin_product/list.dom'">
         <input type="button" class="btn btn-outline-secondary btn-block" value="공지사항작성" onclick="location.href='/doseo/qnawrite.dom'">
         <input type="button" class="btn btn-outline-danger btn-block" value="로그아웃" onclick="location.href='/doseo/logout.dom'">

</body>
</html>













