import java.util.Scanner;
/**
 * 최소 140학점을 이수해야 한다.
 * 전공은 70학점 이상.
 * 교양과 일반은 각각 30학점 이상이거나 총 80학점 이상이어야 한다.
 * 이수한 학점을 각각 입력 받아 졸업 여부를 출력하는 프로그램
 * @author JBP
 *
 */
public class HomeWork0306_09 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int major;
		int elective;
		int general;
		
		System.out.print("전공 이수 학점 : ");
		major = in.nextInt();
		System.out.print("교양 이수 학점 : ");
		elective = in.nextInt();
		System.out.print("일반 이수 학점 : ");
		general = in.nextInt();
		
		boolean s140 = major + elective + general >= 140; //총 학점이 140학점 이상인가?
		boolean m70 = major >= 70; //전공이 70학점 이상인가?
		boolean e30 = elective >= 30; //교양이 30학점 이상인가?
		boolean g30 = general >= 30; //일반이 30학점 이상인가?
		boolean eg80 = elective + general >= 80; //교양과 일반의 합이 80학점 이상인가?
		
		
		String graduate = s140 && m70 && ((e30 && g30) || eg80) ? "졸업 가능" : "졸업 불가";
		
		System.out.println(graduate);
		
		in.close();

	}

}
