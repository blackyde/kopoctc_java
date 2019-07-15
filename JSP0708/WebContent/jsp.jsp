<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Script VS JSP</title>
<%! //함수나 변수 선언시 !
private String call1() { //String 메서드 선언
	String a = "abc"; //변수 선언 및 초기화
	String b = "efg"; //변수 선언 및 초기화
	return (a + b); //연산 결과 return
}
private Integer call2() { //정수형 메서드 선언
	int a = 1; //변수 선언 및 초기화
	int b = 2; //변수 선언 및 초기화
	return (a + b); //연산 결과 return
}
%>
</head>
<body>
	String연산 : <%=call1() %> <!-- 변수 출력 -->
	<br>
	Integer연산 : <%=call2() %> <!-- 변수 출력 -->
	<br>
	Good...
</body>
</html>