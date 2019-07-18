<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.twice.dto.Twice" %>
<%@ page import = "com.twice.dao.*" %>
<%
TwiceDao<Twice> td = new TwiceDaoImpl();
List<Twice> once = td.select();
List<Integer> id = new ArrayList<Integer>();
for(Twice t : once) {
	id.add(t.getGoods_id());
}
int goods_id = Collections.max(id) + 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<form method="post" action="/TwiceCompany/" name="inputForm" onsubmit="return checkAll()">
	<table class="table">
		<tbody>
			<tr>
				<th>상품번호</th>
				<td><%=goods_id %></td>
			<tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="goods_name" id="goods_name" maxlength="50">
					<script>
					// 입력을 제한 할 특수문자의 정규식			
					var replaceId = /[<>]/gi;
		
					$(document).ready(function() {
		
						$("#subject").on("focusout", function() {
							var x = $(this).val();
							if (x.length > 0) {
								if (x.match(replaceId)) {
									x = x.replace(replaceId, "");
								}
								$(this).val(x);
							}
						}).on("keyup", function() {
							$(this).val($(this).val().replace(replaceId, ""));
		
						});
		
					});
					</script>
				</td>
			</tr>
			<tr>
				<th>현재 재고수</th>
				<td>
					<input type="text" name="goods_name" id="goods_name" maxlength="50">					
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="contents" id="contents" cols="50" rows="10" maxlength="5000"></textarea>
					<script>    
					// 입력을 제한 할 특수문자의 정규식			
					var replaceId = /[<>]/gi;
		
					$(document).ready(function() {
		
						$("#contents").on("focusout", function() {
							var x = $(this).val();
							if (x.length > 0) {
								if (x.match(replaceId)) {
									x = x.replace(replaceId, "");
								}
								$(this).val(x);
							}
						}).on("keyup", function() {
							$(this).val($(this).val().replace(replaceId, ""));
		
						});
		
					});
					</script>
				</td>
			</tr>
			<tr>
				<td colspan="2" class="right">
					<input type="reset" value="취소">
					<input type="hidden" name="contentPage" value="writeDB.jsp">
					<input type="submit" value="쓰기">
				</td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>