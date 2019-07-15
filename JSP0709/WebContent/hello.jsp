<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.jsp0709.*, java.sql.*"%>
<%!public static final Connection CONN = Connector.getConnection();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>7월 9일 JSP 시작</title>
</head>
<body>
	<h1>JSP Database 실습 1</h1>	
	<%
		Calendar cal = Calendar.getInstance();
		out.print(cal.getTime());
		
		String sql = "SELECT counter FROM counter WHERE name = 'exam'";
		Statement stmt = CONN.createStatement();
		int counter = 0;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				counter = rs.getInt(1);
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		counter++;
		
		
		//파일을 이용한 카운터는 이제 그만
		/*String data;
		int cnt = 0;
		
		String file = application.getRealPath("/home/cnt.txt");
		
		FileReader fr = new FileReader(file);
		StringBuffer sb = new StringBuffer();
		
		int ch = 0;
		while((ch = fr.read()) != -1) {
			sb.append((char)ch);
		}
		data = sb.toString().trim().replace("\n", "");
		fr.close();
		
		cnt = Integer.parseInt(data);
		cnt++;
		data = Integer.toString(cnt);*/
	%>
	<br><br>
	현재 홈페이지 방문조회수는 [<%=counter %>] 입니다.
	<br>
	<%
		sql = String.format("UPDATE counter SET counter = %d WHERE name = '%s'", counter, "exam");
		try {
			stmt.executeUpdate(sql);
		} catch(Exception e) {
			e.printStackTrace();
		}
		stmt.close();
		/*FileWriter fw = new FileWriter(file, false);
		fw.write(data);
		fw.close();*/
	%>
	<img src="https://vignette.wikia.nocookie.net/pokemon/images/2/2c/%EC%9E%A0%EB%A7%8C%EB%B3%B4_%ED%94%BC%EA%B7%9C%EC%96%B4_Wii_U.png/revision/latest?cb=20160902132618&format=original&path-prefix=ko">
</body>
</html>