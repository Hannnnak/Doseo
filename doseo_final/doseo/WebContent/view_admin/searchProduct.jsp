<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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

<table>
	<tr>
		<th width="70">상품번호</th>
		<th width="100">분야</th>
		<th width="200">상품명</th>
		<th width="100">작가</th>
		<th width="50">가격</th>
	</tr>

	<c:forEach var="product" items="${product}">
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

</table>

</body>
</html>