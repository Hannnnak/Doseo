<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>운송장 조회</title>
</head>
<body>
<form action="http://www.deliverytracking.kr/?dummy=one&deliverytype=doortodoor&keyword=349613741686" method="post">
            <div class="form-group">
<!--               <label for="t_key">API key</label> -->
              <input type="hidden" class="form-control" id="t_key" name="t_key" placeholder="GrnUsRD6tGoXfAlqW0d3Uw">
            </div>
            <div class="form-group">
              <label for="t_code">택배사 코드</label>
              <input type="text" class="form-control" name="t_code" id="t_code" placeholder="04">
            </div>
            <div class="form-group">
              <label for="t_invoice">운송장 번호</label>
              <input type="text" class="form-control" name="t_invoice" id="t_invoice" placeholder="349613741686">
            </div>
            <button type="submit" class="btn btn-default">조회하기</button>
        </form>
</body>
<jsp:include page="footer.jsp"/>
</html>