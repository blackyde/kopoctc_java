<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.board.dto.*" %>
<%@ page import = "com.board.dao.*" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String subject = request.getParameter("subject");
	String contents = request.getParameter("contents");
	if(subject == null || contents == null) {
		response.sendRedirect("/ReBoard/");
	}
	
	subject = subject.replaceAll(";", "&#59;");
	subject = subject.replaceAll("'", "&#39;");
	contents = contents.replaceAll(";", "&#59;");
	contents = contents.replaceAll("'", "&#39;");
	
	BoardDao<Board> bb = new BoardDaoImpl();
	Board b = new Board();
	b.setSubject(subject);
	b.setContents(contents);
	bb.insert(b);
	
%>
<form method="post" action="/ReBoard/" name="fr">
	<input type="hidden" name="contentPage" value="list.jsp">
</form>
<script>
fr.submit();
</script>