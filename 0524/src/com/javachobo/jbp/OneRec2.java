package com.javachobo.jbp;

/**
 * @FileName : OneRec2.java
 * @Project : 0524
 * @Date : 2019. 5. 25.
 * @Author : JBP
 * @Descript : 클래스의 ArrayList
 */
public class OneRec2 {
		
	private int student_id;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	public OneRec2(int student_id, String name, int kor, int eng, int mat) {
		this.student_id = student_id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}
	
	public int student_id() {
		return this.student_id;
	}
	
	public String name() {
		return this.name;
	}
	
	public int kor() {
		return this.kor;
	}
	
	public int eng() {
		return this.eng;
	}
	
	public int mat() {
		return this.mat;
	}
	
	public int sum() {
		return this.kor + this.eng + this.mat;
	}
	
	public double avg() {
		return this.sum() / 3.0;
	}

}
