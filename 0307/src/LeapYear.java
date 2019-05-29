import java.util.Scanner;

/**
 * 입력 받은 년도가 윤년인지 아닌지 출력하는 프로그램
 * @author JBP
 *
 */
public class LeapYear {

	public static void main(String[] args) {
		
		//윤년의 조건
		//4로 나누어 떨어져야 한다.
		//4로 나누어 지지만 100으로도 나누어 지면 평년이다.
		//4로 나누어 지고 100으로도 나누어 지지만 400으로 나누어 지면 윤년이다.
		
		int year = 0;
		
		//(year % 4 == 0) == 윤년
		//(year % 4 == 0) && (year % 100 == 0) == 평년
		//(year % 4 == 0) && (year % 100 == 0) && (year % 400 == 0) == 윤년
		
		int result = 0; //0 == 평년, 1 == 윤년
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("연도를 입력하세요 : ");
		year = in.nextInt();
		
		in.close();
		
		if(year % 4 == 0) { //4로 나누어 떨어지는가
			
			result = 1;
			
			if(year % 100 == 0) { //4로 나누어 떨어지면서 100으로 나누어 떨어지는가
				
				result = 0;
				
				if(year % 400 == 0) { //4로 나누어 떨어지면서 100으로도 나누어 떨어지지만
									//400으로도 나누어 떨어지는가
					result = 1;
					
				}
				
			}
			
		} else {
			
			result = 0;
			
		}
		
		switch(result) {
		
		case 0: 
			System.out.println(year + "년은 평년입니다.");
			break;
			
		case 1:
			System.out.println(year + "년은 윤년입니다.");
			break;
		}
		

	}

}
