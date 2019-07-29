<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean isLogin = false;
	String str = "";
	Object obj = session.getAttribute("login");
	if(obj != null) {
		isLogin = (boolean)session.getAttribute("login");
	}
	
	if(isLogin) {
		session.setAttribute("isLogin", true);
	} else {
		session.setAttribute("isLogin", false);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>파이리조트</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
<link rel="icon" href="favicon.ico" type="image/x-icon">
<!-- include libraries(jQuery, bootstrap) -->
<link rel="stylesheet" href="https://bootswatch.com/4/superhero/bootstrap.css" media="screen">
<link rel="stylesheet" href="https://bootswatch.com/_assets/css/custom.min.css">

<link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo|Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="http://www.knps.or.kr/common/cctv/skin.css">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script src="js/script.js"></script>
<!-- 3. flowplayer -->
<script src="http://www.knps.or.kr/common/cctv/flowplayer.min.js"></script>
<!-- Include the line below if you want to use the HLS.js plugin to avoid flash use on modern browsers -->
<script src="http://www.knps.or.kr/common/cctv/flowplayer.hlsjs.min.js"></script>
<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>

</head>
<body>
	<div class="navbar navbar-expand-lg fixed-top navbar-dark bg-primary">
		<div class="container">
			<a href="/Resort/" class="navbar-brand dokdo" style="font-size: 30px !important;">파이리조트</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav">
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						id="room">리조트 소개 <span class="caret"></span></a>
						<div class="dropdown-menu" aria-labelledby="room">
							<a class="dropdown-item" href="javascript:go('room/gold.html');">금수저룸</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="javascript:go('room/silver.html');">은수저룸</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="javascript:go('room/bronze.html');">흙수저룸</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						id="traffic">찾아오기 <span class="caret"></span></a>
						<div class="dropdown-menu" aria-labelledby="traffic">
							<a class="dropdown-item" href="javascript:go('location/loc_car.html');">자가용 이용</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="javascript:go('location/loc_bus.html');">대중교통 이용</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						id="around">주변 여행지 <span class="caret"></span></a>
						<div class="dropdown-menu" aria-labelledby="around">
							<a class="dropdown-item" href="javascript:go('travel/mountain.html');">산</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="javascript:go('travel/sea.html');">바다</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						id="book">예약하기 <span class="caret"></span></a>
						<div class="dropdown-menu" aria-labelledby="book">
							<a class="dropdown-item" href="javascript:go('book/status.html');">예약상황</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="javascript:go('book/booking.html');">예약하기</a>
						</div>
					</li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
						id="news">펜션 소식 <span class="caret"></span></a>
						<div class="dropdown-menu" aria-labelledby="news">
							<a class="dropdown-item" href="javascript:go('news/board/list.jsp');">리조트 소식</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="javascript:go('news/reboard/list.jsp');">이용 후기</a>
						</div>
					</li>
				</ul>

				<ul class="nav navbar-nav ml-auto">
<%
	if(isLogin) {
%>
					<li class="nav-item">
						<a class="nav-link"
						href="#" target="_blank">관리자 페이지</a>
					</li>
					<li class="nav-item">
						<a class="nav-link"
						href="#" target="_blank">로그아웃</a>
					</li>
<%
	} else {
%>
					<li class="nav-item">
						<a class="nav-link"
						href="javascript:go('login.jsp');" target="_blank">관리자 로그인</a>
					</li>
<%
	}
%>
				</ul>

			</div>
		</div>
	</div>
	
	<div class="container">	