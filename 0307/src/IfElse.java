/**
 * if 와 else 의 개념을 파악해보는 프로그램
 * @author JBP
 *
 */
public class IfElse {

	public static void main(String[] args) {
		
		int data = 10;
		
		data = 85;
		
		if(data >= 90) {
			System.out.println("A 입니다.");
		} else if(data >= 80) {
			System.out.println("B 입니다.");
		} else if(data >= 70) {
			System.out.println("C 입니다.");
		} else if(data >= 60) {
			System.out.println("D 입니다.");
		} else  {
			System.out.println("F 입니다.");
		}
		
		switch(data / 10) {
		
		case 10 :
		case 9 :
			System.out.println("A 입니다.");
			break;
		case 8 :
			System.out.println("B 입니다.");
			break;
		case 7 :
			System.out.println("C 입니다.");
			break;
		case 6 :
			System.out.println("D 입니다.");
			break;
		default :
			System.out.println("F 입니다.");
			break;
		}
		
	}
	
}
