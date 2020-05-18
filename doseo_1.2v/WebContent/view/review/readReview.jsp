<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<title>후기 상세보기</title>
<link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
<a href="../index.jsp">HOME</a>
<hr>
<div>
	<c:if test="${authUser.id == reviewData.review.writer.id}">
		<button class="btn btn-warning float-left" style="margin:10px;"><a href="list.do">목록</a></button>
		<button class="btn btn-warning float-right" style="margin:10px;"><a href="#">후기 삭제</a></button>
		<button class="btn btn-warning float-right" style="margin:10px;"><a href="modify.do?no=${reviewData.review.number}">후기 수정</a></button>
	</c:if>
</div>

<table class="table table-hover" width="100%">
<thead>
			<tr style="background-color: lightgrey">
				<th colspan="3">제목 : <c:out value='${reviewData.review.title}' /></th>			
				<th style="text-align:right;">작성자 : ${reviewData.review.writer.name}</th>
				<th style="text-align:right;">평점</th>
			</tr>
			<tr style="background-color: lightgrey">
				<th colspan="3"></th>			
				<th style="text-align:right;">추천수</th>
				<th style="text-align:right;">작성일</th>
			</tr>
</thead>
<tbody>
			<tr>
				<td colspan="5" style="text-align:center;"><u:pre value='${reviewData.content}'/></td>
			</tr>
			<tr>
				<td>▲이전글</td>
				<td colspan="2"><a href="#" style="color:black; text-decoration:none;">이전글 제목</a></td>
				<td style="text-align:right;">이전글 작성자</td>
				<td style="text-align:right;">2020-04-24</td>
			</tr>
			<tr>
				<td>▼다음글</td>
				<td colspan="2"><a href="#" style="color:black; text-decoration:none;">다음글 제목</a></td>
				<td style="text-align:right;">다음글 작성자</td>
				<td style="text-align:right;">2020-04-23</td>
			</tr>
</tbody>
</table>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
</body>
</html>