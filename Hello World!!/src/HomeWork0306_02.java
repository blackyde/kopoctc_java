/**
 * 입력받은 정수의 제곱값을 출력하는 프로그램입니다.
 * @author JBP
 *
 */
import java.util.Scanner;

public class HomeWork0306_02 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int x;
		
		System.out.print("정수를 입력하세요 : ");
		x = in.nextInt();
		System.out.println(x + "의 제곱은 " + x * x);
		
		
		in.close();
		

	}

}
