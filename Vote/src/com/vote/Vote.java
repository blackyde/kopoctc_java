package com.vote;

public class Vote {
	private int id;
	private int age1;
	private int age2;
	private int age3;
	private int age4;
	private int age5;
	private int age6;
	private int age7;
	private int age8;
	private int age9;
	
	public Vote(int id, int age1, int age2, int age3,
			int age4, int age5, int age6, int age7, int age8, int age9) {
		this.id = id;
		this.age1 = age1;
		this.age2 = age2;
		this.age3 = age3;
		this.age4 = age4;
		this.age5 = age5;
		this.age6 = age6;
		this.age7 = age7;
		this.age8 = age8;
		this.age9 = age9;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge1() {
		return age1;
	}
	public void setAge1(int age1) {
		this.age1 = age1;
	}
	public int getAge2() {
		return age2;
	}
	public void setAge2(int age2) {
		this.age2 = age2;
	}
	public int getAge3() {
		return age3;
	}
	public void setAge3(int age3) {
		this.age3 = age3;
	}
	public int getAge4() {
		return age4;
	}
	public void setAge4(int age4) {
		this.age4 = age4;
	}
	public int getAge5() {
		return age5;
	}
	public void setAge5(int age5) {
		this.age5 = age5;
	}
	public int getAge6() {
		return age6;
	}
	public void setAge6(int age6) {
		this.age6 = age6;
	}
	public int getAge7() {
		return age7;
	}
	public void setAge7(int age7) {
		this.age7 = age7;
	}
	public int getAge8() {
		return age8;
	}
	public void setAge8(int age8) {
		this.age8 = age8;
	}
	public int getAge9() {
		return age9;
	}
	public void setAge9(int age9) {
		this.age9 = age9;
	}
	public int getAllAge() {
		return age1 + age2 + age3 + age4 + age5 + age6 + age7 + age8 + age9;
	}
}
