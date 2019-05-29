package jbp;

/**
 * @FileName : SimpleCompare.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : 단순비교 
 */
public class SimpleCompare {

	public static void main(String[] args) {

		int k08_iA, k08_iB;
		
		k08_iA = 0; //변수에 0을 대입
		while(true) { //무한 루프
			k08_iB = 0; //변수에 0을 대입. 바깥쪽 while문이 돌때마다 초기화 된다.
			while(true) { //무한 루프
				System.out.printf("*"); //별을 찍는다.
				
				if(k08_iA == k08_iB) break; //조건문 두 변수의 값이 같으면 루프를 끝낸다.
				k08_iB++; //루프마다 변수값을 1씩 증가시킨다.
			}
			System.out.printf("\n"); //개행문자
			k08_iA++; //루프마다 변수값을 1씩 증가시킨다.
			if(k08_iA == 30) break; //조건문 변수값이 30에 도달하면 루프를 끝낸다.
		}
	}
}
