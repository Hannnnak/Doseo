<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문목록</title>
<jsp:include page="header.jsp"/>
<style type="text/css">
	.orderList {
	text-align: center;
	}
	body {
	padding-left : 20px;
	padding-right: 20px;
	}
</style>
</head>
<body>
<div class="orderList">
	<div>
		<h2>주문 내역</h2>
<hr>
<c:forEach var="order" items="${ orders }">
    <table class="table">
        <thead class="thead-light">
        <tr>
          <th>#</th>
          <th>도서명</th>
          <th>가격</th>
          <th>수량</th>
          <th>합계</th>
          <th>주문현황</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="item" items="${ order.items }" varStatus="status">
                <tr>
                <th>${ status.count }</th>
                <td>${ item.title }</td>
                <td>${ item.price }</td>
                <td>${ item.amount }</td>
                <td>${ item.price * item.amount }</td>
                <td><a href="tracker.jsp" target="_blank"><input type="button" value="배송조회"></a></td>
            </tr>       
        </c:forEach>
      </tbody>
      <tfoot>
        <tr>
            <td colspan="5"></td>
            <td>${ order.totalPrice }</td>
        </tr>
      </tfoot>
    </table>
</c:forEach>
		<input type="button" value="리뷰작성">
		<input type="button" value="상품 재구매">
		<input type="button" value="판매자문의">
	</div>
</div>
</body>
<jsp:include page="footer.jsp"/>
</html>