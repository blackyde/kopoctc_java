package kr.ac.kopo.ctc.kopo08.ui;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.ac.kopo.ctc.kopo08.dao.AccountDao;
import kr.ac.kopo.ctc.kopo08.dao.AccountDaoImpl;
import kr.ac.kopo.ctc.kopo08.dao.AccountItemDao;
import kr.ac.kopo.ctc.kopo08.dao.AccountItemDaoImpl;
import kr.ac.kopo.ctc.kopo08.domain.Account;
import kr.ac.kopo.ctc.kopo08.domain.AccountItem;

public class UI {
	
	private static final AccountDao AD = new AccountDaoImpl();
	private static final AccountItemDao AID = new AccountItemDaoImpl();
	private static SimpleDateFormat simpleDate = new SimpleDateFormat("YY-MM-dd HH:mm");
	private static DecimalFormat decimal = new DecimalFormat("###,###,###,###,###");
	
	private static Scanner sc = new Scanner(System.in);
	
	//공백 칸맞추기
	private static String blank(String str, String which) {
    	String sub = str;
    	int bytes = 0;
    	int blankSize = 0;
    	if(which.equals("title")) {
    		blankSize = 14;
    	} else if(which.equals("category")) {
    		blankSize = 9;
    	}
    	
    	try {
			bytes = str.getBytes("EUC-KR").length;
			
			if(which.equals("title")) {
				int sum = 0;
				for(int i = 0; i < str.length(); i++) {			
					if(Character.getType(str.charAt(i)) == Character.OTHER_LETTER) {
						if(str.substring(i, i + 1).matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")) {
							sum++;			
						}
					}
				}
				
				if(sum == 0) sub = str.substring(0, 14);
				if(sum == 1) sub = str.substring(0, 13);
				if(sum == 2) sub = str.substring(0, 12);
				if(sum == 3) sub = str.substring(0, 11);
				if(sum == 4) sub = str.substring(0, 10);
				if(sum == 5) sub = str.substring(0, 9);
				if(sum == 6) sub = str.substring(0, 8);
				if(sum >= 7) sub = str.substring(0, 7);
			}
			
			bytes = sub.getBytes("EUC-KR").length;
			
		} catch(Exception e) {
			
		}
    	
		for(int j = 0; j < blankSize - bytes; j++) {
			sub = sub + " ";
		}
		
		return sub;
    }
	
