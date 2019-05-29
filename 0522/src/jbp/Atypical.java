package jbp;

/**
 * @FileName : Atypical.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : 비정형 비교1
 */
public class Atypical {

	public static void main(String[] args) {

		for(int k08_i = 1; k08_i < 13; k08_i++) { //k08_i : 1 ~ 12
			System.out.printf("%2d월 =>", k08_i); //월(k08_i) 출력
			for(int k08_j = 1; k08_j < 32; k08_j++) { //k08_j : 1 ~ 31				
				System.out.printf("%d,", k08_j); //일(k08_j) 출력
				
				if(k08_i == 1 && k08_j == 31) break;  // 1월 31일
				if(k08_i == 2 && k08_j == 28) break;  // 2월 28일
				if(k08_i == 3 && k08_j == 31) break;  // 3월 31일
				if(k08_i == 4 && k08_j == 30) break;  // 4월 30일
				if(k08_i == 5 && k08_j == 31) break;  // 5월 31일
				if(k08_i == 6 && k08_j == 30) break;  // 6월 30일
				if(k08_i == 7 && k08_j == 31) break;  // 7월 31일
				if(k08_i == 8 && k08_j == 31) break;  // 8월 31일
				if(k08_i == 9 && k08_j == 30) break;  // 9월 30일
				if(k08_i == 10 && k08_j == 31) break; //10월 31일
				if(k08_i == 11 && k08_j == 30) break; //11월 30일
				if(k08_i == 12 && k08_j == 31) break; //12월 31일
			}
			System.out.printf("\n");
		}
	}
}