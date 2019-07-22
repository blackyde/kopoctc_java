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
	int rootid = Integer.parseInt(rootids);
	int relevel = Integer.parseInt(relevels);
	BoardDao<Board> bb = new BoardDaoImpl();
	Board b = new Board(subject, contents, rootid, relevel);
	bb.insert(b);
	List<Board> lb = bb.selectDesc();
	
%>
<form method="post" action="/ReBoard/" name="fr">
	<input type="hidden" name="contentPage" value="item.jsp">
	<input type="hidden" name="write_num" value="<%=lb.get(0).getWrite_num() %>">
</form>
<script>
fr.submit();
</script>