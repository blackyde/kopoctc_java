<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("isLogin", false);
%>
<form method="post" action="/Resort/" name="fr">
	<input type="hidden" name="contentPage" value="main.jsp">
</form>
<script>
fr.submit();
</script>