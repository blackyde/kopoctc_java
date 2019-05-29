/**
 * 버블정렬
 * @author JBP
 *
 */
public class Bubble {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		
		System.out.println("입력 받은 값");
		for(int i = 0 ; i < arr.length; i++){
			System.out.printf("%3d", arr[i] = (int)(Math.random() * 10) + 1); 
		}
		System.out.println();
		
		System.out.println("정렬 시작");

		for(int i = 0 ; i < arr.length; i++){
			boolean changed = false;

			for(int j = 0; j < arr.length - i - 1 ; j++){

				if(arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    changed = true;
                }
            }
			
            if(!changed) {
            	break;
            }

            for(int k = 0; k<arr.length; k++) {
            	System.out.printf("%3d", arr[k]);
            }
            System.out.println();

        }

	}
	
}
