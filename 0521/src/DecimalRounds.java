
/**
 * @FileName : DecimalRounds.java
 * @Project : 0521
 * @Date : 2019. 5. 21.
 * @Author : JBP
 * @Descript : 소수점 자리의 반올림 버림 처리
 */
public class DecimalRounds {

	public static void main(String[] args) {

		/////////////////////////////////////////
		//#5. 소수점 이하에서는 어떻게 할까?
		
		int k08_MyVal = 14 / 5; //2.8 이지만 int에서는 버려진다.
		System.out.printf("#5-1 : %d\n", k08_MyVal);
		
		double k08_MyValF;
		
		k08_MyValF = 14 / 5; //소수형 연산이 되지 않는다.
		System.out.printf("#5-2 : %f\n", k08_MyValF);
		
		k08_MyValF = 14.0 / 5; //두 수중 하나라도 실수여야 결과가 실수로 나온다
		System.out.printf("#5-3 : %f\n", k08_MyValF);
		
		k08_MyValF = (14.0) / 5 + 0.5; //실수형 계산에 0.5 더하기
		System.out.printf("#5-4 : %f\n", k08_MyValF);
		
		k08_MyVal = (int)((14.0) / 5 + 0.5); //실수형 계산후 정수로 형변환
		System.out.printf("#5-5 : %d\n", k08_MyVal);
	}

}
