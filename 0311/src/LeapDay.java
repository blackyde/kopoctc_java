/**
 * 원하는 년도, 원하는 날의 요일을 알아보는 프로그램
 * @author JBP
 *
 */
import java.util.Scanner;

public class LeapDay {

	public static void main(String[] args) {
		
		Scanner in = null;
		int inputYear = 0;
		int inputMonth = 0;
		int inputDay = 0;
		int days = 0;
		int dayOfTheWeek = 0;
		String yoil = "";
		
		in = new Scanner(System.in);
		System.out.print("원하는 년도를 입력 : ");
		inputYear = in.nextInt();
		System.out.print("월 : ");
		inputMonth = in.nextInt();
		System.out.print("일 : ");
		inputDay = in.nextInt();
		
		days = (inputYear - 1900) * 365;
		
		for(int i = 1900; i < inputYear; i++) {
			if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) { 
				days++;
			}
		} //윤년일때 1일씩 더해주자
		
		if((inputYear % 4 == 0 && inputYear % 100 != 0) ||
				inputYear % 400 == 0) { 
			if(inputMonth >= 3) {
				days++;
			}
		} //윤년이고 3월 이후의 날짜를 구할때
		
		switch(inputMonth) {
		case 12 : days += 30;
		case 11 : days += 31;
		case 10 : days += 30;
		case 9 : days += 31;
		case 8 : days += 31;
		case 7 : days += 30;
		case 6 : days += 31;
		case 5 : days += 30;
		case 4 : days += 31;
		case 3 : days += 28;
		case 2 : days += 31;
		}
		
		days += inputDay - 1;
		
		dayOfTheWeek = days % 7;
		
		if(dayOfTheWeek == 0) {
			yoil = "월";
		} else if(dayOfTheWeek == 1) {
			yoil = "화";
		} else if(dayOfTheWeek == 2) {
			yoil = "수";
		} else if(dayOfTheWeek == 3) {
			yoil = "목";
		} else if(dayOfTheWeek == 4) {
			yoil = "금";
		} else if(dayOfTheWeek == 5) {
			yoil = "토";
		} else if(dayOfTheWeek == 6) {
			yoil = "일";
		}
		
		
		System.out.printf("1900년 1월 1일 부터 %d년 %d월 %d일 까지 %d일 지났음\n",
				inputYear, inputMonth, inputDay, days);
		System.out.printf("%s요일", yoil);
		in.close();

	}

}
