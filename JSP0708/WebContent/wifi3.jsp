<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String from = request.getParameter("from");
	String cnt = request.getParameter("cnt");
	String start = request.getParameter("start");
	
	if(from == null && cnt == null && start == null) {
		from = "1";
		cnt = "10";
		start = "1";
	}	
%>
<%
	int fromPt = Integer.parseInt(from);
	int cntPt = Integer.parseInt(cnt);
	int startPage = Integer.parseInt(start);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전국 와이파이 데이터3</title>
<style>
table {
	width: 800px;
	margin: auto;
}

table, tr, th, td {
	border: 1px solid #333333;
	border-collapse: collapse;
}
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<table>
		<tr>
			<th>번호</th>
			<th>주소</th>
			<th>위도</th>
			<th>경도</th>
			<th>거리</th>
		</tr>
		<%
			String file = application.getRealPath("전국무료와이파이표준데이터.txt");
			BufferedReader br = new BufferedReader(new FileReader(file));

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

			int lineCnt = 0;
			while ((readtxt = br.readLine()) != null) {
				lineCnt++;
				String[] field = readtxt.split("\t");

				if (lineCnt >= fromPt && lineCnt < ((fromPt + cntPt))) {
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
				}
			}
			br.close();
		%>
	</table>
	<div style="text-align: center;">
		<a href="wifi3.jsp?from=<%=startPage == 1 ? 1 : (startPage - 10) * 10 - 9%>&cnt=10&start=<%=startPage == 1 ? 1 : startPage - 10%>">
			&lt;&lt;
		</a>&nbsp;&nbsp;&nbsp;
		<%
			int finish = 0;
			double total = lineCnt / 10.0;
			for (int i = startPage; i < (startPage + 10); i++) {
				if (lineCnt % 10 == 0 && i > total) {
					finish = i;
					break;
				} else if(i > (total + 1)) {
					finish = i;
					break;
				}
				
				out.print("<a href='wifi3.jsp?from=" + ((i * 10) - 9) + "&cnt=10&start=" + startPage + "'>" + i
						+ "</a>&nbsp;&nbsp;&nbsp;");				
			}
		%>
		<%
			if (finish < total) {
		%>
		<a href="wifi3.jsp?from=<%=(startPage + 10) * 10 - 9%>&cnt=10&start=<%=startPage + 10%>">
			&gt;&gt;
		</a>
		<%
			}
		%>
	</div>
</body>
</html>