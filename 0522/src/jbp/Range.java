package jbp;

/**
 * @FileName : Range.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : 범위를 주어 비교(찾기)
 */
public class Range {

	public static void main(String[] args) {

		int k08_iVal;
		for(int k08_i = 0; k08_i < 300; k08_i++) { //k08_i : 0 ~ 299
			k08_iVal = 5 * k08_i; //5씩 증가. k08_i += 5
			if(k08_iVal >= 0 && k08_iVal < 10) System.out.printf("일 %d\n", k08_iVal);
			//0보다 크거나 같고 10보다 작으면 일 k08_iVal 출력
			else if(k08_iVal >= 10 && k08_iVal < 100) System.out.printf("십 %d\n", k08_iVal);
			//10보다 크거나 같고 100보다 작으면 십 k08_iVal 출력
			else if(k08_iVal >= 100 && k08_iVal < 1000) System.out.printf("백 %d\n", k08_iVal);
			//100보다 크거나 같고 1000보다 작으면 백 k08_iVal 출력
			else System.out.printf("천 %d\n", k08_iVal);
			//1000보다 크면 천 k08_iVal 출력
		}
	}
}