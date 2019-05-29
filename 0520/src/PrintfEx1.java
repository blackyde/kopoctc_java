
/**
 * @FileName : PrintfEx1.java
 * @Project : 0520
 * @Date : 2019. 5. 20.
 * @Author : JBP
 * @Descript : printf 포맷에 대해 실습 
 */
public class PrintfEx1 {

	public static void main(String[] args) {
		
		byte k08_b = 1;
		short k08_s = 2;
		char k08_c = 'A';
		
		int k08_finger = 10;
		long k08_big = 100000000000L;
		long k08_hex = 0xFFFFFFFFFFFFFFFFL; // long k08_hex = 0xFFFFFFFFFFFFFFFFL;
		
		int k08_octNum = 010; // 8진수 10, 10진수로는 8
		int k08_hexNum = 0x10; // 16진수 10, 10진수로는 16
		int k08_binNum = 0b10; // 2진수 10, 10진수로는 2
		
		System.out.printf("k08_b=%d%n", k08_b); //%d 정수 그대로 출력
		System.out.printf("k08_s=%d%n", k08_s); //%d 정수
		System.out.printf("k08_c=%c, %d%n", k08_c, (int)k08_c); //%c는 문자
		System.out.printf("k08_finger=[%5d]%n", k08_finger); //%5d 5칸의 공간을 가지고 우측정렬
		System.out.printf("k08_finger=[%-5d]%n", k08_finger); //%-5d 5칸의 공간을 가지고 좌측정렬
		System.out.printf("k08_finger=[%05d]%n", k08_finger); //%05d 5칸의 공간을 가지고 빈칸을 0으로 채움
		System.out.printf("k08_big=%d%n", k08_big); //정수형 출력
		System.out.printf("k08_hex=%#x%n", k08_hex); // '#'은 접두사 (16진수 0X, 8진수 0)
		System.out.printf("k08_octNum=%o, %d%n", k08_octNum, k08_octNum); //%o 8진수로 출력
		System.out.printf("k08_hexNum=%x, %d%n", k08_hexNum, k08_hexNum); //%x 16진수로 출력
		System.out.printf("k08_binNum=%s, %d%n", Integer.toBinaryString(k08_binNum), k08_binNum);
		//%s 문자열. 10을 2진수형식으로 바꾼 뒤 문자열로 출력(숫자형은 0101 로 표현할 수 없으므로)
		
	}

}
