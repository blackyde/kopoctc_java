/**
 * 19.03.11
 * 입력한 년/월의 달력을 출력하는 프로그램
 * @author JBP
 *
 */
import java.util.Scanner;

public class Calendar {
	
	public static int inputYear = 0;
	public static int inputMonth = 0;
	public static int days = 0;
	public static int dayOfTheWeek = 0;
	public static int sum = 0;
	public static int lastDay = 0;
	
	public static void main(String[] args) {
		
		inputData();
		
		calculator(inputYear, inputMonth);
		
		lastDay(inputMonth);
		
		printCalendar();
		
	}
	
	public static void inputData() {
		//선언
		Scanner in = null;
		
		//입력
		in = new Scanner(System.in);
		System.out.print("원하는 년도를 입력 : ");
		inputYear = in.nextInt();
		System.out.print("원하는 달을 입력 : ");
		inputMonth = in.nextInt();
		
		in.close();
	}
	
	public static void calculator(int inputYear, int inputMonth) {
		//처리
		days = (inputYear - 1900) * 365;
		
		for(int i = 1900; i < inputYear; i++) {
			if((i % 4 == 0 && i % 100 != 0) || i % 400 == 0) { 
				days++;
			}
		} //작년까지가 윤년일때 1일씩 더해주자
		
		if((inputYear % 4 == 0 && inputYear % 100 != 0) ||
				inputYear % 400 == 0) { 
			if(inputMonth >= 3) {
				days++;
			}
		} //올해가 윤년이고 3월 이후의 날짜를 구할때
		
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
		
		dayOfTheWeek = (days + 1) % 7; //일요일은 0 ~ 토요일은 6
		
	}
	
	public static void lastDay(int inputMonth) {
		switch(inputMonth) {
		case 11 : 
		case 9 : 
		case 6 : 
		case 4 : lastDay = 30; break;
		case 2 : lastDay = (isLeap(inputYear)) ? 29 : 28; break;
		default : lastDay = 31; break;
		}
	}
	

	public static boolean isLeap(int inputYear) {
		if ((inputYear % 4 == 0 && inputYear % 100 != 0) ||
				inputYear % 400 == 0) {
			return true;
		}
		return false;
	}
	

	public static void printCalendar() {
		System.out.printf("%4s%4s%4s%4s%4s%4s%4s\n", 
				"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT");
		for(int i = 0; i < dayOfTheWeek; i++) {
			//0칸부터 dayOfTheWeek칸까지 빈칸 설정
			System.out.printf("%4s", " ");
		}
			
		for(int j = dayOfTheWeek; j < 7; j++) {
			sum += 1; //날짜 하루씩 증가
			
			if(sum == lastDay + 1) {
				break;
			}
			
			System.out.printf("%4d", sum);
			
			if(j == 6) {
				System.out.println("");
				j = -1;
			}
		}
	}
	
}
