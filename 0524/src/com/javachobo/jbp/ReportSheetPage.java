package com.javachobo.jbp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @FileName : ReportSheetPage.java
 * @Project : 0524
 * @Date : 2019. 5. 25.
 * @Author : JBP
 * @Descript : 성적 집계표 1페이지
 */
public class ReportSheetPage {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat date = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");

		int iPerson = 30;
		InputData inData = new InputData(iPerson);
		
		for(int i = 0; i < iPerson; i++) {
			String name = String.format("홍길%02d", i + 1);
			int kor = (int)(Math.random() * 100) + 1;
			int eng = (int)(Math.random() * 100) + 1;
			int mat = (int)(Math.random() * 100) + 1;
			inData.SetData(i, name, kor, eng, mat);
		}
		
		int sumkor = 0;
		int sumeng = 0;
		int summat = 0;
		int sumsum = 0;
		double sumavg = 0.0;
		System.out.printf("\n%25s\n", "성적집계표");
		System.out.printf("\n%24s : %s\n", "출력일자", date.format(cal.getTime()));
		System.out.printf("===================================================\n");
		System.out.printf("%s%5s%7s%5s%5s%7s%6s\n", "번호", "이름", "국어", "영어" ,"수학", "총점", "평균");
		for(int i = 0; i < iPerson; i++) {
			System.out.printf(" %03d%7s%7d%7d%7d%9d%8.2f\n", 
					inData.num[i] + 1, inData.name[i], inData.kor[i], inData.eng[i],
					inData.mat[i], inData.sum[i], inData.avg[i]);
			sumkor += inData.kor[i];
			sumeng += inData.eng[i];
			summat += inData.mat[i];
			sumsum += inData.sum[i];
			sumavg += inData.avg[i];
		}
		System.out.printf("===================================================\n");
		System.out.printf("%s%16d%7d%7d%9d%8.2f\n",
				"합계", sumkor, sumeng, summat, sumsum, sumavg);
		System.out.printf("%s%16.2f%7.2f%7.2f%9.2f%8.2f\n",
				"평균", (double)sumkor / iPerson, (double)sumeng / iPerson,
				(double)summat / iPerson, (double)sumsum / iPerson, sumavg / iPerson);
	}
}