package com.javachobo.jbp;

import java.util.ArrayList;

/**
 * @FileName : ArrayListEx.java
 * @Project : 0524
 * @Date : 2019. 5. 25.
 * @Author : JBP
 * @Descript : ArrayList
 */
public class ArrayListEx {

	public static void main(String[] args) {

		ArrayList<String> iAL = new ArrayList<String>();
		
		iAL.add("abc");
		iAL.add("ABCD");
		iAL.add("efga");
		iAL.add("가나다0");
		iAL.add("1234");
		iAL.add("12rk34");
		
		System.out.printf("**********************\n");
		System.out.printf(" 시작 ArraySize %d \n", iAL.size());
		for(int i = 0; i < iAL.size(); i++) {
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
		}
		
		iAL.set(3, "가라라라"); //3번 어레이리스트 내용변경 가나다0 => 가라라라
		System.out.printf("**********************\n");
		System.out.printf(" 내용변경 ArraySize %d \n", iAL.size());
		for(int i = 0; i < iAL.size(); i++) {
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
		}
		
		iAL.remove(4); //4번 어레이리스트 삭제 1234 => 삭제
		System.out.printf("**********************\n");
		System.out.printf(" 내용삭제 ArraySize %d \n", iAL.size());
		for(int i = 0; i < iAL.size(); i++) {
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
		}
		
		iAL.sort(null); //정렬. 숫자 - ABC - abc - 한글 (ASCII 코드 순?)
		System.out.printf("**********************\n");
		System.out.printf(" 리스트Sort ArraySize %d \n", iAL.size());
		for(int i = 0; i < iAL.size(); i++) {
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
		}
		
		iAL.clear(); //어레이리스트 내용 전부 삭제
		System.out.printf("**********************\n");
		System.out.printf(" 전부삭제 ArraySize %d \n", iAL.size());
		for(int i = 0; i < iAL.size(); i++) {
			System.out.printf(" ArrayList %d = %s\n", i, iAL.get(i));
		}
	}
}