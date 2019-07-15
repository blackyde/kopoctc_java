<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Class 사용</title>
<%!
private class AA { //클래스 선언
	private int sum(int i, int j) { //메서드 선언
		return i + j; //리턴
	}
}
AA aa = new AA(); //객체 생성
%>
</head>
<body>
	<% out.println("2 + 3 = " + aa.sum(2, 3)); %> <!-- 메서드 호출 -->
	<br> Good...
</body>
</html>