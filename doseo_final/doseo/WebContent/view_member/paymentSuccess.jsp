<%@ page language="java" contentType="text/html; charset=UTF-8" 
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>주문목록</title>
<jsp:include page="../header.jsp"/>
<meta charset="UTF-8">
<style type="text/css">
   body {
      margin-right: 20px;
      margin-left: 20px;
   }
   
   .btn1 {
      text-align: center;
   }
   
   .order {
      color: red;
   }
   
   .recommend {
      margin-left: 30px;
      margin-right: 30px;
   }
</style>
</head>
<body>
    ${id}님 ${type}로 결제 완료되었습니다!
</body>
<jsp:include page="../footer.jsp"/>
</html>