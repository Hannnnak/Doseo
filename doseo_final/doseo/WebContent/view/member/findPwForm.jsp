<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<jsp:include page="../../header.jsp"/>
</head>
<style>
body {
	margin: 0 20px 0 20px;
}
</style>
<body>
<form name="findFormPw" id="findFormPw" action="findPw.dom" method="POST">
<table class="table table-hover">
	<thead>
		<tr style="background-color: lightgrey">
			<th style="text-align:center;">비밀번호 찾기</th>
		</tr>
		<tr>
	  	<c:if test="${errors.idOrPwNotMatch}">이름, 이메일 또는 아이디가 일치하지 않습니다</c:if>
		</tr>
	</thead>
	
	<tbody>
		<tr>
			<td style="text-align:center;">
				<label for="inputName" class="col-lg-2 control-label">이름</label>
		<input type="text" name="name" id="name" value="${param.name}" />
		<c:if test="${errors.name}">이름을 입력하세요</c:if>
		</p>
			</td>
		</tr>
		<tr>
			<td style="text-align:center;">
<label for="inputEmail" class="col-lg-2 control-label">이메일</label>
		<input type="email" name="email" id="email" value="${param.email}" />
		<c:if test="${errors.email}">메일을 입력하세요</c:if>
			</td>
		</tr>
		<tr>
			<td style="text-align:center;">
				<label for="inputId" class="col-lg-2 control-label">아이디</label>
		<input type="id" name="id" id="id" value="${param.id}" />
		<c:if test="${errors.id}">아이디를 입력하세요</c:if>
			</td>
		</tr>

	</tbody>
</table>
	<div class="row justify-content-center">
		<input type="submit" value="찾기" class="btn btn-outline-primary" style="margin:3px;"/>	  
		<input type="reset"  value="취소" class="btn btn-outline-secondary" style="margin:3px;" onclick="history.back()" />
	</div>
</form>
<jsp:include page="../../footer.jsp"/>
</body>
</html>













