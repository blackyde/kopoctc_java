import java.util.Scanner;

public class Method {
	
	public static String leader() {
		
		String str = null;
		
		str = "why?";
		
		return str;
	}
	
	public static int calcPow(int a, int b) {
		int result = 1;
		for (int i = 0; i < b; i++) {
			result *= a;
		}
		return result;
	}
	
	public static int calculator(int a, int b, String str) {
		
		int result = 0;
		
		if(str.equals("+")) {
			result = a + b;
		} else if(str.equals("-")) {
			result = a - b;
		} else if(str.equals("*")) {
			result = a * b;
		} else if(str.equals("/")) {
			result = a / b;
		}
		
		return result;
		
	}
	
	public static boolean isLeapYear(int year) {
		if((year % 4 == 0 && year % 100 != 0) ||
				year % 400 == 0) { 
			return true;
		}
		return false;
	}
	
	public static String getDayOfTheWeek(int year, int month, int day) {
		
		int days = 0;
		int dayOfTheWeek = 0;
		String yoil = "";
		
		
		days = (year - 1900) * 365;
		
		for(int i = 1900; i < year; i++) {
			if(isLeapYear(i)) { 
				days++;
			}
		} //윤년일때 1일씩 더해주자
		
		if((year % 4 == 0 && year % 100 != 0) ||
				year % 400 == 0) { 
			if(month >= 3) {
				days++;
			}
		} //윤년이고 3월 이후의 날짜를 구할때
		
		switch(month) {
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
		
		days += day - 1;
		
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
				year, month, day, days);
		
		return yoil;
	}

	public static void main(String[] args) {
		
		int inputYear = 0;
		int inputMonth = 0;
		int inputDay = 0;
		
		
		System.out.println(calculator(20, 10, "+"));
		System.out.println(calculator(20, 10, "-"));
		System.out.println(calculator(20, 10, "*"));
		System.out.println(calculator(20, 10, "/"));
		
		Scanner in = null;
		in = new Scanner(System.in);
		System.out.print("원하는 년도를 입력 : ");
		inputYear = in.nextInt();
		System.out.print("월 : ");
		inputMonth = in.nextInt();
		System.out.print("일 : ");
		inputDay = in.nextInt();
		
		
		
		System.out.println(getDayOfTheWeek(inputYear, inputMonth, inputDay));
		
		in.close();

	}

}
