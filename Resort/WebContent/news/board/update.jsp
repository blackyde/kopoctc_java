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
		response.sendRedirect("/Resort/");
	} else {
		int write_num = Integer.parseInt(write_nums);
		BoardDao<Board> bb = new BoardDaoImpl();
		Board b = new Board();
		b.setWrite_num(write_num);
		b = bb.selectOne(b);	
%>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="/Resort/">Home</a></li>
			<li class="breadcrumb-item">펜션 소식</li>
			<li class="breadcrumb-item"><a href="javascript:go('news/board/list.jsp');">리조트 소식</a></li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<table class="table">
			<tbody>
				<tr>
					<th>번호</th>
					<td><%=b.getWrite_num() %></td>
				<tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="subject" id="subject" value="<%=b.getSubject() %>" maxlength="50">
					</td>
				</tr>
				<tr>
					<th>일자</th>
					<td><%=b.getWrite_date() %></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="contents" id="contents" cols="50" rows="10" maxlength="5000"><%=b.getContents() %></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="right">
						<form method="post" action="/Resort/" class="inline">
							<input type="hidden" name="contentPage" value="news/board/list.jsp">
							<input type="submit" value="취소">
						</form>
						<form method="post" action="/Resort/" class="inline" name="updateForm" onsubmit="return checkUpdate()">
							<input type="hidden" name="write_num" value="<%=b.getWrite_num()%>">
							<input type="hidden" id="subjectFinal" name="subjectFinal" value="<%=b.getSubject()%>">
							<input type="hidden" id="contentsFinal" name="contentsFinal" value="<%=b.getContents()%>">
							<input type="hidden" name="contentPage" value="news/board/updateDB.jsp">
							<input type="submit" value="쓰기">
						</form>
						<form method="post" action="/Resort/" class="inline" name="deleteForm" onsubmit="return checkDelete()">
							<input type="hidden" name="contentPage" value="news/board/delete.jsp">
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