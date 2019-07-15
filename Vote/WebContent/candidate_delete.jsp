<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.vote.*"%>
<%!public static final Connection CONN = Connector.getConnection();%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	int id = Integer.parseInt(request.getParameter("id"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%
		Statement stmt = CONN.createStatement();
		String sql = String.format("DELETE FROM hubo WHERE id = %d", id);
		stmt.executeUpdate(sql);
	%>
	<h3>후보가 삭제 되었습니다.</h3>
	<%		
		stmt.close();
	%>
</body>
</html>