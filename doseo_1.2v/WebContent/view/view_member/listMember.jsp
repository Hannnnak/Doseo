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
	
	<a href="./index.jsp">HOME</a>
	<hr/>
	<h3>회원 목록 -listMember.jsp</h3>
	<p>http://localhost/board/list.dom</p>
	
		<%--
		   ArticlePage타입의  articlePage참조변수;
		   request.setAttribute("memberPage", articlePage);
		    모델이 넘어왔다 --%>
	memberPAPE=${memberPAPE}	    
	 <hr/>	    
	*총게시물수 : ${memberPAPE.total}건 <br/>
	 현재페이지 : ${memberPAPE.currentPage}/ 총페이지수:${memberPAPE.totalPages}<p/>
	<table border="1" width="auto">
	<%-- 기타기능 : 글쓰기  p653 11--%>
		<tr>
			<th colspan="9"><a href="">[기능]</a></th>
		</tr>
	<%-- 게시글목록 출력부분 p653 14--%>
		<tr>
			<th width="50">아이디</th>
			<th width="100">이름</th>
			<th width="50">성별</th>
			<th width="auto">생일</th>
			<th width="auto">전화번호</th>
			<th width="50">이메일</th>
			<th width="auto">선호장르</th>
			<th width="auto">주소</th>
			<th width="auto">가입일</th>
		</tr>
		<c:if test="${memberPAPE.hasNoMembers()} ">
			<tr>
				<th colspan="9">게시글이 존재하지 않습니다.</th>
			</tr>
		</c:if>    
		    
		<c:forEach  var="member" items="${memberPAPE.content}">
			<tr>
			  <%-- ${member.number}은 Article클래스의 getNumber()메소드를 호출 --%>
				<td width="50">${member.id} </td>
				<td width="100">${member.name}</td>
				<td width="50">${member.gender}</td>
				<td width="auto">${member.birth}</td>
				<td width="auto">${member.phone}</td>
				<td width="50">${member.email}</td>
				<td width="auto">${member.favorite}</td>
				<td width="auto">${member.address}</td>
				<td width="auto">${member.regDate}</td>
				
		</tr>
		</c:forEach> 
	<%-- 페이징 부분  p653 37--%>
	<c:if test="${memberPAPE.hasMembers() }">
		<tr>
			<th colspan="9">
				<%-- [이전prev]출력 --%>
				<c:if test="${memberPAPE.startPage>5}">
				<a href="list.dom?pageNo=${memberPAPE.startPage-5}">[이전]</a>
				</c:if>
				
				<%-- 페이지출력 [이전] [1] [2] [3] [4] [5] --%>
				<c:forEach var="pNo" 
				           begin="${memberPAPE.startPage}" 
				           end="${memberPAPE.endPage}">
				<a href="list.dom?pageNo=${pNo}">[${pNo}]</a>
				</c:forEach>
				
				<%-- [다음next]출력 --%>
				<c:if test="${memberPAPE.endPage<memberPAPE.totalPages}">
				<a href="list.dom?pageNo=${memberPAPE.startPage+5}">[다음]</a>
				</c:if>
			</th>
		</tr>
	</c:if>
	</table>
</body>
</html>










