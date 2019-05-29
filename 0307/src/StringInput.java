import java.util.Scanner;

public class StringInput {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String inputData;
		
		System.out.print("단어를 입력하세요 : ");
		inputData = in.next();
		
		switch(inputData) {
		
		case "apple" :
			System.out.println("사과");
			break;
			
		case "사과" :
			System.out.println("apple");
			break;
		
		default :
			System.out.println("사전에 없는 단어입니다.");
		
		}
		
		in.close();
		
	}
	
}
