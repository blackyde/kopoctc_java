import java.util.Scanner;

public class RockCaesarPaper {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String cheolsu, younghee, winner = null;
		
		System.out.print("철수 : ");
		cheolsu = in.next();
		System.out.print("영희 : ");
		younghee = in.next();
		
		if(cheolsu.equals("r") && younghee.equals("c")) {
			winner = "철수";
		}
		
		System.out.printf("%s, 승!", winner);
		in.close();

	}

}
