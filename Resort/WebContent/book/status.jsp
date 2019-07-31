<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.book.dao.*" %>
<%@ page import = "com.book.dto.*" %>
<%@ page import = "java.util.*" %>
<%
OneShotDao osd = new OneShotDaoImpl();
List<OneShot> list = osd.selectOneShot();
String[] dow = {"일", "월", "화", "수", "목", "금", "토"};
%>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="/Resort/">Home</a></li>
			<li class="breadcrumb-item">예약하기</li>
			<li class="breadcrumb-item"><a href="javascript:go('book/status.jsp');">예약상황</a></li>
		</ol>
	</div>
</div>
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
					<th scope="col">일자</th>
					<th scope="col">요일</th>
					<th scope="col">금수저룸</th>
					<th scope="col">은수저룸</th>
					<th scope="col">흙수저룸</th>
				</tr>
			</thead>
			<tbody>
<%
for(OneShot os : list) {
%>
				<tr class="table-active">
					<th scope="row"><%=os.getDays() %></th>
					<td><%=dow[os.getDow() - 1] + "요일" %></td>
					<td>
<%
	if(os.getRoom1().equals("예약 가능")) {
%>
						<form method="post" action="/Resort/">
							<input type="hidden" name="contentPage" value="book/booking.jsp">
							<input type="hidden" name="date" value="<%=os.getDays()%>">
							<input type="hidden" name="room" value="1">
							<input type="submit" value="<%=os.getRoom1() %>" class="status">
						</form>						
					
<%
	} else {
%>
						<%=os.getRoom1() %>
<%
	}
%>
					</td>
					<td>
<%
	if(os.getRoom2().equals("예약 가능")) {
%>
						<form method="post" action="/Resort/">
							<input type="hidden" name="contentPage" value="book/booking.jsp">
							<input type="hidden" name="date" value="<%=os.getDays()%>">
							<input type="hidden" name="room" value="2">
							<input type="submit" value="<%=os.getRoom1() %>" class="status">
						</form>						
					
<%
	} else {
%>
						<%=os.getRoom2() %>
<%
	}
%>
					</td>
					<td>
<%
	if(os.getRoom3().equals("예약 가능")) {
%>
						<form method="post" action="/Resort/">
							<input type="hidden" name="contentPage" value="book/booking.jsp">
							<input type="hidden" name="date" value="<%=os.getDays()%>">
							<input type="hidden" name="room" value="3">
							<input type="submit" value="<%=os.getRoom1() %>" class="status">
						</form>						
					
<%
	} else {
%>
						<%=os.getRoom3() %>
<%
	}
%>
					</td>
				</tr>
<%
}
%>
			</tbody>
		</table>
	</div>
</div>