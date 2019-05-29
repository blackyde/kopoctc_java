
/**
 * @FileName : PrintfEx2.java
 * @Project : 0520
 * @Date : 2019. 5. 20.
 * @Author : JBP
 * @Descript : printf 포맷에 대해 실습 2
 */
public class PrintfEx2 {

	public static void main(String[] args) {
		
		String k08_url = "www.codechobo.com";
		
		float k08_f1 = .10f; //0.10, 1.0e-1
		float k08_f2 = 1e1f; //10.0, 1.0e1, 1.0e+1
		float k08_f3 = 3.14e3f; //3140
		double k08_d = 1.23456789;
		
		System.out.printf("k08_f1=%f, %e, %g%n", k08_f1, k08_f1, k08_f1);
		System.out.printf("k08_f2=%f, %e, %g%n", k08_f2, k08_f2, k08_f2);
		System.out.printf("k08_f3=%f, %e, %g%n", k08_f3, k08_f3, k08_f3);
		//%f 실수 표준 표기, %e 실수 지수 표기, %g 상황에 따라 %f나 %e로 표현
		
		System.out.printf("k08_d=%f%n", k08_d); //조건이 없으면 소수점 6자리까지 표현
		System.out.printf("k08_d=%14.10f%n", k08_d); //전체 14자리 중 소수점 10자리
		
		System.out.printf("[12345678901234567890]%n"); //? 그냥 써진대로 출력
		System.out.printf("[%s]%n", k08_url); //문자열
		System.out.printf("[%20s]%n", k08_url); //20칸의 공간으로 오른쪽 정렬
		System.out.printf("[%-20s]%n", k08_url); //20칸의 공간 왼쪽 정렬
		System.out.printf("[%.8s]%n", k08_url); //왼쪽에서 8글자만 출력 (.이나 공백도 문자로 카운트)
	}

}
