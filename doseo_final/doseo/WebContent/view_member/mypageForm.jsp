<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<jsp:include page="../header.jsp"/>
<style type="text/css">
	.footButton {
		text-align: center;
		float: center;
	}
</style>
</head>
<body>
<%--  request.setAttribute("member",member);
	 request.getAttribute("member")
member=${member}
 --%>
	<form action="" method="post">
		<h4 align="center">회원정보</h4>
		<table class="table" id="member">
			<thead align="center" class="thead-light">
		        <tr>
		            <td align="center">아이디</td>
		            <td align="center">비밀번호</td>
		            <td align="center">이름</td>
		            <td align="center">성별</td>
		            <td align="center">생년월일</td>
		            <td align="center">가입일</td>
		            <td align="center">핸드폰번호</td>
		            <td align="center">이메일</td>
		            <td align="center">선호장르</td>
		            <td align="center">주소</td>
		        </tr>
		    </thead>
		    <tr>
	        	<td align="center">${member.id}</td>
	            <td align="center">비공개<input type="hidden" name="password" value="${member.password}"/></td>
	            <td align="center">${member.name}</td>
	            <td align="center">${member.gender}</td>
	            <td align="center">${member.birth}</td>
	            <td align="center">${member.regDate}</td>
	            <td align="center">${member.phone1}-${member.phone2}-${member.phone3}</td>
	            <td align="center">${member.email}</td>
	            <td align="center">${member.favorite1} ${member.favorite2} ${member.favorite3}</td>
	            <td align="center">${member.address}</td>
	        </tr>
	        
	    </table>
	    <br/>
	    <h4 align="center">주문내역</h4>
		<table class="table table-striped" id="order">
	        <tr>
	            <td align="center">주문날짜</td>
	            <td align="center">주문번호</td>
	            <td align="center">아이디</td>
	            <td align="center">주소</td>
	            <td align="center">요구사항</td>
	        </tr>
	        <c:forEach var="order" items="${order}">
			    <tr>
		            <td align="center">${order.orderDate}</td>
		        	<td align="center">${order.oNo}</td>
		            <td align="center">${order.memberId}</td>
		            <td align="center">${order.address}</td>
		            <td align="center">${order.requests}</td>
		        </tr>
	        </c:forEach>
	    </table>
	    <br/>
	    <div class="footButton">
		    <a href="./changePwd.dom" class="btn btn-secondary btn-sm">암호변경</a>
		    <a href="./modify.dom" class="btn btn-primary btn-sm">회원정보수정</a>
			<a href="./delete.dom" class="btn btn-danger btn-sm">회원탈퇴</a>
		</div>
	</form>
</body>
<jsp:include page="../footer.jsp"/>
</html>