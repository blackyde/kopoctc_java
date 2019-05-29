package com.javachobo.jbp;

public class InputData {

	int[] num;
	String[] name;
	int[] kor;
	int[] eng;
	int[] mat;
	int[] sum;
	double[] avg;

	InputData(int iPerson) {
		num = new int[iPerson];
		name = new String[iPerson];
		kor = new int[iPerson];
		eng = new int[iPerson];
		mat = new int[iPerson];
		sum = new int[iPerson];
		avg = new double[iPerson];
	}
	
	public void SetData(int num, String name, int kor, int eng, int mat) {
		this.num[num] = num;
		this.name[num] = name;
		this.kor[num] = kor;
		this.eng[num] = eng;
		this.mat[num] = mat;
		this.sum[num] = kor + eng + mat;
		this.avg[num] = this.sum[num] / 3.0;
	}
}
