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

public String goLogin() {
	return goXML("http://localhost:8080/XmlWeb/login.jsp", true);
}

public String goXML(String getURL) {
	return goXML(getURL, false);
}

public String goXML(String getURL, boolean loginFlag) {
	String result = null;
	
	HttpClient client = getThreadSafeClient();
	HttpConnectionParams.setConnectionTimeout(client.getParams(), 100000);
	HttpConnectionParams.setSoTimeout(client.getParams(), 100000);
	HttpPost post = new HttpPost(getURL);
	
	List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
	if(loginFlag) {
		nameValuePairs.add(new BasicNameValuePair("username", "kopoctc"));
		nameValuePairs.add(new BasicNameValuePair("userpasswd", "kopoctc"));
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
<meta charset="UTF-8">
<title>parsing3</title>
</head>
<body>
<h1>성적조회</h1>
<%

String ret = goLogin();
ret = goXML("http://localhost:8080/XmlWeb/loginxml.jsp");

try {
	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	DocumentBuilder builder = factory.newDocumentBuilder();
	
	ByteArrayInputStream is = new ByteArrayInputStream(ret.getBytes("utf-8"));
	Document doc = builder.parse(is);
	
	Element root = doc.getDocumentElement();
	NodeList tag_name = doc.getElementsByTagName("name");
	NodeList tag_studentid = doc.getElementsByTagName("studentid");
	NodeList tag_kor = doc.getElementsByTagName("kor");
	NodeList tag_eng = doc.getElementsByTagName("eng");
	NodeList tag_mat = doc.getElementsByTagName("mat");
%>
<table border="1">
	<colgroup>
		<col style="width: 100px;"/>
		<col style="width: 100px;"/>
		<col style="width: 100px;"/>
		<col style="width: 100px;"/>
		<col style="width: 100px;"/>
	</colgroup>
	<thead>
		<tr>
			<th>이름</th>
			<th>학번</th>
			<th>국어</th>
			<th>영어</th>
			<th>수학</th>
		</tr>
	</thead>
	<tbody>
	<%
	for(int i = 0; i < tag_name.getLength(); i++) {
	%>
		<tr>
			<td><%=tag_name.item(i).getFirstChild().getNodeValue() %></td>
			<td><%=tag_studentid.item(i).getFirstChild().getNodeValue() %></td>
			<td><%=tag_kor.item(i).getFirstChild().getNodeValue() %></td>
			<td><%=tag_eng.item(i).getFirstChild().getNodeValue() %></td>
			<td><%=tag_mat.item(i).getFirstChild().getNodeValue() %></td>
		</tr>
	<%
	}
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