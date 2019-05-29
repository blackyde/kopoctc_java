import java.util.Scanner;

/**
 * 가위 바위 보 게임을 수행하는 프로그램
 * @author JBP
 *
 */
public class RockCaesarPaper {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int a, b;
		int winner = 0; //0:A가 승리, 1:B가 승리, 2:무승부
		
		System.out.print("Player A 입력 (가위:0, 바위:1, 보:2) => ");
		a = in.nextInt();
		System.out.print("Player B 입력 (가위:0, 바위:1, 보:2) => ");
		b = in.nextInt();
		
		switch(a) {
		
		//A 가 가위를 낸 경우
		case 0 :
			if(b == 0) {
				winner = 2;
				break;
			} else if(b == 1) {
				winner = 1;
				break;
			} else if(b == 2) {
				winner = 0;
				break;
			}
		
		//A 가 바위를 낸 경우
		case 1 :
			if(b == 0) {
				winner = 0;
				break;
			} else if(b == 1) {
				winner = 2;
				break;
			} else if(b == 2) {
				winner = 1;
				break;
			}
		
		//A 가 보를 낸 경우
		case 2 :
			if(b == 0) {
				winner = 1;
				break;
			} else if(b == 1) {
				winner = 0;
				break;
			} else if(b == 2) {
				winner = 2;
				break;
			}
		
		}
		
		switch(winner) {
		
		case 0 :
			System.out.println("Player A가 이겼습니다.");
			break;
		
		case 1 :
			System.out.println("Player B가 이겼습니다.");
			break;
			
		case 2 :
			System.out.println("비겼습니다.");
			break;
			
		}
		
		in.close();

	}

}
