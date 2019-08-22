package com.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {
		doProcess(request, response);
	}
	
	public void doProcess(HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, IOException {

		// 넘어온 커맨드를 추출하는 과정
		String requestURI = request.getRequestURI();
		int cmdIdx = requestURI.lastIndexOf("/") + 1;

		String command = requestURI.substring(cmdIdx);

		ActionForward forward = null;
		Action action = null;

		// 보여줄 화면 URL
		String form = "index.jsp?contentPage=";

		// 커맨드에 해당하는 액션을 실행한다.
		try {
			// 화면전환
			if(command.equals("main.do")) {	// 메인화면 이동
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form + "main.jsp");
			} else if(command.equals("login.do")) {	// 로그인화면 이동
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setNextPath(form + "login.jsp");
			}
			// 각종 처리 액션
            else if(command.equals("loginAction.do")) {	// 로그인 처리
                action = new LoginAction();
                forward = action.execute(request, response);
            } else if(command.equals("logoutAction.do")) {	// 로그아웃 처리
                action = new LogoutAction();
                forward = action.execute(request, response);
            }

			// 화면이동 - isRedirect() 값에 따라 sendRedirect 또는 forward를 사용
			// sendRedirect : 새로운 페이지에서는 request와 response객체가 새롭게 생성된다.
			// forward : 현재 실행중인 페이지와 forwad에 의해 호출될 페이지는
			//           request와 response 객체를 공유
			if(forward != null) {
				if (forward.isRedirect()) {
					response.sendRedirect(forward.getNextPath());
				} else {
					RequestDispatcher dispatcher = request
							.getRequestDispatcher(forward.getNextPath());
					dispatcher.forward(request, response);
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	} // end doProcess
}
