<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%@ page import = "com.book.dao.*" %>
<%@ page import = "com.book.dto.*" %>
<%@ page import = "java.sql.*" %>
<%
request.setCharacterEncoding("UTF-8");

String rooms = request.getParameter("room");
String resv_date = request.getParameter("resv_date");
%>
<form method="post" name="bookForm" action="/Resort/">
	<input type="hidden" name="resv_date" value="<%=resv_date %>">
	<input type="hidden" name="room" value="<%=rooms %>">
	<input type="hidden" name="contentPage" value="book/viewReal.jsp">
	<input type="hidden" name="password">
</form>
<script>pass();</script>