<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
Calendar cal = Calendar.getInstance();
String dates = sdf.format(cal.getTime());
dates = URLEncoder.encode(dates, "UTF-8");
out.println(dates);
Cookie date = new Cookie("date", dates);
date.setMaxAge(365*24*60*60);
response.addCookie(date);
%>