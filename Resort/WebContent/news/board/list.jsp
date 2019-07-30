<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.board.dto.*" %>
<%@ page import = "com.board.dao.*" %>
<%
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
	
	boolean isLogin = false;
	Object obj = session.getAttribute("isLogin");
	if(obj != null) {
		isLogin = (boolean)session.getAttribute("isLogin");
	}
	
%>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="/Resort/">Home</a></li>
			<li class="breadcrumb-item">펜션 소식</li>
			<li class="breadcrumb-item active"><a href="javascript:go('news/board/list.jsp');">리조트 소식</a></li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
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
					<td><%=b.getWrite_num() %></td>
					<td>
						<div style="overflow-x: hidden; text-overflow: ellipsis; white-space: nowrap">
							<a href="javascript:go_notice(<%=b.getWrite_num() %>)" class="none">
								<%=b.getSubject() %>
							</a>
						</div>
					</td>
					<td><%=b.getWrite_date() %></td>
				</tr>
			<%
			}
			
			if(isLogin) {
			%>
				<tr>
					<td colspan="3" class="right">
						<form method="post" action="/Resort/" class="inline">
							<input type="hidden" name="contentPage" value="news/board/write.jsp">
							<input type="submit" value="글쓰기">
						</form>
					</td>
				</tr>
			<%
			}
			%>
				<tr>
					<td colspan="3" class="center">
			<% if(!(start == 1)) { %>				
						<form method="post" action="/Resort/" class="inline">
							<input type="hidden" name="contentPage" value="news/board/list.jsp">
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
							<input type="hidden" name="contentPage" value="news/board/list.jsp">
							<input type="hidden" name="start" value="<%=start %>">
							<input type="hidden" name="from" value="<%=(i * row) - (row - 1)%>">
							<input type="submit" value="<%=i %>">
						</form>&nbsp;&nbsp;&nbsp;
			<%
				}
				
				if (finish < total) {
			%>
						<form method="post" action="/Resort/" class="inline">
							<input type="hidden" name="contentPage" value="news/board/list.jsp">
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
<form name="noticeForm" method="post">
	<input type="hidden" name="write_num">
	<input type="hidden" name="contentPage">
</form>