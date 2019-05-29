/**
 * 마방진
 * @author JBP
 *
 */
public class Magic {

	public static void main(String[] args) {

		int N = 9;
		
		int[][] arr = new int[N][N];
		
		int row = 0;
		int col = N / 2; //맨 윗줄의 가운데서 시작한다.
		
		int num = 1;
		
		while(true) {
			
			arr[row][col] = num;
			if(num % N == 0) {
				row++;
				col--;
			} else {
				row--;
			}
			num++;
			col++;
			
			if(row < 0) {
				row = N - 1;
			}
			if(col == N ) {
				col = 0;
			}
			
			if(num == N * N + 1) {
				break;
			}
			
		}
		
		for(int i = 0; i < N; i++ ) {
			for(int j = 0; j < N; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
		
	}

}
