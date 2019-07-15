<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.twice.dto.Twice" %>
<%@ page import = "com.twice.dao.*" %>
<%
	request.setCharacterEncoding("UTF-8");

	String goods_ids = request.getParameter("goods_id");
	if(goods_ids == null) {
		response.sendRedirect("/TwiceCompany/");
	}
	int goods_id = Integer.parseInt(goods_ids);
	
	TwiceDao<Twice> td = new TwiceDaoImpl();
	Twice t = new Twice();
	t.setGoods_id(goods_id);
	t = td.selectOne(t);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<h3 class="center">(주)트와이스 재고 현황 - 상품 상세</h3>
<hr>
<table class="table">
	<tbody>
		<tr>
			<th>상품번호</th>
			<td><%=t.getGoods_id() %></td>
		<tr>
		<tr>
			<th>상품명</th>
			<td><%=t.getGoods_name() %></td>
		</tr>
		<tr>
			<th>현재 재고수</th>
			<td><%=t.getStock() %></td>
		</tr>
		<tr>
			<th>재고파악일</th>
			<td><%=t.getU_date() %></td>
		</tr>
		<tr>
			<th>상품등록일</th>
			<td><%=t.getC_date() %></td>
		</tr>
		<tr>
			<th>상품설명</th>
			<td><%=t.getDescribe() %></td>
		</tr>
		<tr>
			<th>상품사진</th>
			<td><%=t.getImage() %></td>
		</tr>
	</tbody>
</table>
</body>
</html>