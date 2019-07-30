<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-lg-12">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="/Resort/">Home</a></li>
			<li class="breadcrumb-item">펜션 소식</li>
			<li class="breadcrumb-item active"><a href="javascript:go('news/reboard/list.jsp');">이용 후기</a></li>
		</ol>
	</div>
</div>
<div class="row">
	<div class="col-lg-12">
		<form method="post" action="/Resort/?contentPage=news/reboard/writeDB.jsp" name="inputForm" onsubmit="return checkAll()" enctype="multipart/form-data">
			<table class="table">
				<colgroup>
					<col style="width: 20%;" />
					<col width="*" />
				</colgroup>
				<tbody>
					<tr>
						<th>제목</th>
						<td>
							<input type="text" name="subject" id="subject" maxlength="50" size="50">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea name="contents" id="contents" cols="50" rows="10" maxlength="5000" class="summernote"></textarea>
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
							<input type="button" onclick="javascript:go_list()" value="취소">
							<input type="submit" value="쓰기">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</div>
<form name="wform" method="post">
	<input type="hidden" name="contentPage">
</form>