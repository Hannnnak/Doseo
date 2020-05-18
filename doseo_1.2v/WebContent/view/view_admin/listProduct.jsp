<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품목록</title>
</head>
<body>
<input type="button" onClick="location.href='/doseo/admin_product/write.dom'" value="상품추가">
<table border="1">
	<tr>
		<td width="70">상품번호</td>
		<td width="100">분야</td>
		<td width="200">상품명</td>
		<td width="100">작가</td>
		<td width="50">가격</td>
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



</table>



</body>
</html>