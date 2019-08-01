<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.board.dto.*" %>
<%@ page import = "com.board.dao.*" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String write_nums = request.getParameter("write_num");
	if(write_nums == null) {
%>
<script>
location.href="/Resort/";
</script>
<%
	} else {
	
		int write_num = Integer.parseInt(write_nums);
		BoardDao<Board> bb = new BoardDaoImpl();
		Board b = new Board();
		b.setWrite_num(write_num);
		bb.delete(b);	
%>
<form method="post" action="/Resort/" name="fr">
	<input type="hidden" name="contentPage" value="news/board/list.jsp">
</form>
<script>
fr.submit();
</script>
<%
	}
%>