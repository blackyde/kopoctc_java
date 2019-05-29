
/**
 * @FileName : VarEx2.java
 * @Project : 0520
 * @Date : 2019. 5. 20.
 * @Author : JBP
 * @Descript : 변수에 담긴 값을 교환
 */
public class VarEx2 {

	public static void main(String[] args) {
		
		int k08_x = 10;
		int k08_y = 20;
		int k08_tmp = 0;
		
		System.out.println("x:" + k08_x + " y:" + k08_y);
		
		k08_tmp = k08_x;
		k08_x = k08_y;
		k08_y = k08_tmp;
		
		System.out.println("x:" + k08_x + " y:" + k08_y);
	}

}
