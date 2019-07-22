<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.board.dto.*" %>
<%@ page import = "com.board.dao.*" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String subject = request.getParameter("subjectFinal");
	String contents = request.getParameter("contentsFinal");
	String rootids = request.getParameter("rootid");
	String relevels = request.getParameter("relevel");
	String recnts = request.getParameter("recnt");
	int rootid = Integer.parseInt(rootids);
	int relevel = Integer.parseInt(relevels);
	int recnt = Integer.parseInt(recnts);
	BoardDao<Board> bb = new BoardDaoImpl();
	Board b = new Board(subject, contents, rootid, relevel);
	b.setRecnt(recnt);
	bb.reCnt(b);
	bb.reInsert(b);
	
%>
<form method="post" action="/ReBoard/" name="fr">
	<input type="hidden" name="contentPage" value="list.jsp">
</form>
<script>
fr.submit();
</script>