package jbp;

/**
 * @FileName : ArrayCompare.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : Array 이용 비교
 */
public class ArrayCompare {

	public static void main(String[] args) {
		
		int[] k08_iLMD = {31,28,31,30,31,30,31,31,30,31,30,31};
		//배열에 각 월의 마지막 날을 담는다.
		
		for(int k08_i = 1; k08_i < 13; k08_i++) { //k08_i : 1 ~ 12
			System.out.printf("%2d월 =>", k08_i); //월(k08_i) 출력
			for(int k08_j = 1; k08_j < 32; k08_j++) { //k08_j : 1 ~ 31
				System.out.printf("%d", k08_j); //일(k08_j) 출력

				if(k08_iLMD[k08_i-1] == k08_j) break;
				//1월일때 배열[0]번과 비교 .... 12월일때 배열[11]번과 비교
				
				System.out.printf(",");
				//마지막 날짜는 위에서 break 되므로 여기까지 오지 못한다.

			}
			System.out.printf("\n"); //개행
		}

	}

}
