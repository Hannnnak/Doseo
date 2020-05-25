<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
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
<table class="table table-hover">
	<thead>
	<tr style="background-color: lightgrey">
		<th style="text-align:center;" colspan="4">공지사항 상세보기</th>
		</tr>
		<tr>
			<th>번호</th>
			<td>${qnaData.qna.qNo}</td>		
		</tr>	
		<tr>
			<th>작성자</th>
			<td>${qnaData.qna.writer.memberID}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${qnaData.qna.qTitle}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${qnaData.qna.qContents} </td>
		</tr>
	</thead>
	<tbody>
				<tr>
				<td colspan="4" style="text-align:center;">
						<c:set var="pageNo" value="${empty param.pageNo?'1':param.pageNo}"/>
							<a href="qnalist.dom?pageNo=${pageNo}" class="btn btn-outline-primary">목록</a>
						<c:if test="${! empty AUTHUSER2}">
							<a href="qnamodify.dom?qNo=${qnaData.qna.qNo}" class="btn btn-outline-primary">수정</a>
							<a href="qnadelete.dom?qNo=${qnaData.qna.qNo}" class="btn btn-outline-primary">삭제</a>
						</c:if>
				</td>
			</tr>
	</tbody>
</table>
<jsp:include page="../../footer.jsp"/>
</body>
</html>









