<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
	.topbtn1 {
	margin-left: 10px;
	margin-top: 10px;
	float: left;'
	}
	
	.topbtn2 {
	margin-right: 10px;
	margin-top: 10px;
	float: right;'
	}
	
	.headerImg {
	margin: 0 auto;
	text-align: center;
	left: 50%;
	margin-left: -130px;
	padding: 10px;
	}

	ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    background-color: #333;
	}
	
	ul:after{
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
    height: 40px;
    background-color: transparent;
    border-radius: 30px;
    padding: 10px;
    position: absolute;
    top: 327px;
    right: 20px;
    }

    .search_input{
    color: white;
    border: 0;
    outline: 0;
    background: none;
    width: 0;
    caret-color: transparent;
    line-height: 10px;
    transition: width 0.4s linear;
    }

    .searchbar:hover > .search_input{
    padding: 0 10px 0 10px;
    width: 300px;
    caret-color: red;
    transition: width 0.4s linear;
    }

    .searchbar:hover > .search_icon{
    background: transparent;
    color: #e74c3c;
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
    color: #f1f1f1;
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
		<div class="topbtn2">
			<input type="button" value="로그인">
			<input type="button" value="회원가입">
			<input type="button" value="마이페이지">
			<input type="button" value="장바구니" onclick="location.href='cart.jsp'">
		</div>
		<div class="headerImg">
			<a href="main.jsp" class="link_main"><img src="logo_transparent.png" height=300px width=300px/></a>
		</div>
	</div>
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
	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="searchbar">
				<input class="search_input" type="text" placeholder="Search...">
			    <a href="#" class="search_icon"><i class="fas fa-search"></i></a>
			</div>
		</div>
	</div>
	<hr>
	<br>
