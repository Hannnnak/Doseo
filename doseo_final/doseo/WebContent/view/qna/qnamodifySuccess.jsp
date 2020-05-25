<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 수정</title>
</head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<jsp:include page="../../header.jsp"/>
<body>
	<div class="row justify-content-center">
		<h3 style="text-aling:center;">공지사항을 수정했습니다.</h3>
	</div><br>
	<div class="row justify-content-center">
		<a href="${pageContext.request.contextPath}/qnalist.dom" class="btn btn-outline-primary" style="margin:3px">공지사항 목록</a>
		<a href="${pageContext.request.contextPath}/qnaread.dom?qNo=${modReq.qNo}" class="btn btn-outline-primary" style="margin:3px">공지사항 보기</a>
	</div>
<jsp:include page="../../footer.jsp"/>
</body>
</html>