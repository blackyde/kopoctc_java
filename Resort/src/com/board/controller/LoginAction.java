package com.board.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.connector.Connector;

public class LoginAction implements Action {
	
	final static Connection CONN = Connector.getConnection();
	
	public static boolean check(String id, String password) {
		
		String sql = String.format("SELECT id FROM member"
				+ " WHERE PASSWORD('%s') = auth_string", password);
		
		try {
			Statement stmt = CONN.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs != null) {
				while(rs.next()) {
					if(id.equals(rs.getString(1))) {
						return true;
					} else {
						return false;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		boolean isLogin = check(id, password);
		
		if(isLogin) {
			forward.setNextPath("main.do");
			forward.setRedirect(true);
			request.getSession().setAttribute("isLogin", true);
			request.getSession().setAttribute("loginCheck", "correct");
		} else {
			forward.setNextPath("login.do");
			forward.setRedirect(false);
			request.getSession().setAttribute("isLogin", false);
			request.getSession().setAttribute("loginCheck", "wrong");
			
		}
		
		return forward;
	}

}
