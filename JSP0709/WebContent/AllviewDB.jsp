<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.jsp0709.*"%>
<%@ page import="java.util.*" %>
<%!public static final Connection CONN = Connector.getConnection();%>
<%!
class AscendingObj implements Comparator<Student> {
	 
    @Override
    public int compare(Student s1, Student s2) {
        return (s1.getRank() - s2.getRank());
    }
 
}
%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%
	String rank = request.getParameter("rank");
	if(rank == null) {
		rank = "false";
	}
	String from = request.getParameter("from");
	if(from == null) {
		from = "1";
	}
	int fromPt = Integer.parseInt(from);
	String startPage = request.getParameter("startPage");
	if(startPage == null) {
		startPage = "1";
	}
	int start = Integer.parseInt(startPage);
	
	String url = request.getRequestURL().toString();
	url += "?contentPage=AllviewDB.jsp";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
table, tr, th, td {
	border: 1px solid #000000;
	border-collapse: collapse;
	padding: 5px;
	text-align: center;
}
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<table>
		<colgroup>
			<col style="width:80px;" />
			<col style="width:80px;" />
			<col style="width:80px;" />
			<col style="width:80px;" />
			<col style="width:80px;" />
			<col style="width:80px;" />
			<col style="width:80px;" />
			<col style="width:60px;" />
		</colgroup>
		<thead>
			<tr>
				<th>이름</th>
				<th>학번</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
				<th>등수</th>
			</tr>
		</thead>
		<tbody>
			<%	
				List<Student> ls = new ArrayList<Student>();
				
				Statement stmt = CONN.createStatement();
				ResultSet rset = null;
				try {
					rset = stmt.executeQuery("SELECT * FROM examtable");
					while (rset.next()) {
						Student st = new Student(
							rset.getString(1), rset.getInt(2),
							rset.getInt(3), rset.getInt(4), rset.getInt(5)
						);
						ls.add(st);
					}
					
					for(int i = 0; i < ls.size() - 1; i++) {
						for(int j = i + 1; j < ls.size(); j++) {
							if(ls.get(i).getSum() < ls.get(j).getSum()) {
								ls.get(i).setRank(ls.get(i).getRank() + 1);
							}
							if(ls.get(i).getSum() > ls.get(j).getSum()) {
								ls.get(j).setRank(ls.get(j).getRank() + 1);
							}
						}
					}
					
					if(rank.equals("true")) {
						AscendingObj ascending = new AscendingObj();
				        Collections.sort(ls, ascending);
				        url += "&rank=true";
					}
					
					int cnt = 0;
					for(Student st : ls) {
						cnt++;
						if(cnt < fromPt) {
							continue;
						}
						if(cnt >= fromPt + 10) {
							break;
						}
						out.print("<tr>"
								+ "<td style='white-space: nowrap;'><a href='?contentPage=oneview.jsp?studentid="
								+ st.getStudentid() + "'>" + st.getName()
								+ "</a></td>"
								+ "<td>" + st.getStudentid() + "</td>"
								+ "<td>" + st.getKor() + "</td>"
								+ "<td>" + st.getEng() + "</td>"
								+ "<td>" + st.getMat() + "</td>"
								+ "<td>" + st.getSum() + "</td>"
								+ "<td>" + String.format("%.2f", st.getAvg()) + "</td>"
								+ "<td>" + st.getRank() + "</td>"
								+ "</tr>");
					}
					
					
				} catch(Exception e) {
					out.print("<tr><td colspan='8'>테이블이 없습니다.</td></tr>");
				}
				if(rset != null) {
					rset.close();
				}
				stmt.close();
				double total = ls.size() / 10.0;
			%>
			<tr>
				<td colspan="8">
					<% if(!(start == 1)) { %>
					<a href="<%= url %>&from=<%=start == 1 ? 1 : (start - 10) * 10 - 9%>&start=<%=start == 1 ? 1 : start - 10%>">
						&lt;&lt;
					</a>&nbsp;&nbsp;&nbsp;
					<% } %>
					<%
						int finish = 0;
						for (int i = start; i < (start + 10); i++) {
							if (ls.size() % 10 == 0 && i > total) {
								finish = i;
								break;
							} else if(i > (total + 1)) {
								finish = i;
								break;
							}
							
							out.print("<a href='" + url + "&from=" + ((i * 10) - 9) + "&start=" + start + "'>" + i
									+ "</a>&nbsp;&nbsp;&nbsp;");				
						}
					%>
					<%
						if (finish < total) {
					%>
					<a href="<%= url %>&from=<%=(start + 10) * 10 - 9%>&start=<%=start + 10%>">
						&gt;&gt;
					</a>
					<%
						}
					%>
					&nbsp;
				</td>
			</tr>
		</tbody>
	</table>
	<a href="?contentPage=AllviewDB.jsp&rank=true" style="text-align: center; display: inline-block; background: #dddddd; width: 100px; padding: 10px; margin-top: 15px;">등수 정렬</a>
	<a href="?contentPage=AllviewDB.jsp" style="text-align: center; display: inline-block; background: #dddddd; width: 100px; padding: 10px; margin-top: 15px;">정렬 없음</a>
</body>
</html>