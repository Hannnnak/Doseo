<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문결제</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<jsp:include page="../header.jsp"/>
<style type="text/css">
	body {
		margin-left: 20px;
		margin-right: 20px;
    }

	li {
		float: left; 
		list-style: none; 
		margin: 2px;
	}	
	
	li a {
		width: 150px;
		text-align: center;
		color: black;
		display: inline; 
		border: 1px solid #bcbcbc;
		font-size: 12px; 
		font-family: "돋움";
		text-align:center;
		padding: 10px 10px 10px 10px; 
		text-decoration: none;		
	}
	
	li a:hover {
		background-color: blue; 
		text-decoration: none;
	}
	
	.addressList {
		float: right;
	}
	
	.btn1 {
		text-align: center;
		float: center;
		margin-top: 10px;
	}
	
	#container { 
		padding: 5px 20px 5px 20px; 
	 	font-size: 15px; 
	 	font-weight: bold; 
	 	display: inline-block; 
	 	width: 90px; 
	 	margin-right: 10px; 
 	}
</style>
</head>
<body>
	<h3 style="text-align: center; margin-top: -15px; margin-bottom: 5px;">주문상품</h3>
	<div>
		<table class="table table-striped">
			<thead class="thead-light">
				<tr>
					<th>#</th>
					<th>도서명</th>
					<th>정가</th>
					<th>할인가</th>
					<th>수량</th>
					<th>합계</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="sum" value="0"/>
				<c:forEach var="product" items="${ cartList }" varStatus="status">
					<tr>
						<c:set var="total" value="${ sum = sum + (product.dPrice * product.quantity) }"/>
						<th>${ status.count }</th>
						<td>${ product.pName }</td>
						<td><fmt:formatNumber pattern="###,###,###" value="${ product.price }"/>원</td>
						<td><fmt:formatNumber pattern="###,###,###" value="${ product.dPrice}"/>원</td>
						<td>${ product.quantity}권</td>
						<td><fmt:formatNumber pattern="###,###,###" value="${ product.dPrice * product.quantity }"/>원</td>
						<c:set var="number" value="${status.count -1 }"/>
					</tr>
				</c:forEach>
			</tbody>
			<c:if test="${number == 0}">
				<c:set var="orderBook" value="${cartList[0].pName }"/>
			</c:if>
			<c:if test="${number != 0}">
				<c:set var="orderBook" value="${cartList[0].pName }외${number}건"/>
			</c:if>		
		</table>
	</div>
	<hr style="height: 3px; background-color: black;">
	<h3 style="text-align: center;">주문자 정보</h3>
	<div id="container" style="width: 900px;">
		<p><span class="col-lg-2 control-label">주문자</span>${ name }</p>
		<p><span class="col-lg-2 control-label">연락처</span>${ phone }</p>
		<p><span class="col-lg-2 control-label">주소</span>${ addressList[0].wAddress }</p>
		<p><span class="col-lg-2 control-label">가격</span><fmt:formatNumber pattern="###,###,###" value="${ sum }"/> 원</p> 
	</div>
	<form name="form" id="form" method="post" action="<%= request.getContextPath()%>/paymentSuccess.dom">
		<input type="text" placeholder="배송 요구사항을 기입해주세요" name="request" class="form-control" style="width: 350px; height: 200px; margin-left: 35px;">
		<div class="btn1">
			<input type="hidden" name="orderBook" value="${ orderBook }"/>
			<input type="hidden" name="sum" value="${ sum }"/>
			<input type="hidden" name="addressList" value="${ addressList[0].wAddress }"/>
			<input type="submit" class="btn btn-warning" value="결제하기"/>
		</div>
	</form>
	<br>
</body>
<jsp:include page="../footer.jsp"/>
</html>