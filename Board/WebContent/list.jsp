<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.board.dto.*" %>
<%@ page import = "com.board.dao.*" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String from = request.getParameter("from");
	if(from == null) {
		from = "1";
	}
	int fromPt = Integer.parseInt(from);
	String startPage = request.getParameter("start");
	if(startPage == null) {
		startPage = "1";
	}
	int start = Integer.parseInt(startPage);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<table class="table table-striped table-hover" style="table-layout: fixed;">
	<colgroup>
		<col style="width:10%;"/>
		<col style="width:70%;"/>
		<col width="*"/>
	</colgroup>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록일</th>
		</tr>
	</thead>
	<tbody>
	<%
	BoardDao<Board> bb = new BoardDaoImpl();
	
	//Board insert = new Board();
	//insert.setSubject("공지사항1");
	//insert.setContents("내용은 없습니다");
	//bb.insert(insert);
	
	List<Board> lb = bb.selectDesc();
	int cnt = 0;
	int row = 10;
	int pages = 5;
	int total = (int)Math.ceil(lb.size() / (double)row);
	for(Board b : lb) {
		cnt++;
		if(cnt < fromPt) continue;
		if(cnt > fromPt + row - 1) break;
	%>
		<tr>
			<td>
				<form method="post" action="/Board/">
					<input type="hidden" name="contentPage" value="item.jsp">
					<input type="hidden" name="write_num" value="<%=b.getWrite_num() %>">
					<input type="submit" class="invi" value="상세페이지">
				</form>
				<%=b.getWrite_num() %>
			</td>
			<td><div style="overflow-x: hidden; text-overflow: ellipsis; white-space: nowrap"><%=b.getSubject() %></div></td>
			<td><%=b.getWrite_date() %></td>
		</tr>
	<%
	}
	%>
		<tr>
			<td colspan="3" class="right">
				<form method="post" action="/Board/" class="inline">
					<input type="hidden" name="contentPage" value="write.jsp">
					<input type="submit" value="글쓰기">
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="3" class="center">
	<% if(!(start == 1)) { %>				
				<form method="post" action="/Board/" class="inline">
					<input type="hidden" name="start" value="<%=start - pages%>">
					<input type="hidden" name="from" value="<%=(start - pages) * row - (row - 1)%>">
					<input type="submit" value="&lt;&lt;">
				</form>&nbsp;&nbsp;&nbsp;
	<% } %>
	<%
		int finish = 0;
		if(total == pages) {
			finish = pages;
		}
		for (int i = start; i < (start + pages); i++) {
			if (i > total) {
				finish = i;
				break;
			}
	%>
			
				<form method="post" action="/Board/" class="inline">
					<input type="hidden" name="start" value="<%=start %>">
					<input type="hidden" name="from" value="<%=(i * row) - (row - 1)%>">
					<input type="submit" value="<%=i %>">
				</form>&nbsp;&nbsp;&nbsp;
	<%
		}
		
		if (finish < total) {
	%>
				<form method="post" action="/Board/" class="inline">
					<input type="hidden" name="start" value="<%=start + pages%>">
					<input type="hidden" name="from" value="<%=(start + row) * pages - (pages - 1)%>">
					<input type="submit" value="&gt;&gt;">
				</form>
	<%
		}
	%>
			</td>
		</tr>
	</tbody>
</table>
</body>
</html>