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
Object obj = request.getAttribute("list");
ArrayList<?> list = (ArrayList<?>) obj;
for(int i = 0; i < list.size(); i++) {
	out.print(list.get(i));
}
%>
</body>
</html>