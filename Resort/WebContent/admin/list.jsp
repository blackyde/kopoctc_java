<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.book.dao.*" %>
<%@ page import = "com.book.dto.*" %>
<%@ page import = "java.util.*" %>
<%@page import="java.text.SimpleDateFormat"%>
<%
boolean isLogin = false;
Object obj = session.getAttribute("isLogin");
if(obj != null) {
	isLogin = (boolean)session.getAttribute("isLogin");
}
if(isLogin) {
	request.setCharacterEncoding("UTF-8");
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
	BookDao bd = new BookDaoImpl();
	List<Book> list = bd.select();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	int row = 10;
	int pages = 5;
	int total = (int)Math.ceil(list.size() / (double)row);
	list = bd.selectPage(fromPt - 1, row);
%>

<div class="row">
	<div class="col-lg-12">
		<table class="table table-hover">
			<colgroup>
				<col width="20%" />
				<col width="20%" />
				<col width="20%" />
				<col width="20%" />
				<col width="20%" />
			</colgroup>
			<thead>
				<tr class="table-primary">
					<th scope="col">생성일자</th>
					<th scope="col">예약일자</th>
					<th scope="col">룸</th>
					<th scope="col">성명</th>
					<th scope="col">진행상황</th>
				</tr>
			</thead>
			<tbody>
<%
for(Book b : list) {
	String rooms = "";
	switch(b.getRoom()) {
	case 1 :
		rooms = "금수저룸";
		break;
	case 2 :
		rooms = "은수저룸";
		break;
	default :
		rooms = "흙수저룸";
	}
	
	String process = "";
	switch(b.getProcessing()) {
	case 1 :
		process = "예약확정";
		break;
	case 2 :
		process = "환불요청";
		break;
	case 3 :
		process = "환불완료";
		break;
	default :
		process = "예약진행중";
	}
%>
				<tr class="table-active">
					<th scope="row"><%=sdf.format(b.getWrite_date()) %></th>
					<td><%=sdf.format(b.getResv_date()) %></td>
					<td><%=rooms %></td>
					<td><%=b.getName() %></td>
					<td>
						<%=process %>
						<form method="post" action="/Resort/" name="wform" style="display: inline-block; float: right;">
							<input type="hidden" name="resv_date" value="<%=b.getResv_date() %>">
							<input type="hidden" name="room" value="<%=b.getRoom() %>">
<%
	if(b.getProcessing() == 3) {
%>
							<input type="hidden" name="contentPage" value="admin/delete.jsp">
							<input type="button" value="삭제" onclick="admin_delete();">
<%	
	} else {
%>
							<input type="hidden" name="contentPage" value="admin/update.jsp">
							<input type="submit" value="수정">
<%
	}
%>
							
						</form>
					</td>
				</tr>
<%
}
%>
				<tr>
					<td colspan="5" class="center">
			<% if(!(start == 1)) { %>				
						<form method="post" action="/Resort/" class="inline">
							<input type="hidden" name="contentPage" value="admin/list.jsp">
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
					
						<form method="post" action="/Resort/" class="inline">
							<input type="hidden" name="contentPage" value="admin/list.jsp">
							<input type="hidden" name="start" value="<%=start %>">
							<input type="hidden" name="from" value="<%=(i * row) - (row - 1)%>">
							<input type="submit" value="<%=i %>">
						</form>&nbsp;&nbsp;&nbsp;
			<%
				}
				
				if (finish < total) {
			%>
						<form method="post" action="/Resort/" class="inline">
							<input type="hidden" name="contentPage" value="admin/list.jsp">
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
	</div>
</div>
<%
} else {
%>
<script>
location.href="/Resort/";
</script>
<%
	//response.sendRedirect("/Resort/");
}
%>