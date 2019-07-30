<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.book.dao.*" %>
<%@ page import = "com.book.dto.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.text.SimpleDateFormat"%>
<%@ page import = "java.sql.*" %>
<%
BookDao bd = new BookDaoImpl();
Calendar cal = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String todayString = sdf.format(cal.getTime()) + " 00:00:00.0";
Timestamp today = Timestamp.valueOf(todayString);
List<Book> list = bd.select(today);
String[] dow = {"일", "월", "화", "수", "목", "금", "토"};
/*b.setName("테스터");
b.setResv_date(Timestamp.valueOf("2019-08-01 00:00:00.0"));
b.setRoom(1);
b.setAddr("서울");
b.setTelnum("010-1234-5678");
b.setIn_name("나");
b.setComment("맥주주세요");

bd.insert(b);
*/
String[][] table = new String[5][30];
for(int i = 0; i < 30; i++) {
	cal.add(Calendar.DATE, 1);
	String days = sdf.format(cal.getTime());
	table[0][i] = days;
	table[1][i] = dow[cal.get(Calendar.DAY_OF_WEEK) - 1] + "요일";
	table[2][i] = "예약 가능";
	table[3][i] = "예약 가능";
	table[4][i] = "예약 가능";
	for(Book b : list) {
		if(sdf.format(b.getResv_date()).equals(sdf.format(cal.getTime()))) {
			int room = b.getRoom() + 1;
			table[room][i] = b.getName();
		}
	}
}
%>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="/Resort/">Home</a></li>
			<li class="breadcrumb-item">예약하기</li>
			<li class="breadcrumb-item">예약상황</li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<table class="table table-hover">
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

	
for(int i = 0; i < 30; i++) {	
%>
				<tr class="table-active">
					<th scope="row"><%=table[0][i] %></th>
					<td><%=table[1][i] %></td>
					<td><%=table[2][i] %></td>
					<td><%=table[3][i] %></td>
					<td><%=table[4][i] %></td>

					

				</tr>
<%
}
%>
			</tbody>
		</table>
	</div>
</div>