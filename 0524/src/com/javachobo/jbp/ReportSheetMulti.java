package com.javachobo.jbp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @FileName : ReportSheetMulti.java
 * @Project : 0524
 * @Date : 2019. 5. 25.
 * @Author : JBP
 * @Descript : 성적 집계표 다페이지
 */
public class ReportSheetMulti {

	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat date = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");

		int iPerson = 200;
		InputData inData = new InputData(iPerson);
		
		for(int i = 0; i < iPerson; i++) {
			String name = String.format("홍길%02d", i + 1);
			int kor = (int)(Math.random() * 100) + 1;
			int eng = (int)(Math.random() * 100) + 1;
			int mat = (int)(Math.random() * 100) + 1;
			inData.SetData(i, name, kor, eng, mat);
		}
		
		int page = 0;
		int accuKor = 0;
		int accuEng = 0;
		int accuMat = 0;
		int accuSum = 0;
		double accuAvg = 0;
		int cut = 30;
		int avgcut = 0;
		for(int j = 0; j < iPerson; j++) {
			page ++;
			int sumkor = 0;
			int sumeng = 0;
			int summat = 0;
			int sumsum = 0;
			double sumavg = 0.0;
			System.out.printf("\n%25s\n", "성적집계표");
			System.out.printf("\n%s%d%18s : %s\n","PAGE : ", page, "출력일자", date.format(cal.getTime()));
			System.out.printf("====================================================\n");
			System.out.printf("%s%5s%7s%5s%5s%7s%7s\n", "번호", "이름", "국어", "영어" ,"수학", "총점", "평균");
			for(int i = j; i < j + cut; i++) {
				System.out.printf(" %03d  %-5s%7d%7d%7d%9d%9.2f\n", 
						inData.num[i] + 1, inData.name[i], inData.kor[i], inData.eng[i],
						inData.mat[i], inData.sum[i], inData.avg[i]);
				sumkor += inData.kor[i];
				sumeng += inData.eng[i];
				summat += inData.mat[i];
				sumsum += inData.sum[i];
				sumavg += inData.avg[i];
				accuKor += inData.kor[i];
				accuEng += inData.eng[i];
				accuMat += inData.mat[i];
				accuSum += inData.sum[i];
				accuAvg += inData.avg[i];
				if (i >= iPerson - 1) {
					break;
				}
			}
			avgcut = cut * page;
			if(avgcut > iPerson) {
				avgcut = iPerson;
			}
			System.out.printf("====================================================\n");
			System.out.printf("현재페이지\n");
			System.out.printf("%s%16d%7d%7d%9d%9.2f\n",
					"합계", sumkor, sumeng, summat, sumsum, sumavg);
			System.out.printf("%s%16.2f%7.2f%7.2f%9.2f%9.2f\n",
					"평균", (double)sumkor / cut, (double)sumeng / cut,
					(double)summat / cut, (double)sumsum / cut, sumavg / cut);
			System.out.printf("====================================================\n");
			System.out.printf("누적페이지\n");
			System.out.printf("%s%16d%7d%7d%9d%9.2f\n",
					"합계", accuKor, accuEng, accuMat, accuSum, accuAvg);
			System.out.printf("%s%16.2f%7.2f%7.2f%9.2f%9.2f\n",
					"평균", (double)accuKor / avgcut, (double)accuEng / avgcut,
					(double)accuMat / avgcut, (double)accuSum / avgcut,
					accuAvg / avgcut);
			j += cut - 1;
		}
		
	}
}