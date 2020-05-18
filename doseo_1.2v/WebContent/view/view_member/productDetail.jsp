<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품상세</title>
</head>
<body>

    <h1> productDetail</h1>
    <form method="post" name="productFrm">
    			<img width="300" src="https://post-phinf.pstatic.net/MjAyMDA1MTJfMyAg/MDAxNTg5MjY0NzI5MzQ1.KLM-rJ6P6RtPoq72xa33WEq7lInsNsJXqYQ9tfNUR2Ag.U5eEssL0_oRk1yGNnC6-FL6zImjWwYpfIpW1wDa-X-8g.JPEG/image_2162538391589264703729.jpg?type=w1200">
    	<table>
    		<tr> 
    			<td>책제목</td>
    			<td> ${product.pName}</td>
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
						<input type="number" pattern="[0-9]*" name="quantity" max="99999" min="1" value="1">
    						<span data-hook="number-input-spinner-up-arrow" class="_11lkb"></span>
    						<span data-hook="number-input-spinner-down-arrow" class="_3Bjyb _4Irna"></span>
    			</td>
    		</tr> 
    	</table>
   
      <div id="buttons">
          <input type="button" value="장바구니"   class="submit"    onclick="go_cart()"> 
          <input type="button" value="바로구매"       class="submit"    onclick="go_order()"> 
          <input type="reset"  value="취소"           class="cancel">
      </div>    
   </form>
   
<ul>
	<li name="contentDetail">
		<h3>제품상세</h3>
			<div class="WncCi">
				<p>${product.detailContent}</p>
			</div>
	</li>
	<li name="return">
		<h3>RETURN &amp; REFUND POLICY</h3>
		<div name="WncCi">
			<p>환불정책에 대한 구체적인 내용
				~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~</p>
		</div>
	</li>
	<li name="shoppinfInfo">
		<h3>SHIPPING INFO</h3>
		<div class="WncCi">	
		<p>I'm a shipping policy. I'm a great place to add more information about your shipping methods, packaging and cost.
			 Providing straightforward information about your shipping policy is a great way to build trust and 
			 reassure your customers that they can buy from you with confidence.</p>
		</div>	
	</li>
</ul>

</body>
</html>