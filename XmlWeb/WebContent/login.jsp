<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String username = request.getParameter("username");
String userpasswd = request.getParameter("userpasswd");
String rtn_url = request.getParameter("rtn_url");
String logincnt = request.getParameter("logincnt");
if(logincnt == null) logincnt = "0";
if(username == null) username = "";
if(userpasswd == null) userpasswd = "";
if(rtn_url == null) rtn_url = "";

if(username.equals("kopoctc") && userpasswd.equals("kopoctc")) {
	session.setAttribute("loginOK", "YES");
	response.sendRedirect(rtn_url);
} else {
	session.setAttribute("loginOK", "NO");
	logincnt = Integer.toString(Integer.parseInt(logincnt) + 1);
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form method="post" action="login.jsp">
	이름 : <input type="text" name="username"><br>
	비밀번호 : <input type="password" name="userpasswd"><br>
	<input type="hidden" name="logincnt" value="<%=logincnt %>"><br>
	<input type="hidden" name="rtn_url" value="<%=rtn_url %>"><br>
	<input type="submit" value="전송">
</form>
로그인 시도 횟수 <%=logincnt %>회 입니다. <br>
rtn_url <%=rtn_url %> 입니다. <br>
</body>
</html>