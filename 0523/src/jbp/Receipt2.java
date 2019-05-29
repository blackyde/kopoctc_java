package jbp;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @FileName : Receipt2.java
 * @Project : 0523
 * @Date : 2019. 5. 23.
 * @Author : JBP
 * @Descript : 영수증 출력 2
 */
public class Receipt2 {

	public static void main(String[] args) {
		
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat register = new SimpleDateFormat("YYYYMMdd HHmmss");
		SimpleDateFormat register2 = new SimpleDateFormat("YYYYMMddHHmmss");
		SimpleDateFormat date = new SimpleDateFormat("YYYY/MM/dd");
		
		String shopName = "충주(양평)휴게소";
		String address = "충북충주시가금면용전리380-4";
		String name = "최병권";
		String businessNum = "677-85-00239";
		String tel = "043-857-9229";
		String process = "정상등록";
		String posNum = "0002";
		
		String itemname1, itemname2;
		String itemcode1, itemcode2;
		int price1, price2;
		int num1, num2;
		int tot1, tot2;
		int total, vat;
		int money, change;
		
		itemname1 = "풀무원샘물";
		itemcode1 = "8809169718205";
		price1 = 600;
		num1 = 1;
		tot1 = price1 * num1;
		
		itemname2 = "바나나요구르트";
		itemcode2 = "8809168213444";
		price2 = 1600;
		num2 = 5;
		tot2 = price2 * num2;
		
//		itemname1 = "초코파이";
//		itemcode1 = "8809169718205";
//		price1 = 2400;
//		num1 = 3;
//		tot1 = price1 * num1;
//		
//		itemname2 = "ABC초콜릿";
//		itemcode2 = "8809168213444";
//		price2 = 3600;
//		num2 = 4;
//		tot2 = price2 * num2;
		
		total = tot1 + tot2;
		vat = total - (int)(total / 110.0 * 100);
		
		money = total;
		change = money - total;
		
		System.out.printf("%s\n", shopName);
		System.out.printf("%s\n", address);
		System.out.printf("%s %s TEL:%s\n", name, businessNum, tel);
		System.out.printf("\n\n");
		System.out.printf("[%s]%s%11s%s\n", process, register.format(cal.getTime()), "POS번호: ", posNum);
		for (int i = 0; i < 42; i++) System.out.printf("-");
		System.out.printf("\n%-15.15s%5s%5s%7s\n", "품목코드", "단가", "수량", "금액");
		for (int i = 0; i < 42; i++) System.out.printf("-");
		System.out.printf("\n%s", itemname1);
		System.out.printf("\n%-16.16s%10s%7s%9s", itemcode1, df.format(price1), num1, df.format(tot1));
		System.out.printf("\n%s", itemname2);
		System.out.printf("\n%-16.16s%10s%7s%9s", itemcode2, df.format(price2), num2, df.format(tot2));
		System.out.printf("\n");
		System.out.printf("%-16s%20s\n", "과세 물품 합계", df.format(total - vat));
		System.out.printf("%-16s%23s\n", "부    가    세", df.format(vat));
		System.out.printf("%-16s%24s\n", "합          계", df.format(total));
		System.out.printf("026-비씨카드사%28s\n", "00/00A");
		System.out.printf("카  드  번  호 :%26s\n", "5522-20**-****-BADD");
		System.out.printf("카  드  매  출 :%26s\n", df.format(total));
		System.out.printf("거  래  구  분 :%23s\n", "일시불");
		System.out.printf("승  인  번  호 : %s%18d\n", "04-KICC", 75549250);
		System.out.printf("가 맹 점 번 호 :\n");
		System.out.printf("받  은  금  액 :%26s\n", df.format(money));
		System.out.printf("거    스    름 :%26s\n", df.format(change));
		for (int i = 0; i < 42; i++) System.out.printf("-");
		System.out.printf("\n주문번호:%12s\n", "0920");
		for (int i = 0; i < 42; i++) System.out.printf("-");
		System.out.printf("\n판매원 : %s 편의점2", "000002");
		System.out.printf("\n%s-%s-%s", date.format(cal.getTime()), "0002", "0922");
		System.out.printf("\n연동모듈:[00138705  %s]", register2.format(cal.getTime()));
		
	}
}
