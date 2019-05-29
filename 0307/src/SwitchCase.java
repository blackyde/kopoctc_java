
public class SwitchCase {

	public static void main(String[] args) {
		
		
		
//		if(rank == 1) {
//			System.out.println("1등 입니다.");
//		} else if(rank == 2) {
//			System.out.println("2등 입니다.");
//		} else if(rank == 3) {
//			System.out.println("3등 입니다.");
//		} else  {
//			System.out.println("탈락 입니다.");
//		}
		int rank = 1;
		
		switch(rank) {
		
		case 1 :
			System.out.println("1등 입니다.");
			break;
			
		case 2 :
			System.out.println("2등 입니다.");
			break;
		
		case 3 :
			System.out.println("3등 입니다.");
			break;
			
		default :
			System.out.println("탈락 입니다.");		
		
		}

	}

}
