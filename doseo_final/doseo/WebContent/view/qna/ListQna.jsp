<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../header.jsp"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style>
	li {
	   list-style: none;
   }
   
   body {
		margin: 0 20px 0 20px;
	}
</style>
</head>
<body>
<table class="table table-hover">
	<thead>
		<c:if test="${! empty AUTHUSER2}">
		<tr>
			<th colspan="4" style="text-align:right;"><a href="qnawrite.dom" class="btn btn-outline-primary">글쓰기</a></th>
		</tr>
		</c:if>
		<tr style="background-color: lightgrey">
			<th style="text-align:center;" colspan="4" >공지사항 목록</th>
		</tr>
		<tr>
			<th width="50">번호</th>
			<th width="250">제목</th>
			<th width="150">작성자</th>
			<th width="70">조회수</th>
		</tr>
		<c:if test="${qnaPage.hasNoQnas()} ">
			<tr>
				<th colspan="4">게시글이 존재하지 않습니다.</th>
			</tr>
		</c:if> 
	</thead>
	<tbody>
		<c:forEach  var="qna" items="${qnaPage.qContents}">
			<tr>
			  <%-- ${aritcle.number}은 Article클래스의 getNumber()메소드를 호출 --%>
				<td width="50">${qna.qNo} </td>
				<td width="250"><a href="qnaread.dom?qNo=${qna.qNo}&pageNo=${qnaPage.currentPage}" style="text-decoration:none; color:black">${qna.qTitle}</a></td>
				<td width="150">${qna.writer.memberID}</td>
				<td width="50">${qna.readCount}</td>
		</tr>
		</c:forEach> 
	</tbody>
</table>
<table style="margin-left: auto; margin-right: auto;">
	<c:if test="${qnaPage.hasQnas() }">
		<tr> 
			<th colspan="5">
				<%-- [이전prev]출력 --%>
				<c:if test="${qnaPage.startPage>5}">
				<li class="page-item"><a href="qnalist.dom?pageNo=${qnaPage.startPage-5}" class="page-link">이전</a></li>
				</c:if>
				
				<%-- 페이지출력 [이전] [1] [2] [3] [4] [5] --%>
				<c:forEach var="pNo" 
				           begin="${qnaPage.startPage}" 
				           end="${qnaPage.endPage}">
				<li class="page-item"><a href="qnalist.dom?pageNo=${pNo}" class="page-link">${pNo}</a></li>
				</c:forEach>
				
				<%-- [다음next]출력 --%>
				<c:if test="${qnaPage.endPage<qnaPage.totalPages}">
				<li class="page-item"><a href="qnalist.dom?pageNo=${qnaPage.startPage+5}" class="page-link">다음</a></li>
				</c:if>
			</th>
		</tr>
	</c:if>	
</table>
	<jsp:include page="../../footer.jsp"/>
</body>
</html> 		







