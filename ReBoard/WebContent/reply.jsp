<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.reboard.dto.*" %>
<%@ page import = "com.reboard.dao.*" %>
<%
request.setCharacterEncoding("UTF-8");

String write_nums = request.getParameter("write_num");
if(write_nums == null) {
	response.sendRedirect("/ReBoard/");
} else {
	int write_num = Integer.parseInt(write_nums);
	BoardDao<Board> bb = new BoardDaoImpl();
	Board b = new Board();
	b.setWrite_num(write_num);
	b = bb.selectOne(b);
%>
<h3>답글 달기</h3>
<hr>
<form method="post" action="/ReBoard/?contentPage=replyDB.jsp" class="inline" name="updateForm" onsubmit="return checkUpdate()" enctype="multipart/form-data">
<table class="table">
	<colgroup>
		<col style="width: 20%;" />
		<col width="*" />
	</colgroup>
	<tbody>
		<tr>
			<th>제목</th>
			<td>
				<input type="text" name="subject" id="subject" value="[re]<%=b.getSubject() %>" maxlength="50">
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>
				<textarea name="contents" id="contents" cols="50" rows="10" maxlength="5000"><%=b.getContents() %></textarea>
			</td>
		</tr>
		<tr>
			<th>파일</th>
			<td>
				<input type="file" name="file" id="file" multiple />
			</td>
		</tr>
		<tr>
			<td colspan="2" class="right">
				<input type="button" value="취소" onclick="javascript:go_list()">
				<input type="hidden" id="rootid" name="rootid" value="<%=b.getRootid()%>">
				<input type="hidden" id="recnt" name="recnt" value="<%=b.getRecnt() + 1%>">
				<input type="hidden" id="relevel" name="relevel" value="<%=b.getRelevel() + 1%>">
				<input type="hidden" name="contentPage" value="replyDB.jsp">
				<input type="submit" value="쓰기">
			</td>
		</tr>
	</tbody>
</table>
</form>
<form name="wform" method="post">
	<input type="hidden" name="contentPage">
</form>
<%
}
%>