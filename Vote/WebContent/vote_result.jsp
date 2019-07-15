<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vote.*, java.sql.*, java.util.*"%>
<%!public static final Connection CONN = Connector.getConnection();%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String candidateId = request.getParameter("candidateList");
	String ages = "age" + request.getParameter("ageList");
	int idx = Integer.parseInt(request.getParameter("ageList")); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h2>투표 결과</h2>
	<%
		Statement stmt = CONN.createStatement();
		int id = Integer.parseInt(candidateId);
		String sql = String.format("UPDATE vote SET `%s` = `%s` + 1 WHERE id = %d",
				ages, ages, id);
		try {
			stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
		stmt.close();
	%>
	<h3>투표가 잘 되었습니다.</h3>
</body>
</html>