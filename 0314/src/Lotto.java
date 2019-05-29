/**
 * 로또
 * @author JBP
 *
 */
public class Lotto {

	public static void main(String[] args) {

		int[] lotto = new int[6];
		int[] winner = {4, 8, 15, 16, 23, 42};
		int[] price = {0, 0, 0, 0};
		int count = 0;
		int round = 1;
		
		while(true) {
			
			count = 0;
			
			for(int i = 0; i < lotto.length; i++) {
				lotto[i] = (int)(Math.random() * 45) + 1;
			}
			
			
			//임의의 6개 숫자
			//System.out.print("처음 ");
			//for(int i = 0; i < lotto.length; i++) {
			//	System.out.printf("%3d", lotto[i]);
			//}
			//System.out.println();
			
			//중복되는 숫자를 변경
			//System.out.print("중복 ");
			for(int i = 0; i < lotto.length; i++) {
				for(int j = 1; j < lotto.length; j++) {
					
					if(i == j) {
						continue;
					}
					if(lotto[i] == lotto[j]) {
						//System.out.print((j + 1) + "번째" + lotto[i] + " = " + lotto[j] + "이므로 재입력\n");
						lotto[j] = (int)(Math.random() * 45) + 1;
						i = -1;
						break;
					}
				}
			}
			
			//작은 수부터 정렬
			//System.out.print("정렬");
//			for(int i = 0 ; i < lotto.length; i++){
//				boolean changed = false;
//
//				for(int j = 0; j < lotto.length - i - 1 ; j++){
//
//					if(lotto[j] > lotto[j + 1]) {
//
//	                    int temp = lotto[j];
//	                    lotto[j] = lotto[j + 1];
//	                    lotto[j + 1] = temp;
//	                    changed = true;
//	                }
//	            }
//				
//	            if(!changed) {
//	            	break;
//	            }

//	            for(int k = 0; k < lotto.length; k++) {
//	            	System.out.printf("%3d", lotto[k]);
//	            }
//	            System.out.println();

//	        }
			
			System.out.println(round + "회차");
			for(int i = 0; i < lotto.length; i++) {
				System.out.printf("%3d", lotto[i]);
			}
			System.out.println();
			
			round++;
			
			//비교
			for(int i = 0; i < lotto.length; i++) {
				for(int j = 0; j < winner.length; j++) {
					if(lotto[i] == winner[j]) {
						count++;
					}
				}
			}
			
			//System.out.println();
			//System.out.printf("갯수 : " + count);
			
			
			//System.out.println(count + "개 맞음");
			
			if(count == 3) {
				price[0]++;
			}
			if(count == 4) {
				price[1]++;
			}
			if(count == 5) {
				price[2]++;
			}
			if(count == 6) {
				System.out.println("1등?");
				price[3]++;
			}
			
			if(round == 100000) {
				System.out.printf("%10s%10s%10s%10s\n", "5th", "4th", "3rd", "1st");
				for(int i = 0; i < price.length; i++) {
					System.out.printf("%10d", price[i]);
				}
				break;
			}
			
		}
		
	}

}
