import java.util.Scanner;

/**
 * @FileName : ScannerEx.java
 * @Project : 0520
 * @Date : 2019. 5. 20.
 * @Author : JBP
 * @Descript : Scanner 클래스 사용
 */
public class ScannerEx {

	public static void main(String[] args) {
		
		Scanner k08_scanner = new Scanner(System.in);
		
		System.out.print("두자리 정수를 하나 입력해주세요.>");
		
		String input = k08_scanner.nextLine();
		int num = Integer.parseInt(input); //입력받은 문자열을 숫자로 변환
		
		System.out.println("입력내용 : " + input);
		System.out.printf("num=%d%n", num);
		
		k08_scanner.close();

	}

}
