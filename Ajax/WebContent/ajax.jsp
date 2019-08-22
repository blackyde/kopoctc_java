<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
System.out.println(name);
if("홍길동".equals(name)) {
	out.println("{\"title\": \"홍길동전\", \"html\": \"아버지를 아버지라....\"}");
} else {
	out.println("{\"title\": \"흥부전\", \"html\": \"아이고 형님....\"}");
}
%>