import java.util.Scanner;

/**
 * 화씨온도를 섭씨온도로 변환하는 프로그램입니다.
 * @author JBP
 *
 */
public class HomeWork0306_06 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int temp;
		
		System.out.print("화씨 온도 : ");
		
		temp = in.nextInt();
		
		System.out.printf("섭씨 온도 : %.2f", (double)5 / 9 * (temp-32) );
		
		in.close();
		
	}
	
}
