<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String contentPage = request.getParameter("contentPage");
	if(contentPage == null) {
		contentPage = "main.html";
	}
%>
<jsp:include page="header.jsp" />
<jsp:include page="<%=contentPage %>" />
<jsp:include page="footer.html" />