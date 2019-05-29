/**
 * for 문을 이용한 *표 찍기
 * @author JBP
 *
 */
public class Diamond {

	public static void main(String[] args) {
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <= 3 - i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k <= i * 2; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k <= 6 - (i * 2); k++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
