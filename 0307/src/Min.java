/**
 * 5개의 숫자를 입력 받아 최저 값을 출력하는 프로그램
 * @author JBP
 *
 */
import java.util.Scanner;

public class Min {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int a, b, c, d, e;
		int minValue = 0, maxValue = 0;
		
		System.out.print("숫자 A 입력 : ");
		a = in.nextInt();
		System.out.print("숫자 B 입력 : ");
		b = in.nextInt();
		System.out.print("숫자 C 입력 : ");
		c = in.nextInt();
		System.out.print("숫자 D 입력 : ");
		d = in.nextInt();
		System.out.print("숫자 E 입력 : ");
		e = in.nextInt();
		
		
		//가장 작은 수 찾기
		if(a < b && a < c && a < d && a < e) {
			minValue = a;
		}
		if(b < a && b < c && b < d && b < e) {
			minValue = b;
		}
		if(c < a && c < b && c < d && c < e) {
			minValue = c;
		}
		if(d < a && d < b && d < c && d < e) {
			minValue = d;
		}
		if(e < a && e < b && e < c && e < d) {
			minValue = e;
		}
		
		
		//가장 큰 수 찾기
		if(a > b && a > c && a > d && a > e) {
			maxValue = a;
		}
		if(b > a && b > c && b > d && b > e) {
			maxValue = b;
		}
		if(c > a && c > b && c > d && c > e) {
			maxValue = c;
		}
		if(d > a && d > b && d > c && a > e) {
			maxValue = d;
		}
		if(e > a && e > b && e > c && e > d) {
			maxValue = e;
		}
		
		System.out.println("최대값은 " + maxValue + " 입니다.");
		System.out.println("최대값은 " + minValue + " 입니다.");
		
		in.close();
		
	}

}
