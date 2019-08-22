<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*, javax.sql.*, java.io.*, java.net.*" %>
<%@ page import = "javax.xml.parsers.*, org.w3c.dom.*" %>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}
th, td {
	padding: 5px;
}
td.right {
	text-align: right;
}
td.center {
	text-align: center;
}
span.blue {
	color: blue;
}
span.red {
	color: red;
}
</style>
</head>
<body>
<h1>날씨 조회</h1>
<%
String seq = "";   //48시간중 몇번째 인지
String hour = "";  //동네예보 3시간 단위
String day = "";   //1번째날 (0: 오늘, 1: 내일, 2: 모레)
String temp = "";  //현재 시간 온도
String tmx = "";   //최고 온도
String tmn = "";   //최저 온도
String sky = "";   //하늘 상태코드 (1: 맑음, 2: 구름조금, 3: 구름많음, 4: 흐림)
String pty = "";   //강수 상태코드 (0: 없음, 1: 비, 2: 비/눈, 3: 눈/비, 4: 눈)
String wfKor = ""; //날씨 한국어
String wfEn = "";  //날씨 영어
String pop = "";   //강수 확률 %
String r12 = "";   //12시간 예상 강수량
String s12 = "";   //12시간 예상 적설량
String ws = "";    //풍속(m/s)
String wd = "";    //풍향 (0~7: 북, 북동, 동, 남동, 남, 남서, 서, 북서);
String wdKor = ""; //풍향 한국어
String wdEn = ""; //풍향 영어
String reh = "";   //습도 %
String r06 = "";   //6시간 예상 강수량
String s06 = "";   //6시간 예상 적설량
//파싱을 위한 준비과정
DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
Document doc = docBuilder.parse("http://www.kma.go.kr/wid/queryDFS.jsp?gridx=61&gridy=123");

Element root = doc.getDocumentElement();

//요일
Calendar cal = Calendar.getInstance();
int dotw = cal.get(Calendar.DAY_OF_WEEK) - 1;
String[] dotws = {"일", "월", "화", "수", "목", "금", "토"};
int dotwnext = dotw + 1;
if(dotwnext == 7) {
	dotwnext = 0;
}
int dotwnext2 = dotw + 2;
if(dotwnext2 == 7) {
	dotwnext2 = 0;
}

//기상예보 시간
NodeList header = root.getElementsByTagName("tm");
String time = header.item(0).getFirstChild().getNodeValue();	
String year = time.substring(0, 4);
String month = time.substring(4, 6);
String days = time.substring(6, 8);
String hours = time.substring(8, 10);
String minute = time.substring(10);
%>
<div style="text-align: right;">
	<%out.print(year + "년 " + month + "월 " + days + "일 " + dotws[dotw] + "요일 " + hours + ":" + minute); %> 발표
</div>
<table border="1">
	<colgroup>
		<col />
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
		<col style="width: 5%;"/>
	</colgroup>
	
	<tbody>
<%
//xml의 루트를 기준으로 data 태그를 찾는다.
NodeList nl = root.getElementsByTagName("data");
int today = 0;
int tomorrow = 0;
int dat = 0;

