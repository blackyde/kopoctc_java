import java.util.Scanner;

/**
 * 2차원배열 나선형 프로그램
 * @author JBP
 *
0, 0 = 1 시작
0, 1 = 2
0, 2 = 3
0, 3 = 4
0, 4 = 5

1, 4 = 6
2, 4 = 7
3, 4 = 8
4, 4 = 9

4, 3 = 10
4, 2 = 11
4, 1 = 12
4, 0 = 13

3, 0 = 14
2, 0 = 15
1, 0 = 16

1, 1 = 17
1, 2 = 18
1, 3 = 19

2, 3 = 20
3, 3 = 21

3, 2 = 22
3, 1 = 23

2, 1 = 24

2, 2 = 25

5, 4, 4, 3, 3, 2, 2, 1, 1 이동 횟수
행만 +
열만 +
행만 -
열만 - 를 반복
 */
public class Spiral {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("임의의 양의 정수 : ");
		int n = in.nextInt();
		int[][] arr = new int[n][n];
		
		int num = 0; //배열에 넣을 숫자
		int sw = 1; //양, 음을 변경할 변수
		int row = 0, col = -1; //배열의 행, 열을 결정할 변수
							   //시작하면서 +1을 해줘야 해서 -1 로 설정
		int foward = n; //행, 열 이동 수를 제어할 변수
		
		while(true) {
		
			for(int i = 1; i <= foward; i++) {
				num++; //숫자를 증가시키고
				col = col + sw; //열을 1칸 이동
				arr[row][col] = num; //배열에 입력
			}
			foward = foward - 1;
			//0행에 입력이 완료 되었기 때문에 입력할 수 있는 행의 수가 1 줄어든다.
		
			if(foward > 0) {
				for(int i = 1; i <= foward; i++) {
					num++; //숫자를 증가시키고
					row = row + sw; //행을 1칸 이동
					arr[row][col] = num; //배열에 입력
				}
				sw = sw * (-1); //방향이 바뀌어야 하기 때문에 음수로 바꿔준다.
			} else {
				break;
			}
		
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