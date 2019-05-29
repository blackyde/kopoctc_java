package jbp;

import java.text.DecimalFormat;

/**
 * @FileName : Spacing2.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : 칸 맞춰 인쇄
 */
public class Spacing2 {

	public static void main(String[] args) {

		String k08_item = "사과";
		int k08_unit_price = 5000;
		int k08_num = 500;
		int k08_total = k08_unit_price * k08_num;
		
		DecimalFormat k08_df = new DecimalFormat("###,###,###,###,###");
		
		// 헤더 찍기
		System.out.printf("==========================================================\n");
		System.out.printf("%20.20s%8.8s%8.8s%8.8s\n", "품목", "단가", "수량", "합계");
		//%20.20s : 20칸의 공간을 할당하고 왼쪽부터 20글자만 출력하여 오른쪽 정렬한다.
		System.out.printf("==========================================================\n");
		
		// 값 찍기
		System.out.printf("%20.20s%10.10s%10.10s%10.10s\n",
				k08_item, k08_df.format(k08_unit_price),
				k08_df.format(k08_num), k08_df.format(k08_total));
		//한글 1s 가 영문 2s 와 동일한 칸을 가진다.
		//8s 에 한글이 2글자 인 경우 실제로 차지하는 칸은 8 + 한글 2글자 * 1 = 10칸
		//영어, 숫자만 있는 곳과 비교하여 계산해야한다.
		System.out.printf("==========================================================\n");
	}

}
