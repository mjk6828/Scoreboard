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
<link href="<c:url value='css/loginForm.css' />" rel="stylesheet"
	type="text/css">
<jsp:include page="../include/Header.jsp" />
<title>로그인페이지1</title>
</head>


		<table class="table">
			<thead>
				<tr>
					<td align="center"><h2>
							로그인 에러
						</h2> <br>
						<button type="button" class="loginbtn"
							onclick="document.location.href='./Main.do'">
							<b>메인페이지 이동</b>
						</button></td>
				</tr>
			</thead>
		</table>



</html>