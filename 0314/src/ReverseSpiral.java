import java.util.Scanner;

/**
 * 2차원배열 나선형 프로그램
 * @author JBP
 *
2, 2 = 1 시작

2, 3 = 2 오른쪽으로 1칸

3, 3 = 3 밑으로 1칸

3, 2 = 4
3, 1 = 5 왼쪽으로 2칸

2, 1 = 6
1, 1 = 7 위로 2칸

1, 2 = 8
1, 3 = 9
1, 4 = 10 오른쪽으로 3칸

2, 4 = 11
3, 4 = 12
4, 4 = 13 밑으로 3칸

4, 3 = 14
4, 2 = 15
4, 1 = 16
4, 0 = 17 왼쪽으로 4칸

3, 0 = 18
2, 0 = 19
1, 0 = 20
0, 0 = 21 위로 4칸

0, 1 = 22
0, 2 = 23
0, 3 = 24
0, 4 = 25 오른쪽으로 4칸

1, 1, 2, 2, 3, 3, 4, 4, 4
마지막은 증가값 - 1 로 처리
열만 +
행만 +
열만 -
행만 - 를 반복
 */

public class ReverseSpiral {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("임의의 양의 홀수 : ");
		int n = in.nextInt();
	
		//final int N = 5;
		int[][] arr = new int[n][n];
		int num = 1; //배열에 넣을 숫자
		int foward = 1; //행, 열 이동 수를 제어할 변수
		int sw = 1; //양, 음을 변경할 스위치 변수
		int row = (n / 2), col = (n / 2); //배열의 주소를 결정할 변수. 첫 시작은 정 중앙
		arr[row][col] = num; //가운데 입력하고 시작하게
		
		while(true) {
		
			if(foward < n) { //기본 조건
				for(int i = 1; i <= foward; i++) {
					num++; //배열에 넣을 수를 증가시킴
					col = col + sw; //열을 이동
					arr[row][col] = num; //배열에 저장
				}
			} else if(foward == n) {
				//마지막엔 입력된 수 - 1만큼만 진행할 수 있다.
				for(int i = 1; i <= foward - 1; i++) {
					num++;
					col = col + sw;
					arr[row][col] = num;
				}
				break;
			} else {
				break;
			}
			
			for(int i = 1; i <= foward; i++) {
				num++;
				row = row + sw; //행을 이동
				arr[row][col] = num;
			}
			
			sw = sw * (-1); //음, 양을 번갈아 가며 이동하도
			foward = foward + 1; //중심에서 바깥으로 갈수록 이동할 행,열이 늘어나도록
		
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.printf("%4d", arr[i][j]);
			}
			System.out.println();
		}
		
		in.close();

	}
	
}
