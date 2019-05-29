import java.util.Scanner;

/**
 * 환율에 따라 환전해 주고
 * 지폐 단위별 매수를 출력해주는 프로그램
 * @author JBP
 *
 */
public class Hello0307_01 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		int won = 0;
		double rate = 0;
		
		System.out.print("고객이 가져온 돈 : ");
		won = in.nextInt();
		System.out.print("현재 USD 환율 : ");
		rate = in.nextDouble();
		
		int usd = (int)(won / rate); //센트 단위는 절삭
		int change = (int)(((won / rate) - usd) * rate);
		change -= change % 10; //1원 단위 절삭
		
		//usd = won / rate;
		//change = usd - (int)usd;
		//change = change * rate;
		
		//printf("%d, %d", (int)usd, ((int)change / 10) * 10);
		
		//지폐별 변수 선언
		int hundred = 0;
		int fifty = 0;
		int twenty = 0;
		int ten = 0;
		int five = 0;
		int one = 0;
		
		int temp = usd; //연산을 위한 임의의 변수
		
		//100달러 짜리 지폐
		hundred = temp / 100;
		temp = temp - (hundred * 100);
		
		//50달러 짜리 지폐
		fifty = temp / 50;
		temp = temp - (fifty * 50);
		
		//20달러 짜리 지폐
		twenty = temp / 20;
		temp = temp - (twenty * 20);
		
		//10달러 짜리 지폐
		ten = temp / 10;
		temp = temp - (ten * 10);
		
		//5달러 지폐
		five = temp / 5;
		temp = temp - (five * 5);
		
		//1달러 지폐
		one = temp;
		
		
		System.out.println("내어줄 돈은 " + usd + "USD 이고 "
						+ "거스름 돈은 " + change + "원 이다."
				);
		
		System.out.printf(
				"100달러 %d장, 50달러 %d장, 20달러 %d장,"
				+ " 10달러 %d장, 5달러 %d장, 1달러 %d장"
				, hundred, fifty, twenty, ten, five, one
				);
		
		in.close();
		
	}

}
