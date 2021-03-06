<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<style type="text/css">
.nav navbar-nav {
	text-align: center;
}

#navbarHeader {
	background-color: black;
	color: white;
	font-weight: bold;
	font-size: 15px;
}
</style>
<title>Header</title>
<nav class="navbar navbar-default" id="navbarHeader">
<div class="container-fluid">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="./Main.do">ScoreBoard</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li><a href="#">일일회차별현황 <span class="sr-only">(current)</span></a></li>

			<li><a href="#">일일현황</a></li>
			<li><a href="#">일일현황(합계)</a></li>
			<li><a href="#">기간현황</a></li>
			<li><a href="#">기간별일일현황</a></li>
			<li><a href="#">디지털회차체크현황</a></li>
			<li><a href="#">부금현황(상세)</a></li>
			<li><a href="#">부금현황</a></li>
			<li><a href="#">좌점율</a></li>
			<li><a href="#">극장순위</a></li>

			<!-- 드롭다운 메뉴 -->
			<!-- <li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown" role="button" aria-expanded="false">메뉴<span class="caret"></span>
			</a>
				<ul class="dropdown-menu" role="menu">
					<li><a href="#">메뉴1</a></li>
					<li><a href="#">메뉴2</a></li>
					<li><a href="#">메뉴3</a></li>
					<li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
				</ul></li> -->
		</ul>
		<!-- <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form> -->
		<c:choose>
			<c:when test="${login.id eq null}">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="./Login.do">로그인</a></li>
				</ul>
			</c:when>
			<c:otherwise>
					<!-- <ul class="dropdown-menu" role="menu">
						<li><a href="#">마이 페이지</a></li>
						<li><a href="#">로그아웃</a></li>
					</ul> -->
					
					<ul class="nav navbar-nav navbar-right">
					<li role="presentation" class="dropdown">
					<a	class="dropdown-toggle" data-toggle="dropdown" href="#"
					role="button" aria-expanded="false"> ${login.id} <span class="caret"></span>
					</a>
					 <ul class="dropdown-menu" role="menu">
					<li><a href="#">마이 페이지</a></li>
						<li><a href="./Logout.do">로그아웃</a></li>
					</ul>
					</li>
					</ul>
		
			</c:otherwise>
		</c:choose>
	</div>
	<!-- /.navbar-collapse -->
</div>
<!-- /.container-fluid --> </nav>
</head>
<body>

</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</html>