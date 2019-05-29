package jbp;

/**
 * @FileName : TimesTable3.java
 * @Project : 0523
 * @Date : 2019. 5. 23.
 * @Author : JBP
 * @Descript : 구구단 중복 코드를 하나로
 */
public class TimesTable3 {
	
	public static void timesTable(int row, int add) {
		//중복되지 않는 부분을 파라미터로 변경하고 값을 받아온다.
		for(int i = 1; i < row * 3 + 1; i += row) { 
			System.out.printf("*************\t*************\t*************\n");
			System.out.printf("구구단 %d 단\t구구단 %d 단\t구구단 %d 단\n", i, i + add, i + (2 * add));
			System.out.printf("*************\t*************\t*************\n");
			for(int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d\t%d * %d = %d\t%d * %d = %d\n",
						i, j, i * j, 
						i + add, j, (i + add) * j, 
						i + (2 * add), j, (i + (2 * add)) * j); 
			}
		}		
	}
	
	public static void timesTable2(int row, int add) {
		//구구단을 시작할 단 수와 옆으로 출력할 단수의 증가값을 받는다.
		System.out.printf("*************\t*************\t*************\n");
		System.out.printf("구구단 %d 단\t구구단 %d 단\t구구단 %d 단\n",
				row, row + add, row + (2 * add));
		//단수, 단수 + 증가값, 단수 + 2 * 증가값 : ex) 1, 1 + 1, 1 + 2 or 1, 1 + 3, 1 + 6
		System.out.printf("*************\t*************\t*************\n");
		for(int j = 1; j < 10; j++) { //단수에 상관없이 뒷자리는 1부터 9까지
			System.out.printf("%d * %d = %d\t%d * %d = %d\t%d * %d = %d\n",
					row, j, row * j, //row 단
					row + add, j, (row + add) * j, //row + 증가값 단 
					row + (2 * add), j, (row + (2 * add)) * j); //row + 2*증가값 단
		}
	}

	public static void main(String[] args) {
		
		for (int i = 1; i <= 3; i++) {
			timesTable2(i, 3); //가로 구구단을 1,2,3 증가값이 3
		}
		for (int i = 1; i <= 7; i+=3) {
			timesTable2(i, 1); //세로 구구단을 1,4,7 증가값이 1
		}
		
	}
}