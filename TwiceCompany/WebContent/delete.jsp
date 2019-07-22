<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page import = "com.twice.dto.*" %>
<%@ page import = "com.twice.dao.*" %>
<%
request.setCharacterEncoding("UTF-8");

String goods_ids = request.getParameter("goods_id");	
int goods_id = Integer.parseInt(goods_ids);

TwiceDao<Twice> td = new TwiceDaoImpl();	
Twice t = new Twice();
t.setGoods_id(goods_id);
int result = td.delete(t);

if(result != 0) {
%>
<form method="post" action="/TwiceCompany/" name="fr">
	<input type="hidden" name="contentPage" value="list.jsp">
</form>
<script>
fr.submit();
</script>
<%
} else {
%>
<form method="post" action="/TwiceCompany/" name="fr2">
	<input type="hidden" name="goods_id" value="<%=t.getGoods_id() %>">
	<input type="hidden" name="contentPage" value="item.jsp">
</form>
<script>
fr2.submit();
</script>
<%
}
%>