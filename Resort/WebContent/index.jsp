<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String contentPage = request.getParameter("contentPage");
	if(contentPage == null) {
		contentPage = "temp.html";
	}
%>
<jsp:include page="header.html" />
<jsp:include page="<%=contentPage %>" />
<jsp:include page="footer.html" />