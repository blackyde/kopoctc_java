<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String date = request.getParameter("date");
String room = request.getParameter("room");
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
		<%=date %><br>
		<%=room %>
	</div>
</div>