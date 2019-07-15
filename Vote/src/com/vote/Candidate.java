package com.vote;

public class Candidate {
	private int id;
	private String name;
	private String group;
	
	public Candidate(int id, String name, String group) {
		this.id = id;
		this.name = name;
		this.group = group;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	
}
