<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글 등록</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap.css">
<jsp:include page="../../header.jsp"/>
</head>
<style>
body {
	margin: 0 20px 0 20px;
}
</style>
<body>
<div class="row justify-content-center">
게시글을 등록했습니다.
</div>
<br>
<div class="row justify-content-center">
<a href="${pageContext.request.contextPath}/reviewlist.dom"  class="btn btn-outline-primary btn-lg" style="margin:10px;">게시글목록보기</a>
<a href="${pageContext.request.contextPath}/reviewread.dom?no=${newReviewNo}"  class="btn btn-outline-primary btn-lg" style="margin:10px;">게시글내용보기</a>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<jsp:include page="../../footer.jsp"/>
</body>
</html>