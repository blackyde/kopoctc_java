/**
 * @FileName : Accumulate.java
 * @Project : 0521
 * @Date : 2019. 5. 21.
 * @Author : JBP
 * @Descript : 누적하기
 */
public class Accumulate {

	public static void main(String[] args) {

		/////////////////////////////////////////
		//#2. 누적하기, 합구하기
		
		int k08_sum; //c는 맨 앞에서만 선언해야 하지만, c++, java는 필요할 때 선언해도 됨
				
		k08_sum = 0; //누적, 루프는 꼭 초기화
		
		//1부터 100까지 더해보자.
		for (int i = 1; i < 101; i++) { //1에서 시작 101보다 작을때까지(= 1~100) 1씩증가
			k08_sum = k08_sum + i; //[sum 에 i 를 더한 값을 sum 에 대입] 을 누적
		}
		System.out.printf("#2 : %d\n", k08_sum);
		//평균
		System.out.printf("#2-2 : %d\n", k08_sum / 100); //sum 을 100으로 나눈 값
		
		//응용
		
		int[] k08_v = {1, 2, 3, 4, 5}; //배열 선언과 동시에 값을 5개 입력
		int k08_vSum;
		
		k08_vSum = 0;
		
		for (int i = 0; i < 5; i ++) {
			k08_vSum = k08_vSum + k08_v[i]; //sum 에 배열의 index 에 해당하는 value를 더한다.
		}
		
		System.out.printf("#2-3 : %d\n", k08_vSum);
		
	}

}
