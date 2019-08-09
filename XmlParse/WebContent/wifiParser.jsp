<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*, javax.sql.*, java.io.*, java.net.*" %>
<%@ page import = "javax.xml.parsers.*, org.w3c.dom.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>죽일놈의 와이파이</title>
</head>
<body>
<h1>와이파이</h1>
<%
//파싱을 위한 준비과정
DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
String file = application.getRealPath("wifi.xml");
Document doc = docBuilder.parse(file);

Element root = doc.getDocumentElement();
NodeList address = doc.getElementsByTagName("소재지지번주소");
NodeList latitude = doc.getElementsByTagName("위도");
NodeList longitude = doc.getElementsByTagName("경도");
%>
<table border="1" style="width: 100%;">
	<colgroup>
		<col style="width: 10%;"/>
		<col style="width: 60%;"/>
		<col style="width: 15%;"/>
		<col style="width: 15%;"/>
	</colgroup>
	<thead>
		<tr>
			<th>순번</th>
			<th>소재지지번주소</th>
			<th>위도</th>
			<th>경도</th>
		</tr>
	</thead>
	<tbody>
<%
for(int i = 0; i < address.getLength(); i++) {
%>
		<tr>
			<td><%=i + 1 %></td>
<%
	if(address.item(i).getFirstChild() != null) {
%>
			<td><%=address.item(i).getFirstChild().getNodeValue() %></td>
<%
	} else {
%>
			<td>주소가 없습니다.</td>
<%
	}
%>
			<td><%=latitude.item(i).getFirstChild().getNodeValue() %></td>
			<td><%=longitude.item(i).getFirstChild().getNodeValue() %></td>
		</tr>
<%
}
%>
	</tbody>
</table>
</body>
</html>