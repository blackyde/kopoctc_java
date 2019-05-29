package jbp;

/**
 * @FileName : Pyramid.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : 피라미드 찍기
 */
public class Pyramid {

	public static void main(String[] args) {
		int k08_n, k08_m;
		//변수 n, m 선언
		k08_m = 20; //변수 m 에 20을 대입
		k08_n = 1;  //변수 n 에 1을 대입
		
		while(true) {
			for(int k08_i = 0; k08_i < k08_m; k08_i++) System.out.printf(" ");
			//i가 m보다 작은 동안 공백을 출력한다.
			for(int k08_i = 0; k08_i < k08_n; k08_i++) System.out.printf("*");
			//i가 n보다 작은 동안 *을 출력한다.
			System.out.printf("\n");
			//개행
			
			k08_m = k08_m - 1; //m값을 1씩 줄인다. 공백이 한칸씩 줄어든다.
			k08_n = k08_n + 2; //n값을 2씩 늘인다. 별이 2개씩 늘어난다.
			
			if (k08_m < 0) break; //m값이 0보다 작아지면 break
		}
	}

}
