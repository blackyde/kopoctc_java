
public class Array {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		
//		arr[3] = 10;
//		
//		System.out.println(arr[3]);
		
		int[] arr2 = arr;
		
		int[] arr3 = arr2;
		
		arr3[0] = 10;
		
		System.out.println(arr[0]);
		System.out.println(arr2[0]);
		System.out.println(arr3[0]);
		
		//새로운 배열을 생성하지 않았기 때문에 모두 같은 배열로 취급한다.
		
		int[] arr4 = new int[5];
		arr4 = arr3;
		
		arr3[0] = 20;
		System.out.println(arr3[0]);
		System.out.println(arr4[0]);

	}

}
