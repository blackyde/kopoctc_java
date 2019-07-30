package com.book.dto;

public class OneShot {
	private String days;
	private int dow;
	private String room1;
	private String room2;
	private String room3;
	
	public OneShot(String days, int dow, String room1, String room2, String room3) {
		this.days = days;
		this.dow = dow;
		this.room1 = room1;
		this.room2 = room2;
		this.room3 = room3;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public int getDow() {
		return dow;
	}

	public void setDow(int dow) {
		this.dow = dow;
	}

	public String getRoom1() {
		return room1;
	}

	public void setRoom1(String room1) {
		this.room1 = room1;
	}

	public String getRoom2() {
		return room2;
	}

	public void setRoom2(String room2) {
		this.room2 = room2;
	}

	public String getRoom3() {
		return room3;
	}

	public void setRoom3(String room3) {
		this.room3 = room3;
	}
}
