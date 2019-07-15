<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.jsp0709.Connector"%>
<%!public static final Connection CONN = Connector.getConnection();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>

	<%
		String[] sql = new String[9];
		sql[0] = "INSERT INTO examtable(name, studentid, kor, eng, mat) VALUES('나연', 209901, 95, 100, 95)";
		sql[1] = "INSERT INTO examtable(name, studentid, kor, eng, mat) VALUES('정연', 209902, 100, 100, 100)";
		sql[2] = "INSERT INTO examtable(name, studentid, kor, eng, mat) VALUES('모모', 209903, 100, 90, 100)";
		sql[3] = "INSERT INTO examtable(name, studentid, kor, eng, mat) VALUES('사나', 209904, 100, 95, 90)";
		sql[4] = "INSERT INTO examtable(name, studentid, kor, eng, mat) VALUES('지효', 209905, 80, 100, 70)";
		sql[5] = "INSERT INTO examtable(name, studentid, kor, eng, mat) VALUES('미나', 209906, 95, 90, 95)";
		sql[6] = "INSERT INTO examtable(name, studentid, kor, eng, mat) VALUES('다현', 209907, 100, 90, 100)";
		sql[7] = "INSERT INTO examtable(name, studentid, kor, eng, mat) VALUES('채영', 209908, 100, 75, 90)";
		sql[8] = "INSERT INTO examtable(name, studentid, kor, eng, mat) VALUES('쯔위', 209909, 100, 100, 70)";
		Statement stmt = CONN.createStatement();
		int cnt = 0;
		
		for(int i = 0; i < sql.length; i++) {
			try {
				stmt.executeUpdate(sql[i]);
				cnt++;				
			} catch(Exception e) {
				continue;
			}
		}
		
		out.print(cnt + "행이 입력 되었습니다.");
		
		
		stmt.close();
	%>

</body>
</html>