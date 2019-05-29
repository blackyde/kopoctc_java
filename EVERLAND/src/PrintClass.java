import java.util.*;

public class PrintClass {
	
	//생성자
	PrintClass() {
		
	}
	
	public void printTicket() {
		
		InputClass ic = new InputClass();
		AgeOperationClass aoc = new AgeOperationClass();
		TicketOperationClass toc = new TicketOperationClass();
		PriceClass prc = new PriceClass();
		
		int older, ticket, merit, count, sum, age = 0;
		String registerNumber, ticketName;
		
		List<TicketOrderList> data = new ArrayList<TicketOrderList>();
		int sum2 = 0;
		
		while(true) {
		
			ticket = ic.getTicket();
			registerNumber = ic.getAge();
			count = ic.getCount();
			merit = ic.getMerit();
			
			older = aoc.returnAge(registerNumber);
			ticketName = toc.getTicket(older, ticket, merit);
			sum = prc.getPay(older, ticket, merit);
			age = aoc.getAge(registerNumber);
			
			TicketOrderList tol = new TicketOrderList(age, sum * count, count, ticketName);
//			tol.setAge(age);
//			tol.setPrices(sum * count);
//			tol.setCounts(count);
//			tol.setTicketNames(ticketName);
			data.add(tol);
			
			sum2 = 0;
			
			//출력부
			System.out.println("======== 여기는 에*랜드 ========");
			System.out.println("만 나이는 " + age + "세 이며");
			System.out.printf(ticketName + " " + count + "장 입니다.\n");
			System.out.printf("가격은 %d * %d로 %d원 입니다.\n", sum, count, sum * count);
			
			System.out.println("===========================\n");
			System.out.println("========= 오늘의 매상 =========");
			
			for(TicketOrderList tl : data) {
				System.out.print(tl.getAge() + "세 " + tl.getTicketNames() + " "
								+ tl.getCounts() + "장, " + tl.getPrices() + "\n");
				sum2 += tl.getPrices();
			}
			
			System.out.println("===========================");
			System.out.println("총합 : " + sum2 + " 원");
			System.out.println("===========================");
			
		
		}
	}
	
	//소멸자
	protected void finalize() throws Throwable {
		
	}
}
