package jbp;

/**
 * @FileName : CalendarEx2.java
 * @Project : 0523
 * @Date : 2019. 5. 23.
 * @Author : JBP
 * @Descript : 달력 업그레이드
 */
public class CalendarEx2 {
	
	public static boolean isLeap(int inputYear) {
		//윤년인지 아닌지 판단하는 method
		if ((inputYear % 4 == 0 && inputYear % 100 != 0) ||
				inputYear % 400 == 0) {
			//4로 나누어 떨어지고 100으로는 나누어떨어지지 않지만 400으로는 나누어떨어지는가?
			return true;
		}
		return false;
	}
	
	public static void calendar(int inputYear) {
		//출력하고 싶은 연도를 입력
		int days = (inputYear - 1900) * 365;
		//1900년 1월 1일 월요일부터 지금까지 며칠이 흘렀는가
		for(int year = 1900; year < inputYear; year++) {
			if(isLeap(year)) {
				days++;
			}
		} //입력 년도의 전년까지 윤년일때 1일씩 더해주자
		
		int dayOfTheWeek = (days + 1) % 7; //일요일은 0 ~ 토요일은 6
		//1900년 1월 1일은 월요일이었다. 1을 더해준다.
		//2000년 1월 1일을 기준으로 하면 토요일이므로 6을 더해준다.
		
		printCalendar(inputYear, dayOfTheWeek);
						
	}
	
	public static void printCalendar(int inputYear, int dayOfTheWeek) {
		
		int[] lastDay = {31,(isLeap(inputYear)) ? 29 : 28,31,30,31,30,31,31,30,31,30,31};
		//윤년이면 2월이 29일, 아니면 28일
		
		System.out.printf("\n\n%11d년\n", inputYear);	
		for(int month = 1; month <= 12; month++) { //1월부터 12월까지
			// 헤더
			System.out.printf("\n\n%10d월\n", month); //월을 출력
			System.out.printf("=====================\n");
			System.out.printf(" 일 월 화 수 목 금 토 \n"); //요일을 출력
			
			// 시작하는 요일까지 공백
			for(int space = 0; space < dayOfTheWeek; space++) {
				System.out.printf(" %2s", " ");
			}
			
			// 날짜 출력
			for(int day = 1; day <= lastDay[month - 1]; day++) { //1일부터 마지막날까지
				dayOfTheWeek += 1; //요일을 1씩 증가시킨다.
				System.out.printf(" %2d", day); //날짜 출력
				
				if(dayOfTheWeek == 7) { //요일이 7요일이 되면 0요일로 초기화 시킨다.
					System.out.printf("\n"); //개행
					dayOfTheWeek = 0;
				}				
			}			
			System.out.printf("\n");
		}
		
	}

	public static void main(String[] args) {
		
		calendar(2019);
		
	}
}