<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문결제</title>
<jsp:include page="header.jsp"/>
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
</style>
</head>
<body>
	<div>
		<h3>주문결제</h3>
	</div>
	<hr>
	<div>
		<p>주문자 정보</p>
		<input type="text" id="" placeholder="받는 사람"></input>
		<ul>
			<li><a href="#">배송지 목록</a></li>
		</ul>
		<br>
		<select name="ph1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="018">018</option>
			<option value="019">019</option>
		</select> - <input type="text" id="number" maxlength="4" style="width: 100px;"> - <input type="text" id="number" maxlength="4" style="width: 100px;">
		<br>
		<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기">
		<input type="text" id="sample4_postcode" placeholder="우편번호"><br>
		<input type="text" id="sample4_roadAddress" placeholder="도로명주소">
		<input type="text" id="sample4_jibunAddress" placeholder="지번주소">
		<span id="guide" style="color:#999;display:none"></span>
		<input type="text" id="sample4_detailAddress" placeholder="상세주소">
		<input type="text" id="sample4_extraAddress" placeholder="주소 참고사항">
		
		<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script>
		    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
		    function sample4_execDaumPostcode() {
		        new daum.Postcode({
		            oncomplete: function(data) {
		                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
		
		                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
		                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
		                var roadAddr = data.roadAddress; // 도로명 주소 변수
		                var extraRoadAddr = ''; // 참고 항목 변수
		
		                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
		                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
		                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
		                    extraRoadAddr += data.bname;
		                }
		                // 건물명이 있고, 공동주택일 경우 추가한다.
		                if(data.buildingName !== '' && data.apartment === 'Y'){
		                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
		                }
		                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
		                if(extraRoadAddr !== ''){
		                    extraRoadAddr = ' (' + extraRoadAddr + ')';
		                }
		
		                // 우편번호와 주소 정보를 해당 필드에 넣는다.
		                document.getElementById('sample4_postcode').value = data.zonecode;
		                document.getElementById("sample4_roadAddress").value = roadAddr;
		                document.getElementById("sample4_jibunAddress").value = data.jibunAddress;
		                
		                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
		                if(roadAddr !== ''){
		                    document.getElementById("sample4_extraAddress").value = extraRoadAddr;
		                } else {
		                    document.getElementById("sample4_extraAddress").value = '';
		                }
		
		                var guideTextBox = document.getElementById("guide");
		                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
		                if(data.autoRoadAddress) {
		                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
		                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
		                    guideTextBox.style.display = 'block';
		
		                } else if(data.autoJibunAddress) {
		                    var expJibunAddr = data.autoJibunAddress;
		                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
		                    guideTextBox.style.display = 'block';
		                } else {
		                    guideTextBox.innerHTML = '';
		                    guideTextBox.style.display = 'none';
		                }
		            }
		        }).open();
		    }
		</script>
	</div>
	<hr>
	<div>
		결제 상품 정보
		<table class="table">
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
				<c:forEach var="product" items="${ product.content }" varStatus="status">
					<tr>
						<th>${ status.count }</th>
						<td>${ product.pname }</td>
						<td>${ product.pPrice }</td>
						<td>${ product.dPrice}</td>
						<td>${ product.quantity}</td>
						<td>${ product.price * product.quantity }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<hr>
	<div>
		할인내역 및 총 결제금액
	</div>
	<hr>
	<div class="btn1">
		<ul>
			<li><a href="main.jsp">메인으로</a></li>
			<li><a href="orderList.jsp">주문목록</a></li>
			<li><a href="payment.jsp">결제하기</a></li>
		</ul>
	</div>
	<br>
</body>
<jsp:include page="footer.jsp"/>
</html>