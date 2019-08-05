<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.book.dao.*" %>
<%@ page import = "com.book.dto.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "org.json.simple.*" %>
<%
BookDao bd = new BookDaoImpl();
List<Book> list = bd.select();

JSONObject obj = new JSONObject();

try {
	JSONArray jArray = new JSONArray();//배열이 필요할때
	for (int i = 0; i < list.size(); i++) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("resv_date", String.format("%s", list.get(i).getResv_date()));
		map.put("room", String.format("%d", list.get(i).getRoom()));
		JSONObject sObject = new JSONObject(map);//배열 내에 들어갈 json
		jArray.add(sObject);
	}
	obj.put("book", jArray);//배열을 넣음
	
	out.println(obj.toString());

} catch (Exception e) {
	e.printStackTrace();
}
%>