/**
 * for 문
 * @author JBP
 *
 */
public class For {

	public static void main(String[] args) {
		
		for(int i = 2; i < 10; i++) {
			
//			if(i % 3 == 0) {
//				continue;
//			}
			
			for(int j = 1; j < 10; j++) {
				
				System.out.printf("%d * %d = %d\n", i, j, i * j);
				
			}
			
//			if(i % 3 != 0) {
//				
//				for(int j = 1; j < 10; j++) {
//					
//					System.out.printf("%d * %d = %d\n", i, j, i * j);
//				}	
//
//			} //이렇게도 가능
			
		}

	}

}
