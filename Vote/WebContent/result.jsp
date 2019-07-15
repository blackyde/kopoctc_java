<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vote.*, java.sql.*, java.util.*"%>
<%!public static final Connection CONN = Connector.getConnection();%>
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
	text-align: left;
}
span.bar {
	display: inline-block;
	height: 12px;
	margin: 0px;
}
input.btnCandidate {
	background: none;
	border: 0;
	cursor: pointer;
}
</style>
</head>
<body>
	<h2>후보 별 득표율</h2>
	<%
		Statement stmt = CONN.createStatement();
		String sql = String.format("SELECT * FROM vote");	
		List<Vote> lv = new ArrayList<Vote>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Vote vt = new Vote(rs.getInt(1),
						rs.getInt(2), rs.getInt(3), rs.getInt(4),
						rs.getInt(5), rs.getInt(6), rs.getInt(7),
						rs.getInt(8), rs.getInt(9), rs.getInt(10));
				lv.add(vt);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		sql = String.format("SELECT * FROM hubo");
		List<Candidate> lc = new ArrayList<Candidate>();
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Candidate candi = new Candidate(rs.getInt(1),
						rs.getString(2), rs.getString(3));
				lc.add(candi);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		int sumTotal = 0;
		for(int i = 0; i < lv.size(); i++) {
			sumTotal += lv.get(i).getAllAge();
		}
		if(sumTotal == 0) {
			sumTotal = 1;
		}
	%>
	<table>
	<%
		for(Candidate candi : lc) {
			String r = String.format("%02X", (int)(Math.random() * 256));
			String g = String.format("%02X", (int)(Math.random() * 256));
			String b = String.format("%02X", (int)(Math.random() * 256));
			String rgb = r + g + b;
			int width = (int)((lv.get(candi.getId() - 1).getAllAge() / (double)sumTotal) * 100) * 3;
	%>
		<tr>
			<th>
				<form method="post" action="/Vote/">
					<input type="hidden" value="result" name="select">
					<input type="hidden" value="<%=candi.getId() %>" name="id">
					<input type="hidden" value="result_indi.jsp" name="contentPage">
					<input type="submit"
						value="<%=candi.getId() + " " + candi.getName() %>"
						class="btnCandidate">
				</form>
			</th>
			<td>
				<span class="bar" style="width:<%=width %>px; background: #<%=rgb%>"></span>
	<%
			out.print(lv.get(candi.getId() - 1).getAllAge());
			out.print(" ("
			+ (int)((lv.get(candi.getId() - 1).getAllAge() / (double)sumTotal) * 100)
			+ "%)");
	%>
			</td>
		</tr>
	<%			
		}
	%>
		
	</table>
</body>
</html>