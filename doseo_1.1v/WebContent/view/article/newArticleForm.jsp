<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="./index.jsp">HOME</a>
	<hr/>
	<h3>글등록 newArticleForm.jsp(p643)</h3>
	<p>http://localhost/board/article/write.do</p>
	
	<form name="articleFrm" id="articleFrm" 
				method="POST" action="qnawrite.do">
		<p>
			제목 : <br/>
			<input type="text" name="qTitle" required="required"/>
			<c:if test="">제목을 입력하세요</c:if>
		</p>
		<p>
			내용 : <br/>
			<textarea name="qContents" rows="5" cols="30"  required="required"></textarea>
		</p>
		<input type="submit" value="글 등록"/>
		<input type="reset"  value="취소" />
	</form>
</body>
</html>













