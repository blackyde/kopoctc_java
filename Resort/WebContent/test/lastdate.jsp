<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 마지막 방문일을 저장하고 있는 쿠키를 저장할 객체
    Cookie lastDate = null;
    
    // 화면에 출력할 메시지를 저장할 문자열 변수
    String msg = "";
    
    // 마지막 방문일을 저장하고 있는 쿠키가 존재하는지를 판별할 변수
    boolean isDate = false;
    
    // 현재 시간을 저장
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
	Calendar cal = Calendar.getInstance();
	String dates = sdf.format(cal.getTime());
	dates = URLEncoder.encode(dates, "UTF-8");
    
    // 쿠키를 얻는다.
    Cookie[] cookies = request.getCookies();
    
    // 마지막 방문 일을 정하고 있는 쿠키를 검색
    if (cookies != null) {
        
        for (int i = 0; i < cookies.length; i++) {
            
            lastDate = cookies[i];
            
            if (lastDate.getName().equals("lastdate")) {
                
                isDate = true;
                break;
            }
        }
    }
    
    // 처음 방문일 경우 새 쿠키 생성
    if (!isDate) {
        
        msg = "처음 방문 입니다......";
    
        // 쿠키 객체를 생성
        lastDate = new Cookie("lastdate", dates);
        
        // 쿠키 속성값을 설정
        lastDate.setMaxAge(365*24*60*60);    // 365일
        lastDate.setPath("/");
        
        // 쿠키를 추가
        response.addCookie(lastDate);
    }
    
    else {    // 이미 방문한 적이 있는 클라이언트라면
        
        msg = "당신의 마지막 방문 : " + URLDecoder.decode(lastDate.getValue(), "UTF-8");
        
        // 쿠키에 새 값을 추가
        lastDate.setValue(dates);
        
        // 쿠키를 추가
        response.addCookie(lastDate);
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마지막 방문 일을 출력하는 웹 페이지를 쿠키를 이용하여 작성하기</title>
</head>
<body>
<h2><%= msg %></h2>
</body>
</html>