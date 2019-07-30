<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Cookie[] cookies = request.getCookies();
out.println("현재 설정된 쿠키의 개수 : " + cookies.length + "<br>");
for(int i = 0; i < cookies.length; i++) {
	Cookie thisCookie = cookies[i];
	thisCookie.setMaxAge(0);
	response.addCookie(thisCookie);
	out.println(i + "번째 쿠키 이름 : " + thisCookie.getName() + "<br>");
	out.println(i + "번째 쿠키에 설정된 값 : " + URLDecoder.decode(thisCookie.getValue(), "UTF-8"));
}
%>