package kr.ac.kopo.ctc.kopo08.domain;

import java.sql.Timestamp;

public class Account {
	private int id;
	private String title;
	private Timestamp created;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
}
