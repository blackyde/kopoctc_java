package jbp;

/**
 * @FileName : Spacing.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : 띄어쓰기
 */
public class Spacing {

	public static void main(String[] args) {

		for(int k08_i = 0; k08_i < 10; k08_i++) { //i : 0 ~ 9
			for(int k08_j = 0; k08_j < k08_i; k08_j++) { //j : 0 ~ i
				System.out.printf(" ");
				//j가 i와 같아질 때 까지 공백을 출력
			}
			System.out.printf("%d\n", k08_i);
			//i값을 출력하고 개행
		}
	}
}