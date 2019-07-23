package com.board.dto;

import java.sql.Timestamp;

public class Board {

	private int write_num;
	private String subject;
	private Timestamp write_date;
	private String contents;
	private int rootid;
	private int relevel;
	private int recnt;
	private int viewcnt;
	
	public Board() {
		
	}
	
	public Board(String subject, String contents) {
		this.subject = subject;
		this.contents = contents;
	}
	
	public Board(String subject, String contents,
			int rootid, int relevel) {
		this.subject = subject;
		this.contents = contents;
		this.rootid = rootid;
		this.relevel = relevel;
	}
	
	public int getWrite_num() {
		return write_num;
	}
	public void setWrite_num(int write_num) {
		this.write_num = write_num;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Timestamp getWrite_date() {
		return write_date;
	}
	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getRootid() {
		return rootid;
	}
	public void setRootid(int rootid) {
		this.rootid = rootid;
	}
	public int getRelevel() {
		return relevel;
	}
	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}

	public int getRecnt() {
		return recnt;
	}

	public void setRecnt(int recnt) {
		this.recnt = recnt;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}
}
