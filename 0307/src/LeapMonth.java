import java.util.Scanner;

/**
 * 윤년 판단 프로그램을 응용하여
 * 원하는 년도의 각 달마다의 마지막 날짜를 출력하는 프로그램
 * @author JBP
 *
 */
public class LeapMonth {

	public static void main(String[] args) {
		
		//선언부
		int year = 0;		
		int result = 0; //0 == 평년, 1 == 윤년		
		Scanner in;		
		
		//입력부
		in = new Scanner(System.in);
		
		System.out.print("원하는 연도를 입력하세요 : ");
		year = in.nextInt();
		
		in.close();
		
		//처리부 - 윤년 판단 부분		
		if(year % 4 == 0) {
			
			result = 1;
			
			if(year % 100 == 0) {
				
				result = 0;
				
				if(year % 400 == 0) {
					
					result = 1;
					
				}
				
			}
			
		} else {
			
			result = 0;
			
		}		
		
		
		//출력부
		System.out.println(year + "년은 다음과 같습니다.");
		System.out.printf("1월 : 31일\n"
				+ "2월 : %d일\n"
				+ "3월 : 31일\n"
				+ "4월 : 30일\n"
				+ "5월 : 31일\n"
				+ "6월 : 30일\n"
				+ "7월 : 31일\n"
				+ "8월 : 31일\n"
				+ "9월 : 30일\n"
				+ "10월 : 31일\n"
				+ "11월 : 30일\n"
				+ "12월 : 31일\n", 28 + result);
		
//		for(int i = 1; i <= 12; i++) { //1월부터 12월
//			
//			int lastDay = 31; //가장 많이 차지하는 31을 기본으로 설정
//			
//			if(i == 4 || i == 6 || i == 9 || i == 11) { //4,6,9,11월은 30일까지
//				
//				lastDay -= 1;
//				
//			}
//			
//			if(i == 2 && result == 0) { //2월이며 평년
//				
//				lastDay -= 3;
//				
//			} else if(i == 2 && result == 1) { //2월이며 윤년
//				
//				lastDay -= 2;
//				
//			}
//			
//			System.out.println(i + "월 : " + lastDay + "일");
//			
//		}
		
	}
	
}
