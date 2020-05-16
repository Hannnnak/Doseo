<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="../index.jsp">HOME</a>
	<hr/>
	<h3>modifySuccess.jsp(p674)</h3>
	<p>http://localhost/board/article/modify.do</p>
	<h3>축하합니다~~~ 수정에 성공하셨습니다</h3>
	
	<%--articleNumber;	//게시글번호
	private String userId;	//사용자id
	private String title;//제목
	private String content;//내용
		request.setAttribute("modiREQ", modiReq);
	 --%>
	 ${ctxPath= pageContext.request.contextPath}
	 <a href="${ctxPath}/article/list.do">게시글목록 보기</a>
	 <a href="${ctxPath}/article/read.do?no=${modiREQ.articleNumber}">게시글상세 보기</a>
</body>
</html>














