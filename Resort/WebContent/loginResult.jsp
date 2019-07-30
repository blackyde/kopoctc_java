<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.board.connector.*" %>
<%!
public static class LoginCheck {
	final static Connection CONN = Connector.getConnection();
	public static boolean check(String id, String password) {
		
		String sql = String.format("SELECT id FROM member WHERE PASSWORD('%s') = auth_string", password);
		
		try {
			Statement stmt = CONN.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs != null) {
				while(rs.next()) {
					if(id.equals(rs.getString(1))) {
						return true;
					} else {
						return false;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
%>
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	if(id == null || id.length() < 1) {
		session.setAttribute("isLogin", false);
%>
<script>alert('ID를 입력해주세요');</script>
<form method="post" action="/Resort/" name="fr">
	<input type="hidden" name="contentPage" value="login.jsp">
</form>
<script>
fr.submit();
</script>
<%
	} else if(password == null || password.length() < 8) {
		session.setAttribute("isLogin", false);
%>
<script>alert('PASSWORD를 8글자 이상 입력해주세요');</script>
<form method="post" action="/Resort/" name="fr">
	<input type="hidden" name="contentPage" value="login.jsp">
</form>
<script>
fr.submit();
</script>
<%
	} else {
		boolean isLogin = LoginCheck.check(id, password);
		if(isLogin) {
			session.setAttribute("isLogin", true);
%>
<script>alert('로그인 성공!');</script>
<form method="post" action="/Resort/" name="fr">
</form>
<script>
fr.submit();
</script>
<%
		} else {
			session.setAttribute("isLogin", false);
%>
<script>alert('ID와 PASSWORD를 다시 확인해주세요.');</script>
<form method="post" action="/Resort/" name="fr">
	<input type="hidden" name="contentPage" value="login.jsp">
</form>
<script>
fr.submit();
</script>
<%
		}
	}
%>