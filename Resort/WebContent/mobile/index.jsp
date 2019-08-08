<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="viewport" content="user-scalable=no, width=device-width" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="apple-mobile-web-app-status-bar-style" content="black" />
<meta http-equiv="Cache-Control" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Pragma" content="no-cache" />
<title>파이리조트</title>
<script type="text/javascript">
var orientationEvent;
var uAgent = navigator.userAgent.toLowerCase();
var mobilePhones = "android";
if(uAgent.indexOf(mobilePhones) != -1) {	
	orientationEvent = "resize"; //안드로이드는 resize로 들어온다.
} else orientationEvent = "orientationchange"; //아이폰은 이렇게.
window.addEventListener(orientationEvent, function() {
	location.reload();
}, false);

var prevScreen = 0;
var sv_prevScreen = 0;
function prevShow() {
	ScreenShow(prevScreen);
}

//서브메뉴를 선택(하단 버튼을 누름)했을때 함수
var muCnt = 5; //서브메뉴
var scCnt = 10; //화면
function fncShow(pos) {
	var i = 0;

	//모든 일반 화면은 막는다.
	for(i = 0; i < scCnt; i++) {
		var obj = document.getElementById("s" + i);
		obj.style.display = "none";
	}

	//메뉴 선택에 따라 중간메뉴 div는 보여주고, 누른 버튼의 배경을 바꿔준다.
	for(i = 0; i < muCnt; i++) {
		var obj = document.getElementById("menu" + i);
		var obj2 = document.getElementById("m" + i);

		if(i == pos) {
			obj.style.display = "";
			obj2.style.background = "#FF0000";
		} else {
			obj.style.display = "none";
			obj2.style.background = "#FFFF00";
		}
	}
}

