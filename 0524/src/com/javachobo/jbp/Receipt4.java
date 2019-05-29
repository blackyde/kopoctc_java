package com.javachobo.jbp;

import java.text.DecimalFormat;

/**
 * @FileName : Receipt4.java
 * @Project : 0524
 * @Date : 2019. 5. 26.
 * @Author : JBP
 * @Descript : 고정길이에서 필드 추출 처리
 */
public class Receipt4 {
	
	public static void main(String[] args) {
		
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");

		String[] receipt = {
				"01   미네랄 워터 생수     2,520   1     2,520",
				"02*  냉동 닭가슴살 1      5,880   1     5,880",
				"03   깨끗한 물티슈 1        800   1       800",
				"04*  냉동 차돌박이 바    15,800   1    15,800",
				"05   리얼 데일리너츠      9,980   1     9,980",
				"06*  냉동 돈 삼겹살       9,900   1     9,900",
				"07   냉동 닭안심 1k       5,980   1     5,980",
				"08   고르곤졸라 치즈      1,380   1     1,380",
				"09*  구운 김밥용 김       1,780   2     3,560",
				"10   냉동새우살 450       9,780   2    19,560",
				"11   버터 쿠키 400        2,980   2     5,960",
				"12*  일회용 종이컵 1     12,980   1    12,980",
				"13   감자 칩 오리지날       890   1       890",
				"14*  아몬드 크랜베리      4,980   3    14,940",
				"15   감자 칩 사워 크        980   1       980",
				"16   혼합 9곡 쌀 4        9,990   1     9,990",
				"17   참깨 스틱 과자       1,980   1     1,980",
				"18   냉동 양지 소고기     9,900   5    49,500",
				"19*  참기름과 들기름으    5,280   5    26,400",
				"20   믹스넛 견과류 8      9,980   1     9,980",
				"21*  자색 고구마 칩       1,180   1     1,180",
				"22   다크 초콜릿 10         980  10       980",
				"23   담백한 살코기 참     1,080   1     1,070",
				"24*  체다 치즈볼 스낵     4,780   2     9,560",
				"25*  화이트로즈 톤업크    6,175   1     6,175",
				"26   스키니마스카라(블    6,175   1     6,175",
				"27*  컬링 마스카라(블     5,225   1     5,225",
				"28   틴트사틴 샤이닝오    4,400   2     8,800",
				"29*  스팟 컨실러 베이     6,175   3    18,530",
				"30   스팟 컨실러 바닐     5,200   3    15,600",
				"31*  틴트크림 03 로       3,850   1     3,850",
				"32   틴트워터 02 체       4,400   1     4,400",
				"33   틴트크림 02 핑       4,400   1     4,400",
				"34*  틴트크림 04베리      5,225   1     5,225",
				"35   틴트사틴 스트롱스    4,400   1     4,400",
				"36   화이트로즈 미니컨    5,200   1     5,100"
				};
		
		int price = 0;
		//배열을 잘라 단가를 받을 변수
		int num = 0;
		//수량을 받을 변수
		int totalPrice = 0;
		//합계 금액을 받을 변수를 준비
		
		for (int i = 0; i < receipt.length; i++) {
			//배열의 수만큼 반복
			byte[] t = receipt[i].getBytes();
			//byte 배열을 만들고 문자열의 byte 타입을 담는다.
			try {
				t = receipt[i].getBytes("EUC-KR");
				//인코딩 방식이 다르므로 다시 EUC-KR 로 강제 변환 (3byte -> 2byte)
			} catch (Exception e) {
				e.printStackTrace();
			}
			price = Integer.parseInt(new String(t, 24, 8).trim().replace(",", ""));
			//가격부분만 고정길이로 자르고, 공백제거, 쉼표제거 후 정수로 형변환
			num = Integer.parseInt(new String(t, 32, 4).trim().replace(",", ""));
			//수량부분만 고정길이로 자르고, 공백제거, 쉼표제거 후 정수로 형변환
			totalPrice = Integer.parseInt(new String(t, 36, 9).trim().replace(",", ""));
			//합계부분만 고정길이로 자르고, 공백제거, 쉼표제거 후 정수로 형변환
			if (price * num != totalPrice) {
				System.out.printf("*************************************\n");
				System.out.printf("오류 [%s]\n", receipt[i]);
				System.out.printf("수정 [%s%7s]\n", receipt[i].substring(0, receipt[i].length() - 7), df.format(price * num));
				System.out.printf("*************************************\n");
			}
			
		}
		
	}

}
