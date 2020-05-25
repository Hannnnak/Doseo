<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="./index.jsp">HOME</a>
	<hr/>
	<h1>modifyForm.jsp</h1>
	<p>http://localhost/doseo/mypage.dom</p>
	
	<form name="modifyFrm" id="modifyFrm"
				action="modify.dom" method="post">
		<table border="1" id="member">
	        <tr>
	            <td colspan="10" align="center">회원정보</td>
	        </tr>
	        <tr>
	            <td align="center">아이디</td>
	            <td align="center">이름</td>
	            <td align="center">성별</td>
	            <td align="center">생년월일</td>
	            <td align="center">핸드폰번호</td>
	            <td align="center">이메일</td>
	            <td align="center">선호장르</td>
	            <td align="center">주소</td>
	        </tr>

 
		    <tr>
	        	<td>${member.id}<input type="hidden" name="id" value="${member.id}"/></td>
	            <td>${member.name}<input type="hidden" name="name" value="${member.name}"/></td>
	            <td>${member.gender}<input type="hidden" name="gender" value="${member.gender}"/></td>
	            <td>${member.birth}<input type="hidden" name="birth" value="${member.birth}"/></td>
	            <td>
	            	<input type="text" name="phone1" value="${member.phone1}"/>-
	            	<input type="text" name="phone2" value="${member.phone2}"/>-
	            	<input type="text" name="phone3" value="${member.phone3}"/>
	            </td>
	            <td><input type="text" name="email" value="${member.email}"/></td>
	            <td>
	            	<input type="text" name="favorite1" value="${member.favorite1}"/>, 
	            	<input type="text" name="favorite2" value="${member.favorite2}"/>, 
	            	<input type="text" name="favorite3" value="${member.favorite3}"/>
	            </td>
	            <td><input type="text" name="address" value="${member.address}"/></td>
	        </tr>
	    </table>
	    <input type="submit" value="수정완료"/>		
		<input type="reset"  value="취소"/>
    </form>
</body>
</html>