//총 화면은 15개이고 화면이 선택된 번호에 따라 화면을 보여주는 함수
function ScreenShow(pos) {
	var i = 0;

	//모든 메뉴페이지는 막는다.
	for(i = 0; i < muCnt; i++) {
		var obj = document.getElementById("menu" + i);
		obj.style.display = "none";
	}

	//선택된 화면번호의 화면만 보여준다.
	for(i = 0; i < scCnt; i++) {
		var obj = document.getElementById("s" + i);

		if(i == pos) {
			obj.style.display = "";
		} else {
			obj.style.display = "none";
		}
	}
}
</script>
<style type="text/css">
li {
	text-align: left;
	vertical-align: middle;
	margin: 2px;
	padding: 10px;
	height: 20px;
	background-color: #AAAA00;
	border: 2px solid #FF0000;
	font-size: 16px;
}
ul {
	list-style-type: none;
	vertical-align: middle;
	margin: 2px;
	padding: 10px;
	height: 20px;
	background-color: #BBAABB;
	border: 2px solid #FF0000;
}
.center {
	text-align: center;
}
.container {
	width: device-width;
	height: device-height;
}
.header {
	background-color: #00FFFF;
	height: 35px;
	float: left;
	vertical-align: middle;
}
.menu {
	background-color: #EEEEEE;
}
.s {
	padding: 10px 5px;
	
}
.m {
	position: absolute;
	bottom: 3px;
	height: 80px;
	width: 18%;
	float: left;
}
.m0 {
	left: 1%;
}
.m1 {
	left: 21%;
}
.m2 {
	left: 41%;
}
.m3 {
	left: 61%;
}
.m4 {
	left: 81%;
}
img {
	vertical-align: -webkit-baseline-middle;
}
</style>
</head>
<body class="center" onload="ScreenShow(0);">
	<div id="container" class="container">
		<div id="header1" class="header" style="width: 11%;" onclick="prevShow();">
			<img src="../image/mobile/back.png" style="width: 30px; height: auto;" />
		</div>
		<div id="header2" class="header" style="width: 78%;">
			<strong style="vertical-align: -webkit-baseline-middle;">파이리조트</strong>
		</div>
		<div id="header3" class="header" style="width: 11%;" onclick="ScreenShow(0);">
			<img src="../image/mobile/home.png" style="width: 25px; height: auto;" />
		</div>

		<div id="menu0" class="menu" style="display: none;">
			리조트 소개
			<ul>
				<li onclick="ScreenShow(0);">파이리조트</li>
				<li onclick="ScreenShow(1);">금수저룸</li>
				<li onclick="ScreenShow(2);">은수저룸</li>
				<li onclick="ScreenShow(3);">흙수저룸</li>
			</ul>
		</div>

		<div id="menu1" class="menu" style="display: none;">
			찾아오기
			<ul>				
				<li onclick="ScreenShow(4);">자가용 이용</li>
				<li onclick="ScreenShow(5);">대중교통 이용</li>
			</ul>
		</div>

		<div id="menu2" class="menu" style="display: none;">
			주변 여행지
			<ul>
				<li onclick="ScreenShow(6);">산</li>
				<li onclick="ScreenShow(7);">바다</li>				
			</ul>
		</div>

		<div id="menu3" class="menu" style="display: none;">
			예약하기
			<ul>
				<li onclick="ScreenShow(8);">예약하기</li>
			</ul>
		</div>

		<div id="menu4" class="menu" style="display: none;">
			펜션 소식
			<ul>
				<li onclick="ScreenShow(9);">리조트 소식</li>
				<li onclick="ScreenShow(10);">이용 후기</li>
			</ul>
		</div>
		
		<div style="clear: both;"></div>

		<div id="s0" class="s">
			<p>파이리조트로 놀러오셔요</p>
			<img src="../image/main1.jpg" style="width: 100%; height: auto;" />
			<p>파이리조트로 놀러오셔요</p>
		</div>
		<div id="s1" class="s" style="background-color: #5F5F5F; display: none;">
			<p>금수저룸</p>
			<img src="../image/gold1.jpg" style="width: 100%; height: auto;" />
			<p>파이리조트로 놀러오셔요</p>
		</div>
		<div id="s2" class="s" style="background-color: #5F5F5F; display: none;">
			나 메뉴0_3에 대한 화면
		</div>
		<div id="s3" class="s" style="background-color: #5F5F5F; display: none;">
			나 메뉴1_1에 대한 화면
		</div>
		<div id="s4" class="s" style="background-color: #5F5F5F; display: none;">
			나 메뉴1_2에 대한 화면
		</div>
		<div id="s5" class="s" style="background-color: #5F5F5F; display: none;">
			나 메뉴1_3에 대한 화면
		</div>
		<div id="s6" class="s" style="background-color: #5F5F5F; display: none;">
			나 메뉴2_1에 대한 화면
		</div>
		<div id="s7" class="s" style="background-color: #5F5F5F; display: none;">
			나 메뉴2_2에 대한 화면
		</div>
		<div id="s8" class="s" style="background-color: #5F5F5F; display: none;">
			나 메뉴2_3에 대한 화면
		</div>
		<div id="s9" class="s" style="background-color: #5F5F5F; display: none;">
			나 메뉴3_1에 대한 화면
		</div>
		<div id="s10" class="s" style="background-color: #5F5F5F; display: none;">
			나 메뉴3_2에 대한 화면
		</div>
		<div id="s11" class="s" style="background-color: #5F5F5F; display: none;">
			나 메뉴3_3에 대한 화면
		</div>
		<div id="s12" class="s" style="background-color: #5F5F5F; display: none;">
			나 메뉴4_1에 대한 화면
		</div>
		<div id="s13" class="s" style="background-color: #5F5F5F; display: none;">
			나 메뉴4_2에 대한 화면
		</div>
		<div id="s14" class="s" style="background-color: #5F5F5F; display: none;">
			나 메뉴4_3에 대한 화면
		</div>

		<div id="m0" onclick="fncShow(0)" class="m m0" style="background-color: #FF0000;">
			[메뉴0]
		</div>
		<div id="m1" onclick="fncShow(1)" class="m m1" style="background-color: #FFFF00;">
			[메뉴1]
		</div>
		<div id="m2" onclick="fncShow(2)" class="m m2" style="background-color: #FFFF00;">
			[메뉴2]
		</div>
		<div id="m3" onclick="fncShow(3)" class="m m3" style="background-color: #FFFF00;">
			[메뉴3]
		</div>
		<div id="m4" onclick="fncShow(4)" class="m m4" style="background-color: #FFFF00;">
			[메뉴4]
		</div>
	</div>
</body>
</html>