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
		response.sendRedirect("/Board/");
	}
	int write_num = Integer.parseInt(write_nums);
	BoardDao<Board> bb = new BoardDaoImpl();
	Board b = new Board();
	b.setWrite_num(write_num);
	b = bb.selectOne(b);
	
%>
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
				<script>    
				// 입력을 제한 할 특수문자의 정규식			
				var replaceId = /[<>]/gi;
	
				$(document).ready(function() {
	
					$("#subject").on("focusout", function() {
						var x = $(this).val();
						if (x.length > 0) {
							if (x.match(replaceId)) {
								x = x.replace(replaceId, "");
							}
							$(this).val(x);
						}
					}).on("keyup", function() {
						$(this).val($(this).val().replace(replaceId, ""));
	
					});
	
				});
				</script>
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
				<script>    
				// 입력을 제한 할 특수문자의 정규식			
				var replaceId = /[<>]/gi;
	
				$(document).ready(function() {
	
					$("#contents").on("focusout", function() {
						var x = $(this).val();
						if (x.length > 0) {
							if (x.match(replaceId)) {
								x = x.replace(replaceId, "");
							}
							$(this).val(x);
						}
					}).on("keyup", function() {
						$(this).val($(this).val().replace(replaceId, ""));
	
					});
	
				});
				</script>
			</td>
		</tr>
		<tr>
			<td colspan="2" class="right">
				<form method="post" action="/Board/" class="inline">
					<input type="hidden" name="contentPage" value="list.jsp">
					<input type="submit" value="취소">
				</form>
				<form method="post" action="/Board/" class="inline" name="updateForm" onsubmit="return checkUpdate()">
					<input type="hidden" name="write_num" value="<%=b.getWrite_num()%>">
					<input type="hidden" id="subjectFinal" name="subjectFinal" value="<%=b.getSubject()%>">
					<input type="hidden" id="contentsFinal" name="contentsFinal" value="<%=b.getContents()%>">
					<input type="hidden" name="contentPage" value="updateDB.jsp">
					<input type="submit" value="쓰기">
				</form>
				<form method="post" action="/Board/" class="inline" name="deleteForm" onsubmit="return checkDelete()">
					<input type="hidden" name="contentPage" value="delete.jsp">
					<input type="hidden" name="write_num" value="<%=b.getWrite_num() %>">
					<input type="submit" value="삭제">
				</form>
			</td>
		</tr>
	</tbody>
</table>