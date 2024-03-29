<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<h3>글쓰기</h3>
<hr>
<form method="post" action="/ReBoard/?contentPage=writeDB.jsp" name="inputForm" onsubmit="return checkAll()" enctype="multipart/form-data">
	<table class="table">
		<colgroup>
			<col style="width: 20%;" />
			<col width="*" />
		</colgroup>
		<tbody>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" name="subject" id="subject" maxlength="50">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="contents" id="contents" cols="50" rows="10" maxlength="5000"></textarea>
				</td>
			</tr>
			<tr>
				<th>파일</th>
				<td>
					<input type="file" name="file" id="file" multiple />
				</td>
			</tr>
			<tr>
				<td colspan="2" class="right">
					<input type="button" onclick="location.href='/ReBoard/'" value="취소">
					<input type="hidden" name="contentPage" value="writeDB.jsp">
					<input type="submit" value="쓰기">
				</td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>