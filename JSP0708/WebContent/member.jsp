<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String name = request.getParameter("username");
	String password = request.getParameter("userpasswd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	이름 : <%=name %><br>
	비밀번호 : <%=password %><br>
</body>
</html>