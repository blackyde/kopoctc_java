<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String date = request.getParameter("resv_date");
String room = request.getParameter("room");
String rooms = "";
switch(room) {
case "1" :
	rooms = "금수저룸";
	break;
case "2" :
	rooms = "은수저룸";
	break;
default :
	rooms = "흙수저룸";	
}
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
		<form method="post" action="/Resort/" name="inputForm" onsubmit="return book_check();">
			<fieldset>
				<legend>예약하기</legend>				
				<div class="form-group">
					<label for="name">성명</label>
					<input type="text" class="form-control" id="name" name="name"
					 placeholder="Enter name" maxlength="20">
				</div>
				<div class="form-group">
					<label for="resv_date">예약일자</label>
					<input
						type="text" class="form-control" id="resv_date" name="resv_date"
						value="<%=date %>" readonly style="color: #FFFFFF;">
				</div>
				<div class="form-group">
					<label for="room">예약방</label>
					<input
						type="text" class="form-control" id="room" name="room"
						value="<%=rooms %>" readonly style="color: #FFFFFF;">
				</div>
				<div class="form-group">
					<label for="addr">주소</label>
					<input type="text" class="form-control" id="addr" name="addr"
					 placeholder="Enter address" maxlength="50">
				</div>
				<div class="form-group">
					<label for="telnum">전화번호</label>
					<input type="text" class="form-control" id="telnum" name="telnum"
					 placeholder="Enter Phone Number" maxlength="20">
				</div>
				<div class="form-group">
					<label for="in_name">입금자명</label>
					<input type="text" class="form-control" id="in_name" name="in_name"
					 placeholder="Enter depositor name" maxlength="20">
				</div>
				<div class="form-group">
					<label for="comment">남기실 말</label>
					<input type="text" class="form-control" id="comment" name="comment"
					 placeholder="Enter comments" maxlength="200">
				</div>
				<input type="hidden" name="contentPage" value="book/bookingDB.jsp">
				<button type="submit" class="btn btn-primary">Submit</button>
				<button type="button" class="btn btn-dark" onclick="javascript:history.back();">취소</button>
			</fieldset>
		</form>
	</div>
</div>