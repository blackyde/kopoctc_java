package com.board.controller;

public class ActionForward {
	
	private boolean isRedirect = false;
	private String nextPath = null;
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isREdirect) {
		this.isRedirect = isREdirect;
	}
	public String getNextPath() {
		return nextPath;
	}
	public void setNextPath(String nextPath) {
		this.nextPath = nextPath;
	}	
}
