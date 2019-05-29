
/**
 * @FileName : CastingEx3.java
 * @Project : 0520
 * @Date : 2019. 5. 20.
 * @Author : JBP
 * @Descript : 형변환 3 : float 의 정확도
 */
public class CastingEx3 {

	public static void main(String[] args) {

		float k08_f   = 9.1234567f;
		double k08_d  = 9.1234567;
		double k08_d2 = (double)k08_f;
		
		System.out.printf("k08_f =%20.18f%n", k08_f);
		System.out.printf("k08_d =%20.18f%n", k08_d);
		System.out.printf("k08_d2=%20.18f%n", k08_d2);
	}

}