	//UI 시작
	public static void start() {
		
		sc = new Scanner(System.in);
		
		String input = "";
		int number = 0;
		List<Account> list = AD.selectAll();
		
		while(true) {
			System.out.print("\n사용할 가계부를 선택해 주세요.\n");
			for(int i = 0; i < list.size(); i++) {
				System.out.printf("%d.%s    ", list.get(i).getId(), list.get(i).getTitle());
			}
			System.out.print("00.종료 : ");
			try {
				input = sc.nextLine();
				number = Integer.parseInt(input);				
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
			if(input.equals("00")) {
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				AID.closeAll();
				System.exit(0);
			}

			if(number > list.size() || number <= 0) {
				System.out.println("다시 입력하세요.");
				continue;
			}
			for(int i = 1; i <= list.size(); i++) {
				if(number == i) {
					accountMain(i);
				}
			}
			break;
		}
		
	}
    
	//가계부 메인
	private static void accountMain(int account_id) {
    	List<AccountItem> list = AID.selectAll();
    	int count = 10;
		System.out.printf("\n%s %-13s%-13s%s %s%14s %s\n", "번호", "내용", "일시", "분류", "구분", "금액", "증감");
		for(AccountItem aItem : list) {
			String title = blank(aItem.getTitle(), "title");
			String category = blank(aItem.getCategory(), "category");
			
			if(aItem.getAccount().getId() == account_id) {
				System.out.printf("%4d %s %s %s %s %10s %s\n",
						aItem.getId(), title, simpleDate.format(aItem.getCreated()),
						aItem.getPayment(), category,
						decimal.format(aItem.getPrice()), aItem.getWhether() == 0 ? "지출" : "수입");
			}
			if(count <= 0) break;
			count--;
		}
		
		sc = new Scanner(System.in);
		
		String input = "";
		
		while(true) {
			System.out.print("\n1.입력    2.수정    3.삭제    4.검색    5.분석    0.이전화면    00.종료  : ");
			try {
				input = sc.nextLine();
				Integer.parseInt(input);				
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
			if(input.equals("00")) {
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				AID.closeAll();
				System.exit(0);
			} else if(input.equals("0")) {
				start();
			} else if(input.equals("1")) {
				insert(account_id);
			} else if(input.equals("2")) {
				update(account_id);
			} else if(input.equals("3")) {
				delete(account_id);
			} else if(input.equals("4")) {
				selectMain(account_id);
			} else if(input.equals("5")) {
				System.out.println("개발중");
				continue;
			} else {
				System.out.println("다시 입력해주세요.");
				continue;
			}
			
			break;
		}
    }

	//입력
	private static void insert(int account_id) {
		
		sc = new Scanner(System.in);
		AccountItem aItem = new AccountItem();
		Account account = new Account();
		account.setId(account_id);
		
		aItem.setAccount(account);
		
		while(true) {
			System.out.printf("\n내용 : ");
			String title = sc.nextLine();
			if(title.length() == 0) {
				System.out.println("내용을 입력해 주세요.");
				continue;
			} else {
				aItem.setTitle(title);
			}
			break;
		}
		
		while(true) {			
			System.out.printf("\n분류(1.카드, 2.현금, 3.계좌) : ");
			try {
				String pay = sc.nextLine();
				int payment = Integer.parseInt(pay);
				if(payment == 1) {
					aItem.setPayment("카드");
				} else if(payment == 2) {
					aItem.setPayment("현금");
				} else if(payment == 3) {
					aItem.setPayment("계좌");
				} else {
					System.out.println("다시 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
		}
		
		while(true) {
			System.out.printf("\n1.식비, 2.주거/통신, 3.생활용품, 4.의복/미용, 5.건강/문화\n"
					+ "6.교육/육아, 7.교통/차량, 8.경조사/회비, 9.세금/이자, 10.용돈/기타\n"
					+ "11.카드대금, 12.저축/보험, 13.이체/대체, 14.급여\n");
			System.out.printf("구분 : ");
			try {
				String cat = sc.nextLine();
				int category = Integer.parseInt(cat);
				if(category == 1) {
					aItem.setCategory("식비");
				} else if(category == 2) {
					aItem.setCategory("주거/통신");
				} else if(category == 3) {
					aItem.setCategory("생활용품");
				} else if(category == 4) {
					aItem.setCategory("의복/미용");
				} else if(category == 5) {
					aItem.setCategory("건강/문화");
				} else if(category == 6) {
					aItem.setCategory("교육/육아");
				} else if(category == 7) {
					aItem.setCategory("교통/차량");
				} else if(category == 8) {
					aItem.setCategory("경조사/회비");
				} else if(category == 9) {
					aItem.setCategory("세금/이자");
				} else if(category == 10) {
					aItem.setCategory("용돈/기타");
				} else if(category == 11) {
					aItem.setCategory("카드대금");
				} else if(category == 12) {
					aItem.setCategory("저축/보험");
				} else if(category == 13) {
					aItem.setCategory("이체/대체");
				} else if(category == 14) {
					aItem.setCategory("급여");
				} else {
					System.out.println("다시 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
		}
		
		while(true) {
			System.out.printf("\n금액 : ");
			try {
				String pr = sc.nextLine();
				int price = Integer.parseInt(pr);
				if(price > 0) {
					aItem.setPrice(price);
				} else {
					System.out.println("다시 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
		}
		
		while(true) {
			System.out.printf("\n지출 여부(1.지출, 2.수입) : ");
			try {
				String wt = sc.nextLine();
				int whether = Integer.parseInt(wt);
				if(whether == 1) {
					aItem.setWhether(0);
				} else if(whether == 2) {
					aItem.setWhether(1);
				} else {
					System.out.println("다시 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
		}
		
		AID.create(aItem);
		aItem = AID.selectAll().get(0);
		String title = blank(aItem.getTitle(), "title");
		String category = blank(aItem.getCategory(), "category");
		System.out.printf("\n%s %-13s%-13s%s %s%14s %s\n", "번호", "내용", "일시", "분류", "구분", "금액", "증감");
		System.out.printf("%4d %s %s %s %s %10s %s\n",
				aItem.getId(), title, simpleDate.format(aItem.getCreated()),
				aItem.getPayment(), category,
				decimal.format(aItem.getPrice()), aItem.getWhether() == 0 ? "지출" : "수입");
		
		String input = "";
		while(true) {
			System.out.print("\n1.추가입력    2.수정    3.삭제    0. 이전화면    00. 종료  : ");
			try {
				input = sc.nextLine();
				Integer.parseInt(input);				
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
			if(input.equals("00")) {
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				AID.closeAll();
				System.exit(0);
			} else if(input.equals("0")) {
				accountMain(account_id);
			} else if(input.equals("1")) {
				insert(account_id);
			} else if(input.equals("2")) {
				update(account_id, aItem.getId());
			} else if(input.equals("3")) {
				delete(account_id, aItem.getId());
			} else {
				System.out.println("다시 입력해주세요.");
				continue;
			}
			break;
		}
		
	}

	//입력 후 수정
	private static void update(int account_id, int id) {
		
		sc = new Scanner(System.in);
		AccountItem aItem = new AccountItem();
		
		aItem = AID.selectOne(id);
		
		System.out.println("\n바꾸지 않을 내용은 엔터를 눌러주세요.");
		
		System.out.printf("내용 : ");
		String title = sc.nextLine();
		if(title.length() != 0) {
			aItem.setTitle(title);
		}
		
		while(true) {			
			System.out.printf("\n분류(1.카드, 2.현금, 3.계좌) : ");
			try {
				String pay = sc.nextLine();
				if(pay.length() == 0) break;
				int payment = Integer.parseInt(pay);
				if(payment == 1) {
					aItem.setPayment("카드");
				} else if(payment == 2) {
					aItem.setPayment("현금");
				} else if(payment == 3) {
					aItem.setPayment("계좌");
				} else {
					System.out.println("다시 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
		}
		
		while(true) {
			System.out.printf("\n1.식비, 2.주거/통신, 3.생활용품, 4.의복/미용, 5.건강/문화\n"
					+ "6.교육/육아, 7.교통/차량, 8.경조사/회비, 9.세금/이자, 10.용돈/기타\n"
					+ "11.카드대금, 12.저축/보험, 13.이체/대체, 14.급여\n");
			System.out.printf("구분 : ");
			try {
				String cat = sc.nextLine();
				if(cat.length() == 0) break;
				int category = Integer.parseInt(cat);
				if(category == 1) {
					aItem.setCategory("식비");
				} else if(category == 2) {
					aItem.setCategory("주거/통신");
				} else if(category == 3) {
					aItem.setCategory("생활용품");
				} else if(category == 4) {
					aItem.setCategory("의복/미용");
				} else if(category == 5) {
					aItem.setCategory("건강/문화");
				} else if(category == 6) {
					aItem.setCategory("교육/육아");
				} else if(category == 7) {
					aItem.setCategory("교통/차량");
				} else if(category == 8) {
					aItem.setCategory("경조사/회비");
				} else if(category == 9) {
					aItem.setCategory("세금/이자");
				} else if(category == 10) {
					aItem.setCategory("용돈/기타");
				} else if(category == 11) {
					aItem.setCategory("카드대금");
				} else if(category == 12) {
					aItem.setCategory("저축/보험");
				} else if(category == 13) {
					aItem.setCategory("이체/대체");
				} else if(category == 14) {
					aItem.setCategory("급여");
				} else {
					System.out.println("다시 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
		}
		
		while(true) {
			System.out.printf("\n금액 : ");
			try {
				String pr = sc.nextLine();
				if(pr.length() == 0) break;
				int price = Integer.parseInt(pr);
				if(price > 0) {
					aItem.setPrice(price);
				} else {
					System.out.println("다시 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
		}
		
		while(true) {
			System.out.printf("\n지출 여부(1.지출, 2.수입) : ");
			try {
				String wt = sc.nextLine();
				if(wt.length() == 0) break;
				int whether = Integer.parseInt(wt);
				if(whether == 1) {
					aItem.setWhether(0);
				} else if(whether == 2) {
					aItem.setWhether(1);
				} else {
					System.out.println("다시 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
		}
		
		AID.update(aItem);
		aItem = AID.selectOne(id);
		title = blank(aItem.getTitle(), "title");
		String category = blank(aItem.getCategory(), "category");
		System.out.printf("\n%s %-13s%-13s%s %s%14s %s\n", "번호", "내용", "일시", "분류", "구분", "금액", "증감");
		System.out.printf("%4d %s %s %s %s %10s %s\n",
				aItem.getId(), title, simpleDate.format(aItem.getCreated()),
				aItem.getPayment(), category,
				decimal.format(aItem.getPrice()), aItem.getWhether() == 0 ? "지출" : "수입");
		
		String input = "";
		while(true) {
			System.out.print("\n1.입력    2.수정    3.삭제    0. 이전화면    00. 종료  : ");
			try {
				input = sc.nextLine();
				Integer.parseInt(input);				
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
			if(input.equals("00")) {
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				AID.closeAll();
				System.exit(0);
			} else if(input.equals("0")) {
				accountMain(account_id);
			} else if(input.equals("1")) {
				insert(account_id);
			} else if(input.equals("2")) {
				update(account_id, aItem.getId());
			} else if(input.equals("3")) {
				delete(account_id, aItem.getId());
			} else {
				System.out.println("다시 입력해주세요.");
				continue;
			}
			break;
		}
		
		
	}
	
	//수정
	private static void update(int account_id) {
		
		sc = new Scanner(System.in);
		AccountItem aItem = new AccountItem();
		
		int id = 0;
		while(true) {			
			System.out.printf("\n수정할 항목의 번호 : ");
			try {
				String input = sc.nextLine();
				id = Integer.parseInt(input);
				aItem = AID.selectOne(id);
				if(aItem.getTitle() == null || aItem.getAccount().getId() != account_id) {
					System.out.println("올바른 번호를 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력해주세요.");
				continue;
			}
		}
		
		
		
		System.out.println("\n바꾸지 않을 내용은 엔터를 눌러주세요.");
		
		System.out.printf("내용 : ");
		String title = sc.nextLine();
		if(title.length() != 0) {
			aItem.setTitle(title);
		}
		
		while(true) {			
			System.out.printf("\n분류(1.카드, 2.현금, 3.계좌) : ");
			try {
				String pay = sc.nextLine();
				if(pay.length() == 0) break;
				int payment = Integer.parseInt(pay);
				if(payment == 1) {
					aItem.setPayment("카드");
				} else if(payment == 2) {
					aItem.setPayment("현금");
				} else if(payment == 3) {
					aItem.setPayment("계좌");
				} else {
					System.out.println("다시 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
		}
		
		while(true) {
			System.out.printf("\n1.식비, 2.주거/통신, 3.생활용품, 4.의복/미용, 5.건강/문화\n"
					+ "6.교육/육아, 7.교통/차량, 8.경조사/회비, 9.세금/이자, 10.용돈/기타\n"
					+ "11.카드대금, 12.저축/보험, 13.이체/대체, 14.급여\n");
			System.out.printf("구분 : ");
			try {
				String cat = sc.nextLine();
				if(cat.length() == 0) break;
				int category = Integer.parseInt(cat);
				if(category == 1) {
					aItem.setCategory("식비");
				} else if(category == 2) {
					aItem.setCategory("주거/통신");
				} else if(category == 3) {
					aItem.setCategory("생활용품");
				} else if(category == 4) {
					aItem.setCategory("의복/미용");
				} else if(category == 5) {
					aItem.setCategory("건강/문화");
				} else if(category == 6) {
					aItem.setCategory("교육/육아");
				} else if(category == 7) {
					aItem.setCategory("교통/차량");
				} else if(category == 8) {
					aItem.setCategory("경조사/회비");
				} else if(category == 9) {
					aItem.setCategory("세금/이자");
				} else if(category == 10) {
					aItem.setCategory("용돈/기타");
				} else if(category == 11) {
					aItem.setCategory("카드대금");
				} else if(category == 12) {
					aItem.setCategory("저축/보험");
				} else if(category == 13) {
					aItem.setCategory("이체/대체");
				} else if(category == 14) {
					aItem.setCategory("급여");
				} else {
					System.out.println("다시 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
		}
		
		while(true) {
			System.out.printf("\n금액 : ");
			try {
				String pr = sc.nextLine();
				if(pr.length() == 0) break;
				int price = Integer.parseInt(pr);
				if(price > 0) {
					aItem.setPrice(price);
				} else {
					System.out.println("다시 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
		}
		
		while(true) {
			System.out.printf("\n지출 여부(1.지출, 2.수입) : ");
			try {
				String wt = sc.nextLine();
				if(wt.length() == 0) break;
				int whether = Integer.parseInt(wt);
				if(whether == 1) {
					aItem.setWhether(0);
				} else if(whether == 2) {
					aItem.setWhether(1);
				} else {
					System.out.println("다시 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
		}
		
		AID.update(aItem);
		aItem = AID.selectOne(id);
		title = blank(aItem.getTitle(), "title");
		String category = blank(aItem.getCategory(), "category");
		System.out.printf("\n%s %-13s%-13s%s %s%14s %s\n", "번호", "내용", "일시", "분류", "구분", "금액", "증감");
		System.out.printf("%4d %s %s %s %s %10s %s\n",
				aItem.getId(), title, simpleDate.format(aItem.getCreated()),
				aItem.getPayment(), category,
				decimal.format(aItem.getPrice()), aItem.getWhether() == 0 ? "지출" : "수입");
		
		String input = "";
		while(true) {
			System.out.print("\n1.입력    2.수정    3.삭제    0. 이전화면    00. 종료  : ");
			try {
				input = sc.nextLine();
				Integer.parseInt(input);				
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
			if(input.equals("00")) {
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				AID.closeAll();
				System.exit(0);
			} else if(input.equals("0")) {
				accountMain(account_id);
			} else if(input.equals("1")) {
				insert(account_id);
			} else if(input.equals("2")) {
				update(account_id, aItem.getId());
			} else if(input.equals("3")) {
				delete(account_id, aItem.getId());
			} else {
				System.out.println("다시 입력해주세요.");
				continue;
			}
			break;
		}
		
		
	}

	//입력 or 수정 후 삭제
	private static void delete(int account_id, int id) {
		
		sc = new Scanner(System.in);
		
		AccountItem aItem = AID.selectOne(id);
		String title = blank(aItem.getTitle(), "title");
		String category = blank(aItem.getCategory(), "category");
		System.out.printf("\n%s %-13s%-13s%s %s%14s %s\n", "번호", "내용", "일시", "분류", "구분", "금액", "증감");
		System.out.printf("%4d %s %s %s %s %10s %s\n",
				aItem.getId(), title, simpleDate.format(aItem.getCreated()),
				aItem.getPayment(), category,
				decimal.format(aItem.getPrice()), aItem.getWhether() == 0 ? "지출" : "수입");
		
		System.out.print("위 항목을 삭제하시겠습니까? (y/n) : ");
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			AID.deleteOne(aItem);
			System.out.println("삭제되었습니다.");
			accountMain(account_id);
		} else if(answer.equalsIgnoreCase("n")) {
			System.out.println("삭제하지 않고 상위 메뉴로 돌아가겠습니다.");
			accountMain(account_id);
		} else {
			System.out.println("다시 입력해주세요.");
			delete(account_id, id);
		}
		
		
	}
	
	//삭제
	private static void delete(int account_id) {
		
		sc = new Scanner(System.in);
		
		int id = 0;
		while(true) {			
			System.out.printf("\n삭제할 항목의 번호 : ");
			try {
				String input = sc.nextLine();
				id = Integer.parseInt(input);
				AccountItem aItem = AID.selectOne(id);
				if(aItem.getTitle() == null || aItem.getAccount().getId() != account_id) {
					System.out.println("올바른 번호를 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력해주세요.");
				continue;
			}
		}
		
		AccountItem aItem = AID.selectOne(id);
		String title = blank(aItem.getTitle(), "title");
		String category = blank(aItem.getCategory(), "category");
		System.out.printf("\n%s %-13s%-13s%s %s%14s %s\n", "번호", "내용", "일시", "분류", "구분", "금액", "증감");
		System.out.printf("%4d %s %s %s %s %10s %s\n",
				aItem.getId(), title, simpleDate.format(aItem.getCreated()),
				aItem.getPayment(), category,
				decimal.format(aItem.getPrice()), aItem.getWhether() == 0 ? "지출" : "수입");
		
		System.out.print("위 항목을 삭제하시겠습니까? (y/n) : ");
		String answer = sc.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			AID.deleteOne(aItem);
			System.out.println("삭제되었습니다.");
			accountMain(account_id);
		} else if(answer.equalsIgnoreCase("n")) {
			System.out.println("삭제하지 않고 상위 메뉴로 돌아가겠습니다.");
			accountMain(account_id);
		} else {
			System.out.println("다시 입력해주세요.");
			delete(account_id, id);
		}
		
		
	}
	
	//검색
	private static void selectMain(int account_id) {
		
		sc = new Scanner(System.in);
		
		String input = "";
		
		while(true) {
			System.out.print("\n1.번호로 검색   2.모두 검색    3.내용으로 검색    0.이전화면    00.종료  : ");
			try {
				input = sc.nextLine();
				Integer.parseInt(input);				
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
			if(input.equals("00")) {
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				AID.closeAll();
				System.exit(0);
			} else if(input.equals("0")) {
				accountMain(account_id);
			} else if(input.equals("1")) {
				selectId(account_id);
				selectMain(account_id);
			} else if(input.equals("2")) {
				selectAll(account_id);
				selectMain(account_id);
			} else if(input.equals("3")) {
				selectContents(account_id);
				selectMain(account_id);
			} else {
				System.out.println("다시 입력해주세요.");
				continue;
			}
			
			break;
		}
		
	}
	
	//번호로 검색
	private static void selectId(int account_id) {
		
		sc = new Scanner(System.in);
		
		String input = "";
		int id = 0;
		while(true) {			
			System.out.printf("\n검색할 항목의 번호 : ");
			try {
				input = sc.nextLine();
				id = Integer.parseInt(input);
				AccountItem aItem = AID.selectOne(id);
				if(aItem.getTitle() == null || aItem.getAccount().getId() != account_id) {
					System.out.println("올바른 번호를 입력해주세요.");
					continue;
				}
				break;
			} catch(Exception e) {
				System.out.println("숫자만 입력해주세요.");
				continue;
			}
		}
		
		AccountItem aItem = AID.selectOne(id);
		String title = blank(aItem.getTitle(), "title");
		String category = blank(aItem.getCategory(), "category");
		System.out.printf("\n%s %-13s%-13s%s %s%14s %s\n", "번호", "내용", "일시", "분류", "구분", "금액", "증감");
		System.out.printf("%4d %s %s %s %s %10s %s\n",
				aItem.getId(), title, simpleDate.format(aItem.getCreated()),
				aItem.getPayment(), category,
				decimal.format(aItem.getPrice()), aItem.getWhether() == 0 ? "지출" : "수입");
		
	}
	
	//모두 검색
	private static void selectAll(int account_id) {
		
		List<AccountItem> list = AID.selectAll();
		System.out.printf("\n%s %-13s%-13s%s %s%14s %s\n", "번호", "내용", "일시", "분류", "구분", "금액", "증감");
		for(AccountItem aItem : list) {
			String title = blank(aItem.getTitle(), "title");
			String category = blank(aItem.getCategory(), "category");
			
			if(aItem.getAccount().getId() == account_id) {
				System.out.printf("%4d %s %s %s %s %10s %s\n",
						aItem.getId(), title, simpleDate.format(aItem.getCreated()),
						aItem.getPayment(), category,
						decimal.format(aItem.getPrice()), aItem.getWhether() == 0 ? "지출" : "수입");
			}
		}
	}
	
	//내용으로 검색
	private static void selectContents(int account_id) {
		
		sc = new Scanner(System.in);
		
		String input = "";
		List<String> filter = new ArrayList<String>();
		while(true) {			
			System.out.printf("\n무엇으로 검색할까요?");
			System.out.printf("\n1.내용, 2.날짜, 3.분류, 4.구분");
			System.out.printf("\n번호 : ");
			try {
				input = sc.nextLine();
				Integer.parseInt(input);				
			} catch(Exception e) {
				System.out.println("숫자만 입력하세요.");
				continue;
			}
			if(input.equals("1")) {
				filter.add("title");
			} else if(input.equals("2")) {
				filter.add("created");
			} else if(input.equals("3")) {
				filter.add("payment");
			} else if(input.equals("4")) {
				filter.add("category");
			} else {
				System.out.println("다시 입력해주세요.");
				continue;
			}
			
			break;
		}
		System.out.println("검색 방법");
		System.out.println("1.내용 : 설렁탕, 요금 ...");
		System.out.println("2.날짜형식 : 19-06-09");
		System.out.println("3.분류 : 카드 or 현금  or 계좌");
		System.out.println("4.구분 : 식비, 통신 ...");
		System.out.printf("검색 내용 : ");
		input = sc.nextLine();
		filter.add(input);
		
		
		List<AccountItem> list = AID.selectContainsTitle(filter);
		System.out.printf("\n%s %-13s%-13s%s %s%14s %s\n", "번호", "내용", "일시", "분류", "구분", "금액", "증감");
		for(AccountItem aItem : list) {
			String title = blank(aItem.getTitle(), "title");
			String category = blank(aItem.getCategory(), "category");
			
			if(aItem.getAccount().getId() == account_id) {
				System.out.printf("%4d %s %s %s %s %10s %s\n",
						aItem.getId(), title, simpleDate.format(aItem.getCreated()),
						aItem.getPayment(), category,
						decimal.format(aItem.getPrice()), aItem.getWhether() == 0 ? "지출" : "수입");
			}
		}
	}
}
