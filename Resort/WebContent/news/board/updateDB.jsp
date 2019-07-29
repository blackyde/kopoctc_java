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
	String subject = request.getParameter("subjectFinal");
	String contents = request.getParameter("contentsFinal");
	if(subject == null || contents == null) {
		response.sendRedirect("/Resort/");
	} else {
	
		int write_num = Integer.parseInt(write_nums);
		BoardDao<Board> bb = new BoardDaoImpl();
		Board b = new Board();
		b.setWrite_num(write_num);
		b.setSubject(subject);
		b.setContents(contents);
		bb.update(b);
		
		b = bb.selectOne(b);
	
%>
<form method="post" action="/Resort/" name="fr">
	<input type="hidden" name="contentPage" value="news/board/item.jsp">
	<input type="hidden" name="write_num" value="<%=b.getWrite_num() %>">
</form>
<script>
fr.submit();
</script>
<%
	}
%>