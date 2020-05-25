<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
<%-- <jsp:include page="subMenu.jsp"/> --%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style type="text/css">
	body {
		margin: 20px 20px 0 20px;
	}
</style>
</head>
<body>
<div>
	<a href="http://localhost/doseo/view_admin/adminForm.jsp">홈</a>
	&nbsp;|&nbsp;
	<a onclick="history.back()">이전 페이지</a>
</div>
<br>
<input type="button" onClick="location.href='/doseo/admin_product/write.dom'" value="상품추가">
<form name="search" action="search.dom" method="post">
	 <SELECT name='col'> 
     <OPTION value='pName'>도서명</OPTION>
     <OPTION value='writer'>작가</OPTION>
     <OPTION value='category'>분야</OPTION>
   </SELECT>
	 <input type='text' name='word' placeholder="특수문자는 사용할수 없습니다.">
   <button type='submit'>검색</button>    
</form>
<table class="table table-hover">
	<tr>
		<th width="70">상품번호</th>
		<th width="100">분야</th>
		<th width="200">상품명</th>
		<th width="100">작가</th>
		<th width="50">가격</th>
	</tr>


	<c:forEach var="product" items="${productPage.content}">
		<tr>
		<td width="70">${product.pNo}</td>
		<td width="100">${product.category}</td>
		<td width="200"><a href="read.dom?pNo=${product.pNo}&pageNo=${productPage.currentPage}">${product.pName}</a></td>
		<td width="100">${product.writer}</td>
		<td width="50">${product.pPrice}</td>
		</tr>
	</c:forEach>

	<c:if test="${productPage.hasNoProducts()}">
		<tr>
			<td colspan="5">등록된 상품이 없습니다. </td>
		</tr>
	</c:if>

		<%-- 페이징 처리--%>
	<c:if test="${productPage.total>0 }">
		<tr>
			<th colspan="5">
			
			<!-- 검색조건이 없을 때는 페이지 넘버만 파라미터로 보내기 -->
			<c:if test="${null eq word}">
				<%-- [이전prev]출력 --%>
				<c:if test="${productPage.currentPage>5}">
				<a href="list.dom?pageNo=${productPage.startPage-5}">[이전]</a>
				</c:if>
				
				<%-- 페이지출력 [이전] [1] [2] [3] [4] [5] --%>
				<c:forEach var="pNum" 
				           begin="${productPage.startPage}" 
				           end="${productPage.endPage}">
				<a href="list.dom?pageNo=${pNum}">[${pNum}]</a>
				</c:forEach>
				
				<%-- [다음next]출력 --%>
				<c:if test="${productPage.endPage<productPage.totalPages}">
				<a href="list.dom?pageNo=${productPage.startPage+5}">[다음]</a>
				</c:if>
			</c:if>
			
			
			<!-- 검색조건이 있을 때는 페이지 넘버와 검색조건도 파라미터로 보내기 -->
			<c:if test="${null ne word }">
				<%-- [이전prev]출력 --%>
				<c:if test="${productPage.currentPage>5}">
				<a href="list.dom?pageNo=${productPage.startPage-5}">[이전]</a>
				</c:if>
				
				<%-- 페이지출력 [이전] [1] [2] [3] [4] [5] --%>
				<c:forEach var="pNum" 
				           begin="${productPage.startPage}" 
				           end="${productPage.endPage}">
				<a href="list.dom?pageNo=${pNum}">[${pNum}]</a>
				</c:forEach>
				
				<%-- [다음next]출력 --%>
				<c:if test="${productPage.endPage<productPage.totalPages}">
				<a href="list.dom?pageNo=${productPage.startPage+5}">[다음]</a>
				</c:if>
			</c:if>	
		</th>
	</tr>	
</c:if>


</table>



</body>
</html>