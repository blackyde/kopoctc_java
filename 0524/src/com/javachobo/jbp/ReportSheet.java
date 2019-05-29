package com.javachobo.jbp;
/**
 * @FileName : ReportSheet.java
 * @Project : 0524
 * @Date : 2019. 5. 26.
 * @Author : JBP
 * @Descript : 클래스의 배열
 */
public class ReportSheet {

	public static void main(String[] args) {

		int iPerson = 10;
		InputData inData = new InputData(iPerson);
		
		for(int i = 0; i < iPerson; i++) {
			String name = String.format("홍길%02d", i + 1);
			int kor = (int)(Math.random() * 100) + 1;
			int eng = (int)(Math.random() * 100) + 1;
			int mat = (int)(Math.random() * 100) + 1;
			inData.SetData(i, name, kor, eng, mat);
		}
		
		for(int i = 0; i < iPerson; i++) {
			System.out.printf("번호:%02d, 이름:%s, 국어%3d, 영어:%3d, 수학:%3d, 총점:%3d 평균:%2.2f\n", 
					inData.num[i], inData.name[i], inData.kor[i], inData.eng[i],
					inData.mat[i], inData.sum[i], inData.avg[i]);
		}
	}
}