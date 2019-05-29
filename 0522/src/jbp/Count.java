package jbp;

/**
 * @FileName : Count.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : 숫자 읽기 
 */
public class Count {

	public static void main(String[] args) {

		String[] k08_units = {"영","일","이","삼","사","오","육","칠","팔","구"};
		//배열에 숫자를 읽는 문자 입력
		
		for(int k08_i = 0; k08_i < 101; k08_i++) { //k08_i : 0 ~ 100
			if(k08_i >= 0 && k08_i < 10) { //0보다 크거나 같고 10보다 작을때 
				System.out.printf("일의자리 : %s\n", k08_units[k08_i]);
				//증가하는 k08_i 값과 배열의 순서가 동일하므로 그대로 읽어준다.
			} else if(k08_i >= 10 && k08_i < 100) { //10보다 크거나 같고 100보다 작을때
				int k08_i10, k08_i0;
				k08_i10 = k08_i / 10; //10으로 나누어 10의 자리 수 판별
				k08_i0 = k08_i % 10; //10으로 나눈 나머지로 1의 자리 수 판별
				if(k08_i0 == 0) { //1의 자리가 0이면
					System.out.printf("십의자리 : %s십\n", k08_units[k08_i10]);
					//뒤에 십만 붙이고  개행
				} else { //1의 자리가 0이 아니면
					System.out.printf("십의자리 : %s십%s\n",
							k08_units[k08_i10], k08_units[k08_i0]);
					//십 뒤에 1의 자리를 붙이고 개행
				}
			} else { //100보다 크거나 같으면
				System.out.printf("==> %d\n", k08_i);
				//k08_i 그대로 출력
			}
		}
	}
}