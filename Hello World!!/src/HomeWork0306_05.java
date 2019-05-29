import java.util.Scanner;

/**
 * 임의의 소문자를 대문자로 변환해 출력하는 프로그램입니다.
 * @author JBP
 *
 */
public class HomeWork0306_05 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int change = (int)'a' - (int)'A'; //대문자와 소문자의 코드값 차이
		
		char lowerCase;
		System.out.print("임의의 소문자를 입력하세요 : ");
		lowerCase = in.next().charAt(0);
		
		System.out.printf("입력받은 %s 의 대문자는 %s 입니다.", lowerCase, (char)(lowerCase - change));
		
		in.close();

	}

}
