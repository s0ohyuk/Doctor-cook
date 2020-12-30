<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Beautiful Bootstrap Navbar with Menu Icons</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/style.css">
</head> 
<body>
<nav class="navbar navbar-expand-xl sticky-top">
<div class="container">
	<a href="home.do">닥터<b>쿡</b></a>  		
	<!-- Collection of nav links, forms, and other content for toggling -->
	<div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
		<div class="nav-item dropdown">
			<a href="#" data-toggle="dropdown" class="nav-item nav-link dropdown-toggle user-action">이야기<b class="caret"></b></a>
			<div class="dropdown-menu">
				<a href="#" class="dropdown-item">공지사항</a>
				<a href="#" class="dropdown-item">질문게시판</a>
				<a href="#" class="dropdown-item">자주묻는질문</a>
			</div>
		</div>
		<a href="#" class="nav-item nav-link">클래스</a>
		<a href="#" class="nav-item nav-link">선생님</a>
		<div class="navbar-nav ml-auto text-center">
			<form class="navbar-form form-inline">
				<div class="input-group search-box">								
					<input type="text" id="search" class="form-control" placeholder="Search here...">
					<span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
				</div>
			</form>
			<a href="#" class="nav-item nav-link active">
				<svg width="1.8em" height="1.8em" viewBox="0 0 16 16" class="bi bi-person-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
					<path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
				</svg>
				<p>내 강의</p>
			</a>
			<a href="SignIn.do" class="nav-item nav-link">
				<svg width="1.8em" height="1.8em" viewBox="0 0 16 16" class="bi bi-person-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
	  				<path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
				</svg>
				<p>로그인</p>
			</a>
		</div>
	</div>
	</div>
</nav>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</html>