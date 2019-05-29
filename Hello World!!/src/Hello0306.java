/**
 * 3월 6일 수업 내용
 * BusCard.java
 * Scanner0306.java
 */
public class Hello0306 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.printf("AA%7dBBB\n", 100); // %숫자d : 숫자만큼의 빈 자리를 생성 후 우측 정렬
		System.out.printf("AA%-7dBBB\n", 5);  // -일 경우 좌측 정렬
		System.out.printf("AA%7.2fBBB\n", 10.1234); //총 7자리이며 소숫점 2자리 .도 1자리 차지함. 최종 반올림
		System.out.printf("AA%-7.2fBBB\n", 10.1234);
		System.out.printf("%-7s", "Hello");
		System.out.println("World");
		System.out.printf("%-7s", "안녕");
		System.out.println("하세요");
		
		//줄이 길어질 경우 + 를 활용하여 정리할 수 있다.
		System.out.println("이름 : 홍길동\n" + 
							"나이 : 30\n" + 
							"생일 : 11월 13일\n" + 
							"인사말 : 안녕하세요. 반갑습니다. " + 
							"한국폴리텍대학 융합기술교육원에 오신걸 " + 
							"환영합니다.");
		String name = "홍길동";
		byte age = 30;
		String birth = "11월 13일";
		String intro = "안녕하세요. 반갑습니다. 한국폴리텍대학 융합기술교육원에 오신걸 환영합니다.";
		System.out.println("이름 : " + name + "\n나이 : " + age + "\n생일 : " + birth + "\n인사말 : " + intro);
		
		System.out.println();
		
		//변수 활용
		int mach; //변수 선언 정수형 int (byte < short < int < long)
		int distance;
		mach = 340; //변수에 값을 입력
		distance = mach * 60 * 60;
		System.out.println("소리가 1시간 동안 가는 거리 : " + distance + "m");
		System.out.printf("소리가 1시간 동안 가는 거리 : %dm\n", distance);
		
		double radius; //실수형 double (float < double)
		double area;
		radius = 10.0;
		area = radius * radius * 3.14;
		
		System.out.println("반지름이 " + radius + "인 원의 넓이 : " + area);
		System.out.printf("반지름이 %.1f인 원의 넓이 : %.1f\n", radius, area);
		
		System.out.println();
		
		char ga1 = '가'; //문자 변수. 1글자만 가능
		char ga2 = '\uac00'; // 유니코드, 숫자코드값으로도 입력할 수 있다.
		boolean cham = true; //true or false 값만 가지는 boolean.
		boolean geojit = false;
		
		System.out.println(ga1);
		System.out.println(ga2);
		System.out.println(cham + "가 아니면 " + geojit + "입니다.");
		
		char hangul = '닭';
		
		System.out.println(hangul);
		
		char eng = 'A';
		eng = (char) (eng + 10); //대문자 A의 코드는 65이므로 10을 더하면 75인 'K'가 된다.
		
		System.out.println(eng);
		
		int i;
		double d;
		//byte b;
		
		//i = 7 / 4;
		//i = 7 / (double)4;    //불가
		i = (int)(7 / (double)4.2);
		System.out.println(i);
		
		d = 7 / 4;
		System.out.println(d);
		
		d = 7 / (double) 4;
		System.out.println(d);
		
		
		//삼항 연산
		int x = 1;
		int y;
		
		y = (x == 1) ? 10 : 20; //x 가 1 과 같은가? 참이면 10 거짓이면 20. 참이므로 10
		
		System.out.println(y);
		
		y = (x > 1) ? x++ : x + 20; //x > 1 이 거짓이므로 y 에 x + 20 을 대입.
		
		System.out.println(x);
		System.out.println(y);
		
		
		

	}

}
