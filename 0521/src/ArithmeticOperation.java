
/**
 * @FileName : ArithmeticOperation.java
 * @Project : 0521
 * @Date : 2019. 5. 21.
 * @Author : JBP
 * @Descript : 사칙연산, 연산 후 대입
 */
public class ArithmeticOperation {

	public static void main(String[] args) {
		
		/////////////////////////////////////////
		//#1. 연산후 대입, 사칙연산 순서대로
		int k08_ii;
		k08_ii = 1 + 2; // 왼쪽에서 오른쪽으로
		System.out.printf("#1-1 : %d\n", k08_ii);
		///////
		k08_ii = 1 + 2 * 3; // 왼쪽에서 오른쪽 but 곱하기가 먼저
		System.out.printf("#1-2 : %d\n", k08_ii);
		
		
	}

}
