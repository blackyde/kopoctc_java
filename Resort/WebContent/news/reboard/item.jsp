<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.reboard.dto.*" %>
<%@ page import = "com.reboard.dao.*" %>
<%
request.setCharacterEncoding("UTF-8");

String write_nums = request.getParameter("write_num");
if(write_nums == null) {
	response.sendRedirect("/Resort/");
} else {
	int write_num = Integer.parseInt(write_nums);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	BoardDao<Board> bb = new BoardDaoImpl();
	Board b = new Board();
	b.setWrite_num(write_num);
	bb.viewCnt(b);
	b = bb.selectOne(b);
	if(b.getRootid() == 0) {
		b.setRootid(b.getWrite_num());
	}
%>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="/Resort/">Home</a></li>
			<li class="breadcrumb-item">펜션 소식</li>
			<li class="breadcrumb-item active"><a href="javascript:go('news/reboard/list.jsp');">이용 후기</a></li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<table class="table">
			<colgroup>
				<col style="width: 20%;" />
				<col width="*" />
			</colgroup>
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
					<td><%=sdf.format(b.getWrite_date()) %></td>
				</tr>
				<tr>
					<th>조회수</th>
					<td><%=b.getViewcnt() %></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>				
						<div style="height: 300px; overflow-y: scroll;">
							<%=b.getContents() %>
						</div>
					</td>
				</tr>
				<tr>
					<th>파일</th>
					<td>				
		<%
			if(b.getFile() != null && b.getFile().size() > 0) {
				for(String s : b.getFile()) {
		%>
						<a href="upload/<%=s %>" class="none" download><%=s %></a><br>
		<%
				}
			} else {
		%>
						첨부 파일이 없습니다.
		<%
			}
		%>
					</td>
				</tr>
				<tr>
					<th>원글</th>
					<td><%=b.getRootid() %></td>
				</tr>
				<tr>
					<th>레벨</th>
					<td><%=b.getRelevel() %></td>
				</tr>
				<tr>
					<th>댓글 순서</th>
					<td><%=b.getRecnt() %></td>
				</tr>
				<tr>
					<td colspan="2" class="right">
						<form method="post" action="/Resort/" class="inline">
							<input type="hidden" name="contentPage" value="news/reboard/list.jsp">
							<input type="submit" value="목록">
						</form>
						<form method="post" action="/Resort/" class="inline">
							<input type="hidden" name="contentPage" value="news/reboard/reply.jsp">
							<input type="hidden" name="write_num" value="<%=b.getWrite_num() %>">
							<input type="submit" value="답글달기">
						</form>
						<form method="post" action="/Resort/" class="inline">
							<input type="hidden" name="contentPage" value="news/reboard/update.jsp">
							<input type="hidden" name="write_num" value="<%=b.getWrite_num() %>">
							<input type="submit" value="수정">
						</form>
						<form method="post" action="/Resort/" class="inline" name="deleteForm" onsubmit="return checkDelete()">
							<input type="hidden" name="contentPage" value="news/reboard/delete.jsp">
							<input type="hidden" name="write_num" value="<%=b.getWrite_num() %>">
							<input type="submit" value="삭제">
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</div>
</div>
<%
}
%>