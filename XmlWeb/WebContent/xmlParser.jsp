<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*, javax.sql.*, java.io.*, java.net.*" %>
<%@ page import = "javax.xml.parsers.*, org.w3c.dom.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>성적 조회</h1>
<%
//파싱을 위한 준비과정
DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
String file = application.getRealPath("testdata.xml");
Document doc = docBuilder.parse("http://localhost:8080/XmlParse/xmlmake.jsp");

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
</body>
</html>