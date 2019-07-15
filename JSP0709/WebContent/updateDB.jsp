<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.jsp0709.Connector"%>
<%!public static final Connection CONN = Connector.getConnection();%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String name = request.getParameter("name");
	int studentid = Integer.parseInt(request.getParameter("studentid"));
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
	text-align: center;
}
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<h2>레코드 수정</h2>
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
				String sql = String.format(
						"UPDATE examtable SET name='%s', kor=%d, eng=%d, mat=%d WHERE studentid=%d",
						name, kor, eng, mat, studentid);
				stmt.executeUpdate(sql);
				ResultSet rset = null;
				try {
					rset = stmt.executeQuery("SELECT * FROM examtable");
					while (rset.next()) {
						if(rset.getInt(2) == studentid) {
			%>
			<tr>
				<td style="background: yellow;">
					<a href="?contentPage=oneview.jsp?studentid=<%=rset.getInt(2) %>"><%=rset.getString(1) %></a>
				</td>
				<td style="background: yellow;"><%=rset.getInt(2) %></td>
				<td style="background: yellow;"><%=rset.getInt(3) %></td>
				<td style="background: yellow;"><%=rset.getInt(4) %></td>
				<td style="background: yellow;"><%=rset.getInt(5) %></td>
			</tr>
			<%
						} else {
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