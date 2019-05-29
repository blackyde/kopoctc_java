import java.util.Scanner;

/**
 * 입력 받은 수의 크기를 비교하는 프로그램
 * @author JBP
 *
 */
public class MaxMin {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int a, b;
		
		System.out.print("숫자 A 입력 : ");
		a = in.nextInt();
		System.out.print("숫자 B 입력 : ");
		b = in.nextInt();
		
		if(a > b) {
			System.out.println("큰 숫자는 " + a + "입니다.");
		} else if(a < b) {
			System.out.println("큰 숫자는 " + b + "입니다.");
		} else {
			System.out.println("두 숫자는 같습니다.");
		}
		
		in.close();
		
	}

}
