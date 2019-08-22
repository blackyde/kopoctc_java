<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*, javax.sql.*, java.io.*, java.net.*" %>
<%
//CORS policy 해결
response.setHeader("Access-Control-Allow-Origin", "*");

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
rs.last();
int row = rs.getRow();
rs = pstmt.executeQuery();
int i = 0;
%>
{"twice" : [
<%
while(rs.next()) {
	i++;
%>
	{
		"name" : "<%=rs.getString("name") %>",
		"studentid" : "<%=rs.getInt("studentid") %>",
		"kor" : "<%=rs.getInt("kor") %>",
		"eng" : "<%=rs.getInt("eng") %>",
		"mat" : "<%=rs.getInt("mat") %>"
	}<%=i == row ? "" : ","%>
<%
}
%>
]}
<%
rs.close();
pstmt.close();
conn.close();
%>