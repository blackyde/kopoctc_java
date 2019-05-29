
public class TicketOperationClass {
	
	TicketOperationClass() {
		
	}
	
	public String getTicket(int older, int ticket, int merit) {
		
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
	
}
