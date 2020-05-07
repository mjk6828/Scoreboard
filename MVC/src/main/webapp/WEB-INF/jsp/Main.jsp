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
<link href="<c:url value='css/main.css' />" rel="stylesheet"
	type="text/css">
<title>Score Board</title>
<jsp:include page="include/Header.jsp" />
<style type="text/css">
.dropdown {
	float: left;
	margin-right: 20px;
}

span {
	padding-top: 5px;
	margin-right: 10px;
}

th {
	text-align: center;
}
</style>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-body">
				<span>검색일자</span> <input type="date" size="5"> <span>부터</span>
				<input type="date" size="5"> <span>까지</span>
			</div>
			<div class="panel-body">
				<span style="float: left;">영화</span>
				<div class="dropdown">
					<select class="form-control" id="cinema">

					</select>

				</div>
				<span style="float: left;">지역</span>
				<div class="dropdown">
					<select class="form-control" id="location">
						<option value="alllocation">전체</option>
						<option value="seoul">서울</option>
						<option value="gyoung">경기,강원</option>
						<option value="busan">부산,경남</option>
						<option value="daegu">대구,경북</option>
						<option value="daejun">대전,충청</option>
						<option value="gwangju">광주,호남</option>
					</select>
				</div>
				
				<span style="float: left;">극장</span>
				<div class="dropdown">
					<select class="form-control" id="theater">
						<option value="alltheater">전체</option>
						<option value="cgv">CGV</option>
						<option value="lottee">롯데시네마</option>
						<option value="mega">메가박스</option>
						<option value="free">프리머스</option>
						<option value="normal">일반</option>
					</select>
				</div>
				
				<span style="float: left;">구분</span>
				<div class="dropdown">
					<select class="form-control" id="division">
						<option value="alldivision">전체</option>
						<option value="direct">직영점</option>
						<option value="commission">위탁점</option>
						<option value="solo">개인점</option>
					</select>

				</div>
				<span style="float: left;">필름</span>
				<div class="dropdown">
					<select class="form-control" id="film">
						<option value="allfilm">전체</option>
						<option value="35mm">35mm</option>
						<option value="imax4d">IMAX 4D</option>
						<option value="digital4d">디지털 4D</option>
						<option value="atomos4d">ATOMOS 4D</option>
						<option value="digital2d">디지털 2D</option>
						<option value="digital3d">디지털 3D</option>
						<option value="digitaldubbing">디지털 더빙</option>
						<option value="digital3ddubbing">디지털3D 더빙</option>
						<option value="imax2d">아이맥스 2D</option>
						<option value="imax3d">아이맥스 3D</option>
						<option value="atomos2d">ATOMOS 2D</option>
						<option value="atomos3d">ATOMOS 3D</option>
					</select>

				</div>
				<!-- <input type="file" class="btn btn-primary pull-right" style="float:right;" value="엑셀출력"> -->
				<!-- <button class="btn btn-danger pull-right" style="float: right;" type="file">엑셀출력</button> -->
				<form id="excelForm" name="excelForm" enctype="multipart/form-data"
					method="post" action="./ExcelUpload.do">
					<input id="excelFile" type="file" name="excelFile"
						style="float: right; margin-top: 10px;" value="엑셀업로드">

					<button class="btn btn-danger pull-right" style="float: right;"
						type="button" id="excelup">업로드</button>

					<button class="btn btn-primary pull-right" style="float: rigth;"
						type="button" onclick="SearchFunction()">검색</button>
				</form>


			</div>
		</div>
		<table class="table" id="list" style="text-align: center;">
			<tbody id="table" style="text-align:center;">
			
			</tbody>
		</table>
	</div>
</body>
<script type="text/javascript" src="<c:url value='js/main.js' />"></script>
</html>