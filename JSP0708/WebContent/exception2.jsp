<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 예외 처리 2</title>
</head>
<body>
	<%
		String[] arr = new String[] { "111", "222", "333" }; //문자열 배열 선언 및 초기화
		//try {
			out.println(arr[4] + "<br>"); //index를 넘어가는 항목을 출력하라고 명령
		//} catch(Exception e) {
		//	out.println("error==>" + e + "<=======<br>"); //에러가 출력된다.
		//}
	%>
</body>
</html>