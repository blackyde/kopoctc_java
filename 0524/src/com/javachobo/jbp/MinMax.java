package com.javachobo.jbp;

/**
 * @FileName : MinMax.java
 * @Project : 0524
 * @Date : 2019. 5. 25.
 * @Author : JBP
 * @Descript : 배열의 최대, 최소값 찾기
 */
public class MinMax {

	public static void main(String[] args) {
		
		int[] iArray = {1,7,5,3,2,1,3,4,9,12,0,212,33,11,21,11,2121,121,11,5,6,33};
		
		for(int i = 0; i < iArray.length; i++) {
			System.out.printf("iArray[%d] = %d\n", i, iArray[i]);
		}
		//Max, Min 찾기
		int iMax = iArray[0]; //처음부터 시작 첫 value
		int iMaxPt = 0; //index 값
		int iMin = iArray[0]; //최소값도 처음부터 시작
		int iMinPt = 0; //최소값 index
		for (int i = 0; i < iArray.length; i++) { //배열의 수만큼 루프
			if (iMax < iArray[i]) { //iMax 변수와 배열의 수를 비교하여 배열의 수가 크면
				iMax = iArray[i]; //iMax 변수에 해당 배열의 수를 담고
				iMaxPt = i; //iMaxPt 변수에 해당 배열의 index 를 담는다.
			}
			
			if (iMin > iArray[i]) {//iMin 변수와 배열의 수를 비교하여 배열의 수가 작으면
				iMin = iArray[i]; //iMin 변수에 해당 배열의 수를 담고
				iMinPt = i; //iMinPt 변수에 해당 배열의 index 를 담는다.
			}
		}
		
		System.out.printf("MAX : iArray[%d] = %d\n", iMaxPt, iMax);
		System.out.printf("MIN : iArray[%d] = %d\n", iMinPt, iMin);
	}
}
