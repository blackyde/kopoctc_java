import java.util.Scanner;

public class ArraySecond {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] arr = new String[1][5];
		int frequency = 2;
		Scanner in = new Scanner(System.in);
		String answer = "";
		
		//System.out.println(arr.length);
		
		
		
		
		for(int i = 0; i < arr.length; i++) { //행의 길이
			for(int j = 0; j < arr[0].length; j++) { //열의 길이
				System.out.print("입력 : ");
				arr[i][j] = in.next();
			}
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) { //열의 길이
				System.out.printf("%3s", arr[i][j]);
			}
			System.out.println();
		}
		
		while(true) {
			
			String[][] tempArr = new String[frequency][5]; 
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[0].length; j++) { //열의 길이
					tempArr[i][j] = arr[i][j];
				}
			}
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[0].length; j++) { //열의 길이
					System.out.printf("%3s", arr[i][j]);
				}
				System.out.println();
			}
			
			for(int i = arr.length; i < tempArr.length; i++) {
				for(int j = 0; j < arr[0].length; j++) { //열의 길이
					System.out.print(frequency + "번째 입력 : ");
					tempArr[i][j] = in.next();
				}
			}
			
			arr = tempArr;
			
			//System.out.println(arr.length);
			
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[0].length; j++) { //열의 길이
					System.out.printf("%3s", arr[i][j]);
				}
				System.out.println();
			}
			
			
			System.out.println("한번더?");
			answer = in.next();
			
			if(answer.equals("no")) {
				in.close();
				break;
			}
			
			frequency++;
		}
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) { //열의 길이
				System.out.printf("%3s", arr[i][j]);
			}
			System.out.println();
		}

	}

}
