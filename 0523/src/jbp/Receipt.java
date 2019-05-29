package jbp;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @FileName : Receipt.java
 * @Project : 0523
 * @Date : 2019. 5. 23.
 * @Author : JBP
 * @Descript : 영수증 출력 1
 */
public class Receipt {

	public static void main(String[] args) {
		
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat order = new SimpleDateFormat("YYYYMMdd");
		SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		
		String shopName = "종로상회 (분당서현점)";
		String businessNumber = "129-17-77924";
		String name = "이상철";
		String tel = "031 781 1596";
		String address = "성남시 분당구 서현동 269-3";
		int tableNum = 12;
		String orderNum = order.format(cal.getTime()) + " 01 00041";
		//originPrice + (originPrice * rate) = customPrice
		//op + (op * 0.1) = 14000
		//1.1op = 14000
		//op = 14000 / 1.1
		int customPrice = 14000;
		//int customPrice = 21000;
		int totalPrice = customPrice;
		int discount = 0;
		int resultPrice = totalPrice - discount;
		double rate = 0.1;
		int originPrice = (int)((customPrice / (100 + rate * 100)) * 100.0);
		int tax = customPrice - originPrice;
		int cash = 0;
		int credit = totalPrice;
		int point = 0;
		int taxfree = 0;
		String cardComp = "우리";
		String cardNum = "55222059****2021";
		int confirm = 79753574;
		String month = "00";
		int license = 730461774;
		String cardComp2 ="비씨";
		
		
		System.out.printf("\n%24s\n", "영  수  증");
		for (int i = 0; i < 44; i++) System.out.printf("-");
		System.out.printf("\n%-15.15s", shopName);
		System.out.printf("%s\n", businessNumber);
		System.out.printf("%-6s%s\n", name, tel);
		System.out.printf("%s\n", address);
		System.out.printf("테이블명 : %d\n", tableNum);
		System.out.printf("주문번호 : %s\n", orderNum);
		for (int i = 0; i < 44; i++) System.out.printf("-");
		System.out.printf("\n주문합계%36s", df.format(totalPrice));
		System.out.printf("\n할인금액%36s", df.format(discount));
		System.out.printf("\n받을금액%36s\n", df.format(resultPrice));
		for (int i = 0; i < 44; i++) System.out.printf("-");
		System.out.printf("\n현  금%14s", df.format(cash));
		System.out.printf("%8s%14s", "과  세", df.format(originPrice));
		System.out.printf("\n카  드%14s", df.format(credit));
		System.out.printf("%8s%14s", "세  액", df.format(tax));
		System.out.printf("\n포인트%14s", df.format(point));
		System.out.printf("%8s%14s", "면  세", df.format(taxfree));
		System.out.printf("\n%30s%10s\n", "영수금액", df.format(totalPrice));
		for (int i = 0; i < 44; i++) System.out.printf("-");
		System.out.printf("\n%12s[%s카드 신용 승인]", "", cardComp);
		System.out.printf("\n승 인 일 시 : %s", date.format(cal.getTime()));
		System.out.printf("\n카 드 번 호 : %s", cardNum);
		System.out.printf("\n승 인 번 호 : %d %5s : %s", confirm, "할부개월", month);
		System.out.printf("\n승 인 금 액 : %s", df.format(totalPrice));
		System.out.printf("\n가 맹 번 호 : %s  /  %s카드사", license, cardComp2);
		System.out.printf("\n사업자 번호 : %s\n", businessNumber);
		for (int i = 0; i < 44; i++) System.out.printf("-");
		System.out.printf("\n%s%10s%7s 직원\n", date.format(cal.getTime()), "CASHIER :", "박준범");
		for (int i = 0; i < 44; i++) System.out.printf("-");
		System.out.printf("\n감사 합니다.");
	}
}
