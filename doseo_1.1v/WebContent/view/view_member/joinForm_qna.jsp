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
	<h3>회원가입폼 joinForm.jsp(p600)</h3>
	<p>http://localhost/board/join.do</p>
	<form name="joinFrm" id="joinFrm" 
				action="join.do" method="post">
		<p>아이디 : <br/>
		 <input type="text" name="id" />
		</p>
		<p>암호 : <br/>
		 <input type="text" name="password" />
		</p>
		<p>암호확인 : <br/>
		 <input type="text" name="confirmPassword" />
		</p>
		<p>이 름 : <br/>
		 <input type="text" name="name" />
		</p>
		<p>성 별 : <br/>
		 <input type="text" name="gender" />
		</p>
		<p>생 일 : <br/>
		 <input type="text" name="birth" />
		</p>
		<p>전화번호 : <br/>
		 <input type="text" name="phone" />
		</p>
		<p>이메일 : <br/>
		 <input type="text" name="email" />
		</p>
		<p>선호장르 : <br/>
		 <input type="text" name="favorite" />
		</p>
		<p>주 소 : <br/>
		 <input type="text" name="address" />
		</p>
		
		<input type="submit" value="가입"/>		
		<input type="reset"  value="취소"/>
	</form>
</body>
</html>














