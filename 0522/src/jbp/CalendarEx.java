package jbp;

/**
 * @FileName : CalendarEx.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : 달력 인쇄
 */
public class CalendarEx {
	
	public static void main(String[] args) {

		int dayOfTheWeek = 5;
		//시작이 금요일이므로 5요일로 설정 0:일요일 ~ 6:토요일
		int[] lastDay = {31,29,31,30,31,30,31,31,30,31,30,31};
		//윤년이라 주어졌다. 각 달의 마지막 날을 설정. 2월을 29일로 설정
		
		for(int month = 1; month <= 12; month++) { //1월부터 12월까지
			// 헤더
			System.out.printf("\n\n%10d월\n", month); //월을 출력
			System.out.printf("=====================\n");
			System.out.printf(" 일 월 화 수 목 금 토 \n"); //요일을 출력
			
			// 시작하는 달의 공백
			for(int space = 0; space < dayOfTheWeek; space++) {
				//시작하는 요일까지 공백을 넣는다.
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
}