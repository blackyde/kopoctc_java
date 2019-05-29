import java.util.Scanner;

/**
 * 에*랜드 매표소 발권 프로그램
 * @author JBP
 *
 */
public class EverLand {
	
	//입력변수
	public static Scanner in = new Scanner(System.in);
	
	public static int getPay(int older, int ticket, int merit) {
		
		int sum = 0;
		//나이 구분
		final int BABY = 3;
		final int BOY = 12;
		final int TEEN = 18;
		
		//요금 테이블
		//성인 일반요금
		final int DAY_ADULT = 54000;
		final int DAY_TEEN = 46000;
		final int DAY_BOY = 43000;
		final int NIGHT_ADULT = 45000;
		final int NIGHT_TEEN = 39000;
		final int NIGHT_BOY = 36000;
		final int TWO_DAY_ADULT = 84000;
		final int TWO_DAY_TEEN = 71000;
		final int TWO_DAY_BOY = 67000;
		
		//장애인
		final int DISABLED_DAY_ADULT = 33000;
		final int DISABLED_DAY_TEEN = 28000;
		final int DISABLED_DAY_BOY = 26000;
		final int DISABLED_NIGHT_ADULT = 27000;
		final int DISABLED_NIGHT_TEEN = 24000;
		final int DISABLED_NIGHT_BOY = 23000;
		
		//유공자
		final int MERIT_DAY_ADULT = 27000;
		final int MERIT_DAY_TEEN = 23000;
		final int MERIT_DAY_BOY = 21500;
		final int MERIT_NIGHT_ADULT = 22500;
		final int MERIT_NIGHT_TEEN = 19500;
		final int MERIT_NIGHT_BOY = 18000;
		
		//다자녀
		final int MULTI_DAY_ADULT = 43000;
		final int MULTI_DAY_TEEN = 36000;
		final int MULTI_DAY_BOY = 34000;
		final int MULTI_NIGHT_ADULT = 36000;
		final int MULTI_NIGHT_TEEN = 31000;
		final int MULTI_NIGHT_BOY = 28000;
		
		//임산부
		final int PREGNANT_DAY = 45000;
		final int PREGNANT_NIGHT = 36000;
		
		switch(merit) {
		
		case 1 : //없음
			switch(ticket) {
			case 1 : //주간권
				switch(older) {
				case BABY : 
					sum = 0;
					break;
				case BOY : //소인과 경로 포함
					sum = DAY_BOY; 
					break;
				case TEEN :
					sum = DAY_TEEN;
					break;
				default :
					sum = DAY_ADULT;
					break;
				}
				break;
			case 2 : //야간권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = NIGHT_BOY;
					break;
				case TEEN :
					sum = NIGHT_TEEN;
					break;
				default :
					sum = NIGHT_ADULT;
					break;
				}
				break;
			case 3 : //2일권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = TWO_DAY_BOY;
					break;
				case TEEN :
					sum = TWO_DAY_TEEN;
					break;
				default :
					sum = TWO_DAY_ADULT;
					break;
				}
				break;
			}
			break;
			
