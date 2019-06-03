package kr.ac.kopo.ctc.kopo08.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo08.conn.Conn;
import kr.ac.kopo.ctc.kopo08.domain.Account;
import kr.ac.kopo.ctc.kopo08.domain.AccountItem;

public class AccountItemDaoImpl extends GenericDaoImpl<AccountItem> implements AccountItemDao {

	@Override
	public AccountItem create_overriding(Connection conn, PreparedStatement pstmt, AccountItem aItem) throws SQLException {
		
		String sql = "INSERT INTO AccountItem"
				+ " (title, account_id, category, price, whether) VALUES (?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, aItem.getTitle());
		pstmt.setInt(2, aItem.getAccount().getId());
		pstmt.setString(3, aItem.getCategory());
		pstmt.setInt(4, aItem.getPrice());
		pstmt.setString(5, aItem.getWhether());
		pstmt.executeUpdate();
		pstmt.close();
		
		return null;
	}

	@Override
	public AccountItem selectOne_overriding(Connection conn, PreparedStatement pstmt, ResultSet rset, AccountItem aItem) throws SQLException {
		
		String sql = "SELECT * FROM AccountItem WHERE id = ?";
		
		Account account = new Account();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aItem.getId());
		rset = pstmt.executeQuery();
		while(rset.next()) {
			aItem.setId(rset.getInt(1));
			aItem.setTitle(rset.getString(2));
			aItem.setCreated(rset.getDate(3));
			account.setId(rset.getInt(4));
			aItem.setAccount(account);
			aItem.setCategory(rset.getString(5));
			aItem.setPrice(rset.getInt(6));
			aItem.setWhether(rset.getString(7));
		}
		rset.close();
		pstmt.close();
		return aItem;
	}

	@Override
	public List<AccountItem> selectAll_overriding(Connection conn, PreparedStatement pstmt, ResultSet rset, List<AccountItem> list) throws SQLException {
				
		String sql = "SELECT * FROM AccountItem";
		
		pstmt = conn.prepareStatement(sql);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			AccountItem aItem = new AccountItem();
			Account account = new Account();
			aItem.setId(rset.getInt(1));
			aItem.setTitle(rset.getString(2));
			aItem.setCreated(rset.getDate(3));
			account.setId(rset.getInt(4));
			aItem.setAccount(account);
			aItem.setCategory(rset.getString(5));
			aItem.setPrice(rset.getInt(6));
			aItem.setWhether(rset.getString(7));
			list.add(aItem);
		}
		rset.close();
		pstmt.close();
		return list;
	}

	@Override
	public List<AccountItem> selectContainsTitle(List<String> filter) {
		PreparedStatement pstmt = null;
		Connection conn = Conn.getConnection();
		ResultSet rset = null;
		List<AccountItem> list = new ArrayList<AccountItem>();
		AccountItem aItem = new AccountItem();
		
		try {
			selectContainsTitle_overriding(conn, pstmt, rset, list, aItem, filter);
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public List<AccountItem> selectContainsTitle_overriding(Connection conn, PreparedStatement pstmt, ResultSet rset, List<AccountItem> list, AccountItem aItem, List<String> filter) throws SQLException {
		
		String sql = "SELECT * FROM AccountItem WHERE " + filter.get(0) + " = ?";
		
		pstmt = conn.prepareStatement(sql);
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
			aItem.setCategory(rset.getString(5));
			aItem.setPrice(rset.getInt(6));
			aItem.setWhether(rset.getString(7));
			list.add(aItem);
		}
		rset.close();
		pstmt.close();
		return list;
	}

	@Override
	public AccountItem update_overriding(Connection conn, PreparedStatement pstmt, AccountItem aItem) throws SQLException {
		
		String sql = "UPDATE AccountItem SET title = ?, account_id = ?, category = ?, price = ?, whether = ? WHERE id = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, aItem.getTitle());
		pstmt.setInt(2, aItem.getAccount().getId());
		pstmt.setString(3, aItem.getCategory());
		pstmt.setInt(4, aItem.getPrice());
		pstmt.setString(5, aItem.getWhether());
		pstmt.setInt(6, aItem.getId());
		pstmt.executeUpdate();
		pstmt.close();
		return null;
	}

	@Override
	public AccountItem deleteOne_overriding(Connection conn, PreparedStatement pstmt, AccountItem aItem) throws SQLException {
		
		String sql = "DELETE FROM AccountItem WHERE id = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aItem.getId());
		pstmt.executeUpdate();
		pstmt.close();
		return null;
	}
	
	@Override
	public AccountItem deleteAll_overriding(Connection conn, PreparedStatement pstmt) throws SQLException {
		
		String sql = "DELETE FROM AccountItem";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		return null;
	}
}
