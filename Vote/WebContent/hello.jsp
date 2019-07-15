<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.vote.*, java.sql.*"%>
<%!public static final Connection CONN = Connector.getConnection();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%
		Calendar cal = Calendar.getInstance();
		out.print(cal.getTime());
		
		String sql = "SELECT counter FROM counter WHERE name = 'vote'";
		Statement stmt = CONN.createStatement();
		int counter = 0;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				counter = rs.getInt(1);
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		counter++;
	%>
	<br><br>
	현재 홈페이지 방문조회수는 [<%=counter %>] 입니다.
	<br>
	<%
		sql = String.format("UPDATE counter SET counter = %d WHERE name = '%s'", counter, "vote");
		try {
			stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
		stmt.close();
	%>
	<img src="https://vignette.wikia.nocookie.net/pokemon/images/2/2c/%EC%9E%A0%EB%A7%8C%EB%B3%B4_%ED%94%BC%EA%B7%9C%EC%96%B4_Wii_U.png/revision/latest?cb=20160902132618&format=original&path-prefix=ko">
</body>
</html>