<%@page import="java.text.SimpleDateFormat"%>
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
<script>
if (self.name != 'reload') {
    self.name = 'reload';
    self.location.reload(true);
} else self.name = '';
</script>
</head>
<body>
<h3>게시판</h3>
<hr>
<table class="table table-striped table-hover fixed">
	<colgroup>
		<col style="width:10%;"/>
		<col style="width:60%;"/>
		<col style="width:20%;"/>
		<col width="*"/>
	</colgroup>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
	<%
	BoardDao<Board> bb = new BoardDaoImpl();
	
	List<Board> lb = bb.select();
	int row = 10;
	int pages = 5;
	int total = (int)Math.ceil(lb.size() / (double)row);
	lb = bb.selectList(fromPt - 1, row);
	for(Board b : lb) {
	%>
		<tr>
			<td>
				<%=b.getWrite_num() %>
			</td>
			<td>
				<div class="flow">
					<a href="javascript:go_view(<%=b.getWrite_num() %>)" class="none">
	<%
	for(int i = 0; i < b.getRelevel(); i++) {
		out.print("-");
	}
	if(b.getRelevel() != 0) {
		out.print(">");
	}
	%>
	<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
	Calendar cal = Calendar.getInstance();
	long today = Long.parseLong(sdf.format(cal.getTime()));
	long w_day = Long.parseLong(sdf.format(b.getWrite_date()));
	if((today - w_day) < 10000) {
		out.print(" [new]");
	}
	%>
					<%=b.getSubject() %>
					</a>
				</div>
			</td>
			<td>
	<%
	sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	String w_date = sdf.format(b.getWrite_date());
	%>
				<%=w_date %>
			</td>
			<td><%=b.getViewcnt() %></td>
		</tr>
	<%
	}
	%>
		<tr>
			<td colspan="4" class="right">
				<form method="post" action="/ReBoard/" class="inline">
					<input type="hidden" name="contentPage" value="write.jsp">
					<input type="submit" value="글쓰기">
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="4" class="center">
	<% if(!(start == 1)) { %>				
				<form method="post" action="/ReBoard/" class="inline">
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
			
				<form method="post" action="/ReBoard/" class="inline">
					<input type="hidden" name="start" value="<%=start %>">
					<input type="hidden" name="from" value="<%=(i * row) - (row - 1)%>">
					<input type="submit" value="<%=i %>">
				</form>&nbsp;&nbsp;&nbsp;
	<%
		}
		
		if (finish < total) {
	%>
				<form method="post" action="/ReBoard/" class="inline">
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
<form name="wform" method="post">
	<input type="hidden" name="write_num">
	<input type="hidden" name="contentPage">
</form>
</body>
</html>