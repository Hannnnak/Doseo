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
	<h3>회원가입폼 joinForm.jsp</h3>
	<p>http://localhost/doseo/join.do</p>
	<form name="joinFrm" id="joinFrm" 
				action="join.dom" method="post">
				
		<p>아이디 : <br/>
		<input type="text" name="memberId" />
		</p>
		<p>비밀번호 : <br/>
		<input type="text" name="memberPw" />
		</p>
		<p>이름 : <br/>
		<input type="text" name="name" />
		</p>
		<p>성별 : <br/>
		<input type="text" name="gender" />
		</p>
		<p>생년월일 : <br/>
		<input type="text" name="birth" />
		</p>
		<p>가입일 : <br/>
		<input type="text" name="enrollDate" />
		</p>
		<p>핸드폰번호 : <br/>
		<input type="text" name="phone" />
		</p>
		<p>이메일 : <br/>
		<input type="text" name="email" />
		</p>
		<p>선호장르 : <br/>
		<input type="text" name="favorite" />
		</p>
		<p>address : <br/>
		<input type="text" name="address" />
		</p>
		
		<input type="submit" value="가입"/>		
		<input type="reset"  value="취소"/>
	</form>
</body>
</html>