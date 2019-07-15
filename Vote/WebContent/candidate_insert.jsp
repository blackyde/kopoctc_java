<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vote.*, java.sql.*, java.util.*"%>
<%!public static final Connection CONN = Connector.getConnection();%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String ids = request.getParameter("id");
	String name = request.getParameter("name");
	String group = request.getParameter("group");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<%
	int id = Integer.parseInt(ids);
	String sql = String.format("INSERT INTO hubo VALUES(%d, '%s', '%s')", id, name, group); 
	Statement stmt = CONN.createStatement();
	try {
		stmt.executeUpdate(sql);
	} catch(Exception e) {
		e.printStackTrace();
	}
	sql = String.format("INSERT INTO vote(id) VALUES(%d)", id);
	try {
		stmt.executeUpdate(sql);
	} catch(Exception e) {
		e.printStackTrace();
	}
	out.print("<h3>후보가 등록되었습니다.</h3>");
	stmt.close();
%>
</body>
</html>