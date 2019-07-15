<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vote.*, java.sql.*, java.util.*"%>
<%!public static final Connection CONN = Connector.getConnection();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
div.vote {
	display: inline-block;
	border: 1px solid #000000;
	padding: 10px;
}
</style>
<script>
function check() {
	if(document.getElementById("candidateList").value.length < 1) {
		return false;
	}
	if(document.getElementById("ageList").value.length < 1) {
		return false;
	}
	return true;
}
</script>
</head>
<body>
	<h2>투표</h2>
	
	<%
		String sql = "SELECT * FROM hubo";
		Statement stmt = CONN.createStatement();
		List<Candidate> lc = new ArrayList<Candidate>();
		
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Candidate candi = new Candidate(rs.getInt(1), rs.getString(2), rs.getString(3));
				lc.add(candi);
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	%>
	<div class="vote">
		<form method="post" action="/Vote/" onsubmit="return check()">
			<select name="candidateList" id="candidateList">
				<option value="">후보선택</option>
	<%
		for(Candidate candi : lc) {
	%>
				<option value="<%=candi.getId()%>"><%=candi.getName() %></option>
	<%
		}
	%>
			</select>
			
			<select name="ageList" id="ageList">
			    <option value="">연령선택</option>
	<%
		for(int i = 10; i <= 90; i += 10) {
			int value = i / 10;
	%>
		    	<option value="<%=value%>"><%=i %>대</option>
	<%
		}
	%>
			</select>
			<input type="hidden" value="vote" name="select">
			<input type="hidden" value="vote_result.jsp" name="contentPage">
			<input type="submit" value="투표하기">
		</form>
	</div>
	
	
</body>
</html>