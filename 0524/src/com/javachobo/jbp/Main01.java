package com.javachobo.jbp;

import java.util.ArrayList;

/**
 * @FileName : Main01.java
 * @Project : 0524
 * @Date : 2019. 5. 26.
 * @Author : JBP
 * @Descript : 클래스의 ArrayList 처리 부
 */
public class Main01 {

	static ArrayList<OneRec2> aor = new ArrayList<OneRec2>();
	
	static int sumkor = 0;
	static int sumeng = 0;
	static int summat = 0;
	static int sumsum = 0;
	static double sumavg = 0;
	static final int I_PERSON = 20;
	
	//데이터 만들기
	public static void dataSet() {
		for (int i = 0; i < I_PERSON; i++) {
			String name = String.format("홍길%02d", i);
			int kor = (int)(Math.random() * 100) + 1;
			int eng = (int)(Math.random() * 100) + 1;
			int mat = (int)(Math.random() * 100) + 1;
			aor.add(new OneRec2(i, name, kor, eng, mat));
		}
	}
	
	//헤더 인쇄
	public static void headerPrint() {
		System.out.printf("************************************\n");
		System.out.printf("%2s%4s %2s %2s %2s %2s  %2s\n", "번호", "이름",
				"국어", "영어", "수학", "합계", "평균");
		System.out.printf("************************************\n");
	}
	
	//내용 인쇄
	public static void itemPrint(int i) {
		OneRec2 rec;
		
		rec = aor.get(i);
		System.out.printf("%4d %4s %3d %3d %3d   %3d  %5.2f\n", rec.student_id(),
				rec.name(), rec.kor(), rec.eng(), rec.mat(), rec.sum(), rec.avg());
		
		sumkor += rec.kor();
		sumeng += rec.eng();
		summat += rec.mat();
		sumsum += rec.sum();
		sumavg += rec.avg();
	}
	
	//꼬리 인쇄
	public static void tailPrint() {
		System.out.printf("************************************\n");
		System.out.printf("국어합계: %6d   국어평균: %5.2f\n",
				sumkor, sumkor / (double)aor.size());
		System.out.printf("영어합계: %6d   영어평균: %5.2f\n",
				sumeng, sumeng / (double)aor.size());
		System.out.printf("수학합계: %6d   수학평균: %5.2f\n",
				summat, summat / (double)aor.size());
		System.out.printf("************************************\n");
		System.out.printf("반평균합계: %6.2f  반평균: %5.2f\n",
				sumavg, sumavg / (double)aor.size());
	}

}
