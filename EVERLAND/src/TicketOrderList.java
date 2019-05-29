
public class TicketOrderList {
	//List<TicketOrderList> data = new ArrayList<TicketOrderList>();
	//이런식으로 만들도록 이 안에 변수의 틀을 만들자
	private int age;
	private int prices;
	private int counts;
	private String ticketNames;
	
	TicketOrderList() {
		
	}
	
	TicketOrderList(int age, int prices, int counts, String ticketNames) {
		this.age = age;
		this.prices = prices;
		this.counts = counts;
		this.ticketNames = ticketNames;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPrices() {
		return prices;
	}
	public void setPrices(int prices) {
		this.prices = prices;
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public String getTicketNames() {
		return ticketNames;
	}
	public void setTicketNames(String ticketNames) {
		this.ticketNames = ticketNames;
	}
}
