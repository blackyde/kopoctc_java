<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 문자함수1</title>
<%!
String str = "abcdfeffasdsd"; //String 변수 선언
int str_len = str.length(); //문자열의 길이 값
String str_sub = str.substring(5); //5번째 index부터 출력되도록 자름
int str_loc = str.indexOf("cd"); //cd 와 일치하는 문자열의 index
String strL = str.toLowerCase(); //소문자로
String strU = str.toUpperCase(); //대문자로
%>
</head>
<body>
	Str : <%=str %><br>
	str_len : <%=str_len %><br>
	str_sub : <%=str_sub %><br>
	str_loc : <%=str_loc %><br>
	strL : <%=strL %><br>
	strU : <%=strU %><br>
</body>
</html>