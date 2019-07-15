<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vote.*, java.sql.*, java.util.*"%>
<%!public static final Connection CONN = Connector.getConnection();%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String ids = request.getParameter("id");
	int id = Integer.parseInt(ids);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table, tr, th, td {
	border: 1px solid #000000;
	border-collapse: collapse;
}
th, td {
	padding: 8px;
	font-size: 14px;
}
span.bar {
	display: inline-block;
	height: 12px;
	margin: 0px;
}
</style>
</head>
<body>
	<%
		Statement stmt = CONN.createStatement();
		String sql = String.format("SELECT * FROM vote WHERE id = %d", id);	
		Vote vt = null;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				vt = new Vote(rs.getInt(1),
						rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getInt(5), rs.getInt(6), rs.getInt(7),
						rs.getInt(8), rs.getInt(9), rs.getInt(10));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		sql = String.format("SELECT * FROM hubo WHERE id = %d", id);
		Candidate candi = null;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				candi = new Candidate(rs.getInt(1),
						rs.getString(2), rs.getString(3));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		int total = 0;
		if(vt.getAllAge() == 0) {
			total = 1;
		} else {
			total = vt.getAllAge();
		}
		
		int[] vote = {vt.getAge1(), vt.getAge2(), vt.getAge3(), vt.getAge4()
				,vt.getAge5(), vt.getAge6(), vt.getAge7(), vt.getAge8(), vt.getAge9()};
		
	%>
	<h3>기호 <%=candi.getId() %>번 <%=candi.getName() %> 후보 득표성향 분석</h3>
	<table>
		
	<%
		int percent = 0;
		for(int i = 0; i < vote.length; i++) {
			String r = String.format("%02X", (int)(Math.random() * 256));
			String g = String.format("%02X", (int)(Math.random() * 256));
			String b = String.format("%02X", (int)(Math.random() * 256));
			String rgb = r + g + b;
			int age = (i + 1) * 10;
	%>
		<tr>
			<th><%=age %>대</th>
			<td>
			<%
				percent = (int)((vote[i] / (double)total) * 100);
			%>
				<span class="bar" style="width:<%=percent * 3 %>px; background: #<%=rgb%>"></span>
			<%
				out.print(vote[i]);
				out.print(" (");
				out.print(percent);
				out.print("%)");
			%>
			</td>
		</tr>
	<%
		}
	%>
		
	</table>
</body>
</html>