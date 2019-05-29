import java.util.Scanner;

/**
 * 키보드로 0부터 999 사이의 정수를 입력받아 각 자릿수를 더한 결과를 출력하는 프로그램
 * @author JBP
 *
 */
public class HomeWork0306_08 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int x;
		System.out.print("0 ~ 999 사이의 숫자를 입력하세요 : ");
		
		x = in.nextInt();
		
		int a; //100의 자리
		int b; //10의 자리
		int c; //1의 자리
		
		a = x / 100;
		b = (x % 100) / 10;
		c = (x % 100) % 10;
		
		System.out.printf("각 자릿수 %d, %d, %d의 합 : %d", a, b, c, a + b + c);
		
		in.close();
		
		
	}
}
