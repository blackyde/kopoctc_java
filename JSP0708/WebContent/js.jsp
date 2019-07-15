<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Script VS JSP</title>
<script>
function call1() { //함수 선언
	var a = "abc"; //변수 a 선언 및 문자열로 초기화
	var b = "efg"; //변수 b 선언 및 문자열로 초기화
	document.write("String연산:" + (a + b)); //문자열의 연산 결과를 출력
}
function call2() { //함수 선언
	var a = 1; //변수 a 선언 및 정수로 초기화
	var b = 2; //변수 b 선언 및 정수로 초기화
	document.write("Integer연산:" + (a + b)); //정수의 연산 결과를 출력
}
</script>
</head>
<body>
	<script>call1();</script>
	<br>
	<script>call2();</script>
	<br>
	Good...
</body>
</html>