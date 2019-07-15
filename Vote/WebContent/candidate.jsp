<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.vote.*, java.sql.*, java.util.*"%>
<%!public static final Connection CONN = Connector.getConnection();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//code.jquery.com/jquery.min.js"></script>
<style>
table, tr, th, td {
	border: 1px solid #000000;
	border-collapse: collapse;
}
th, td {
	padding: 8px;
	font-size: 14px;
}
.number {
	width: 10px;
	border: 0px;
}
.name {
	width: 50px;
}
.group {
	width: 120px;
}
</style>
<script>
function check() {
	if(document.getElementById("readname").value.length > 10) {
		document.getElementById("readname").value = "";
		document.getElementById("readname").focus();
	}
	if(document.getElementById("readname").value.length < 1
			|| document.getElementById("readname").value.trim() < 1) {
		document.getElementById("readname").focus();
		return false;
	}
	if(document.getElementById("readgroup").value.length > 10) {
		document.getElementById("readgroup").value = "";
		document.getElementById("readgroup").focus();
	}
	if(document.getElementById("readgroup").value.length < 1
			|| document.getElementById("readgroup").value.trim() < 1) {
		document.getElementById("readgroup").focus();
		return false;
	}
	
	setname();
	setgroup();
	return true;
}
function setname() {
	document.getElementById("name").value = document.getElementById("readname").value.trim();
}
function setgroup() {
	document.getElementById("group").value = document.getElementById("readgroup").value.trim();
}
</script>
</head>
<body>
<h2>후보등록</h2>
<table>
	<%
	String sql = "SELECT * FROM hubo";
	Statement stmt = CONN.createStatement();
	int huboid = 1;
	
	try {
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			if(huboid == rs.getInt(1)) {
				huboid++;
			}
			
	%>
	<tr>
		<th>기호</th>
		<td><%=rs.getInt(1) %></td>
		<th>이름</th>
		<td><%=rs.getString(2) %></td>
		<th>소속</th>
		<td><%=rs.getString(3) %></td>
		<td>
			<form method="post" action="/Vote/">
				<input type="hidden" value="<%=rs.getInt(1) %>" name="id">
				<input type="hidden" value="candidate" name="select">
				<input type="hidden" value="candidate_delete.jsp" name="contentPage">
				<input type="submit" value="삭제">
			</form>
		</td>
	</tr>
	<%
		}
		rs.close();
	} catch(Exception e) {
		e.printStackTrace();
	}
	
	%>
	<tr>
		<th>기호</th>
		<td><input type="text" value="<%=huboid %>" class="number" name="readid" readonly></td>
		<th>이름</th>
		<td>
			<input type="text" class="name" name="readname" id="readname">
			<script>    
			// 입력을 제한 할 특수문자의 정규식			
			var replaceId = /[<>()!0-9/*@#$%^&+_='"\-\\?]/gi;

			$(document).ready(function() {

				$("#readname").on("focusout", function() {
					var x = $(this).val();
					if (x.length > 0) {
						if (x.match(replaceId)) {
							x = x.replace(replaceId, "");
						}
						$(this).val(x);
					}
				}).on("keyup", function() {
					$(this).val($(this).val().replace(replaceId, ""));

				});

			});
			</script>
		</td>
		<th>소속</th>
		<td>
			<input type="text" class="group" name="readgroup" id="readgroup">
			<script>    
			// 입력을 제한 할 특수문자의 정규식			
			var replaceId = /[<>()!0-9/*@#$%^&+_='"\-\\?]/gi;

			$(document).ready(function() {

				$("#readgroup").on("focusout", function() {
					var x = $(this).val();
					if (x.length > 0) {
						if (x.match(replaceId)) {
							x = x.replace(replaceId, "");
						}
						$(this).val(x);
					}
				}).on("keyup", function() {
					$(this).val($(this).val().replace(replaceId, ""));

				});

			});
			</script>
		</td>
		<td>
			<form method="post" action="/Vote/" onsubmit="return check()">
				<input type="hidden" value="<%=huboid %>" name="id">
				<input type="hidden" name="name" id="name">
				<input type="hidden" name="group" id="group">
				<input type="hidden" value="candidate" name="select">
				<input type="hidden" value="candidate_insert.jsp" name="contentPage">
				<input type="submit" value="추가">
			</form>
		</td>
	</tr>
	
</table>
</body>
</html>