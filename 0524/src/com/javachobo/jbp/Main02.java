package com.javachobo.jbp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

/**
 * @FileName : Main02.java
 * @Project : 0524
 * @Date : 2019. 5. 26.
 * @Author : JBP
 * @Descript : 다페이지 + OneRec
 */
public class Main02 {

	static ArrayList<OneRec2> aor2 = new ArrayList<OneRec2>();
	
	static int sumkor = 0;
	static int sumeng = 0;
	static int summat = 0;
	static int sumsum = 0;
	static double sumavg = 0;
	static final int I_PERSON = 300;
	static int accuKor = 0;
	static int accuEng = 0;
	static int accuMat = 0;
	static int accuSum = 0;
	static double accuAvg = 0;
	static int page = 0;
	static int cut = 15;
	static int avgcut = 0;
	
	//데이터 만들기
	public static void dataSet() {
		for (int i = 0; i < I_PERSON; i++) {
			String name = String.format("홍길%02d", i);
			int kor = (int)(Math.random() * 100) + 1;
			int eng = (int)(Math.random() * 100) + 1;
			int mat = (int)(Math.random() * 100) + 1;
			aor2.add(new OneRec2(i, name, kor, eng, mat));
		}
	}
	
	public static void dataSort() {
		Comparator<OneRec2> bikyo = new Comparator<OneRec2>() {

			@Override
			public int compare(OneRec2 o1, OneRec2 o2) {
				// TODO Auto-generated method stub
				return (o2.sum() - o1.sum());
			}
			
		};
		Collections.sort(aor2, bikyo);
	}
	
	public static void run() {
		
		dataSet();
		//데이터 생성
		dataSort();
		//데이터 정렬
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat date = new SimpleDateFormat("YYYY.MM.dd HH:mm:ss");
		OneRec2 rec;
		//OneRec2 객체 생성
		
		for(int j = 0; j < I_PERSON; j++) {
			//for문 200명
			page ++;
			//몇페이지 인가
			sumkor = 0;
			sumeng = 0;
			summat = 0;
			sumsum = 0;
			sumavg = 0.0;
			//페이지별 sum 은 초기화해준다.
			System.out.printf("\n%25s\n", "성적집계표");
			System.out.printf("\n%s%d%18s : %s\n","PAGE : ", page, "출력일자", date.format(cal.getTime()));
			System.out.printf("====================================================\n");
			System.out.printf("%s%5s%7s%5s%5s%7s%7s\n", "번호", "이름", "국어", "영어" ,"수학", "총점", "평균");
			for(int i = j; i < j + cut; i++) {
				//위에서 받은 j 부터 cut(30명)
				rec = aor2.get(i);
				//클래스의 ArrayList에서 data를 get
				System.out.printf(" %03d  %-5s%7d%7d%7d%9d%9.2f\n", 
						rec.student_id(), rec.name(), rec.kor(), rec.eng(),
						rec.mat(), rec.sum(), rec.avg());
				sumkor += rec.kor();
				sumeng += rec.eng();
				summat += rec.mat();
				sumsum += rec.sum();
				sumavg += rec.avg();
				accuKor += rec.kor();
				accuEng += rec.eng();
				accuMat += rec.mat();
				accuSum += rec.sum();
				accuAvg += rec.avg();
				//초기화 되지 않는 accu 는 계속 누적
				if (i >= I_PERSON - 1) {
					break;
					//배열의 인덱스 0~199 를 넘어가면 break
				}
			}
			avgcut = cut * page;
			//30명씩 2페이지면 60명으로 평균을 낸다.
			if(avgcut > I_PERSON) {
				avgcut = I_PERSON;
				//avgcut 이 총원보다 많아지면 안된다.
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
			//페이지별 평균은 30명으로 나누고 누적 평균은 avgcut 만큼 나눈다.
			j += cut - 1;
			//j값에 29를 더해준다. for문이 돌면서 또 1이 더해진다. 0 + 29 + 1 = 30
			//30명째부터 또 돈다.
		}
	}
}