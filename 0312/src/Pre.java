import java.util.Scanner;
/**
 * for 문을 이용한 *표 찍기 응용
 * @author JBP
 *
 */
public class Pre {

	public static void main(String[] args) {
		
		int inputNum = 0;
		Scanner in = new Scanner(System.in);
		
		while(true) {
			System.out.print("임의의 홀수 : ");
			try {
				inputNum = in.nextInt();
				if(inputNum % 2 == 0) {
					continue;
				} else if(inputNum == 99) {
					in.close();
					System.exit(0);
				}
			} catch(Exception e) {
				System.out.println("숫자를 입력하시오");
				in.nextLine();
			}
			
			for(int i = 0; i <= inputNum; i++) {
				for(int j = 0; j < inputNum - i; j++) {					
					System.out.print(" ");
				}
				for(int k = 0; k <= i * 2; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
			for(int i = 0; i < inputNum; i++) {
				for(int j = 0; j <= i; j++) {					
					System.out.print(" ");
				}
				for(int k = 0; k <= (inputNum - i - 1) * 2; k++) {
					System.out.print("*");
				}
				System.out.println();
			}
			
		}

	}

}
