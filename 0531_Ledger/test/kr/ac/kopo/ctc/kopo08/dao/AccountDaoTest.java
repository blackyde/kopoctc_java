package kr.ac.kopo.ctc.kopo08.dao;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.List;


import kr.ac.kopo.ctc.kopo08.domain.Account;
import kr.ac.kopo.ctc.kopo08.domain.AccountItem;

public class AccountDaoTest {
	
	public void testCreate() {
		String title = "회사용";
		
		AccountDao dao = new AccountDaoImpl();
		Account account = new Account();
		account.setTitle(title);
		dao.create(account);
	}
	
	
	public void testCreateItem() {
		String title = "PS4";
		int id = 1;
		String category = "취미";
		int price = 378000;
		String whether = "지출";
		AccountItemDao dao = new AccountItemDaoImpl();
		AccountItem aItem = new AccountItem();
		Account account = new Account();
		account.setId(id);
		aItem.setAccount(account);
		aItem.setTitle(title);
		aItem.setCategory(category);
		aItem.setPrice(price);
		aItem.setWhether(whether);
		dao.create(aItem);
	}
	
	public void testSelectOne() {
		int id = 1;
		AccountDao dao = new AccountDaoImpl();
		Account account = new Account();
		account.setId(id);
		dao.selectOne(account);
		
		System.out.printf("%d %s %s", account.getId(), account.getTitle(), account.getCreated());
	}
	
	
	public void testSelectOneItem() {
		int id = 6;
		AccountItemDao dao = new AccountItemDaoImpl();
		AccountItem aItem = new AccountItem();
		aItem.setId(id);
		dao.selectOne(aItem);
		
		System.out.printf("%d %s %s %d %s", aItem.getId(), aItem.getTitle(), aItem.getCreated(), aItem.getAccount().getId(), aItem.getCategory());
	}
	
	@Test
	public void testSelectAllItem() {
		AccountItemDao dao = new AccountItemDaoImpl();
		List<AccountItem> list = dao.selectAll();
		for (AccountItem aItem : list) {
			System.out.printf("%d %s %s\n", aItem.getId(), aItem.getTitle(), aItem.getCreated());
		}
	}
	
	public void testSelectAll() {
		AccountDao dao = new AccountDaoImpl();
		dao.selectAll();
		List<Account> list = dao.selectAll();
		
		for (Account account : list) {
			System.out.printf("%d %s %s\n", account.getId(), account.getTitle(), account.getCreated());
		}
		
		
	}
	
	public void testUpdate(int id, String title) {
		AccountDao dao = new AccountDaoImpl();
		Account account = new Account();
		account.setId(id);
		account.setTitle(title);
		dao.update(account);
		
		testSelectAll();
	}
	

	public void testUpdateItem() {
		AccountItemDao dao = new AccountItemDaoImpl();
		AccountItem aItem = new AccountItem();
		
		int id = 1;
		aItem.setId(id);
		dao.selectOne(aItem);
		
		aItem.setPrice(498000);
		
		dao.update(aItem);
		
		testSelectAllItem();
	}
	
	public void testDelete() {
		AccountItemDao dao = new AccountItemDaoImpl();
		AccountItem aItem = new AccountItem();
		
		int id = 1;
		aItem.setId(id);
		dao.deleteOne(aItem);
		
		testSelectAllItem();
	}
	
	
	public void testCreated() {
		AccountDao dao = new AccountDaoImpl();
		Account account = new Account();
		account.setId(3);		
		dao.selectOne(account);
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
