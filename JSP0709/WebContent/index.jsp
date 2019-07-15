<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String contentPage = request.getParameter("contentPage");
	if(contentPage == null) {
		contentPage = "hello.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>0709 DB 연동</title>
<link rel="shortcut icon" href="/JSP0709/favicon.ico" type="image/x-icon">
<link rel="icon" href="/JSP0709/favicon.ico" type="image/x-icon">
</head>
<body>
	<div style="float:left; width:260px; height:100vh; border-right: 1px solid #000000;">
        <jsp:include page="menu.html" />
    </div>
    <div style="margin:0 0 0 260px; height:100vh; padding: 15px 0 0 15px;">
        <jsp:include page="<%=contentPage %>" />
    </div>
</body>
</html>