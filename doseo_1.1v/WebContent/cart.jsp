<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>장바구니</title>
<jsp:include page="header.jsp"/>
<meta charset="UTF-8">
<style type="text/css">
	.d1 { /* 비회원일 경우 뜨는 로그인 안내 */
		background-color: #dad9d9;
		border: 1px solid #aaaaaa;
		padding-top: 17px;
		padding-right: 30px;
		padding-bottom: 17px;
		padding-left: 35px;
		margin-right: 40px;
		margin-left: 40px;
	}
	
	.d2 { /* 결제목록 */
		margin-top: 20px;
		text-align: center;
	}
	
	body {
		margin-right: 20px;
		margin-left: 20px;
	}
	
	.btn1 {
		text-align: center;
	}
	
	.order {
		color: red;
	}
	
	.recommend {
		margin-left: 30px;
		margin-right: 30px;
	}
	
	h4 {
		text-align: center;
		color: red;
	}
	
</style>
</head>
<body>
	<!-- 비회원 전용 화면 -->			
	<c:if test="${ empty sessionScope.memberID }">
		<div class="d1">
			비회원으로 구매하시면 Doseo에서 드리는 모든 할인/쿠폰과 이벤트 등의 혜택을 받으실 수 없습니다. (할인모음가 금액으로 구매불가) 또한 비회원 주문 시에는 적립금이 지급되지 않습니다.
			<br>
			혜택을 받으시려면, Doseo ID/PW로 로그인 또는 회원가입해주세요.<br>
			<input type="button" value="로그인">
			<input type="button" value="회원가입">
		</div>
		<br>
	</c:if>
	<c:choose>
	<c:when test= "${ empty sessionScope.quantity }">
		<script>
			alert('장바구니에 담긴 도서가 없습니다');
			history.back;
		</script>
	</c:when>
	<c:otherwise>
	<form name="form1" id="form1" method="post" action="">
		<table class="table" id="cart">
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
				<c:forEach var="product" items="${ product }" varStatus="status">
					<tr>
						<th>${ status.count }</th>
						<td>${ product.title }</td>
						<td>${ product.price }</td>
						<td>${ product.dPrice}</td>
						<td>${ product.quantity}</td>
						<td>${ product.price * product.quantity }</td>
					</tr>
				</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4"></td>
						<td>${ cart.totalPrice }</td>
					</tr>
				</tfoot>
				<c:if test= "${ not empty sessionScope.quantity }">
					<div align="center">
						<input type="button" value="주문하기" class="btn btn-primary" onclick="location.href='order.jsp'">
					</div>
				</c:if>
		</table>
	</form>
	</c:otherwise>
	</c:choose>
</body>
<jsp:include page="footer.jsp"/>
</html>