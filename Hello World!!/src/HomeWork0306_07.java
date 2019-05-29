import java.util.Scanner;
/**
 * 키보드로 정수를 입력받아 
 * 4와 5로 나누어지는지,
 * 4 또는 5로 나누어지는지,
 * 4나 5 중 하나로 나누어지지만 두 수 모두로는 나누어지지 않는지를
 * true/false로 출력하는 프로그램
 * @author JBP
 *
 */
public class HomeWork0306_07 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int x;
		
		System.out.print("임의의 정수를 입력하시오 : ");
		
		x = in.nextInt();
		
		System.out.printf("정수 %d는 4 와 5로 나누어지는가? %s\n", x, (x % 4 == 0) && (x % 5 == 0) ? true : false);
		System.out.printf("정수 %d는 4 또는 5로 나누어지는가? %s\n", x, (x % 4 == 0) || (x % 5 == 0) ? true : false);
		System.out.printf("정수 %d는 4 또는 5중 하나로 나누어지지만 두 수 모두로는 나누어 지지 않는가? %s\n", x,
							((x % 4 == 0) || (x % 5 == 0)) && !((x % 4 == 0) && (x % 5 == 0))? true : false
									//true = 두 수 중 하나로만 나누어진다. false = 두 수 모두로 나누어 진다.
						);
		
		in.close();

	}

}
