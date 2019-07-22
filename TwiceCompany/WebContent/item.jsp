<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.twice.dto.Twice" %>
<%@ page import = "com.twice.dao.*" %>
<%@ page import = "java.text.SimpleDateFormat" %>
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
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
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
			<td><%=sdf.format(t.getU_date()) %></td>
		</tr>
		<tr>
			<th>상품등록일</th>
			<td><%=sdf.format(t.getC_date()) %></td>
		</tr>
		<tr>
			<th>상품설명</th>
			<td><textarea cols="50" rows="10" readonly><%=t.getDescribe() %></textarea></td>
		</tr>
		<tr>
			<th>상품사진</th>
			<td><img src="upload/<%=t.getImage() %>" style="max-width: 400px;"/></td>
		</tr>
		<tr>
			<td colspan="2" class="right">
				<form method="post" action="/TwiceCompany/" class="inline">
					<input type="hidden" name="contentPage" value="list.jsp">
					<input type="submit" value="리스트로 돌아가기">
				</form>
				<form method="post" action="/TwiceCompany/" class="inline">
					<input type="hidden" name="goods_id" value="<%=t.getGoods_id() %>">
					<input type="hidden" name="contentPage" value="update.jsp">
					<input type="submit" value="수정">
				</form>
				<form method="post" action="/TwiceCompany/" class="inline" onsubmit="return checkDelete()">
					<input type="hidden" name="goods_id" value="<%=t.getGoods_id() %>">
					<input type="hidden" name="contentPage" value="delete.jsp">
					<input type="submit" value="삭제">
				</form>
			</td>
		</tr>
	</tbody>
</table>
</body>
</html>