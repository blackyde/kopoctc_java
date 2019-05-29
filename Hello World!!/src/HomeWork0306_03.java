/**
 * 원기둥의 부피를 구하는 프로그램입니다.
 * @author JBP
 *
 */
import java.util.Scanner;

public class HomeWork0306_03 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int x; //밑면의 반지름
		int y; //높이
		final float PI = 3.14f;
		
		System.out.print("원기둥의 밑면의 반지름은? ");
		x = in.nextInt();
		System.out.print("원기둥의 높이는? ");
		y = in.nextInt();
		System.out.println("원기둥의 부피는 " + x * x * PI * y); //밑면의 넓이 (반지름의 제곱 * 파이) * 높이
		
		
		in.close();
		

	}

}