package jbp;

/**
 * @FileName : Sin.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : sin함수 그래프
 */
public class Sin {

	public static void main(String[] args) {

		double k08_fSin;
		
		for(int k08_i = 0; k08_i < 360; k08_i++) {
			//i : 0 ~ 359
			k08_fSin = Math.sin(k08_i * 3.141592 / 180);
			//2pi radian = 360 degree
			//1 radian = 360 / 2pi degree = 180 / pi degree
			//1 degree = pi / 180 radian
			//i degree 의 sin 함수 값 = i * pi / 180
			System.out.printf("%d sin ==>%f\n", k08_i, k08_fSin);
		}
		
		for(int k08_i = 0; k08_i < 360; k08_i++) {
			//i : 0 ~ 359
			k08_fSin = Math.sin(k08_i * 3.141592 / 180);
			//sin 함수가 -1 ~ 1 까지 나왔다.
			int k08_iSpace = (int)((1.0 - k08_fSin) * 50);
			//1 - sin 함수 = 0 ~ 2 (1에서 1을 빼면 0, 1에서 -1을 빼면 2)
			//50을 곱하면 0 ~ 100
			for(int k08_j = 0; k08_j < k08_iSpace; k08_j++) System.out.printf(" ");
			//나온 수 만큼 공백을 출력
			System.out.printf("*[%f][%d]\n", k08_fSin, k08_iSpace);
			//*, sin 함수값, 공백의 수 를 출력
		}
	}
}