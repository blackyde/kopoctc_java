import java.util.Scanner;

public class Scanner0306_02 {
	
public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int inputData;
		
		System.out.print("정수를 입력하세요 : ");
		inputData = in.nextInt();
		
		System.out.printf("입력하신 수는 %s 입니다.\n", (inputData % 2) != 0 ? "홀수" : "짝수");
		
		in.close();
		
		
	}

}
