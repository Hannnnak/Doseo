<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글수정 성공</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style type="text/css">
	#atags {
		margin: 10px 0 0 20px;
	}
	
	#alert {
		margin: 200px 500px 0 500px;
		text-align: center;
		line-height: 100px;	
	}
</style>
</head>
<body>
<div id="atags">
	<a href="http://localhost/doseo/view_admin/adminForm.jsp">홈</a>
	&nbsp;|&nbsp;
	<a onclick="history.back()">이전 페이지</a>
	&nbsp;|&nbsp;
	<a href="${ctxPath}/admin_product/list.dom">게시글목록 보기</a>
	&nbsp;|&nbsp;
	<a href="${ctxPath}/admin_product/read.dom?pNo=${product.pNo}">게시글상세 보기</a>
</div>
<hr/>
<h2 id="alert">
	게시글이 수정되었습니다!
</h2>
<br/>
	 <%-- ${ctxPath= pageContext.request.contextPath} --%>
</body>
</html>