<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.board.dto.*" %>
<%@ page import = "com.board.dao.*" %>
<%
	request.setCharacterEncoding("UTF-8");

	String write_nums = request.getParameter("write_num");
	if(write_nums == null) {
		response.sendRedirect("/Board/");
	}
	int write_num = Integer.parseInt(write_nums);
	
	BoardDao<Board> bb = new BoardDaoImpl();
	Board b = new Board();
	b.setWrite_num(write_num);
	b = bb.selectOne(b);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<table class="table">
	<tbody>
		<tr>
			<th>번호</th>
			<td><%=b.getWrite_num() %></td>
		<tr>
		<tr>
			<th>제목</th>
			<td style="word-break:break-all"><%=b.getSubject() %></td>
		</tr>
		<tr>
			<th>일자</th>
			<td><%=b.getWrite_date() %></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea cols="50" rows="10" readonly><%=b.getContents() %></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="right">
				<form method="post" action="/Board/" class="inline">
					<input type="hidden" name="contentPage" value="list.jsp">
					<input type="submit" value="목록">
				</form>
				<form method="post" action="/Board/" class="inline">
					<input type="hidden" name="contentPage" value="update.jsp">
					<input type="hidden" name="write_num" value="<%=b.getWrite_num() %>">
					<input type="submit" value="수정">
				</form>
			</td>
		</tr>
	</tbody>
</table>
</body>
</html>