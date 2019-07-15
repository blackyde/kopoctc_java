package com.jsp0709;

public class Student {
	private String name;
	private int studentid;
	private int kor;
	private int eng;
	private int mat;
	private int rank = 1;

	
	public Student(String name, int studentid, int kor, int eng, int mat) {
		this.name = name;
		this.studentid = studentid;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getSum() {
		return (this.kor + this.eng + this.mat);
	}
	
	public double getAvg() {
		return (this.kor + this.eng + this.mat) / 3.0;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
