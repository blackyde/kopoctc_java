<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.book.dao.*" %>
<%@ page import = "com.book.dto.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.Timestamp"%>
<%
request.setCharacterEncoding("UTF-8");
boolean isLogin = false;
Object obj = session.getAttribute("isLogin");
if(obj != null) {
	isLogin = (boolean)session.getAttribute("isLogin");
}
if(isLogin) {
	request.setCharacterEncoding("UTF-8");
	String resv_dates = request.getParameter("resv_date");
	String rooms = request.getParameter("room");
	String process = request.getParameter("process");
	
	Timestamp resv_date = Timestamp.valueOf(resv_dates);
	int room = Integer.parseInt(rooms);
	int processing = Integer.parseInt(process);
	
	BookDao bd = new BookDaoImpl();
	Book b = new Book();
	b.setResv_date(resv_date);
	b.setRoom(room);
	b.setProcessing(processing);
	
	b = bd.update(b);
	
%>
<form method="post" action="/Resort/" name="fr">
	<input type="hidden" name="contentPage" value="admin/list.jsp">
</form>
<script>
fr.submit();
</script>
<%
} else {
%>
<script>
location.href="/Resort/";
</script>
<%
	//response.sendRedirect("/Resort/");
}
%>