<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.jsp0709.Connector"%>
<%!public static final Connection CONN = Connector.getConnection();%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String studentid = request.getParameter("studentid");
	if(studentid == null) {
		response.sendRedirect("?contentPage=AllviewDB.jsp");
	}
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
	text-align: center;
}
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<table>
		<colgroup>
			<col style="width:80px;" />
			<col style="width:80px;" />
			<col style="width:80px;" />
			<col style="width:80px;" />
			<col style="width:80px;" />
		</colgroup>
		<thead>
			<tr>
				<th>이름</th>
				<th>학번</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
			</tr>
		</thead>
		<tbody>
			<%
				String sql = "SELECT * FROM examtable WHERE studentid = ?";
				PreparedStatement pstmt = CONN.prepareStatement(sql);
				pstmt.setString(1, studentid);

				ResultSet rset = pstmt.executeQuery();
				while (rset.next()) {
					out.print("<tr>"
							+ "<td>" + rset.getString(1) + "</td>"
							+ "<td>" + rset.getInt(2) + "</td>"
							+ "<td>" + rset.getInt(3) + "</td>"
							+ "<td>" + rset.getInt(4) + "</td>"
							+ "<td>" + rset.getInt(5) + "</td>"
							+ "</tr>");
				}

				rset.close();
				pstmt.close();
			%>
		</tbody>
	</table>
	<p></p>
	<a href="?contentPage=AllviewDB.jsp">전체보기로 돌아가기</a>
</body>
</html>