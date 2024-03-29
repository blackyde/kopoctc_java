<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.reboard.dto.*" %>
<%@ page import = "com.reboard.dao.*" %>
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
			<li class="breadcrumb-item active"><a href="javascript:go('news/reboard/list.jsp');">이용 후기</a></li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<form method="post" action="/Resort/?contentPage=news/reboard/updateDB.jsp" class="inline" name="updateForm" onsubmit="return checkUpdate()" enctype="multipart/form-data">
		<table class="table">
			<colgroup>
				<col style="width: 20%;" />
				<col width="*" />
			</colgroup>
			<tbody>
				<tr>
					<th>번호</th>
					<td><input type="text" name="write_num" value="<%=b.getWrite_num()%>" readonly></td>
				<tr>
				<tr>
					<th>제목</th>
					<td>
						<input type="text" name="subject" id="subject" value="<%=b.getSubject() %>" maxlength="50" size="50">
					</td>
				</tr>
				<tr>
					<th>일자</th>
					<td><%=b.getWrite_date() %></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea name="contents" id="contents" cols="50" rows="10" maxlength="5000" class="summernote"><%=b.getContents() %></textarea>
					</td>
				</tr>
				<tr>
					<th>파일</th>
					<td>
		<%
			int check = 0;
			if(b.getFile() != null && b.getFile().size() > 0) {
				for(String s : b.getFile()) {
					
		%>
						<%=s %>
						<input type="checkbox" id="file<%=check%>" name="file<%=check%>">
						파일을 삭제하려면 체크해 주세요.
						<br>
		<%
					check++;
				}
		%>
		<%
			}	
		%>
						<input type="hidden" id="totalFile" name="totalFile" value="<%=check %>">
						<input type="file" name="file" id="file" multiple />
					</td>
				</tr>
				<tr>
					<td colspan="2" class="right">
						<input type="button" value="취소" onclick="javascript:go_list()">
						<input type="submit" value="수정하기">
					</td>
				</tr>
			</tbody>
		</table>
		</form>
	</div>
</div>

<form name="wform" method="post">
	<input type="hidden" name="contentPage">
</form>
<%
}
%>