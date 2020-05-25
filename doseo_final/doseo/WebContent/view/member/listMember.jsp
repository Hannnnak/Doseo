<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<style type="text/css">
	a {
		text-decoration:none;
	}
	
	a:visited {
		color: black;
	}
	
	body {
		margin: 10px 20px 0 20px;
	}
</style>
</head>
<body>
<a href="http://localhost/doseo/main.dom">홈</a>
&nbsp;|&nbsp;
<a onclick="history.back()">이전 페이지</a>
      <%--
         ArticlePage타입의  articlePage참조변수;
         request.setAttribute("memberPage", articlePage);
          모델이 넘어왔다 --%>
<hr/>  
<%--          
   *총 회원수 : ${memberPAPE.total}건 <br/>
    현재페이지 : ${memberPAPE.currentPage}/ 총페이지수:${memberPAPE.totalPages}<p/> --%>
   <table class="table table-striped" style="width: auto;">
   <%-- 기타기능 : 글쓰기  p653 11--%>
      <tr>
         <th colspan="9" style="padding-bottom: 5px; padding-top: 5px;">
            <%--     <div id="searchForm">
                <form name="joinFrm" id="joinFrm" action="join.dom find.dom" method="get">
                
            <select name="opt">
                <option value="0">아이디</option>
                <option value="1">이름</option>
                <option value="2">전화번호</option>
                <option value="3">이메일</option>
            </select>
            <input type="text" size="20" name="condition"/>&nbsp;
            <input type="submit" value="검색"/>
              </form>    
             </div>--%>
       </th>
      </tr>
   <%-- 게시글목록 출력부분 p653 14--%>
      <tr>
         <th>아이디</th>
         <th>이름</th>
         <th>성별</th>
         <th>생일</th>
         <th>전화번호</th>
         <th>이메일</th>
         <th>선호장르</th>
         <th>주소</th>
         <th>가입일</th>
      </tr>
      <c:if test="${memberPAPE.hasNoMembers()} ">
         <tr>
            <th colspan="9">게시글이 존재하지 않습니다.</th>
         </tr>
      </c:if>    
          
      <c:forEach  var="member" items="${memberPAPE.content}">
         <tr>
           <%-- ${member.number}은 Article클래스의 getNumber()메소드를 호출 --%>
            <td>${member.id} </td>
            <td>${member.name}</td>
            <td>${member.gender}</td>
            <td>${member.birth}</td>
            <td>${member.phone1} ${member.phone2} ${member.phone3}</td>
            <td>${member.email}</td>
            <td>${member.favorite1} ${member.favorite2} ${member.favorite3}</td>
            <td>${member.address}</td>
            <td>${member.regDate}</td>
            
      </tr>
      </c:forEach> 
   <%-- 페이징 부분  p653 37--%>
   <c:if test="${memberPAPE.hasMembers() }">
      <tr>
         <th colspan="9">
            <%-- [이전prev]출력 --%>
            <c:if test="${memberPAPE.startPage>5}">
            <a href="listad.dom?pageNo=${memberPAPE.startPage-5}">[이전]</a>
            </c:if>
            
            <%-- 페이지출력 [이전] [1] [2] [3] [4] [5] --%>
            <c:forEach var="pNo" 
                       begin="${memberPAPE.startPage}" 
                       end="${memberPAPE.endPage}">
            <a href="listad.dom?pageNo=${pNo}">[${pNo}]</a>
            </c:forEach>
            
            <%-- [다음next]출력 --%>
            <c:if test="${memberPAPE.endPage<memberPAPE.totalPages}">
            <a href="listad.dom?pageNo=${memberPAPE.startPage+5}">[다음]</a>
            </c:if>
         </th>
      </tr>
   </c:if>
   </table>

</body>
</html>









