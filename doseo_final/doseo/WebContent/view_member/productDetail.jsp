<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품상세</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style type="text/css">
	#productDetail{
		border:5px solid #eee; 
		padding:10px 20px; 
		margin-bottom:20px;
		font-size:20px; 
		font-weight:bold; 
		display:inline-block; 
		width:1000px; 
		margin-right:10px;
		float: left;
	}
	
	#WncCi {
		border:5px solid #eee; 
		padding:10px 20px; 
		margin-bottom:20px;
		font-size:20px; 
		font-weight:bold; 
		display:inline-block; 
		width:1000px; 
		margin-right:10px;
		float: left;
	}
</style>
<jsp:include page="../header.jsp"/>
</head>
<body>
<script>
 function getValue(){
	 var count=$('#count').val();
	 location.href="cart.dom?pno=${product.pNo}&count="+count;
 }
 function getValues(){
	 var count=$('#count').val();
	 location.href="order.dom?pno=${product.pNo}&count="+count;
 }
</script>
	<div>
	   <a href="http://localhost/doseo/main.dom">홈</a>
	   &nbsp;|&nbsp;
	   <a href="<%= request.getContextPath()%>/list.dom?category=${product.category}">
	   ${product.category}</a>
	   &nbsp;|&nbsp;
	   <a>${product.pName}</a>
	</div>
	<br>
    <form method="post" name="detailFrm" >
		<c:set var="str" value="${product.imageFileURL}"/>
        <c:if test="${fn:contains(str, 'image.aladin.co.kr')}">
        	<img src="${product.imageFileURL}" >
        </c:if>
        <br>
        <c:if test="${!fn:contains(str, 'image.aladin.co.kr')}">
        	<img src="/doseo/product_images/${product.imageFileURL}" >
        </c:if> 
        <br>
    	<table id="info">
    		<tr> 
    			<td>도서명</td>
    			<td> ${product.pName}</td>
    		</tr>
    		<tr> 
    			<td>도서번호</td>
    			<td> ${product.pNo}</td>
    		</tr>
    		<tr>
    		  <td>정가</td>
    			<td> ${product.pPrice}</td>
    		</tr>
    		<tr>
    		  <td>할인율</td>
    			<td> ${product.discount}</td>
    		</tr>
    		<tr>
    			<td>수량</td> 
    			<td>
					<input type="number" pattern="[0-9]*" name="quantity" max="99999" min="1" value="1" id="count">
   						<span data-hook="number-input-spinner-up-arrow" class="_11lkb"></span>
   						<span data-hook="number-input-spinner-down-arrow" class="_3Bjyb _4Irna"></span>
    			</td>
    		</tr> 
    	</table>
   	  <br>
      <div id="buttons">
          <input type="button" value="장바구니" class= "submit btn btn-primary" onclick="getValue()"> 
          <input type="button" value="바로구매" class="submit btn btn-success" onclick="getValues()"> 
          <input type="button" value="후기" class="submit btn btn-info" onclick="location.href='reviewlist.dom'"> 
      </div>    
   </form>
   <br>
<div>
	<ul>
		<li name="contentDetail">
			<h4>제품상세</h4>
				<div class="productDetail">
					<p>${product.detailContent}</p>
				</div>
		</li>
	</ul>
	<br>
	<br>
	<br>
	<br>
	<ul>
		<li name="return">
			<h4>RETURN &amp; REFUND POLICY</h4>
			<div id="WncCi">
				<p>
					반품/교환가능 기간: 변심반품의 경우 수령 후 7일 이내, 상품의 결함 및 계약내용과 다를 경우 문제점 발견 후 30일 이내
				</p>
				<p>
					반품/교환비용: 변심 혹은 구매착오로 인한 반품/교환은 반송료 고객 부담
				</p>
				<p>
					반품/교환 불가 사유: 소비자의 책임 있는 사유로 상품 등이 손실 또는 훼손된 경우
					(단지 확인을 위한 포장 훼손은 제외)
					소비자의 사용, 포장 개봉에 의해 상품 등의 가치가 현저히 감소한 경우
					예) 화장품, 식품, 가전제품(악세서리 포함) 등
					복제가 가능한 상품 등의 포장을 훼손한 경우
					예) 음반/DVD/비디오, 소프트웨어, 만화책, 잡지, 영상 화보집
					소비자의 요청에 따라 개별적으로 주문 제작되는 상품의 경우 ((1)해외주문도서)
					디지털 컨텐츠인 eBook, 오디오북 등을 1회 이상 다운로드를 받았을 경우
					시간의 경과에 의해 재판매가 곤란한 정도로 가치가 현저히 감소한 경우
					전자상거래 등에서의 소비자보호에 관한 법률이 정하는 소비자 청약철회 제한 내용에
					해당되는 경우
					(1) 해외주문도서 : 이용자의 요청에 의한 개인주문상품으로 단순변심 및 착오로 인한 취소/교환/반품 시 ‘해외주문 반품/취소 수수료’ 고객 부담 (해외주문 반품/취소 수수료 : ①양서-판매정가의 12%, ②일서-판매정가의 7%를 적용)
				</p>
			</div>
		</li>
	</ul>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.js"></script>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<jsp:include page="../footer.jsp"/>
</body>
</html>