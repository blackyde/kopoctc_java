<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.book.dao.*" %>
<%@ page import = "com.book.dto.*" %>
<%@ page import = "java.sql.*" %>
<%
request.setCharacterEncoding("UTF-8");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

String name = request.getParameter("name");
String resv_date = request.getParameter("resv_date") + " 00:00:00.0";
String rooms = request.getParameter("room");
int room = 0;
switch(rooms) {
case "금수저룸" :
	room = 1;
	break;
case "은수저룸" :
	room = 2;
	break;
default :
	room = 3;
}
String addr = request.getParameter("addr");
String telnum = request.getParameter("telnum");
String in_name = request.getParameter("in_name");
String comment = request.getParameter("comment");
String password = request.getParameter("password");

BookDao bd = new BookDaoImpl();
Book b = new Book();
b.setName(name);
b.setResv_date(Timestamp.valueOf(resv_date));
b.setRoom(room);
b.setAddr(addr);
b.setTelnum(telnum);
b.setIn_name(in_name);
b.setComment(comment);
b.setPassword(password);

b = bd.insert(b);
%>
<form method="post" name="fr" action="/Resort/">
	<input type="hidden" name="room" value="<%=room %>">
	<input type="hidden" name="resv_date" value="<%=resv_date %>">
	<input type="hidden" name="contentPage" value="book/bookingResult.jsp">
</form>
<script>
fr.submit();
</script>