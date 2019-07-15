<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String select = request.getParameter("select");
	if(select == null) {
		select = "home";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
input[type=submit].nav {
	display: block;
	font-size: 15px;
	border: 1px solid blue;
	text-decoration: none;
	width: 100px;
	height: 50px;
	text-align: center;
	float: left;
	background: white;
}
.select {
	background: yellow !important;
}
</style>
<script>
var selected = "<%=select %>";
window.onload = function() {
    document.getElementById(selected).classList.add("select");
}
</script>
</head>
<body>
	<div>
		<form method="post" action="/Vote/">
			<input type="hidden" value="home" name="select">
			<input type="hidden" value="hello.jsp" name="contentPage">
			<input type="submit" class="nav" id="home" value="HOME">
		</form>
		<form method="post" action="/Vote/">
			<input type="hidden" value="candidate" name="select">
			<input type="hidden" value="candidate.jsp" name="contentPage">
			<input type="submit" class="nav" id="candidate" value="후보등록">
		</form>
		<form method="post" action="/Vote/">
			<input type="hidden" value="vote" name="select">
			<input type="hidden" value="vote.jsp" name="contentPage">
			<input type="submit" class="nav" id="vote" value="투표">
		</form>
		<form method="post" action="/Vote/">
			<input type="hidden" value="result" name="select">
			<input type="hidden" value="result.jsp" name="contentPage">
			<input type="submit" class="nav" id="result" value="개표결과">
		</form>
		
	</div>	
	<div style="clear: both;"></div>
</body>
</html>