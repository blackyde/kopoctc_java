<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.book.dao.*" %>
<%@ page import = "com.book.dto.*" %>
<%@ page import = "java.sql.*" %>
<%
request.setCharacterEncoding("UTF-8");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

String resv_date = request.getParameter("resv_date");
String rooms = request.getParameter("room");
int room = Integer.parseInt(rooms);
switch(room) {
case 1 :
	rooms = "금수저룸";
	break;
case 2 :
	rooms = "은수저룸";
	break;
default :
	rooms = "흙수저룸";	
}
BookDao bd = new BookDaoImpl();
Book b = new Book();

b.setResv_date(Timestamp.valueOf(resv_date));
b.setRoom(room);

b = bd.selectOne(b);
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
					<td><%=rooms %></td>
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
			</tbody>
		</table>
		<form name="wform" method="post" action="/Resort/">
			<input type="hidden" name="contentPage" value="book/status.jsp">
			<input type="submit" value="예약 상황으로" class="btn btn-primary">
		</form>
	</div>
</div>
