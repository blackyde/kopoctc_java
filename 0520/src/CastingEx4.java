
/**
 * @FileName : CastingEx4.java
 * @Project : 0520
 * @Date : 2019. 5. 20.
 * @Author : JBP
 * @Descript : 형변환 4 
 */
public class CastingEx4 {

	public static void main(String[] args) {

		int    k08_i  = 91234567;      // 8자리의 10진수
		float  k08_f  = (float)k08_i;  // int를 float로 형변환
		int    k08_i2 = (int)k08_f;    // float를 다시 int로 형변환
		
		double k08_d  = (double)k08_i; // int를 double로 형변환
		int    k08_i3 = (int)k08_d;    // double을 다시 int로 형변환
		
		float  k08_f2 = 1.666f;
		int    k08_i4 = (int)k08_f2;
		
		System.out.printf("k08_i=%d%n", k08_i);
		System.out.printf("k08_f=%f k08_i2=%d%n", k08_f, k08_i2);
		System.out.printf("k08_d=%f k08_i3=%d%n", k08_d, k08_i3);
		System.out.printf("(int)%f=%d%n", k08_f2, k08_i4);
	}

}
