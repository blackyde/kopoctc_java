package com.javachobo.jbp;

/**
 * @FileName : ReportSheet2.java
 * @Project : 0524
 * @Date : 2019. 5. 26.
 * @Author : JBP
 * @Descript : 클래스의 배열
 */
public class ReportSheet2 {

	public static void main(String[] args) {

		int iPerson = 5;
		OneRec[] inData = new OneRec[iPerson];
		
		inData[0] = new OneRec("홍길01", 100, 100, 90);
		inData[1] = new OneRec("홍길02", 90, 90, 90);
		inData[2] = new OneRec("홍길03", 80, 70, 90);
		inData[3] = new OneRec("홍길04", 70, 60, 90);
		inData[4] = new OneRec("홍길05", 60, 100, 90);
		
		for (int i = 0; i < inData.length; i++) {
			System.out.printf("이름:%s, 국어:%3d, 영어:%3d, 수학:%3d, 총점:%3d, 평균:%2.2f\n", 
					inData[i].name(), inData[i].kor(), inData[i].eng(),
					inData[i].mat(), inData[i].sum(), inData[i].avg());
		}
	}
}