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
<title>투표 시스템</title>
<link rel="shortcut icon" href="/Vote/favicon.ico" type="image/x-icon">
<link rel="icon" href="/Vote/favicon.ico" type="image/x-icon">
</head>
<body>
	<div style="padding: 20px;">
        <jsp:include page="header.jsp" />
    </div>
    <div>
        <jsp:include page="<%=contentPage %>" />
    </div>
</body>
</html>