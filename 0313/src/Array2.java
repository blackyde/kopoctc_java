/**
 * 2차원배열
 * @author JBP
 *
 */
public class Array2 {

	public static void main(String[] args) {
		
		final int N = 10;
		int[][] arr = new int[N][N];
		int num = 1;
		
		for(int i = 0; i < N; i++) {
			
			if(i % 2 == 0) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = num;
					num++;
				}
			} else {
				for(int j = N - 1; j >= 0; j--) {
					arr[i][j] = num;
					num++;
				}
			}
			
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
		

	}

}
