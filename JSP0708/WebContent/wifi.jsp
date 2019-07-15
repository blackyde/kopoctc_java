<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전국 와이파이 데이터</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>주소</th>
			<th>위도</th>
			<th>경도</th>
			<th>거리</th>
		</tr>
	<%
		File f = new File("c:\\Study\\File\\전국무료와이파이표준데이터.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));

		String readtxt;

		if ((readtxt = br.readLine()) == null) {
			System.out.printf("빈 파일입니다.\n");
			return;
		}
		String[] field_name = readtxt.split("\t");
		//쉼표로 구분하는 방법은 "12,23" 같은 하나의 데이터까지 분리해 버리므로 탭으로 구분한다.
		//융합기술교육원 위도 경도 37.3857959,127.12127099999998
		double lat = 37.3857959;
		double lng = 127.12127099999998;

		int lineCnt = 1;
		while ((readtxt = br.readLine()) != null) {

			String[] field = readtxt.split("\t");
			out.print("<tr>");
			out.print("<td>" + lineCnt + "</td>");
			out.print("<td>" + field[9] + "</td>");
			out.print("<td>" + field[12] + "</td>");
			out.print("<td>" + field[13] + "</td>");
			
			double dist = Math.sqrt(Math.pow(Double.parseDouble(field[12]) - lat, 2)
					+ Math.pow(Double.parseDouble(field[13]) - lng, 2));
			//거리 = sqrt((위도1 - 위도2)^2 + (경도1 - 경도2)^2) //최소제곱법?
			
			out.print("<td colspan='2'>" + dist + "</td>");
			out.print("</tr>");
			lineCnt++;
			if(lineCnt >= 100) {
				break;
			}
		}
		br.close();
	%>
	</table>
</body>
</html>