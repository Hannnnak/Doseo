<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	}
	
	.searchbar{
		margin-bottom: auto;
		margin-top: auto;
		height: 42px;
		background-color: transparent;
		border:0;
		border-radius: 30px;
		padding: 10px;
		position: absolute;
		top: 325px;
		right: 20px;
	}

    .search_input{
	    color: black;
	    outline: 0;
	    border: 0;
	    background: none;
	    width: 0;
	    caret-color: transparent;
	    line-height: 10px;
	    transition: width 0.8s linear;
    }

    .searchbar:hover > .search_input{
	    padding: 0 10px 0 10px;
	    width: 300px;
	    caret-color: black;
	    transition: width 0.2s linear;
    }

    .searchbar:hover > .search_icon{
	    background: transparent;
	    color: #4CAF50;
    }

    .search_icon{
	    height: 20px;
	    width: 20px;
	    float: right;
	    display: flex;
	    justify-content: center;
	    align-items: center;
	    border-radius: 50%;
	    color: black;
	    text-decoration:none;
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
<!-- Search Box -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>
<body>
	<div class="top-menu">
		<div class="topbtn1">
			<input type="button" value="HOME">
			<input type="button" value="후기">
			<input type="button" value="Q&A">
		</div>
		<div class="headerImg">
			<a href="index.jsp" class="link_main"><img src="<%= request.getContextPath()%>/view/view_member/logo_transparent.png" height=300px width=300px/></a>
		</div>
		<div class="topbtn2">
			<input type="button" value="로그인" onclick="location.href='loginForm.jsp'">
			<input type="button" value="회원가입" onclick="location.href='joinForm.jsp'">
			<input type="button" value="마이페이지" onclick="location.href='mypageForm.jsp'">
			<input type="button" value="장바구니" onclick="location.href='cart.jsp'">
		</div>
	</div>
	<div class="one">
		<div id="mySidenav" class="sidenav">
			<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
			<a href="#">가정/유아</a>
			<a href="#">건강</a>
			<a href="#">경제/경영</a>
			<a href="#">과학</a>
			<a href="#">만화</a>
			<a href="#">소설</a>
			<a href="#">시/에세이</a>
			<a href="#">어린이(초등)</a>
			<a href="#">역사/문화</a>
			<a href="#">예술/대중문화</a>
			<a href="#">외국어</a>
			<a href="#">요리</a>
			<a href="#">유아(0~7세)</a>
			<a href="#">인문</a>
			<a href="#">자기계발</a>
			<a href="#">정치/사회</a>
			<a href="#">종교</a>
			<a href="#">컴퓨터/IT</a>
		</div>
		<span style="font-size:30px; cursor:pointer" onclick="openNav()">&#9776; 전체 카테고리</span>
	</div>
	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="searchbar">
			<form action=".do" method="post">
				<input class="search_input" type="text" placeholder="Search...">
			    <a href="javascript:formname.submit();" class="search_icon"><i class="fas fa-search"></i></a>
			</form>
			</div>
		</div>
	</div>
	<hr>
	<br>
