<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리리스트</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<jsp:include page="../header.jsp"/>
<style type="text/css">
	.row {
		margin: 0 10px 0 10px;
	}
	
	li {
	   list-style: none;
   }
   
   body {
		margin: 0 20px 0 20px; 
   }
</style>
</head>
<body>
<h3 style="text-align: center;">카테고리별 리스트</h3>
<body>
<!-- <form action="search.dom">
	<input  type="text" placeholder="Search..." name="search">
	<button type='submit'>검색</button> 
</form> -->
<table style="margin: auto;">
		<tr>
	<c:forEach var="product" items="${product}"> 
			<td>
				<div class="row">
					<div name="img">
						<div name="list_img">
							  <c:set var="str" value="${product.imageFileURL}"/>
         
				               <c:if test="${fn:contains(str, 'image.aladin.co.kr')}">
				                  <img src="${product.imageFileURL}" >
				               </c:if>
				               
				               <c:if test="${!fn:contains(str, 'image.aladin.co.kr')}">
				                  <img src="/doseo/product_images/${product.imageFileURL}" >
				               </c:if> 
						</div>
					</div>
					<div name="infos">
						<h3 class="name">
							<a href="read.dom?pNo=${product.pNo}&pageNo=${productPage.currentPage}">${product.pName}</a>
						</h3>
						<div>
							<span name="price">가격</span>
							<span name="price">${product.pPrice}</span>
						</div>
					</div>
				</div>	
			</td>	
	</c:forEach>
		<tr>		
</table>
<br>
<table style="margin-left: auto; margin-right: auto;">
			<%-- 페이징 처리--%>
	<c:if test="${productPage.hasProducts() }">
		<tr>
			<th colspan="5">
				<%-- [이전prev]출력 --%>
				<c:if test="${productPage.startPage>5}">
				<li class="page-item"><a href="list.dom?pageNo=${productPage.startPage-5}" class="page-link">이전</a></li>
				</c:if>
				
				<%-- 페이지출력 [이전] [1] [2] [3] [4] [5] --%>
				<c:forEach var="pNum" 
				           begin="${productPage.startPage}" 
				           end="${productPage.endPage}">
				<li class="page-item"><a href="list.dom?pageNo=${pNum}" class="page-link">${pNum}</a></li>
				</c:forEach>
				
				<%-- [다음next]출력 --%>
				<c:if test="${productPage.endPage<productPage.totalPages}">
				<li class="page-item"><a href="list.dom?pageNo=${productPage.startPage+5}" class="page-link">다음</a></li>
				</c:if>
			</th>
		</tr>
	</c:if>
</table>
<jsp:include page="../footer.jsp"/>
</body>
</html>