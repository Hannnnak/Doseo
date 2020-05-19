<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="./index.jsp">HOME</a>
	<hr/>
	<h3>deleteForm.jsp</h3>
	<p>http://localhost/doseo/delete.dom</p>
	
	<form name="deleteFrm" id="deleteFrm" 
			  action="delete.dom" method="POST">
		<p>
		*아이디 : <br/>
		${member.id}<input type="hidden" name="id" value="${member.id}"/>
		</p>
		<p>
		*암 호 : <br/>
		<input type="password" name="password"/>
		<c:if test="${errors.password}">암호를 입력하세요</c:if>
		</p>
		<input type="submit" value="탈퇴하기" />
		<input type="reset"  value="취소" />
	</form>
</body>
</html>