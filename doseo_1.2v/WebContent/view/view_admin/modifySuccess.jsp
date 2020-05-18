<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글수정성공</title>
</head>
<body>
	<a href="../index.jsp">HOME</a>
	<hr/>
게시글이 수정되었습니다!
<br/>
	 ${ctxPath= pageContext.request.contextPath}
	 <a href="${ctxPath}/admin_product/list.dom">게시글목록 보기</a>
	 <a href="${ctxPath}/admin_product/read.dom?pNo=${modReq.pNo}">게시글상세 보기</a>
</body>
</html>