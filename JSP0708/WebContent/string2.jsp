<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 문자함수2</title>
</head>
<body>
	<%
		String[] arr = new String[] { "111", "222", "333" }; //문자열 배열 선언 및 초기화
		String str = "abc,efg,hij"; //문자열 변수 선언 및 초기화
		String[] str_arr = str.split(","); //문자열을 , 를 기준으로 잘라 배열에 담기
	%>
	arr[0] : <%=arr[0] %><br>
	arr[1] : <%=arr[1] %><br>
	arr[2] : <%=arr[2] %><br>
	str_arr[0] : <%=str_arr[0] %><br>
	str_arr[1] : <%=str_arr[1] %><br>
	str_arr[2] : <%=str_arr[2] %><br>
	Good...
</body>
</html>