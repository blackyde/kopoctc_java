package com.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward = new ActionForward();
		
		forward.setNextPath("main.do");
		forward.setRedirect(true);
		request.getSession().setAttribute("isLogin", false);		
		
		return forward;
	}

}
