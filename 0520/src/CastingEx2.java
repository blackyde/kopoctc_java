
/**
 * @FileName : CastingEx2.java
 * @Project : 0520
 * @Date : 2019. 5. 20.
 * @Author : JBP
 * @Descript : 형변환 2 
 */
public class CastingEx2 {

	public static void main(String[] args) {
		
		int k08_i = 10;
		byte k08_b = (byte)k08_i;
		System.out.printf("[int -> byte] k08_i=%d -> k08_b=%d%n", k08_i, k08_b);
		
		k08_i = 300;
		k08_b = (byte)k08_i;
		System.out.printf("[int -> byte] k08_i=%d -> k08_b=%d%n", k08_i, k08_b);
		
		k08_b = 10;
		k08_i = (int)k08_b;
		System.out.printf("[byte -> int] k08_b=%d -> k08_i=%d%n", k08_b, k08_i);
		
		k08_b = -2;
		k08_i = (int)k08_b;
		System.out.printf("[byte -> int] k08_b=%d -> k08_i=%d%n", k08_b, k08_i);
		
		System.out.println("k08_i=" + Integer.toBinaryString(k08_i));
	}

}
