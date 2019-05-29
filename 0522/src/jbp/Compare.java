package jbp;

/**
 * @FileName : Compar.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : 숫자형, 문자형 비교
 */
public class Compare {

	public static void main(String[] args) {

		int k08_iI;
		double k08_iD;
		
		k08_iI = 10/3; //정수형 연산
		k08_iD = 10/3.0; //실수형 연산
		
		if (k08_iI == k08_iD) System.out.printf("equal\n");
		//정수와 실수의 값이 같으면 equal 을 출력하고 개행한다.
		else System.out.printf("Not equal[%f][%f]\n", (double)k08_iI, k08_iD);
		//정수와 실수의 값이 다르면 Not equal[정수값의 실수화][실수]를 출력하고 개행한다.
		
		if (k08_iD == 3.333333) System.out.printf("equal\n");
		//실수연산값이 3.333333 과 같으면 equal 을 출력하고 개행한다.
		else System.out.printf("Not equal[3.333333][%f]\n", k08_iD);
		//실수연산값은 3.33333333333... 이므로 소수점 6자리 333333 과는 다르다.
		//Not equal[3.333333][실수연산값]을 출력하고 개행한다.
		
		k08_iD = (int)k08_iD; //소수점 밑이 버려진다.
		if (k08_iI == k08_iD) System.out.printf("equal\n");
		//정수와 실수의 값이 같으면 equal 을 출력하고 개행한다.
		//실수의 소수점이 버려졌으므로 같다.
		else System.out.printf("Not equal[%f][%f]\n", (double)k08_iI, k08_iD);
		//정수와 실수의 값이 다르면 Not equal[정수값의 실수화][실수]를 출력하고 개행한다.
		
		System.out.printf("int로 인쇄[%d][%f]\n", k08_iI, k08_iD);
		System.out.printf("double로 인쇄[%f][%f]\n", (double)k08_iI, k08_iD);
		
		char k08_a = 'c';
		
		if (k08_a == 'b') System.out.printf("k08_a는 b이다\n");
		//변수 k08_a의 값이 b와 같다면 k08_a는 b이다 출력하고 개행
		if (k08_a == 'c') System.out.printf("k08_a는 c이다\n");
		//변수 k08_a의 값이 c와 같다면 k08_a는 c이다 출력하고 개행
		if (k08_a == 'd') System.out.printf("k08_a는 d이다\n");
		//변수 k08_a의 값이 d와 같다면 k08_a는 d이다 출력하고 개행
		
		String k08_aa = "abcd";
		
		if(k08_aa.equals("abcd")) System.out.printf("k08_aa는 abcd이다\n");
		//문자열은 ==으로 비교할 수 없다. 문자열의 값이 abcd 이면 k08_aa는 abcd이다 출력
		else System.out.print("k08_aa는 abcd가 아니다\n");
		
		boolean k08_bb = true;
		
		if(!!k08_bb) System.out.printf("k08_bb가 아니고 아니면 참이다\n");
		//조건식이 참인가 거짓인가
		//논리연산자 !는 값을 반대로 만든다. !를 ! 하면 아무것도 하지 않은 것과 같다.
		//처음 설정된 변수값이 true 이므로 true 로 실행된다.
		else System.out.printf("k08_bb가 아니고 아니면 거짓이다\n");
		
	}

}
