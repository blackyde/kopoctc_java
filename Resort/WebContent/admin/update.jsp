<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.book.dao.*" %>
<%@ page import = "com.book.dto.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.sql.Timestamp"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%
boolean isLogin = false;
Object obj = session.getAttribute("isLogin");
if(obj != null) {
	isLogin = (boolean)session.getAttribute("isLogin");
}
if(isLogin) {
	request.setCharacterEncoding("UTF-8");
	String resv_dates = request.getParameter("resv_date");
	String rooms = request.getParameter("room");
	
	Timestamp resv_date = Timestamp.valueOf(resv_dates);
	int room = Integer.parseInt(rooms);
	
	BookDao bd = new BookDaoImpl();
	Book b = new Book();
	b.setResv_date(resv_date);
	b.setRoom(room);
	
	b = bd.selectOne(b);
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
%>

<div class="row">
	<div class="col-lg-12">
		<form name="updateForm" method="post" action="/Resort/">
			<table class="table table-hover">
				<colgroup>
					<col width="20%" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>성명</th>
						<td><%=b.getName() %></td>
					</tr>
					<tr>
						<th>예약일자</th>
						<td><%=sdf.format(b.getResv_date()) %></td>
					</tr>
					<tr>
						<th>예약방</th>
						<td>
							<%=b.getRoom() %><br><br>
							<span style="color: #999999 !important;">1 : 금수저룸, 2 : 은수저룸, 3 : 흙수저룸</span>
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td><%=b.getAddr() %></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><%=b.getTelnum() %></td>
					</tr>
					<tr>
						<th>입금자명</th>
						<td><%=b.getIn_name() %></td>
					</tr>
					<tr>
						<th>남기실 말</th>
						<td><%=b.getComment() %></td>
					</tr>
					<tr>
						<th>진행상황</th>
						<td>
							<input type="number" name="processing" id="processing" value="<%=b.getProcessing()%>" maxlength="1" oninput="maxLengthCheck(this)">
							<br><br>
							<span style="color: #999999 !important;">0 : 예약 진행중, 1 : 입금완료(예약확정), 2 : 환불요청, 3 : 환불완료</span>
							<script type="text/javascript">	
							function maxLengthCheck(object){
								if (object.value.length > object.maxLength){
									object.value = object.value.slice(0, object.maxLength);
								}
								if (object.value > 3) {
									object.value = 0;
								}
								document.updateForm.process.value = object.value;
							}
							</script>
						</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="contentPage" value="admin/updateDB.jsp">
			<input type="hidden" name="resv_date" value="<%=b.getResv_date()%>">
			<input type="hidden" name="room" value="<%=b.getRoom()%>">
			<input type="hidden" name="process" value="<%=b.getProcessing() %>">
			<input type="submit" value="수정하기" class="btn btn-primary">
			<input type="button" value="취소" class="btn btn-dark" onclick="history.back();">
		</form>
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
