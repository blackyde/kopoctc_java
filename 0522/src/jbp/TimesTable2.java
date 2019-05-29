package jbp;

/**
 * @FileName : TimesTable2.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : 구구단 인쇄(2)
 */
public class TimesTable2 {

	public static void main(String[] args) {
		
		for(int i = 1; i < 4; i++) { //1부터 3까지 1씩 증가
			System.out.printf("*************\t*************\t*************\n");
			System.out.printf("구구단 %d 단\t구구단 %d 단\t구구단 %d 단\n", i, i+3, i+6);
			//i단, i+3단, i+6단을 한줄로 출력
			System.out.printf("*************\t*************\t*************\n");
			for(int j = 1; j < 10; j++) {
				System.out.printf("%d * %d = %d\t%d * %d = %d\t%d * %d = %d\n",
						i, j, i * j, //i단
						i + 3, j, (i + 3) * j, //i+3단
						i + 6, j, (i + 6) * j); //i+6단
			}
		}

	}

}
