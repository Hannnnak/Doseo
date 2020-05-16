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
	<a href="../index.jsp">HOME</a>
	<hr/>
	<h3>글수정 폼 modifyForm.jsp(p674)</h3>
	<p>http://localhost/board/article/modify.do</p>
	
	<%--request.setAttribute("modiREQ", modiReq); --%>
	
	<form name="modifyFrm" id="modifyFrm" 
				method="POST" action="modify.do">
		<p>
		 글번호 : ${modiREQ.articleNumber}<br/>
		 <input type="hidden" name="no" 
		  value="${modiREQ.articleNumber}"/>
		</p>		
		<p>
			제목 : <br/>
			<input type="text" name="title" required="required"
			       value="${modiREQ.title}"/>
			<c:if test="${errors.title}">제목을 입력하세요</c:if>
		</p>
		<p>
			내용 : <br/>
			<textarea name="content" rows="5" cols="30"  required="required">
			${modiREQ.content}
			</textarea>
		</p>
		<input type="submit" value="글수정"/>
		<input type="reset"  value="취소" />
	</form>
</body>
</html>













