/**
 * 버스카드의 현재 잔액을 표시해 보는 프로그램
 * @author JBP
 *
 */
public class BusCard {
	
	public static void main(String[] args) {
		
		int currentBalance; //현재 잔액 변수 선언
		currentBalance = 30000;
		final int CURRENT_BUS_PRICE; //변하지 않는 값은 final 선언하고 변수명은 대문자로 작성
		CURRENT_BUS_PRICE = 1250;
		
		System.out.println("현재 잔액은 " + currentBalance + "원 입니다.");
		//System.out.printf("현재 잔액은 %d원 입니다.\n", currentBalance);
		
		//카드를 찍었을 경우		
		
		currentBalance = currentBalance - CURRENT_BUS_PRICE;
		
		System.out.println("현재 잔액은 " + currentBalance + "원 입니다.");
		
		
		//버스 2번째
		
		currentBalance = currentBalance - CURRENT_BUS_PRICE;
		
		System.out.println("현재 잔액은 " + currentBalance + "원 입니다.");
		
		//충전
		
		int charge;
		charge = 10000;
		currentBalance = currentBalance + charge;
		
		System.out.println("현재 잔액은 " + currentBalance + "원 입니다.");
		
	}
	
}
