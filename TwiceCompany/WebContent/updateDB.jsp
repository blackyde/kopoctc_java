<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.twice.dto.Twice" %>
<%@ page import = "com.twice.dao.*" %>
<%@ page import = "com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import = "com.oreilly.servlet.MultipartRequest"%>
<%
request.setCharacterEncoding("UTF-8");
String goods_ids = request.getParameter("goods_id");
String goods_name = "";
String stocks = "";
String describe = "";
String oldimage = request.getParameter("image");
String newimage = "";
String image = oldimage;
int goods_id = Integer.parseInt(goods_ids);
int stock = 0;

String uploadPath = application.getRealPath("upload");

try {
	MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
			request, 
			uploadPath, // 파일을 저장할 디렉토리 지정
			1000 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
			"utf-8", // 인코딩 방식 지정
			new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
	);

	goods_name = multi.getParameter("goods_name");
	stocks = multi.getParameter("stock");
	describe = multi.getParameter("describe");
	stock = Integer.parseInt(stocks);
	
	newimage = multi.getFilesystemName("images"); // name=file1의 업로드된 시스템 파일명을 구함(중복된 파일이 있으면, 중복 처리 후 파일 이름)
	if(newimage.equals("")) {
		image = oldimage;
	} else if(newimage.length() < 1) {
		image = oldimage;
	} else {
		image = newimage;
	}
	
} catch (Exception e) {
	e.getStackTrace();
} // 업로드 종료

if(goods_name.equals("")) {
%>
<form method="post" action="/TwiceCompany/" name="fr1">
	<input type="hidden" name="goods_id" value="<%=goods_id %>">
	<input type="hidden" name="contentPage" value="update.jsp">
</form>
<script>
alert("파일 용량이 너무 큽니다.");
fr1.submit();
</script>
<%
} else {
	TwiceDao<Twice> td = new TwiceDaoImpl();
	Twice t = new Twice(goods_name, stock, describe, image);
	t.setGoods_id(goods_id);
	
	td.update(t);
	
	t = td.update(t);
	
%>
<form method="post" action="/TwiceCompany/" name="fr2">
	<input type="hidden" name="contentPage" value="item.jsp">
	<input type="hidden" name="goods_id" value="<%=t.getGoods_id()%>">
</form>
<script>
fr2.submit();
</script>
<%
}
%>