boolean snow = false;
for(int i = 0; i < nl.getLength(); i++) {
	//data 태그가 여러개 있는데 하나를 선택(item(i))하여 어트리뷰트 seq를 찾고 그 값을 찾는다.
	seq = nl.item(i).getAttributes().getNamedItem("seq").getNodeValue();
	
	//찾은 data를 기준으로 만든다.
	Element elmt = (Element)nl.item(i);
	
	day = elmt.getElementsByTagName("day").item(0).getFirstChild().getNodeValue();
	if(day.equals("0")) {
		today++;
	} else if(day.equals("1")) {
		tomorrow++;
	} else {
		dat++;
	}
	
	//wfKor = elmt.getElementsByTagName("wfKor").item(0).getFirstChild().getNodeValue();
	//wfEn = elmt.getElementsByTagName("wfEn").item(0).getFirstChild().getNodeValue();
	
	//r12 = elmt.getElementsByTagName("r12").item(0).getFirstChild().getNodeValue();
	//s12 = elmt.getElementsByTagName("s12").item(0).getFirstChild().getNodeValue();
	
	//wdKor = elmt.getElementsByTagName("wdKor").item(0).getFirstChild().getNodeValue();
	//wdEn = elmt.getElementsByTagName("wdEn").item(0).getFirstChild().getNodeValue();
	
	
}
%>
		<tr>
			<th>날짜</th>
			<td colspan="<%=today%>" class="center">오늘 (<%=days %>일 <%=dotws[dotw] %>)</td>
			<td colspan="<%=tomorrow%>" class="center">내일 (<%=Integer.parseInt(days) + 1 %>일 <%=dotws[dotwnext] %>)</td>
			<td colspan="<%=dat%>" class="center">모레 (<%=Integer.parseInt(days) + 2 %>일 <%=dotws[dotwnext2] %>)</td>
		</tr>
		<tr>
			<th>시각</th>
			
<%
for(int i = 0; i < nl.getLength(); i++) {
	//찾은 data를 기준으로 만든다.
	Element elmt = (Element)nl.item(i);
	
	//현재 data 태그 하나를 기준으로 하위의 hour를 찾아 그 값을 가져온다. 이하 동일		
	hour = elmt.getElementsByTagName("hour").item(0).getFirstChild().getNodeValue();
%>
			<td class="right">~ <%=hour %></td>
<%
}
%>
			
		</tr>
		<tr>
			<th>날씨</th>
			
<%
for(int i = 0; i < nl.getLength(); i++) {
	Element elmt = (Element)nl.item(i);
	
	sky = elmt.getElementsByTagName("sky").item(0).getFirstChild().getNodeValue();
	pty = elmt.getElementsByTagName("pty").item(0).getFirstChild().getNodeValue();
	String img = "";
	if(pty.equals("0")) { //비가 안오면
		switch(sky) {
		case "1" :
			img = "DB01"; //맑음
			break;
		case "2" :
			img = "DB02"; //구름 조금
			break;
		case "3" :
			img = "DB03"; //구름 많음
			break;
		case "4" :
			img = "DB04"; //흐림
			break;
		}
	} else {
		switch(pty) {
		case "1" :
			img = "DB05"; //비
			break;
		case "2" :
			img = "DB06"; //비눈
			snow = true;
			break;
		case "3" :
			img = "DB07"; //눈비
			snow = true;
			break;
		case "4" :
			img = "DB08"; //눈
			snow = true;
			break;
		}
	}
%>
			<td class="center"><img src="image/<%=img%>.png" /></td>
<%
}
%>
			
		</tr>
		<tr>
			<th>강수확률(%)</th>
			
<%
for(int i = 0; i < nl.getLength(); i++) {
	Element elmt = (Element)nl.item(i);
	
	pop = elmt.getElementsByTagName("pop").item(0).getFirstChild().getNodeValue();
	
%>
			<td class="center"><%=pop %></td>
<%
}
%>
			
		</tr>
		<tr>
			<th><%=snow ? "적설량(mm)" : "강수량(mm)"%></th>
			
<%
for(int i = 0; i < nl.getLength(); i++) {
	Element elmt = (Element)nl.item(i);
	
	r06 = elmt.getElementsByTagName("r06").item(0).getFirstChild().getNodeValue();
	s06 = elmt.getElementsByTagName("s06").item(0).getFirstChild().getNodeValue();
	
	if(r06.equals("0.0")) r06 = "-";
	if(s06.equals("0.0")) s06 = "-";
%>
			<td class="center"><%=snow ? s06 : r06 %></td>
<%
}
%>
			
		</tr>
		<tr>
			<th>최저/최고(℃)</th>
			
