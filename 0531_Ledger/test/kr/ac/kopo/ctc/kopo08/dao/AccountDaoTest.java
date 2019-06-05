package kr.ac.kopo.ctc.kopo08.dao;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.List;


import kr.ac.kopo.ctc.kopo08.domain.Account;
import kr.ac.kopo.ctc.kopo08.domain.AccountItem;

public class AccountDaoTest {
	
	public static final AccountDao AD = new AccountDaoImpl();
	public static final AccountItemDao AID = new AccountItemDaoImpl();
	
	public void testCreate() {
		String title = "회사용";
		
		Account account = new Account();
		account.setTitle(title);
		AD.create(account);
	}
	
	
	public void testCreateItem() {
		
		String title = "PS4";
		int id = 1;
		String payment = "카드";
		String category = "건강/문화";
		int price = 378000;
		int whether = 0; //0 : 지출, 1 : 수입
		AccountItem aItem = new AccountItem();
		Account account = new Account();
		account.setId(id);
		aItem.setAccount(account);
		aItem.setTitle(title);
		aItem.setPayment(payment);
		aItem.setCategory(category);
		aItem.setPrice(price);
		aItem.setWhether(whether);
		AID.create(aItem);
	}
	
	public void testSelectOne() {
		int id = 1;
		Account account = AD.selectOne(id);
		
		System.out.printf("%d %s %s", account.getId(), account.getTitle(), account.getCreated());
	}
	
	
	@Test
	public void testSelectOneItem() {
		int id = 2;
		AccountItem aItem = AID.selectOne(id);
		System.out.printf("번호\t내용\t일자\t구분\t방법\t분야\t금액\t지출여부\t번호\t내용\t일자\n");
		System.out.printf("[%d]\t[%s]\t[%s]\t[%d]\t[%s]\t[%s]\t[%d]\t[%d]\t[%d]\t[%s]\t[%s]\n",
				aItem.getId(), aItem.getTitle(), aItem.getCreated(),
				aItem.getAccount().getId(), aItem.getPayment(), aItem.getCategory(),
				aItem.getPrice(), aItem.getWhether(), aItem.getAccount().getId(),
				aItem.getAccount().getTitle(), aItem.getAccount().getCreated());
	}
	
	
	public void testSelectAllItem() {
		List<AccountItem> list = AID.selectAll();
		System.out.printf("번호\t내용\t일자\t구분\t방법\t분야\t금액\t지출여부\t번호\t내용\t일자\n");
		for (AccountItem aItem : list) {
			System.out.printf("[%d] [%s] [%s] [%d] [%s] [%s] [%d] [%d] [%d] [%s] [%s]\n",
					aItem.getId(), aItem.getTitle(), aItem.getCreated(),
					aItem.getAccount().getId(), aItem.getPayment(), aItem.getCategory(),
					aItem.getPrice(), aItem.getWhether(), aItem.getAccount().getId(),
					aItem.getAccount().getTitle(), aItem.getAccount().getCreated());
		}
	}
	
	public void testSelectAll() {
		List<Account> list = AD.selectAll();
		
		for (Account account : list) {
			System.out.printf("%d %s %s\n", account.getId(), account.getTitle(), account.getCreated());
		}
		
		
	}
	
	public void testUpdate() {
		int id = 2;
		String title = "회사용";
		Account account = new Account();
		account.setId(id);
		account.setTitle(title);
		AD.update(account);
		
		testSelectAll();
	}
	

	public void testUpdateItem() {
		int id = 1;
		AccountItem aItem = AID.selectOne(id);
		
		aItem.setPrice(498000);
		
		AID.update(aItem);
		
		testSelectAllItem();
	}
	
	public void testDelete() {
		AccountItem aItem = new AccountItem();
		
		int id = 1;
		aItem.setId(id);
		AID.deleteOne(aItem);
		
		testSelectAllItem();
	}
	
	
	public void testCreated() {
		Account account = new Account();
		AD.selectOne(3);
		assertEquals(account.getTitle(), "회사용");
	}

//	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testCreate("개인용");
		//testSelectOne(1);
		//testSelectAll();
		//testUpdate(3, "회사용");
		//testCreateItem("미각", 1, "외식");
		
//	}

}




enum Cat {
	 
    FOOD("식비"),
    HOME("주거/통신"),
    LIVING("생활용품"),
    CLOTH("의복/미용"),
    CULTURE("건강/문화"),
    EDUCATION("교육/육아"),
    TRAFFIC("교통/차량"),
    DUES("경조사/회비"),
    TAX("세금/이자"),
    ETC("용돈/기타"),
    CREDIT("카드대금"),
    SAVE("저축/보험"),
    WIRE("이체/대체");
     
    final private String name;
     
    public String getName() {
        return name;
    }
 
    private Cat(String name){
        this.name = name;
    }
}