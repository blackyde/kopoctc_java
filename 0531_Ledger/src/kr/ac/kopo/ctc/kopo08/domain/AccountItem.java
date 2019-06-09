package kr.ac.kopo.ctc.kopo08.domain;

import java.sql.Timestamp;

public class AccountItem {
	private int id;
	private String title;
	private Timestamp created;
	private String payment;
	private String category;
	private int price;
	private int whether;
	private Account account;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp date) {
		this.created = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int view) {
		this.price = view;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public int getWhether() {
		return whether;
	}

	public void setWhether(int whether) {
		this.whether = whether;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
}
