
/**
 * @FileName : OverflowEx.java
 * @Project : 0520
 * @Date : 2019. 5. 20.
 * @Author : JBP
 * @Descript : overflow 에 대하여 실습
 */
public class OverflowEx {

	public static void main(String[] args) {
		
		short k08_sMin = -32768;
		short k08_sMax = 32767;
		char k08_cMin = 0;
		char k08_cMax = 65535;
		
		System.out.println("k08_sMin = " + k08_sMin);
		System.out.println("k08_sMin - 1 = " + (short)(k08_sMin - 1));
		System.out.println("k08_sMax = " + k08_sMax);
		System.out.println("k08_sMax + 1 = " + (short)(k08_sMax + 1));
		System.out.println("k08_cMin = " + (int)k08_cMin);
		System.out.println("k08_cMin - 1 = " + (int)--k08_cMin);
		System.out.println("k08_cMax = " + (int)k08_cMax);
		System.out.println("k08_cMax + 1 = " + (int)++k08_cMax);
	}

}
