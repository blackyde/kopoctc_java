<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.twice.dto.Twice" %>
<%@ page import = "com.twice.dao.*" %>
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
<h3 class="center">(주)트와이스 재고 현황 - 전체 현황</h3>
<hr>
<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>현재 재고수</th>
			<th>재고파악일</th>
			<th>상품등록일</th>
		</tr>
	</thead>
	<tbody>
	<%
	TwiceDao<Twice> td = new TwiceDaoImpl();
	List<Twice> once = td.select();
	int cnt = 0;
	int row = 5;
	int pages = 5;
	int total = (int)Math.ceil(once.size() / (double)row);
	for(Twice t : once) {
		cnt++;
		if(cnt < fromPt) continue;
		if(cnt > fromPt + row - 1) break;
	%>
		<tr>
			<td>
				<form method="post" action="/TwiceCompany/">
					<input type="hidden" name="contentPage" value="item.jsp">
					<input type="hidden" name="goods_id" value="<%=t.getGoods_id() %>">
					<input type="submit" class="invi" value="상세페이지">
				</form>
				<%=t.getGoods_id() %>
			</td>
			<td><%=t.getGoods_name() %></td>
			<td><%=t.getStock() %></td>
			<td><%=t.getU_date() %></td>
			<td><%=t.getC_date() %></td>
		</tr>
	<%
	}
	%>
		<tr>
			<td colspan="5" class="right">
				<form method="post" action="/TwiceCompany/" class="inline">
					<input type="hidden" name="contentPage" value="write.jsp">
					<input type="submit" value="글쓰기">
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="5" class="center">
	<% if(!(start == 1)) { %>				
				<form method="post" action="/TwiceCompany/" class="inline">
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
			
				<form method="post" action="/TwiceCompany/" class="inline">
					<input type="hidden" name="start" value="<%=start %>">
					<input type="hidden" name="from" value="<%=(i * row) - (row - 1)%>">
					<input type="submit" value="<%=i %>">
				</form>&nbsp;&nbsp;&nbsp;
	<%
		}
		
		if (finish < total) {
	%>
				<form method="post" action="/TwiceCompany/" class="inline">
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