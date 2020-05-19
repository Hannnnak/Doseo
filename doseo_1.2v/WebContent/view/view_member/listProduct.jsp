<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="header.jsp"/>
</head>
<body>
<table border="1">
<c:forEach var="product" items="${productPage.content}"> 
<tr>
	<td>
			<div name="img">
				<div name="list_img">
					<img src="${product.imageFileURL}" >
					src="${product.imageFileURL}"웹주소로 된 것은 올라감
				</div>
			</div>
			<div name="infos">
					<h3 class="name">
					<a href="read.dom?pNo=${product.pNo}&pageNo=${productPage.currentPage}">${product.pName}</a>
					</h3>
				<div>
				</div>
				<div>
					<span name="price">가격</span>
					<span	name="price">${product.pPrice}</span>
				</div>
			</div>
	</td>	
<tr>		
</c:forEach>	
</table>

		<%-- 페이징 처리--%>
	<c:if test="${productPage.hasProducts() }">
		<tr>
			<th colspan="5">
				<%-- [이전prev]출력 --%>
				<c:if test="${productPage.startPage>5}">
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
			</th>
		</tr>
	</c:if>



</body>
</html>