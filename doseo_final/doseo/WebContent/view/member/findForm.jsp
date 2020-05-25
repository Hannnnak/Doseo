<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<jsp:include page="../../header.jsp"/>
<style type="text/css">
	.formContent {
		text-align: center;
	}
	body {
	margin: 0 20px 0 20px;
}
</style>
</head>
<body>
	<form name="findForm" id="findForm" action="find.dom" method="POST">
	<table class="table table-hover">
	<thead>
		<tr style="background-color: lightgrey">
			<th style="text-align:center;">아이디 찾기</th>
		</tr>
		<tr>
		<c:if test="${errors.idOrPwNotMatch}">
				이름 또는 이메일이 일치하지 않습니다</c:if>
		</tr>
	</thead>
	
	<tbody>
	<tr>
	<td style="text-align:center;">
	<label for="inputName" class="col-lg-2 control-label">이름</label>
				<input type="text" class="fadeIn second" name="name" id="name" value="${param.name}" />
				<c:if test="${errors.name}">이름을 입력하세요</c:if>
	</td>
	</tr>
	<tr>
		<td style="text-align:center;">
		<label for="inputEmail" class="col-lg-2 control-label">이메일</label>
				<input type="email" class="fadeIn third" name="email" id="email" value="${param.email}" />
				<c:if test="${errors.email}">이메일을 입력하세요</c:if>
		</td>
	</tr>
	</tbody>
	</table>
		<div class="row justify-content-center">
		<input type="submit" class="control-label btn btn-outline-primary" value="찾기" style="margin:3px;"/>
		<input type="button" class="control-label btn btn-outline-secondary" value="취소" onclick="history.back()" style="margin:3px;"/>
	</div>
	
	</form>
	
	<jsp:include page="../../footer.jsp"/>
</body>
</html>