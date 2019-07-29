<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.reboard.dto.*" %>
<%@ page import = "com.reboard.dao.*" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String contentPage = request.getParameter("contentPage");
	if(contentPage == null) {
		contentPage = "list.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<link rel="shortcut icon" href="/Vote/favicon.ico" type="image/x-icon">
<link rel="icon" href="/Vote/favicon.ico" type="image/x-icon">
<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 

<!-- include summernote css/js -->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>

<link rel="stylesheet" href="css/style.css">
<script src="js/script.js"></script>
</head>
<body>
<jsp:include page="<%=contentPage %>" />
</body>
</html>