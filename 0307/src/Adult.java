/**
 * 주민등록 번호를 입력하면 성년 여부를 판단해 보자
 * 00~19 는 2000~2019년 생으로, 20~99는 1920~1999년생으로 판단
 * 나이를 만 나이로 계산.
 * 3월 7일이 지났으면 2019 - 생년
 * 3월 7일이 지나지 않았으면 2019 - 생년 - 1
 * @author JBP
 *
 */
import java.util.Scanner;

public class Adult {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int birthAge = 0;
		int age = 0;
		int currentYear = 2019;
		int today = 0307;
		int inputData;
		int birth, birthMonth, birthDay;
		
		System.out.print("주민등록번호 앞자리를 입력하시오 : ");
		inputData = in.nextInt();		
		
		birth = inputData; //주민등록 번호를 받음
		birth = birth - ((birth / 10000) * 10000);	//앞 2자리를 잘라냄	
		
		inputData = inputData / 10000; //앞 2자리만 남김
		
		//연나이
		if(inputData <= 19) { //1900년대 생일때
			
			age = currentYear - (inputData + 2000) + 1;
			
		} else { //2000년대 생일때
			
			age = currentYear - (inputData + 1900) + 1;
			
		}		
		
		//만나이
		if(birth > today) { //생일이 오늘보다 뒤면
			
			birthAge = age - 1;
			
		} else { //생일이 오늘이거나 지났으면
			
			birthAge = age;
			
		}
		
		birthMonth = birth / 100; //월만 뽑아내기
		birthDay = birth % 100; //일만 뽑아내기		
		
		System.out.println("생일은 " + birthMonth + "월 " + birthDay + "일");
		
		System.out.println("나이는 " + age);
		
		System.out.println("만나이는 " + birthAge);
		
		if(age >= 20) {
			System.out.println("성년");
		} else {
			System.out.println("미성년");
		}
		
		in.close();
		
	}

}
