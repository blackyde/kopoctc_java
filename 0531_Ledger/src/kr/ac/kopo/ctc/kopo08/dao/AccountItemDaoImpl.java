package kr.ac.kopo.ctc.kopo08.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo08.domain.Account;
import kr.ac.kopo.ctc.kopo08.domain.AccountItem;

public class AccountItemDaoImpl extends GenericDaoImpl<AccountItem> implements AccountItemDao {
	
	@Override
	public AccountItem create_overriding(AccountItem aItem) throws SQLException {
		
		String sql = "INSERT INTO AccountItem"
				+ " (title, account_id, payment, category, price, whether) VALUES (?, ?, ?, ?, ?, ?)";
		pstmt = CONN.prepareStatement(sql);
		pstmt.setString(1, aItem.getTitle());
		pstmt.setInt(2, aItem.getAccount().getId());
		pstmt.setString(3, aItem.getPayment());
		pstmt.setString(4, aItem.getCategory());
		pstmt.setInt(5, aItem.getPrice());
		pstmt.setInt(6, aItem.getWhether());
		pstmt.executeUpdate();
		
		return null;
	}

	@Override
	public AccountItem selectOne_overriding(int id) throws SQLException {
		
		String sql = "SELECT * FROM AccountItem WHERE id = ?";
		Account account = new Account();
		AccountItem aItem = new AccountItem();
		pstmt = CONN.prepareStatement(sql);
		pstmt.setInt(1, id);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			aItem.setId(rset.getInt(1)); //AccountItem.id
			aItem.setTitle(rset.getString(2)); //AccountItem.title
			aItem.setCreated(rset.getDate(3)); //AccountItem.created
			
			sql = "SELECT * FROM Account WHERE id = ?";
			pstmt = CONN.prepareStatement(sql);
			pstmt.setInt(1, rset.getInt(4)); //AccountItem.account_id
			rset2 = pstmt.executeQuery();
			while(rset2.next()) {
				account.setId(rset2.getInt(1)); //Account.id
				account.setTitle(rset2.getString(2)); //Account.title
				account.setCreated(rset2.getDate(3)); //Account.created
				aItem.setAccount(account);
			}
			aItem.setPayment(rset.getString(5)); //AccountItem.payment
			aItem.setCategory(rset.getString(6)); //AccountItem.category
			aItem.setPrice(rset.getInt(7)); //AccountItem.price
			aItem.setWhether(rset.getInt(8)); //AccountItem.whether
		}		
		return aItem;
	}

	@Override
	public List<AccountItem> selectAll_overriding(List<AccountItem> list) throws SQLException {
		
		list = new ArrayList<AccountItem>();
		String sql = "SELECT * FROM AccountItem";
		pstmt = CONN.prepareStatement(sql);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			AccountItem aItem = new AccountItem();
			Account account = new Account();
			aItem.setId(rset.getInt(1));
			aItem.setTitle(rset.getString(2));
			aItem.setCreated(rset.getDate(3));
			
			
			sql = "SELECT * FROM Account WHERE id = ?";
			pstmt = CONN.prepareStatement(sql);
			pstmt.setInt(1, rset.getInt(4));
			rset2 = pstmt.executeQuery();
			while(rset2.next()) {
				account.setId(rset2.getInt(1));
				account.setTitle(rset2.getString(2));
				account.setCreated(rset2.getDate(3));
				aItem.setAccount(account);
			}
			account.setId(rset.getInt(4));
			aItem.setAccount(account);
			
			
			aItem.setPayment(rset.getString(5));
			aItem.setCategory(rset.getString(6));
			aItem.setPrice(rset.getInt(7));
			aItem.setWhether(rset.getInt(8));
			list.add(aItem);
		}
		return list;
	}

	@Override
	public List<AccountItem> selectContainsTitle(List<String> filter) {
		
		List<AccountItem> list = new ArrayList<AccountItem>();
		AccountItem aItem = new AccountItem();
		
		try {
			selectContainsTitle_overriding(list, aItem, filter);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public List<AccountItem> selectContainsTitle_overriding(List<AccountItem> list, AccountItem aItem, List<String> filter) throws SQLException {
		
		String sql = "SELECT * FROM AccountItem WHERE " + filter.get(0) + " = ?";
		
		pstmt = CONN.prepareStatement(sql);
		pstmt.setString(1, filter.get(1));
		rset = pstmt.executeQuery();
		while(rset.next()) {
			aItem = new AccountItem();
			Account account = new Account();
			aItem.setId(rset.getInt(1));
			aItem.setTitle(rset.getString(2));
			aItem.setCreated(rset.getDate(3));
			account.setId(rset.getInt(4));
			aItem.setAccount(account);
			aItem.setPayment(rset.getString(5));
			aItem.setCategory(rset.getString(6));
			aItem.setPrice(rset.getInt(7));
			aItem.setWhether(rset.getInt(8));
			list.add(aItem);
		}
		return list;
	}

	@Override
	public AccountItem update_overriding(AccountItem aItem) throws SQLException {
		
		String sql = "UPDATE AccountItem SET title = ?, account_id = ?, payment = ?, category = ?, price = ?, whether = ? WHERE id = ?";
		
		pstmt = CONN.prepareStatement(sql);
		pstmt.setString(1, aItem.getTitle());
		pstmt.setInt(2, aItem.getAccount().getId());
		pstmt.setString(3, aItem.getPayment());
		pstmt.setString(4, aItem.getCategory());
		pstmt.setInt(5, aItem.getPrice());
		pstmt.setInt(6, aItem.getWhether());
		pstmt.setInt(7, aItem.getId());
		pstmt.executeUpdate();
		return null;
	}

	@Override
	public AccountItem deleteOne_overriding(AccountItem aItem) throws SQLException {
		
		String sql = "DELETE FROM AccountItem WHERE id = ?";
		
		pstmt = CONN.prepareStatement(sql);
		pstmt.setInt(1, aItem.getId());
		pstmt.executeUpdate();
		return null;
	}
	
	@Override
	public AccountItem deleteAll_overriding() throws SQLException {
		
		String sql = "DELETE FROM AccountItem";
		
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
		return null;
	}
}
