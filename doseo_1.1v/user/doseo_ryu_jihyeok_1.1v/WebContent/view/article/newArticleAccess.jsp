<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	//WriteArticleHandler에서
	//db에 insert성공시의  해당글번호가 newArticleNo에 넣어주고
	//아래코드에서 모델로 넘겨주었다
	//request.setAttribute("NEWARTICLENO", newArticleNo);
	%>
	
	<a href="../index.jsp">HOME</a>
	<hr/>
	<h3>newArticleAccess.jsp(p643)</h3>
	<p>http://localhost/board/article/write.do</p>
	${ctxPath = pageContext.request.contextPath}
	<h4>ㅊㅋㅊㅋ  글등록 성공!!</h4>
	<a href="${ctxPath}/article/list.do">글 목록보기</a>
	<a href="${ctxPath}/article/read.do?no=${NEWARTICLENO}">(입력된)글 상세내용 조회</a>
	
</body>
</html>






