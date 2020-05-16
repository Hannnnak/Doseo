<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--  request.setAttribute("member",member);
	 request.getAttribute("member")
 --%>
member=${member}
	<h1>mypageForm.jsp</h1>
	<hr/>
	<form action="" method="post">
		<table border="1" id="member">
	        <tr>
	            <td colspan="10" align="center">회원정보</td>
	        </tr>
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


		    <tr>
	        	<td align="center">${member.memberId}</td>
	            <td align="center">${member.memberPw}</td>
	            <td align="center">${member.name}</td>
	            <td align="center">${member.gender}</td>
	            <td align="center">${member.birth}</td>
	            <td align="center">${member.enrollDate}</td>
	            <td align="center">${member.phone}</td>
	            <td align="center">${member.email}</td>
	            <td align="center">${member.favorite}</td>
	            <td align="center">${member.address}</td>
	        </tr>
	        
	    </table>
	    <br/>
		<table border="1" id="order">
	        <tr>
	            <td colspan="7" align="center">주문내역</td>
	        </tr>
	        <tr>
	            <td align="center">주문번호</td>
	            <td align="center">주문날짜</td>
	            <td align="center">요구사항</td>
	            <td align="center">제품번호</td>
	            <td align="center">할인가</td>
	            <td align="center">수량</td>
	            <td align="center">가격</td>
	        </tr>
		    <tr>
	        	<td align="center">$</td>
	            <td align="center">$</td>
	            <td align="center">$</td>
	            <td align="center">$</td>
	            <td align="center">$</td>
	            <td align="center">$</td>
	            <td align="center">$</td>
	        </tr>
	    </table>
	    <br/>
	    <a href="#">회원정보수정</a>
		<a href="#">회원탈퇴</a>
	</form>
</body>
</html>