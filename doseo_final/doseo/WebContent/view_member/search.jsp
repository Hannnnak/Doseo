<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../header.jsp"/>
</head>
<body>
<h3>검색 결과 리스트</h3>
<table class="table table-striped">
<c:forEach var="product" items="${product}"> 
<tr>
	<td>
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
			</div>
			<div>
				<span name="price">가격</span>
				<span name="price">${product.pPrice}</span>
			</div>
		</div>
	</td>	
<tr>		
</c:forEach>	
</table>
</body>
<jsp:include page="../footer.jsp"/>
</html>