<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
List<String> list = new ArrayList<String>();

list.add("test1");
list.add("test2");
list.add("test3");

request.setAttribute("list", list);
%>
</body>
<jsp:forward page="test3.jsp" />
</html>