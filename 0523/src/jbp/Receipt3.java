package jbp;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @FileName : Receipt3.java
 * @Project : 0523
 * @Date : 2019. 5. 23.
 * @Author : JBP
 * @Descript : 영수증 출력 3
 */
public class Receipt3 {

	public static void main(String[] args) {
		
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat register = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		
		String itemname[]= {"미네랄 워터 생수 (2L x 6개입)","냉동 닭가슴살 1kg","깨끗한 물티슈 100매",
				"냉동 차돌박이 바로구이 소고기 (600g)",
				"리얼 데일리너츠 400g(20gx20개입)","냉동 돈 삼겹살 바로구이(1kg)","냉동 닭안심 1kg",
				"고르곤졸라 치즈 소프트 콘 145g","구운 김밥용 김 (10매)",
				"냉동새우살 450g","버터 쿠키 400g","일회용 종이컵 180ml1400개","감자 칩 오리지날 110g",
				"아몬드 크랜베리 시리얼 630g","감자 칩 사워 크림 & 어니언 110g","혼합 9곡 쌀 4kg",
				"참깨 스틱 과자 220g",
				"냉동 양지 소고기 샤브샤브 (600g)","참기름과 들기름으로 구운 우리 재래 김 80g",
				"믹스넛 견과류 800g",
				"자색 고구마 칩 스낵 110g","다크 초콜릿 100g","담백한 살코기 참치 90g",
				"체다 치즈볼 스낵 370g","화이트로즈 톤업크림","스키니마스카라(블랙)","컬링 마스카라(블랙)",
				"틴트사틴 샤이닝오렌지","스팟 컨실러 베이지",
				"스팟 컨실러 바닐라","틴트크림 03 로즈쉬폰","틴트워터 02 체리핑크","틴트크림 02 핑크레이디",
				"틴트크림 04베리라떼","틴트사틴 스트롱스트로베리","화이트로즈 미니컨실팩트 베이지"};
	      
		int num[] = {100,1,1,1,1,1,1,1,2,2,2,1,1,3,1,1,1,5,5,1,1,1,1,2,1,1,1,2,
				3,3,1,1,1,1,1,1};
		long price[] = {10000000,5880,800,15800,9980,9900,5980,1380,1780,9780,2980,
				12980,890,4980,980,9990,1980,9900,5280,9980,1180,980,1080,
				4780,6175,6175,5225,4400,6175,5200,3850,4400,4400,5225,4400,5200};
		
		boolean[] taxfree = {false,true,false,true,false,true,false,false,true,false,false,
				true,false,true,false,false,false,false,true,false,true,false,false,true,
				true,false,true,false,true,false,true,false,false,true,false,false};
		
		long sum = 0;
		int free = 0;
		
		String shopName = "이마트 죽전점";
		String tel = "(031)888-1234";
		String address = "용인시 수지구 포은대로 552";
		String name = "이갑수";
		String businessNum = "206-86-50913";
		String process = "구 매";
		String posNum = "0009-2418";
		
		System.out.printf(" emart %20s %s\n", shopName, tel);
		System.out.printf("%32s  %s\n", businessNum, name);
		System.out.printf("%36s\n", address);
		System.out.printf("\n\n");
		System.out.printf("영수증 미지참시 교환/환불 불가(30일내)\n");
		System.out.printf("교환/환불 구매점에서 가능(결제카드지참)\n");
		System.out.printf("체크카드/신용카드 청구취소 반영은\n");
		System.out.printf("최대 3~5일 소요 (주말,공휴일제외)\n");
		System.out.printf("\n");
		System.out.printf("[%s]%s%16s%s\n", process, register.format(cal.getTime()), "POS:", posNum);
		
		for (int i = 0; i < 48; i++) System.out.printf("-");
		System.out.printf("\n      %-10s%7s%5s%11s\n", "상 품 명", "단가", "수량", "금액");
		for (int i = 0; i < 48; i++) System.out.printf("-");
		//위에는 단순한 printf.
		
		for (int i = 0; i < itemname.length; i++) {
			//itemname 배열의 길이만큼 for문을 돌린다.
			String nowitem = itemname[i];
			//현재 i 인덱스의 itemname을 변수에 담는다.
			int bytes = 0;
			//변수 선언
			try {
				bytes = nowitem.getBytes("EUC-KR").length;
				//문자열의 byte값을 EUC-KR 기준으로 담는다.
				//현재 본인의 이클립스의 한글 byte 는 1글자당 3byte 이므로 강제로 2byte 로 인식시킨다.
				nowitem = itemname[i].trim().replaceAll(" ", "").substring(0, 7);
				//itemname 이 9글자(0~8)로 잘라지면 자른다.
				//자를 수 없으면 try 문을 빠져나간다.
				bytes = nowitem.getBytes("EUC-KR").length;
				//잘라진 경우 byte값을 다시 담는다.
			} catch(Exception e) {
				e.printStackTrace();
			}
			for(int j = 0; j <= 14 - bytes; j++) {
				//빈칸을 18칸으로 설정하고 문자열의 byte수 만큼 빼준다.
				//영수증 크기에 맞춰 임의로 설정하였다.
				//문자열이 모두 한글로 9글자인경우 18byte
				//그외의 경우 각각의 남는 byte를
	            nowitem = nowitem + " ";
	            //공백으로 채운다.
			}
			System.out.printf("\n%2s%s  %s%10s%4s%14s",
					i < 9 ? "0" + (i + 1) : "" + (i + 1),
					//i값이 9보다 작으면 앞에 0을 붙여준다. 문자열"0"과 숫자1의 연산은 "01" 이므로
					//i값이 9보다 큰 경우는 "" + int 연산으로 "11"과 같이 만들어 준다.
					taxfree[i] ? "*" : " ",
					//면세아이템인가? 판단하여 true 이면 "*" false 이면 " "
					nowitem,
					//위에서 자르고 공백을 붙여준 item 을 입력
					df.format(price[i]), 
					df.format(num[i]), 
					df.format(num[i] * price[i]));
			
			if(taxfree[i]) {
				free += num[i] * price[i];
				//면세인가? 면세인 품목만 더해준다.
			} else {
				sum += num[i] * price[i];
				//면세가 아닌가? 면세가 아닌 품목만 더해준다.
			}
		}
		//아래는 단순한 printf.
		System.out.printf("\n%23s%21s", "(*)면 세  물 품", df.format(free));
		System.out.printf("\n%23s%21s", "과 세  물 품", df.format((int)((sum / 110.0) * 100.0)));
		System.out.printf("\n%24s%21s", "부   가   세", df.format(sum - (int)((sum / 110.0) * 100.0)));
		System.out.printf("\n%25s%21s", "합        계", df.format(sum + free));
		System.out.printf("\n%s%31s\n", "결 제 대 상 금 액", df.format(sum + free));
		for (int i = 0; i < 48; i++) System.out.printf("-");
		System.out.printf("\n0024 하  나%37s", "5417**8890/07850246");
		System.out.printf("\n카드결제");
		System.out.printf("%37s\n", "일시불 / " + df.format(sum + free));
		for (int i = 0; i < 48; i++) System.out.printf("-");
	}
}