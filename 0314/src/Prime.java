/**
 * 소수인지 아닌지
 * @author JBP
 *
 */
import java.util.Scanner;

public class Prime {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("양의 정수를 입력하세요 : ");
		int num = in.nextInt();
		
		if(isPrime(num)) {
			System.out.println(num + " : 소수");
		} else {
			System.out.println(num + " : 소수가 아니다.");
		}
		
		in.close();
		
	}

	static boolean isPrime(int num) {
		
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
		
	}

}
