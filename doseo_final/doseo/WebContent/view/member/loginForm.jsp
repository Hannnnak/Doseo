<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../../header.jsp"/>
<meta charset="UTF-8">
<meta name="viewport" content=width=device-width", initial-scale="1">
<title>로그인</title>
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style type="text/css">
    body {
      font-family: 'Varela Round', sans-serif;
   }
   .modal-login {
      width: 350px;
   }
   .modal-login .modal-content {
      padding: 20px;
      border-radius: 5px;
      border: none;
   }
   .modal-login .modal-header {
      border-bottom: none;
      position: relative;
      justify-content: center;
   }
   .modal-login .close {
      position: absolute;
      top: -10px;
      right: -10px;
   }
   .modal-login h4 {
      color: #636363;
      text-align: center;
      font-size: 26px;
      margin-top: 0;
   }
   .modal-login .modal-content {
      color: #999;
      border-radius: 1px;
      margin-bottom: 15px;
      background: #fff;
      border: 1px solid #f3f3f3;
      box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
      padding: 25px;
    }
   .modal-login .form-group {
      margin-bottom: 20px;
   }
   .modal-login label {
      font-weight: normal;
      font-size: 13px;
   }
   .modal-login .form-control {
      min-height: 38px;
      padding-left: 5px;
      box-shadow: none !important;
      border-width: 0 0 1px 0;
      border-radius: 0;
   }
   .modal-login .form-control:focus {
      border-color: #ccc;
   }
   .modal-login .input-group-addon {
      max-width: 42px;
      text-align: center;
      background: none;
      border-width: 0 0 1px 0;
      padding-left: 5px;
      border-radius: 0;
   }
    .modal-login .btn {        
      font-size: 16px;
      font-weight: bold;
      border-radius: 3px;
      border: none;
      min-width: 140px;
      outline: none !important;
    }
   .modal-login .btn:hover, .modal-login .btn:focus {
      background: #179b81;
   }
   .modal-login .hint-text {
      text-align: center;
      padding-top: 5px;
      font-size: 13px;
   }
   .modal-login .modal-footer {
      color: #999;
      border-color: #dee4e7;
      text-align: center;
      margin: 0 -25px -25px;
      font-size: 13px;
      justify-content: center;
   }
   .modal-login a {
      color: #fff;
      text-decoration: underline;
   }
   .modal-login a:hover {
      text-decoration: none;
   }
   .modal-login a {
      color: #19aa8d;
      text-decoration: none;
   }   
   .modal-login a:hover {
      text-decoration: underline;
   }
   .modal-login .fa {
      font-size: 21px;
   }
   .trigger-btn {
      display: inline-block;
      margin: 100px auto;
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
   <div class="modal-dialog modal-login">
      <div class="modal-content">
         <div class="modal-header">            
            <h4 class="modal-title">Sign In</h4>
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
         </div>
            <form name="loginFrm" id="loginFrm" action="login.dom" method="POST">
              <c:if test="${errors.idOrPwNotMatch}">
                 아이디 또는 비밀번호가 일치하지 않습니다
              </c:if>
               <div class="form-group">
                  <div class="input-group">
                     <span class="input-group-addon"><i class="fa fa-user"></i></span>
                     <input type="text" name="id" id="id" value="${param.id}" class="form-control" placeholder="memberID"/>
                     <c:if test="${errors.id}">ID를 입력하세요</c:if>
                  </div>
               </div>
               <div class="form-group">
                  <div class="input-group">
                     <span class="input-group-addon"><i class="fa fa-lock"></i></span>
                     <input type="password" name="password" id="password" class="form-control" placeholder="password"/>
                   <c:if test="${errors.password}">암호를 입력하세요</c:if>
                  </div>
               </div>
               <div class="form-group" >
                  <input type="submit" class="btn btn-primary" value="로그인" style="margin:3px"/>     
                  <input type="button" class="btn btn-defualt" value="취소" style="margin:3px" onclick="history.back()"/>
               </div>
               <p class="hint-text"><a href="find.dom">Forgot MemberID?</a></p>
               <p class="hint-text"><a href="findPw.dom">Forgot Password?</a></p>
            </form>
         <div class="modal-footer">
         	Don't have an account? <a href="join.dom">Create one</a>
         </div>
         </div>
      </div>
</body>
<jsp:include page="../../footer.jsp"/>
</html>