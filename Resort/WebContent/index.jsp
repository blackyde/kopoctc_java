<%@ page import = "java.net.URLDecoder"%>
<%@ page import = "java.net.URLEncoder"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%@ page import = "java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String contentPage = request.getParameter("contentPage");
	if(contentPage == null) {
		contentPage = "main.jsp";
	}
	
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
        
        msg = "처음 방문 입니다.";
    
        // 쿠키 객체를 생성
        lastDate = new Cookie("lastdate", dates);
        
        // 쿠키 속성값을 설정
        lastDate.setMaxAge(365*24*60*60);    // 365일
        lastDate.setPath("/");
        
        // 쿠키를 추가
        response.addCookie(lastDate);
    }
	// 이미 방문한 적이 있는 클라이언트라면
    else {
        
        msg = "최근 접속일은 " + URLDecoder.decode(lastDate.getValue(), "UTF-8") + "입니다.";
        
        // 쿠키에 새 값을 추가
        lastDate.setValue(dates);
        
        // 쿠키를 추가
        response.addCookie(lastDate);
    }
%>
<jsp:include page="header.jsp" />
<jsp:include page="<%=contentPage %>">
	<jsp:param value="<%=msg %>" name="msg"/>
</jsp:include>
<jsp:include page="footer.jsp" />