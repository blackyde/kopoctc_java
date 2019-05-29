package com.javachobo.jbp;

import java.util.ArrayList;

/**
 * @FileName : ArrayListEx2.java
 * @Project : 0524
 * @Date : 2019. 5. 26.
 * @Author : JBP
 * @Descript : ArrayList 2
 */
public class ArrayListEx2 {

	public static void main(String[] args) {

		int iTestMax = 1000000;
		ArrayList<Integer> iAL = new ArrayList<Integer>();
		
		for (int i = 0; i < iTestMax; i++) {
			iAL.add((int)(Math.random() * 1000000) + 1);
		} //100만번 돌면서 랜덤값을 넣어주자
		
		for (int i = 0; i < iAL.size(); i++) {
			System.out.printf(" ArrayList %d = %d\n", i, iAL.get(i));
		} //출력
		
		System.out.printf("*****************************************\n");
		iAL.sort(null); //정렬 오름차순
		for (int i = 0; i < iAL.size(); i++) {
			System.out.printf(" ArrayList %d = %d\n", i, iAL.get(i));
		} //다시 출력
	}
}