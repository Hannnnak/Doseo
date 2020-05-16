<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 수정</title>
</head>
<body>
<a href="../index.jsp">HOME</a>
<hr>
게시글을 수정했습니다.
<br>

<a href="${pageContext.request.contextPath}/review/list.do">[게시글목록보기]</a>
<a href="${pageContext.request.contextPath}/review/read.do?no=${modReq.reviewNumber}">[게시글내용보기]</a>
</body>
</html>