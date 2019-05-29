import java.util.Scanner;

/**
 * 시간을 환산하는 프로그램입니다.
 * @author JBP
 *
 */
public class HomeWork0306_04 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int sec;
		System.out.print("초 단위 정수를 입력하세요 : ");
		
		sec = in.nextInt();
		
		int hour = sec / 3600;
		int minute = (sec - (3600 * hour)) / 60;
		int second = sec % 60;
		
		System.out.printf("%d시간 %d분 %d초", hour, minute, second);
		
		in.close();

	}

}
