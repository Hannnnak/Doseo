<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<title></title>
<style type="text/css">
/*상단 */
	.top-menu{
		height:150px;
		padding:10px 10px;
	}
	.top-menu :: after {
		content: "";
		position: relative;
		display: block;
		clear: both;
	}
	.topbtn1 {
		float: left;
		width: 33%;
		height:150px;
	}
	
	.topbtn2 {
		float: right;
		width: 33%;
		text-align:right;
	}
	
	.headerImg {
		text-align:center;
		float:left;
		width:34%;
	}
	
	.searchBox {
		float: right;
		margin-top: -40px;
	}
	
	.one {
		clear:both;
	}
	
	ul {
		list-style-type: none;
		margin: 0;
		padding: 0;
		background-color: #333;
	}
	
	ul :: after{
		content: '';
		display: block;
		clear :both;
	}
	
	li {
		float: left;
	}
	
	li a {
		display: block;
		color: white;
		text-align: center;
		padding: 14px 16px;
		text-decoration: none;
	}
	
	li a:hover:not(.active) {
		background-color: #111;
	}
	
	.active {
		background-color: #4CAF50;
	}
	
	body {
		font-family: "Lato", sans-serif;
		margin: 0 20px 0 20px;
	}
	
	.sidenav {
	    height: 100%;
	    width: 0;
	    position: fixed;
	    z-index: 1;
	    top: 0;
	    background-color: #111;
	    overflow-x: hidden;
	    transition: 0.5s;
	    padding-top: 60px;
	}
	.sidenav a {
	    padding: 10px 10px 10px 35px;
	    text-decoration: none;
	    font-size: 20px;
	    color: #818181;
	    display: block;
	    transition: 0.3s;
	}
	.sidenav a:hover {
	color:	 #f1f1f1;
	}
	.sidenav .closebtn {
		position: absolute;
		top: 0;
		right: 25px;
		font-size: 36px;
		margin-left: 50px;
	}
	
	@media screen and (max-height: 450px) {
	.sidenav {padding-top: 15px;}
	.sidenav a {font-size: 18px;}
	}
</style>
<!-- sideMenu -->
<script>
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
</script>
</head>
<body>

<%	String userID = null; %>
		
		<%-- 비로그인 --%>
		<c:if test="${empty AUTHUSER && empty AUTHUSER2 }">
			<% userID = "1"; %>
		</c:if>
		
		<%-- 로그인 --%>		
		<c:if test="${! empty AUTHUSER }">
		<% userID = "2"; %>
		</c:if>
	
		<%-- 관리자 로그인 --%>
		<c:if test="${! empty AUTHUSER2}">
		<% userID = "3"; %>
		</c:if>


				<%-- 비로그인 --%>
			<%
				if(userID == "1"){
			%>

	<div class="top-menu">
		<div class="topbtn1">
			<input type="button" class="btn btn-primary" value="HOME" onclick="location.href='main.dom'">
			<input type="button" class="btn btn-outline-secondary" value="후기" onclick="location.href='reviewlist.dom'">
			<input type="button" class="btn btn-outline-secondary" value="공지사항" onclick="location.href='qnalist.dom'">
		</div>
		<div class="headerImg">
			<a href="/doseo/main.dom" class="link_main"><img src="logo_transparent.png" height=300px width=300px/></a>
		</div>
		<div class="topbtn2">
			<input type="button" class="btn btn-outline-secondary" value="로그인" onclick="location.href='login.dom'">
			<input type="button" class="btn btn-outline-secondary" value="회원가입" onclick="location.href='join.dom'">
			<input type="button" class="btn btn-outline-secondary" value="장바구니" onclick="location.href='cart.dom'">
		</div>
	</div>

			<%-- 로그인 --%>	
			<%		
				}else if(userID == "2") {
			%>
	
		<div class="top-menu">
		<div class="topbtn1">
			<input type="button" class="btn btn-primary" value="HOME" onclick="location.href='main.dom'">
			<input type="button" class="btn btn-outline-secondary" value="후기" onclick="location.href='reviewlist.dom'">
			<input type="button" class="btn btn-outline-secondary" value="공지사항" onclick="location.href='qnalist.dom'">
		</div>
		<div class="headerImg">
			<a href="/doseo/main.dom" class="link_main"><img src="logo_transparent.png" height=300px width=300px/></a>
		</div>
		<div class="topbtn2">
			<input type="button" class="btn btn-outline-secondary" value="로그아웃" onclick="location.href='logout.dom'">
			<input type="button" class="btn btn-outline-secondary" value="마이페이지" onclick="location.href='mypage.dom'">
			<input type="button" class="btn btn-outline-secondary" value="장바구니" onclick="location.href='cart.dom'">
		</div>
	</div>
	
	
				<%-- 관리자 로그인 --%>	
			<%		
				}else if(userID == "3") {
			%>
			
			
				<div class="top-menu">
		<div class="topbtn1">
			<input type="button" class="btn btn-primary" value="HOME" onclick="location.href='main.dom'">
			<input type="button" class="btn btn-outline-secondary" value="후기" onclick="location.href='reviewlist.dom'">
			<input type="button" class="btn btn-outline-secondary" value="공지사항" onclick="location.href='qnalist.dom'">
		</div>
		<div class="headerImg">
			<a href="/doseo/main.dom" class="link_main"><img src="logo_transparent.png" height=300px width=300px/></a>
		</div>
		<div class="topbtn2">
         <input type="button" class="btn btn-outline-secondary" value="로그아웃" onclick="location.href='logout.dom'">
         <input type="button" class="btn btn-outline-secondary" value="관리자페이지" onclick="location.href='view_admin/adminForm.jsp'">
		</div>
	</div>
						<% 
				}
			%>
	<div class="one">
		<div id="mySidenav" class="sidenav">
			<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			<a href="list.dom?category=가정/유아">가정/유아</a>
			<a href="list.dom?category=건강">건강</a>
			<a href="list.dom?category=경제/경영">경제/경영</a>
			<a href="list.dom?category=과학">과학</a>
			<a href="list.dom?category=만화">만화</a>
			<a href="list.dom?category=소설">소설</a>
			<a href="list.dom?category=시/에세이">시/에세이</a>
			<a href="list.dom?category=어린이(초등)">어린이(초등)</a>
			<a href="list.dom?category=역사/문화">역사/문화</a>
			<a href="list.dom?category=예술/대중문화">예술/대중문화</a>
			<a href="list.dom?category=외국어">외국어</a>
			<a href="list.dom?category=요리">요리</a>
			<a href="list.dom?category=유아(0~7세)">유아(0~7세)</a>
			<a href="list.dom?category=인문">인문</a>
			<a href="list.dom?category=자기계발">자기계발</a>
			<a href="list.dom?category=정치/사회">정치/사회</a>
			<a href="list.dom?category=종교">종교</a>
			<a href="list.dom?category=컴퓨터/IT">컴퓨터/IT</a>
		</div>
		<span style="font-size:30px; cursor:pointer" onclick="openNav()">&#9776; 전체 카테고리</span>
	</div>
	<form action="search.dom" class="searchBox">
		<div class="input-group">
			<input type="text" placeholder="Search..." name="search" style="margin: 3px;">
			<span class="input-group-btn">
				<button type='submit' class="btn btn-default" style="margin: 3px;">검색</button> 
				<span class="glyphicon glyphicon-search"></span>
			</span>
		</div>
	</form>
	<hr>
	<br>