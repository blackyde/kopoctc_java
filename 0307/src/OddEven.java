import java.util.Scanner;

/**
 * 홀수인가 짝수인가 판별하는 프로그램
 * @author JBP
 *
 */
public class OddEven {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int inputData;
		
		System.out.print("숫자 입력 : ");
		inputData = in.nextInt();
		
		if(inputData % 2 == 0) {
			System.out.println("짝수 입니다.");
		} else {
			System.out.println("홀수 입니다.");
		}
		
		in.close();

	}

}
