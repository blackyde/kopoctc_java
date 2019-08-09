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
	location.href = "#";
}, false);

var prevScreen = 0;
var sv_prevScreen = 0;
function prevShow() {
	ScreenShow(prevScreen);
}

//서브메뉴를 선택(하단 버튼을 누름)했을때 함수
var muCnt = 5; //서브메뉴
var scCnt = 11; //화면
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

var ScrObj;

var timer1;

function ScrAnimation() {
	var offset = -50;
	if(parseInt(ScrObj.style.left) > 10) {
		ScrObj.style.left = parseInt(ScrObj.style.left) + offset + "px";
		timer1 = setTimeout("ScrAnimation()", 1);
	} else {
		ScrObj.style.left = 5;
		clearTimeout(timer1);
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
			prevScreen = sv_prevScreen;
			sv_prevScreen = i;
			obj.style.display = "";
			obj.style.position = "relative";
			obj.style.top = 35;
			obj.style.left = screen.width;
			obj.style.height = screen.height - 120;
			
			ScrObj = obj;
			ScrAnimation();
		} else {
			obj.style.display = "none";
		}
	}
}
</script>
<style type="text/css">
.menu li {
	vertical-align: middle;
	margin: 2px;
	padding: 10px;
	height: 20px;
	background-color: #AAAA00;
	border: 2px solid #FF0000;
	font-size: 16px;
}
.menu ul {
	list-style-type: none;
	vertical-align: middle;
	margin: 2px;
	padding: 10px;
	height: 20px;
	background-color: #BBAABB;
	border: 2px solid #FF0000;
}
li {
	text-align: left;
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
	position: fixed;
	bottom: 3px;
	height: 80px;
	width: 18%;
	float: left;
	display: table;
}
.m span {
	display: table-cell;
	vertical-align: middle;
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
iframe {
	border: 0;
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
			리조트 소식
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
		<div id="s1" class="s" style="display: none;">
			<p>금수저룸</p>
			<img src="../image/gold1.jpg" style="width: 100%; height: auto;" />
			<p>럭셔리 휴식공간</p>
		</div>
		<div id="s2" class="s" style="display: none;">
			<p>은수저룸</p>
			<img src="../image/silver1.jpg" style="width: 100%; height: auto;" />
			<p>아늑한 휴식공간</p>
		</div>
		<div id="s3" class="s" style="display: none;">
			<p>흙수저룸</p>
			<img src="../image/bronze1.jpg" style="width: 100%; height: auto;" />
			<p>경제적 휴식공간</p>
		</div>
		<div id="s4" class="s" style="display: none; overflow: hidden;">
			<p>자가용 이용</p>
			<div
				style="font: 12px AppleSDGothicNeo-Regular, dotum, sans-serif; letter-spacing: -1px; width: 100%; color: rgb(51, 51, 51); position: relative;">
				<div style="height: 240px;">
					<a
						href="https://map.kakao.com/?urlX=853197&amp;urlY=1303110&amp;itemId=27392264&amp;q=%EB%A1%AF%EB%8D%B0%EB%A6%AC%EC%A1%B0%ED%8A%B8%EC%86%8D%EC%B4%88&amp;srcid=27392264&amp;map_type=TYPE_MAP&amp;from=roughmap"
						target="_blank"><img class="map"
						src="//t1.daumcdn.net/roughmap/imgmap/ccdcae9eaa18b0a949a89c969c76a94656ae03741e77800b3b8ad3a3a02052df"
						width="100%" height="238"
						style="border: 1px solid rgb(204, 204, 204);"></a>
				</div>
			</div>
			<h5>주소 : 강원도 속초시 대포항길 186</h5>
			<h5>출발지 : 서울</h5>
			<ol>
				<li>올림픽대로</li>
				<li>강일IC</li>
				<li>서울춘천고속도로</li>
				<li>춘천JC</li>
				<li>동홍천양양고속도로</li>
				<li>양양JC</li>
				<li>동해고속도로</li>
			</ol>
			<div style="height: 80px;"></div>
		</div>
		<div id="s5" class="s" style="display: none; overflow: hidden;">
			<p>버스 이용</p>
			<div
				style="font: 12px AppleSDGothicNeo-Regular, dotum, sans-serif; letter-spacing: -1px; width: 100%; color: rgb(51, 51, 51); position: relative;">
				<div style="height: 240px;">
					<a
						href="https://map.kakao.com/?urlX=853197&amp;urlY=1303110&amp;itemId=27392264&amp;q=%EB%A1%AF%EB%8D%B0%EB%A6%AC%EC%A1%B0%ED%8A%B8%EC%86%8D%EC%B4%88&amp;srcid=27392264&amp;map_type=TYPE_MAP&amp;from=roughmap"
						target="_blank"><img class="map"
						src="//t1.daumcdn.net/roughmap/imgmap/ccdcae9eaa18b0a949a89c969c76a94656ae03741e77800b3b8ad3a3a02052df"
						width="100%" height="238"
						style="border: 1px solid rgb(204, 204, 204);"></a>
				</div>
			</div>
			<h5>주소 : 강원도 속초시 대포항길 186</h5>
			<h5>출발지 : 서울</h5>
			<ol>
				<li>동서울터미널(1688-5979)</li>
				<li>속초터미널</li>
			</ol>
			<ol>
				<li>서울 고속버스터미널(1688-4700)</li>
				<li>속초터미널</li>
			</ol>
			<div style="height: 80px;"></div>
		</div>
		<div id="s6" class="s" style="display: none; overflow: hidden;">
			<p>설악</p>
			<img src="http://www.thekmagazine.co.kr/file/webzine/11/wz_11_16_1_1529868633.jpg" style="width: 100%; height: auto;" />
			<p>산이다.</p>
		</div>
		<div id="s7" class="s" style="display: none; overflow: hidden;">
			<p>동해</p>
			<img src="http://img.etoday.co.kr/pto_db/2017/06/20170630055356_1088133_710_340.jpg" style="width: 100%; height: auto;" />
			<p>바다다.</p>
		</div>
		<div id="s8" class="s" style="display: none; overflow: hidden;">
			<iframe src="/Resort/?contentPage=book/status.jsp" style="width: 100%; height: 98vh; margin-top: -130px;" onload="setIFrameHeight(this);"></iframe>
			<script>
				function setIFrameHeight(obj) {

					if (obj.contentDocument) {

						obj.height = obj.contentDocument.body.offsetHeight + 40;

					} else {

						obj.height = obj.contentWindow.document.body.scrollHeight;

					}

				}
			</script>
			<div style="height: 85px;"></div>
		</div>
		<div id="s9" class="s" style="display: none; overflow: hidden;">
			<iframe src="/Resort/?contentPage=news/board/list.jsp" style="width: 100%; height: 98vh; margin-top: -130px;"></iframe>
			<div style="height: 85px;"></div>
		</div>
		<div id="s10" class="s" style="display: none; overflow: hidden;">
			<iframe src="/Resort/?contentPage=news/reboard/list.jsp" style="width: 100%; margin-top: -130px;" onload="setIFrameHeight(this);"></iframe>
			<script>
				function setIFrameHeight(obj) {

					if (obj.contentDocument) {

						obj.height = obj.contentDocument.body.offsetHeight + 40;

					} else {

						obj.height = obj.contentWindow.document.body.scrollHeight;

					}

				}
			</script>
			<div style="height: 85px;"></div>
		</div>

		<div id="m0" onclick="fncShow(0)" class="m m0" style="background-color: #FF0000;">
			<span>리조트<br>소개</span>
		</div>
		<div id="m1" onclick="fncShow(1)" class="m m1" style="background-color: #FFFF00;">
			<span>찾아<br>오기</span>
		</div>
		<div id="m2" onclick="fncShow(2)" class="m m2" style="background-color: #FFFF00;">
			<span>주변<br>여행지</span>
		</div>
		<div id="m3" onclick="fncShow(3)" class="m m3" style="background-color: #FFFF00;">
			<span>예약<br>하기</span>
		</div>
		<div id="m4" onclick="fncShow(4)" class="m m4" style="background-color: #FFFF00;">
			<span>리조트<br>소식</span>
		</div>
	</div>
</body>
</html>