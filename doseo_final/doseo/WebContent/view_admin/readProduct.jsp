<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품상세보기</title>

<script type="text/javascript">
function deleteProductCheck(){
    if(confirm("정말 삭제하시겠습니까?")){
        return true;
    } else {
        return false;
    }
}
</script>

</head>
<body>
<form name="readFrm">
<table border="1" width="70%">
	<tr>
		<td>상품번호</td>
		<td>${product.pNo}</td>
	</tr>
	
	<tr>
		<td>분야</td>
		<td>${product.category}</td>
	</tr>
	
	<tr>
		<td>도서명</td>
		<td>${product.pName}</td>
	</tr>
	
	<tr>
		<td>작가</td>
		<td>${product.writer}</td>
	</tr>	

		<tr>
		<td>출판사</td>
		<td>${product.publishing}</td>
	</tr>
	
	<tr>
		<td>출판일</td>
		<td>${product.pDate}</td>
	</tr>
	
	<tr>
		<td>도서이미지</td>
		<td>${product.imageFileURL}</td>
	</tr>
	
	<tr>
		<td>제품상세설명</td>
		<td><u:pre value='${product.detailContent}'/></td>
	</tr>	

	<tr>
		<td colspan="2">
		<c:set var="pageNo" value="${empty param.pageNo?'1':param.pageNo}"/>
			<a href="list.dom?pageNo=${pageNo}">[목록으로 돌아가기]</a>
			<a href="modify.dom?pNo=${product.pNo}">[제품 수정하기]</a>
			<a href="delete.dom?pNo=${product.pNo}" onclick="deleteProductCheck()">[제품 삭제하기]</a> 
		</td>
	</tr>
</table>
</form>
</body>
</html>