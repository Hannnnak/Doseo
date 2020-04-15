<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<style type="text/css">
	.d1 { /* 비회원일 경우 뜨는 로그인 안내 */
	background-color: #dad9d9;
	border: 1px solid #aaaaaa;
	padding-top: 17px;
	padding-right: 0px;
	padding-bottom: 17px;
	padding-left: 70px;
	margin-right: 30px;
	margin-left: 30px;
	}
	
	.d2 { /* 결제목록 */
	margin-top: 20px;
	text-align: center;
	}
	
	.ctitle { /* 장바구니 로고 */
	margin-left: 30px;
	margin-right: 30px;
	}
	
</style>
</head>
<body>
	<form action="#">
		<div class="ctitle">
			<h1>장바구니</h1>
			<hr border="3" color="black">
		</div>
		<div class="d1">
			비회원으로 구매하시면 Doseo에서 드리는 모든 할인/쿠폰과 이벤트 등의 혜택을 받으실 수 없습니다.(할인모음가 금액으로 구매불가) 또한 비회원 주문 시에는 적립금이 지급되지 않습니다.
			<br>
			혜택을 받으시려면, Doseo ID/PW로 로그인 또는 회원가입해주세요.<br>
			<input type="button" value="로그인">
			<input type="button" value="회원가입">
		</div>
		<div class="d2">
			결제목록
		</div>
		<a href="bill.jsp">결제 페이지로 이동</a>
		
		</table>
	
	</form>
</body>
</html>