<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import= "org.apache.http.HttpEntity" %>
<%@ page import= "org.apache.http.HttpResponse" %>
<%@ page import= "org.apache.http.NameValuePair" %>
<%@ page import= "org.apache.http.ParseException" %>
<%@ page import= "org.apache.http.client.HttpClient" %>
<%@ page import= "org.apache.http.client.entity.UrlEncodedFormEntity" %>
<%@ page import= "org.apache.http.client.methods.HttpGet" %>
<%@ page import= "org.apache.http.client.methods.HttpPost" %>
<%@ page import= "org.apache.http.impl.client.DefaultHttpClient" %>
<%@ page import= "org.apache.http.impl.client.HttpClientBuilder" %>
<%@ page import= "org.apache.http.message.BasicNameValuePair" %>
<%@ page import= "org.apache.http.params.HttpConnectionParams" %>
<%@ page import= "org.apache.http.util.EntityUtils" %>
<%@ page import= "org.apache.http.conn.ClientConnectionManager" %>
<%@ page import= "org.apache.http.params.HttpParams" %>
<%@ page import= "org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager" %>
<%@ page import="java.io.*" %>
<%@ page import="java.text.*,java.util.*,java.sql.*,javax.servlet.*,javax.sql.*,javax.naming.*" %>
<%@ page import = "javax.xml.parsers.*,org.w3c.dom.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%!
DefaultHttpClient client;

public DefaultHttpClient getThreadSafeClient() {
	
	if(client != null) return client;
	client = new DefaultHttpClient();
	ClientConnectionManager mgr = client.getConnectionManager();
	HttpParams params = client.getParams();
	client = new DefaultHttpClient(
			new ThreadSafeClientConnManager(
					params, mgr.getSchemeRegistry()
					),
			params);
	return client;
}

public String goXML(String getURL) {
	String result = null;
	
	HttpClient client = getThreadSafeClient();
	HttpConnectionParams.setConnectionTimeout(client.getParams(), 100000);
	HttpConnectionParams.setSoTimeout(client.getParams(), 100000);
	HttpPost post = new HttpPost(getURL);
	
	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	if(false) {
		nameValuePairs.add(new BasicNameValuePair("input1", "kopoctc"));
	}
	
	try {
		post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		HttpResponse responsePost = null;
		
		responsePost = client.execute(post);
		HttpEntity resEntity = responsePost.getEntity();
		
		if(resEntity != null) {
			result = EntityUtils.toString(resEntity).trim();
		}
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		
	}
	return result;
}
%>
</head>
<body>
<h1>날씨조회</h1>
<%
String ret = goXML("http://www.kma.go.kr/wid/queryDFS.jsp?gridx=61&gridy=123");

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


try {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	
	ByteArrayInputStream is = new ByteArrayInputStream(ret.getBytes("utf-8"));
	Document doc = builder.parse(is);
	
	Element root = doc.getDocumentElement();
	
	//기상예보 시간
	//NodeList header = doc.getElementsByTagName("header");
	//for(int i = 0; i < header.getLength(); i++) {
	//	out.print(header.item(i));
	//}
	
	
	//xml의 루트를 기준으로 data 태그를 찾는다.
	NodeList tag_001 = doc.getElementsByTagName("data");
	for(int i = 0; i < tag_001.getLength(); i++) {
		//data 태그가 여러개 있는데 하나를 선택(item(i))하여 어트리뷰트 seq를 찾고 그 값을 찾는다.
		seq = tag_001.item(i).getAttributes().getNamedItem("seq").getNodeValue();
		
		//찾은 data를 기준으로 만든다.
		Element elmt = (Element)tag_001.item(i);
		
		//현재 data 태그 하나를 기준으로 하위의 hour를 찾아 그 값을 가져온다. 이하 동일		
		hour = elmt.getElementsByTagName("hour").item(0).getFirstChild().getNodeValue();
		day = elmt.getElementsByTagName("day").item(0).getFirstChild().getNodeValue();
		temp = elmt.getElementsByTagName("temp").item(0).getFirstChild().getNodeValue();
		tmx = elmt.getElementsByTagName("tmx").item(0).getFirstChild().getNodeValue();
		tmn = elmt.getElementsByTagName("tmn").item(0).getFirstChild().getNodeValue();
		sky = elmt.getElementsByTagName("sky").item(0).getFirstChild().getNodeValue();
		pty = elmt.getElementsByTagName("pty").item(0).getFirstChild().getNodeValue();
		wfKor = elmt.getElementsByTagName("wfKor").item(0).getFirstChild().getNodeValue();
		wfEn = elmt.getElementsByTagName("wfEn").item(0).getFirstChild().getNodeValue();
		pop = elmt.getElementsByTagName("pop").item(0).getFirstChild().getNodeValue();
		r12 = elmt.getElementsByTagName("r12").item(0).getFirstChild().getNodeValue();
		s12 = elmt.getElementsByTagName("s12").item(0).getFirstChild().getNodeValue();
		ws = elmt.getElementsByTagName("ws").item(0).getFirstChild().getNodeValue();
		wd = elmt.getElementsByTagName("wd").item(0).getFirstChild().getNodeValue();
		wdKor = elmt.getElementsByTagName("wdKor").item(0).getFirstChild().getNodeValue();
		wdEn = elmt.getElementsByTagName("wdEn").item(0).getFirstChild().getNodeValue();
		reh = elmt.getElementsByTagName("reh").item(0).getFirstChild().getNodeValue();
		r06 = elmt.getElementsByTagName("r06").item(0).getFirstChild().getNodeValue();
		s06 = elmt.getElementsByTagName("s06").item(0).getFirstChild().getNodeValue();
	}
	
	
%>
<table border="1" style="width: 100%;">
	<thead>
		<tr>
			<th>날짜</th>
			<th>시각</th>
			<th>온도</th>
			<th>최고온도</th>
			<th>최저온도</th>
			<th>구름</th>
			<th>비</th>
			<th>날씨</th>
			<th>weather</th>
			<th>강수확률</th>
			<th>12시간</th>
		</tr>
	</thead>
	<tbody>
	<%
	//for(int i = 0; i < tag_name.getLength(); i++) {
	%>
		<tr>
			<td></td>
		</tr>
	<%
	//}
	%>
	</tbody>
</table>
<%
} catch(Exception e) {
	e.printStackTrace();
}
%>
</body>
</html>