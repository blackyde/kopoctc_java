/**
 * 입력받은 값을 처리하는 프로그램
 */
import java.util.Scanner;

public class Scanner0306 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int x = in.nextInt();
		int y = in.nextInt();
		
		int plus = x + y;
		int minus = x - y;
		int multiply = x * y;
		double divide = (double)x / y; //정수와 정수의 계산 값은 정수로만 나오기 때문에 형변환이 필요하다.
		int mod = x % y;
		
		//System.out.printf("%d * %d은(는) %d 입니다.\n", x, y, x * y);
		
		//System.out.printf("%d + %d = %d 입니다.\n", x, y, x + y);
		
		System.out.printf("입력 받은 값은 %d, %d 이고 +, -, *, / 값은 %d, %d, %d, %.6f 입니다.\n",
							x, y, plus, minus, multiply, divide);
		
		System.out.printf("나눈 값의 나머지는 %d", mod);
		
		in.close();
		
		
	}
	
}
