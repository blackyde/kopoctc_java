import java.util.Scanner;

public class InputClass {
	
	private Scanner in;
	
	//생성자
	InputClass() {
		in = new Scanner(System.in);
	}
	
	private int setTicket() {
		int ticket = 0; //권종
		
		while(true) {
			System.out.print("발권할 티켓(1.주간, 2.야간, 3.2일, 99.퇴근) : ");
			try {
				ticket = in.nextInt();
				if(ticket == 99) {
					System.out.println("집에가자");
					try {
						finalize();
					} catch (Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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
	
	public int getTicket() {
		int ticket = setTicket();
		return ticket;
	}
	
	private String setAge() {
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
	
	public String getAge() {
		String registerNumber = setAge();
		return registerNumber;
	}
	
	private int setCount() {
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
	
	public int getCount() {
		int count = setCount();
		return count;
	}

	private int setMerit() {
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
	
	public int getMerit() {
		int merit = setMerit();
		return merit;
	}
	
	//소멸자
	protected void finalize() throws Throwable {
		in.close();
	}

}
