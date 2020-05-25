<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>암호 변경</title>
<jsp:include page="../../header.jsp"/>
</head>
<body>
	<form action="changePwd.dom" method="post">
	<p>
		<label for="inputCurPassword" class="col-lg-2 control-label">현재 암호</label>
		<br/><input type="password" name="curPwd">
		<c:if test="${errors.curPwd}">현재 암호를 입력하세요.</c:if>
		<c:if test="${errors.badCurPwd}">현재 암호가 일치하지 않습니다.</c:if>
	</p>
	<p>
		<label for="inputNewPassword" class="col-lg-2 control-label">새 암호</label>
		<br/><input type="password" name="newPwd">
		<c:if test="${errors.newPwd}">새 암호를 입력하세요.</c:if>
	</p>
	<input type="submit" value="암호 변경">
	</form>
</body>
</html>