<%
	Element elmt = (Element)nl.item(0);
	String tmxToday = elmt.getElementsByTagName("tmx").item(0).getFirstChild().getNodeValue();
	String tmnToday = elmt.getElementsByTagName("tmn").item(0).getFirstChild().getNodeValue();
	
	elmt = (Element)nl.item(today);
	String tmxTomorrow = elmt.getElementsByTagName("tmx").item(0).getFirstChild().getNodeValue();
	String tmnTomorrow = elmt.getElementsByTagName("tmn").item(0).getFirstChild().getNodeValue();
	
	elmt = (Element)nl.item(today + tomorrow);
	String tmxDat = elmt.getElementsByTagName("tmx").item(0).getFirstChild().getNodeValue();
	String tmnDat = elmt.getElementsByTagName("tmn").item(0).getFirstChild().getNodeValue();
	
	if(tmnToday.equals("-999.0")) tmnToday = "-";
	if(tmnTomorrow.equals("-999.0")) tmnTomorrow = "-";
	if(tmnDat.equals("-999.0")) tmnDat = "-";
	if(tmxToday.equals("-999.0")) tmxToday = "-";
	if(tmxTomorrow.equals("-999.0")) tmxTomorrow = "-";
	if(tmxDat.equals("-999.0")) tmxDat = "-";	
	
%>
			<td class="center" colspan="<%=today%>"><span class="blue"><%=tmnToday %></span>/<span class="red"><%=tmxToday %></span></td>
			<td class="center" colspan="<%=tomorrow%>"><span class="blue"><%=tmnTomorrow %></span>/<span class="red"><%=tmxTomorrow %></span></td>
			<td class="center" colspan="<%=dat%>"><span class="blue"><%=tmnDat %></span>/<span class="red"><%=tmxDat %></span></td>
<%
%>
			
		</tr>
		<tr>
			<th>기온(℃)</th>
			
<%
for(int i = 0; i < nl.getLength(); i++) {
	elmt = (Element)nl.item(i);
	
	temp = elmt.getElementsByTagName("temp").item(0).getFirstChild().getNodeValue();
%>
			<td class="center"><%=temp %></td>
<%
}
%>
			
		</tr>
		<tr>
			<th>풍향</th>
			
<%
for(int i = 0; i < nl.getLength(); i++) {
	elmt = (Element)nl.item(i);
	
	wd = elmt.getElementsByTagName("wd").item(0).getFirstChild().getNodeValue();
	
	String img = "";
	switch(wd) {//풍향 (0~7: 북, 북동, 동, 남동, 남, 남서, 서, 북서);
	case "0" :
		img = "N";
		break;
	case "1" :
		img = "NE";
		break;
	case "2" :
		img = "E";
		break;
	case "3" :
		img = "SE";
		break;
	case "4" :
		img = "S";
		break;
	case "5" :
		img = "SW";
		break;
	case "6" :
		img = "W";
		break;
	case "7" :
		img = "NW";
		break;
	}
%>
			<td class="center"><img src="image/<%=img %>.gif" /></td>
<%
}
%>
			
		</tr>
		<tr>
			<th>풍속(km/h)</th>
			
<%
for(int i = 0; i < nl.getLength(); i++) {
	elmt = (Element)nl.item(i);
	
	ws = elmt.getElementsByTagName("ws").item(0).getFirstChild().getNodeValue();
	ws = ws.substring(0, ws.indexOf(".")) + "." + ws.substring(ws.indexOf(".") + 1, ws.indexOf(".") + 2);
	
%>
			<td class="center"><%=ws %></td>
<%
}
%>
			
		</tr>
<tr>
			<th>습도(%)</th>
			
<%
for(int i = 0; i < nl.getLength(); i++) {
	elmt = (Element)nl.item(i);
	
	reh = elmt.getElementsByTagName("reh").item(0).getFirstChild().getNodeValue();
%>
			<td class="center"><%=reh %></td>
<%
}
%>
			
		</tr>
	</tbody>
</table>
</body>
</html>