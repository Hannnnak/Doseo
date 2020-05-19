<%@ page contentType="text/html; charset=utf-8"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<a href="./index.jsp">HOME</a>
	<hr/>
	<h3>문의글 상세보기</h3>
	<table border="1" width="100%">
		<tbody>
			<tr>
				<th width="100">번호</th>
				<td>${qnaData.qna.qNo}</td>				
			</tr>
			<tr>
				<th width="100">작성자</th>
				<td>${qnaData.qna.writer.memberID} </td>
			</tr>
			<tr>
				<th width="100">제목</th>
				<td>${qnaData.qna.qTitle}</td>
			</tr>
			<tr>
				<th width="100">내용</th>
				<td>${qnaData.qna.qContents} </td>
			</tr>
			<tr>
				<td colspan="2">
						<c:set var="pageNo" value="${empty param.pageNo?'1':param.pageNo}"/>
							<a href="qnalist.dom?pageNo=${pageNo}">[목록]</a>
							<a href="qnamodify.dom?pNo=${product.pNo}">[수정]</a>
							<a href="qnadelete.dom?pNo=${product.pNo}">[삭제]</a>
				</th>
			</tr>
		</tbody>
	</table>
</body>
</html>









