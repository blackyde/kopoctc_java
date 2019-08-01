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
%>
<script>
location.href="/Resort/";
</script>
<%
	} else {
	
		BoardDao<Board> bb = new BoardDaoImpl();
		Board b = new Board();
		b.setSubject(subject);
		b.setContents(contents);
		bb.insert(b);
		
		List<Board> lb = bb.selectDesc();
	
%>
<form method="post" action="/Resort/" name="fr">
	<input type="hidden" name="contentPage" value="news/board/item.jsp">
	<input type="hidden" name="write_num" value="<%=lb.get(0).getWrite_num() %>">
</form>
<script>
fr.submit();
</script>
<%
	}
%>