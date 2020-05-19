<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="modifyFrm" id="modifyFrm"
				action="modify.dom" method="post">
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
	        	<td>${member.id}<input type="hidden" name="id" value="${member.id}"/></td>
	            <td><input type="text" name="name" value="${member.name}"/></td>
	            <td><input type="text" name="gender" value="${member.gender}"/></td>
	            <td><input type="text" name="birth" value="${member.birth}"/></td>
	            <td><input type="text" name="phone" value="${member.phone}"/></td>
	            <td><input type="text" name="email" value="${member.email}"/></td>
	            <td><input type="text" name="favorite" value="${member.favorite}"/></td>
	            <td><input type="text" name="address" value="${member.address}"/></td>
	        </tr>
	    </table>
	    <input type="submit" value="수정완료"/>		
		<input type="reset"  value="취소"/>
    </form>
</body>
</html>