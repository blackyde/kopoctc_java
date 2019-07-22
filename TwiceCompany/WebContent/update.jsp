<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.twice.dto.Twice" %>
<%@ page import = "com.twice.dao.*" %>
<%
request.setCharacterEncoding("UTF-8");

String goods_ids = request.getParameter("goods_id");
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
<h3 class="center">(주)트와이스 재고 현황 - 상품 수정</h3>
<hr>
<form method="post" action="updateDB.jsp?goods_id=<%=t.getGoods_id() %>&image=<%=t.getImage() %>" name="inputForm" onsubmit="return checkAll()" enctype="multipart/form-data">
	<table class="table">
		<tbody>
			<tr>
				<th>상품번호</th>
				<td>
					<input type="text" name="goods_id" id="goods_id" value="<%=t.getGoods_id() %>" readonly>
				</td>
			<tr>
			<tr>
				<th>상품명</th>
				<td>
					<input type="text" name="goods_name" id="goods_name" maxlength="20" value="<%=t.getGoods_name()%>">
					<script>
					// 입력을 제한 할 특수문자의 정규식			
					var replaceId = /[<>]/gi;
		
					$(document).ready(function() {
		
						$("#goods_name").on("focusout", function() {
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
					<input type="text" name="stock" id="stock" onkeyup="check('stock')" maxlength="6" value="<%=t.getStock()%>">					
				</td>
			</tr>
			<tr>
				<th>재고파악일</th>
				<td>
					<input type="text" name="u_date" id="u_date" value="자동 업데이트" readonly value="<%=t.getU_date()%>">					
				</td>
			</tr>
			<tr>
				<th>상품등록일</th>
				<td>
					<input type="text" name="c_date" id="c_date" value="자동 등록" readonly value="<%=t.getC_date()%>">					
				</td>
			</tr>
			<tr>
				<th>상품설명</th>
				<td>
					<textarea name="describe" id="describe" cols="50" rows="10" maxlength="1000"><%=t.getDescribe() %></textarea>
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
				<th>상품사진</th>
				<td>
					<img src="upload/<%=t.getImage() %>" style="max-width: 400px;"/>
					<input type="file" name="images" id="images">					
				</td>
			</tr>
			<tr>
				<td colspan="2" class="right">
					<input type="button" value="취소" onclick="location.href='/TwiceCompany/'">
					<input type="submit" value="쓰기">
				</td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>