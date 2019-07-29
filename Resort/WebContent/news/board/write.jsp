<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="/Resort/">Home</a></li>
			<li class="breadcrumb-item">펜션 소식</li>
			<li class="breadcrumb-item"><a href="javascript:go('news/board/list.jsp');">리조트 소식</a></li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<form method="post" action="/Resort/" name="inputForm" onsubmit="return checkAll()">
			<table class="table">
				<tbody>
					<tr>
						<th>번호</th>
						<td>신규(insert)</td>
					<tr>
					<tr>
						<th>제목</th>
						<td>
							<input type="text" name="subject" id="subject" maxlength="50">
						</td>
					</tr>
					<tr>
						<th>일자</th>
						<td></td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea name="contents" id="contents" cols="50" rows="10" maxlength="5000"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="right">
							<input type="reset" value="취소">
							<input type="hidden" name="contentPage" value="news/board/writeDB.jsp">
							<input type="submit" value="쓰기">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</div>
