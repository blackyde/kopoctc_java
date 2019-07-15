<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.jsp0709.Connector"%>
<%!public static final Connection CONN = Connector.getConnection();%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	int studentid = Integer.parseInt(request.getParameter("studentid"));
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
	<h2>레코드 삭제</h2>
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
				Statement stmt = CONN.createStatement();
				String sql = String.format("DELETE FROM examtable WHERE studentid = %d", studentid);
				stmt.executeUpdate(sql);
				ResultSet rset = null;
				try {
					rset = stmt.executeQuery("SELECT * FROM examtable");
					while (rset.next()) {
			%>
			<tr>
				<td>
					<a href="?contentPage=oneview.jsp?studentid=<%=rset.getInt(2) %>"><%=rset.getString(1) %></a>
				</td>
				<td><%=rset.getInt(2) %></td>
				<td><%=rset.getInt(3) %></td>
				<td><%=rset.getInt(4) %></td>
				<td><%=rset.getInt(5) %></td>
			</tr>
			<%
					}
				} catch(Exception e) {
					out.print("<tr><td colspan='5'>테이블이 없습니다.</td></tr>");
				}
				if(rset != null) {
					rset.close();
				}
				stmt.close();
			%>
		</tbody>
	</table>

</body>
</html>