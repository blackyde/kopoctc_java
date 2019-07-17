package com.board.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Board {

	private int write_num;
	private String subject;
	private Timestamp write_date;
	private String contents;
	
	public Board() {
		
	}
	
	public Board(String subject, String contents) {
		this.subject = subject;
		this.contents = contents;
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
	public String getWrite_date() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");		
		return sdf.format(write_date);
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
}
