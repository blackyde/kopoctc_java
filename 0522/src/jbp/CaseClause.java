package jbp;

/**
 * @FileName : CaseClause.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : Case문 비교
 */
public class CaseClause {

	public static void main(String[] args) {

		for(int k08_i = 1; k08_i < 13; k08_i++) { //k08_i : 1 ~ 12
			System.out.printf("%2d월 =>", k08_i); //월(k08_i) 출력
			k08_LOOP : for(int k08_j = 1; k08_j < 32; k08_j++) { //k08_j : 1 ~ 31
				//for문에 이름을 붙인다.
				//이름을 붙이면 하나 이상의 반복문을 이름으로 빠져나갈 수 있다.
				System.out.printf("%d,", k08_j); //일(k08_j) 출력

				switch(k08_i) {
				//k08_i 의 값으로 조건을 구분한다.
				case 4:case 6:case 9:case 11:
					//4, 6, 9, 11월 일때
					if(k08_j == 30) break k08_LOOP;
					//30일때 k08_LOOP를 빠져나간다.
					break;
					//case 문의 break. 없으면 4,6,9,11이 다 2월처럼 된다.
				case 2:
					//2월
					if(k08_j == 28) break k08_LOOP;
					//28일때 k08_LOOP를 빠져나간다.
					break;
				}

			}
			System.out.printf("\n"); //개행
		}
	}
}