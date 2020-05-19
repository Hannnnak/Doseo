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
	
	<a href="../index.jsp">HOME</a>
	<hr/>
	<h3>게시글 목록 -listAricle.jsp(p653)</h3>
	<p>http://localhost/board/article/list.dom</p>
	
		<%--
		   ArticlePage타입의  articlePage참조변수;
		   request.setAttribute("articlePAPE", articlePage);
		    모델이 넘어왔다 --%>
	articlePAPE=${articlePAPE}	    
	 <hr/>	    
	*총게시물수 : ${articlePAPE.total}건 <br/>
	 현재페이지 : ${articlePAPE.currentPage}/ 총페이지수:${articlePAPE.totalPages}<p/>
	<table border="1" width="500">
	<%-- 기타기능 : 글쓰기  p653 11--%>
		<tr>
			<th colspan="4"><a href="write.dom">[글쓰기]</a></th>
		</tr>
	<%-- 게시글목록 출력부분 p653 14--%>
		<tr>
			<th width="50">번호</th>
			<th width="250">제목</th>
			<th width="150">작성자</th>
			<th width="50">조회수</th>
		</tr>
		<c:if test="${articlePAPE.hasNoArticles()} ">
			<tr>
				<th colspan="4">게시글이 존재하지 않습니다.</th>
			</tr>
		</c:if>    
		    
		<c:forEach  var="aritcle" items="${articlePAPE.content}">
			<tr>
			  <%-- ${aritcle.number}은 Article클래스의 getNumber()메소드를 호출 --%>
				<td width="50">${aritcle.number} </td>
				<td width="250"><a href="read.dom?no=${aritcle.number}&pageNo=${articlePAPE.currentPage}">${aritcle.title}</a></td>
				<td width="150">${aritcle.writer.name}</td>
				<td width="50">${aritcle.readCount}</td>
		</tr>
		</c:forEach> 
	<%-- 페이징 부분  p653 37--%>
	<c:if test="${articlePAPE.hasArticles() }">
		<tr>
			<th colspan="4">
				<%-- [이전prev]출력 --%>
				<c:if test="${articlePAPE.startPage>5}">
				<a href="list.dom?pageNo=${articlePAPE.startPage-5}">[이전]</a>
				</c:if>
				
				<%-- 페이지출력 [이전] [1] [2] [3] [4] [5] --%>
				<c:forEach var="pNo" 
				           begin="${articlePAPE.startPage}" 
				           end="${articlePAPE.endPage}">
				<a href="list.dom?pageNo=${pNo}">[${pNo}]</a>
				</c:forEach>
				
				<%-- [다음next]출력 --%>
				<c:if test="${articlePAPE.endPage<articlePAPE.totalPages}">
				<a href="list.dom?pageNo=${articlePAPE.startPage+5}">[다음]</a>
				</c:if>
			</th>
		</tr>
	</c:if>
	</table>
</body>
</html>










