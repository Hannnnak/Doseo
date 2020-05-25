<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>암호 변경</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<jsp:include page="../../header.jsp"/>
<style>
	#change {
		float: center;
		text-align: center;
	}
	
	#btn {
		float: center;
		text-align: center;
	}
</style>
</head>
<body>
	<%
	//컨트롤러인 LoginHandler에서
	//에러에 대하 정보를 아래와 같이  Model로 넘겼다
	//request.setAttribute("errors",errors);
	
	//p607 44~51
	/*if(id==null||id.isEmpty()){errors.put("id",Boolean.TRUE);}
		if(password==null||password.isEmpty()){errors.put("password",Boolean.TRUE);
	}*/
	
		//View에서 사용시에는
	//Map<String,Boolean> errors = request.getAttribute("errors");
	//${errors.키값}
	%>

	<form name="changePwdFrm" id="changePwdFrm" action="changePwd.dom" method="POST">
		<div id="change">
			<p>
				<label for="inputCurPassword" class="col-lg-2 control-label">현재 암호</label>
				<input type="password" name="curPwd"/><br/>
				<c:if test="${errors.curPwd}">
					현재 암호를 입력하세요
				</c:if>
				<c:if test="${errors.badCurPwd}">
					현재 암호가 일치하지 않습니다
				</c:if>
			</p>
			<p>
				<label for="inputNewPassword" class="col-lg-2 control-label">새 암호</label>
				<input type="password" name="newPwd"/><br/>	  
				<c:if test="${errors.newPwd}">
					새 암호를 입력하세요
				</c:if>
				<c:if test="${errors.badCurPwd}">
					현재 암호가 일치하지 않습니다
				</c:if>
			</p>
		</div>
		<div id="btn">
			<input type="submit" class="btn btn-primary" value="암호변경" />	  
			<input type="reset" class="btn btn-defualt" value="취소" onclick="history.back()"/>
		</div>
	</form>
</body>
<jsp:include page="../../footer.jsp"/>
</html>













