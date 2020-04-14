<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<c:url value='css/loginForm.css' />" rel="stylesheet" type="text/css">
<jsp:include page="../include/Header.jsp" />
<title>로그인페이지1</title>
</head>
<body>
			<form action="./LoginForm.do" id="loginform" method="post">
				<div class="container" id="login">
					<p>
					<h1 class="title">
						<b>LOGIN</b>
					</h1>
					</p>
					<input type="text" class="ID" placeholder="UserID" 
					 name="id" id="login_id" required><br><br> 
					<input type="password" class="PW" placeholder="Password"
					 name="pass" required><br><br>
					<div class="check">
						<label class="container remember" for="remember"> 
						<input id="remember" type="checkbox" class="checkbox">&nbsp; Remember me
						</label> 
						<a href="/Temp/page/forgetCheck.jsp" class="forgot"><b>forgot?</b></a>
					</div>
					<button type="submit" id="loginbtn" class="loginbtn">
						<b>LOGIN</b>
					</button>
				</div>
			</form>

</body>
</html>