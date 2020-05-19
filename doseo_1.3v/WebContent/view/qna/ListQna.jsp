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
	
	<a href="./index.jsp">HOME</a>
	<hr/>
	<h3>문의글 목록</h3>
	
		<%--
		   ArticlePage타입의  articlePage참조변수;
		   request.setAttribute("articlePAPE", articlePage);
		    모델이 넘어왔다 --%>
	 <hr/>	    
	*총게시물수 : ${qnaPage.total}건 <br/>
	 현재페이지 : ${qnaPage.currentPage}/ 총페이지수:${qnaPage.totalPages}<p/>
	<table border="1" width="500">
	<%-- 기타기능 : 글쓰기  p653 11--%>
		<tr>
			<th colspan="4"><a href="qnawrite.dom">[글쓰기]</a></th>
			
		</tr>
	<%-- 게시글목록 출력부분 p653 14--%>
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
		    
		<c:forEach  var="qna" items="${qnaPage.qContents}">
			<tr>
			  <%-- ${aritcle.number}은 Article클래스의 getNumber()메소드를 호출 --%>
				<td width="50">${qna.qNo} </td>
				<td width="250"><a href="qnaread.dom?qNo=${qna.qNo}&pageNo=${qnaPage.currentPage}">${qna.qTitle}</a></td>
				<td width="150">${qna.writer.memberID}</td>
				<td width="50">${qna.readCount}</td>
		</tr>
		</c:forEach> 
	<%-- 페이징 부분  p653 37--%>
	<c:if test="${qnaPage.hasQnas() }">
		<tr>
			<th colspan="4">
				<%-- [이전prev]출력 --%>
				<c:if test="${qnaPage.startPage>5}">
				<a href="qnalist.dom?pageNo=${qnaPage.startPage-5}">[이전]</a>
				</c:if>
				
				<%-- 페이지출력 [이전] [1] [2] [3] [4] [5] --%>
				<c:forEach var="pNo" 
				           begin="${qnaPage.startPage}" 
				           end="${qnaPage.endPage}">
				<a href="qnalist.dom?pageNo=${pNo}">[${pNo}]</a>
				</c:forEach>
				
				<%-- [다음next]출력 --%>
				<c:if test="${qnaPage.endPage<qnaPage.totalPages}">
				<a href="qnalist.dom?pageNo=${qnaPage.startPage+5}">[다음]</a>
				</c:if>
			</th>
		</tr>
	</c:if>
	</table>
</body>
</html> 		







