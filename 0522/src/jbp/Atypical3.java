package jbp;

/**
 * @FileName : Atypical3.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : 비정형비교 3
 */
public class Atypical3 {

	public static void main(String[] args) {
		
		for(int k08_i = 1; k08_i < 13; k08_i++) { //k08_i : 1 ~ 12
			System.out.printf("%2d월 =>", k08_i); //월(k08_i) 출력
			for(int k08_j = 1; k08_j < 32; k08_j++) { //k08_j : 1 ~ 31				
				System.out.printf("%d,", k08_j); //일(k08_j) 출력
				
				if((k08_i == 4 || k08_i == 6 || k08_i == 9 || k08_i == 11)
						&& (k08_j == 30)) break;
				//4, 6, 9, 11월 이고 30일일때 break
				
				if((k08_i == 2)	&& (k08_j == 28)) break;
				//2월이고 28일일때 break
				
			}
			System.out.printf("\n"); //개행
		}
	}
}