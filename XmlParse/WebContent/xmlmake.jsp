<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE xml>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*, javax.sql.*, java.io.*, java.net.*" %>
<%
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
	System.out.println("Driver 로드 실패");
}
final String USERNAME = "root";
final String PASSWORD = "Dptmzbdpf12!@";
final String ADDRESS = "35.221.189.227";
final String DB_NAME = "jsp";

Connection conn = null;
try {
	conn = DriverManager.getConnection("jdbc:mysql://" + ADDRESS + "/" + DB_NAME, USERNAME, PASSWORD);
} catch (SQLException e) {
	System.out.println("DB 연결 실패");
}

String sql = "SELECT * FROM examtable";
PreparedStatement pstmt = conn.prepareStatement(sql);
ResultSet rs = pstmt.executeQuery();
%>
<datas>
<%
while(rs.next()) {
%>
	<data>
		<name><%=rs.getString("name") %></name>
		<studentid><%=rs.getInt("studentid") %></studentid>
		<kor><%=rs.getInt("kor") %></kor>
		<eng><%=rs.getInt("eng") %></eng>
		<mat><%=rs.getInt("mat") %></mat>
	</data>
<%
}
%>
</datas>
<%
rs.close();
pstmt.close();
conn.close();
%>