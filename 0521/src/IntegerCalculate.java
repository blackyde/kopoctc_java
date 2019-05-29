
/**
 * @FileName : IntegerCalculate.java
 * @Project : 0521
 * @Date : 2019. 5. 21.
 * @Author : JBP
 * @Descript : 정수형 연산(버림), 나머지 연산자 응용 
 */
public class IntegerCalculate {

	public static void main(String[] args) {

		/////////////////////////////////////////
		//#3. 정수형 변수의 나눗셈은 정수범위에서 버림.
		
		int k08_ii = 1000 / 3; //333.3333333333.... 이 아니다. 그냥 333
		System.out.printf("#3-1 : %d\n", k08_ii);
		
		k08_ii = 1000 % 3; 
		//나머지 연산자 % 1000을 3으로 나누고 남은 값 : 1000 % 3 = 333 * 3 + [1]
		System.out.printf("#3-2 : %d\n", k08_ii);
		
		//나머지 연산자의 응용
		
		for (int i = 0; i < 20; i++) {
			System.out.printf("#3-3 : %2d  ", i);
			
			if (((i + 1) % 5) == 0) { //숫자를 5번 쓰고 줄바꿈. 0 1 2 3 4(줄바꿈)
				System.out.printf("\n");
			}
		}	
		
	}

}
