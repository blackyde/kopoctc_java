<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.jsp0709.Connector"%>
<%!public static final Connection CONN = Connector.getConnection();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<%
		Statement stmt = CONN.createStatement();
		try {
			stmt.executeUpdate("DROP TABLE examtable");
			out.print("테이블이 삭제 되었습니다.");
		} catch(Exception e) {
			out.print("테이블이 없거나 삭제되지 않았습니다.");
		}
		stmt.close();
	%>

</body>
</html>