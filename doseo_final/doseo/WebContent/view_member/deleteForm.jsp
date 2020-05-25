<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
<jsp:include page="../header.jsp"/>
</head>
<body>
	<form name="deleteFrm" id="deleteFrm" action="delete.dom" method="POST">
		<div>
			<label for="inputID" class="col-lg-2 control-label">아이디</label>
			${member.id}
			<input type="hidden" name="id" value="${member.id}"/>
		</div>
		<div>
			<label for="inputPw" class="col-lg-2 control-label">암호</label>
			<input type="password" name="password"/>
			<c:if test="${errors.password}">암호를 입력하세요</c:if>
		</div>
		<div>
			<input type="submit" class="btn btn-danger" value="탈퇴하기" />
			<input type="reset" class="btn btn-secondary" value="취소" onclick="history.back()" />
		</div>
	</form>
</body>
</html>