/**
 * N번째 소수를 찾아보자
 * @author JBP
 *
 */
public class PrimePosition {

	public static void main(String[] args) {
		
		final int N = 100;

		int num = 2;
		int count = 1;
		
		while(true) {
			
			if(isPrime(num)) {
				System.out.println(count + "번째 소수 : " + num);
				count++;
			}
			
			num++;
			
			if(count == N + 1) {
				break;
			}
			
		}
		
		
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
