<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.jsp0709.Connector"%>
<%@ page import="java.util.*" %>
<%!public static final Connection CONN = Connector.getConnection();%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String name = request.getParameter("name");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int mat = Integer.parseInt(request.getParameter("mat"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table, tr, th, td {
	border: 1px solid #000000;
	border-collapse: collapse;
	padding: 5px;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<table>
		<colgroup>
			<col style="width: 60px;" />
			<col style="width: 400px;" />
		</colgroup>
		<%
			String sql = "SELECT * FROM examtable";
			PreparedStatement pstmt = CONN.prepareStatement(sql);

			ResultSet rset = pstmt.executeQuery();
			int studentid = 209901;
			while (rset.next()) {
				if(studentid == rset.getInt(2)) {
					studentid++;
				}
			}
			
			sql = String.format(
					"INSERT INTO examtable(name, studentid, kor, eng, mat)"
					+ "VALUES('%s', %d, %d, %d, %d)", name, studentid, kor, eng, mat);
			pstmt = CONN.prepareStatement(sql);
			try {
				pstmt.executeUpdate(sql);
				sql = String.format("SELECT * FROM examtable WHERE studentid = %d",
						studentid);
				pstmt = CONN.prepareStatement(sql);
				rset = pstmt.executeQuery();
				while (rset.next()) {
					out.print("<tr><th>이름</th>");
					out.print("<td>" + rset.getString(1) + "</td></tr>");
					out.print("<tr><th>학번</th>");
					out.print("<td>" + rset.getInt(2) + "</td></tr>");
					out.print("<tr><th>국어</th>");
					out.print("<td>" + rset.getInt(3) + "</td></tr>");
					out.print("<tr><th>영어</th>");
					out.print("<td>" + rset.getInt(4) + "</td></tr>");
					out.print("<tr><th>수학</th>");
					out.print("<td>" + rset.getInt(5) + "</td></tr>");
				}
				out.print("<tr><td colspan='2'>입력 되었습니다.</td></tr>");
			} catch(Exception e) {
				out.print("<tr><td colspan='2'>입력이 실패했습니다.</td></tr>");
				e.printStackTrace();
			}
			
			rset.close();
			pstmt.close();
		%>
	</table>
	<p></p>
	<a href="?contentPage=AllviewDB.jsp">전체보기로 돌아가기</a>
</body>
</html>