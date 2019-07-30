package com.book.dto;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] resv_arr = new String[5][30];
		
		resv_arr[2][3] = "김나나";
		
		for(int i = 0; i < resv_arr[0].length; i++) {
			for(int j = 0; j < resv_arr.length; j++) {
				System.out.print(resv_arr[j][i] + ", ");
			}
			System.out.println();
		}
	}

}
