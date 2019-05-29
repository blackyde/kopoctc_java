package jbp;

/**
 * @FileName : TimesTable.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : 구구단 인쇄
 */
public class TimesTable {

	public static void main(String[] args) {

		for(int i = 1; i < 10; i += 3) { //1부터 9까지 3씩 증가
			System.out.printf("*************\t*************\t*************\n");
			System.out.printf("구구단 %d 단\t구구단 %d 단\t구구단 %d 단\n", i, i+1, i+2);
			//i단, i+1단, i+2단을 한줄로 출력
			System.out.printf("*************\t*************\t*************\n");
			for(int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d\t%d * %d = %d\t%d * %d = %d\n",
						i, j, i * j, //i단
						i + 1, j, (i + 1) * j, //i+1단
						i + 2, j, (i + 2) * j); //i+2단
			}
		}
	}
}