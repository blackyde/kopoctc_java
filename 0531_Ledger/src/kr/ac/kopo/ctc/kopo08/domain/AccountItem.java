package kr.ac.kopo.ctc.kopo08.domain;

import java.util.Date;

enum Category {
	 
    A("식비"),
    B("주거/통신"),
    C("생활용품"),
    D("의복/미용"),
    E("건강/문화"),
    F("교육/육아"),
    G("교통/차량"),
    H("경조사/회비"),
    I("세금/이자"),
    J("용돈/기타"),
    K("카드대금"),
    L("저축/보험"),
    M("이체/대체");
     
    final private String name;
     
    public String getName() {
        return name;
    }
 
    private Category(String name){
        this.name = name;
    }
}

public class AccountItem {
	private int id;
	private String title;
	private Date created;
	private String category;
	private int price;
	private String whether;
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
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
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

	public String getWhether() {
		return whether;
	}

	public void setWhether(String whether) {
		this.whether = whether;
	}
}
