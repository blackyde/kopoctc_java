/**
 * while 문
 * @author JBP
 *
 */
public class While {

	public static void main(String[] args) {
		
		int i = 1;
		while(i < 5) {
			System.out.print(i);
			i++;
		}
		
		
		int row = 2;
		while(row < 10) {
			int column = 1;
			while(column < 10) {
				System.out.print(row + "*" + column + "==" +(row * column));
				column++;
			}
			System.out.println();
			row++;
		}
		
//		do {
//			
//		} while(조건); 한번 실행 후 조건 판별하여 반복 여부 판단
		
	}
}
