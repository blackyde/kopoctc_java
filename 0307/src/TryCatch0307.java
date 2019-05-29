/**
 * try catch
 * @author JBP
 *
 */
import java.util.Scanner;

public class TryCatch0307 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int number1, number2, div = 0;
		
		System.out.print("첫 번째 숫자 : ");
		number1 = in.nextInt();
		System.out.print("두 번째 숫자 : ");
		number2 = in.nextInt();
		
		try {
			div = number1 / number2;
			System.out.printf("%d / %d = %d\n", number1, number2, div);
		} catch(Exception e) {
			System.out.println("0으로 나누면 안됩니다.");
		}
		
		
		in.close();

	}

}