		case 2 : //장애인
			switch(ticket) {
			case 1 : //장애인 주간권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = DISABLED_DAY_BOY;
					break;
				case TEEN :
					sum = DISABLED_DAY_TEEN;
					break;
				default :
					sum = DISABLED_DAY_ADULT;
					break;
				}
				break;
			case 2 : //장애인 야간권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = DISABLED_NIGHT_BOY;
					break;
				case TEEN :
					sum = DISABLED_NIGHT_TEEN;
					break;
				default :
					sum = DISABLED_NIGHT_ADULT;
					break;
				}
				break;
			//우대권엔 2일권이 따로 없으므로 1일권 x 2 의 가격을 받는다.
			case 3 : //장애인 2일권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = DISABLED_DAY_BOY * 2;
					break;
				case TEEN :
					sum = DISABLED_DAY_TEEN * 2;
					break;
				default :
					sum = DISABLED_DAY_ADULT * 2;
					break;
				}
				break;
			}
			break;
			
		case 3 : //유공자
			switch(ticket) {
			case 1 : //유공자 주간권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = MERIT_DAY_BOY;
					break;
				case TEEN :
					sum = MERIT_DAY_TEEN;
					break;
				default :
					sum = MERIT_DAY_ADULT;
					break;
				}
				break;
			case 2 : //유공자 야간권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = MERIT_NIGHT_BOY;
					break;
				case TEEN :
					sum = MERIT_NIGHT_TEEN;
					break;
				default :
					sum = MERIT_NIGHT_ADULT;
					break;
				}
				break;
			case 3 : //유공자 2일권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = MERIT_DAY_BOY * 2;
					break;
				case TEEN :
					sum = MERIT_DAY_TEEN * 2;
					break;
				default :
					sum = MERIT_DAY_ADULT * 2;
					break;
				}
				break;
			}
			break;
			
		case 4 : //다자녀
			switch(ticket) {
			case 1 : //다자녀 주간권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = MULTI_DAY_BOY;
					break;
				case TEEN :
					sum = MULTI_DAY_TEEN;
					break;
				default :
					sum = MULTI_DAY_ADULT;
					break;
				}
				break;
			case 2 : //다자녀 야간권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = MULTI_NIGHT_BOY;
					break;
				case TEEN :
					sum = MULTI_NIGHT_TEEN;
					break;
				default :
					sum = MULTI_NIGHT_ADULT;
					break;
				}
				break;
			case 3 : //다자녀 2일권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = MULTI_DAY_BOY * 2;
					break;
				case TEEN :
					sum = MULTI_DAY_TEEN * 2;
					break;
				default :
					sum = MULTI_DAY_ADULT * 2;
					break;
				}
				break;
			}
			break;
			
		case 5 : //임산부
			switch(ticket) {
			case 1 : //임산부 주간권
				sum = PREGNANT_DAY;
				break;
			case 2 : //임산부 야간권
				sum = PREGNANT_NIGHT;
				break;
			case 3 : //임산부 2일권
				sum = PREGNANT_DAY * 2;
				break;
			}
		}
		
		return sum;
		
	}
	
	public static int getAge(String registerNumber) {
		
		//나이 판별용
		int age = 0;
		int birthAge = 0;
		int older = 0;
		
		int currentYear = 2019;
		int today = 308;
		int birthYear = 0;
		int birth = 0;
		
		final int OLD = 65;
		final int BABY = 3;
		final int BOY = 12;
		final int TEEN = 18;
		final int ADULT = 19;
		
		//나이 처리
		birth = Integer.parseInt(registerNumber); //주민등록 번호를 받음		
		birthYear = birth / 10000; //앞 2자리만 남김
		
		//연나이
		if(birthYear <= 19) { //2000년대 생일때			
			age = currentYear - (birthYear + 2000) + 1;
		} else { //1900년대 생일때			
			age = currentYear - (birthYear + 1900) + 1;			
		}
		
		//만나이
		birth = birth - ((birth / 10000) * 10000);	//앞 2자리를 잘라냄
		if(birth > today) { //생일이 오늘보다 뒤면			
			birthAge = age - 2;			
		} else { //생일이 오늘이거나 지났으면			
			birthAge = age - 1;			
		}
		
		if(birthAge < BABY) {
			older = BABY;
		} else if((birthAge >= BABY && birthAge <= BOY) || birthAge >= OLD) {
			older = BOY;
		} else if(birthAge > BOY && birthAge <= TEEN) {
			older = TEEN;
		} else {
			older = ADULT;
		}
		
		return older;
	}
	
	public static String getTicket(int older, int ticket, int merit) {
		
		String meritName = "";
		String ticketName ="";
		
		final int BABY = 3;
		final int BOY = 12;
		final int TEEN = 18;
		
		//나이 구분
		if(older == BABY) {
			meritName = "유아";
		} else if((older == BOY)) {
			meritName = "소인/경로";
		} else if(older == TEEN) {
			meritName = "청소년";
		} else {
			meritName = "대인";
		}
		
		//권종 구분
		if(ticket == 1) {
			ticketName = "주간권";
		} else if(ticket == 2) {
			ticketName = "야간권";
		} else if(ticket == 3) {
			ticketName = "2일권";
		}
		
		//우대 구분
		if(merit == 2) {
			meritName += " 장애인";
		} else if(merit == 3) {
			meritName += " 국가유공자";
		} else if(merit == 4) {
			meritName += " 다자녀 가정";
		} else if(merit == 5) {
			meritName += " 임산부";
		}
		
		return meritName + " " + ticketName;
		
	}
	
	public static int setTicket() {
		int ticket = 0; //권종
		
		while(true) {
			System.out.print("발권할 티켓(1.주간, 2.야간, 3.2일, 99.퇴근) : ");
			try {
				ticket = in.nextInt();
				if(ticket == 99) {
					System.out.println("집에가자");
					in.close();
					System.exit(0);
				}
				if(ticket > 3 || ticket < 1) {
					System.out.println("1 ~ 3 사이로 입력하시오.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하시오.");
				in.nextLine();
			}
			
		}
		return ticket;
	}
	
	public static String setAge() {
		String registerNumber = "000101"; //주민등록번호
		
		while(true) {
			System.out.print("주민등록번호 앞자리 : ");
			try {
				registerNumber = in.next();
				Integer.parseInt(registerNumber);
				if(registerNumber.length() != 6) {
				//if((int)(Math.log10(registerNumber)+1) != 6) {//00 01 같은 경우는 처리가 안됨.
					System.out.println("6자리 숫자를 입력하시오.");
					continue;
				}
				//00월 방지
				if(registerNumber.charAt(2) == '0' && registerNumber.charAt(3) == '0') {
					System.out.println("정확한 형식으로 입력하시오. 00월");
					continue;
				} else if(registerNumber.charAt(2) == '1' && registerNumber.charAt(3) >= '3') {
					System.out.println("정확한 형식으로 입력하시오. 13~19월");
					continue;
				} else if(registerNumber.charAt(2) >= '2') {
					System.out.println("정확한 형식으로 입력하시오. 20월~");
					continue;
				}
				//00일 방지 (2월은? 4,6,9,11월은? 윤년은?)
				if(registerNumber.charAt(4) == '0' && registerNumber.charAt(5) == '0') {
					System.out.println("정확한 형식으로 입력하시오. 00일");
					continue;
				} else if(registerNumber.charAt(4) == '3' && registerNumber.charAt(5) >= '2') {
					System.out.println("정확한 형식으로 입력하시오. 32~39일");
					continue;
				} else if(registerNumber.charAt(4) >= '4') {
					System.out.println("정확한 형식으로 입력하시오. 40일~");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하시오.");
				in.nextLine();
			}
		}
		return registerNumber;
	}
	
	public static int setCount() {
		int count = 0; //매수
		
		while(true) {
			System.out.print("매수 : ");
			try {
				count = in.nextInt();
				if(count == 0) {
					System.out.println("1장 이상 입력하시오.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하시오.");
				in.nextLine();
			}
		}
		return count;
	}

	public static int setMerit() {
		int merit = 0; //우대사항
		
		while(true) {
			System.out.print("우대사항(1.없음(나이), 2.장애, 3.유공자, 4.다자녀, 5.임산부 : ");
			try {
				merit = in.nextInt();
				if(merit > 5 || merit < 1) {
					System.out.println("1 ~ 5 사이로 입력하시오.");
					continue;				
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하시오.");
				in.nextLine();
			}
			
		}
		return merit;		
	}

	public static void main(String[] args) {
		
		while(true) {
			
			printTicket();
			
		}

	}
	
	public static void printTicket() {
		
		int older, ticket, merit, count, sum;
		String registerNumber, ticketName;
		ticket = setTicket();
		registerNumber = setAge();
		count = setCount();
		merit = setMerit();
		
		older = getAge(registerNumber);
		ticketName = getTicket(older, ticket, merit);
		sum = getPay(older, ticket, merit);
		
		//출력부
		System.out.println("======== 여기는 에*랜드 ========");
		//System.out.println("만 나이는 " + age + "세 이며");
		System.out.printf(ticketName + " " + count + "장 입니다.\n");
		System.out.printf("가격은 %d * %d로 %d원 입니다.\n", sum, count, sum * count);
		System.out.println("======== 여기는 에*랜드 ========");
	}

}
