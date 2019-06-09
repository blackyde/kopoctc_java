package kr.ac.kopo.ctc.kopo08.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import kr.ac.kopo.ctc.kopo08.domain.Account;

public class AccountDaoImpl extends GenericDaoImpl<Account> implements AccountDao {
	
	@Override
	public Account create_overriding(Account account) throws SQLException {
		String sql = "INSERT INTO Account"
				+ " (title) VALUES (?)";
		pstmt = CONN.prepareStatement(sql);
		pstmt.setString(1, account.getTitle());
		pstmt.executeUpdate();
		return null;
	}

	@Override
	public Account selectOne_overriding(int id) throws SQLException {
		Account account = new Account();
		String sql = "SELECT * FROM Account WHERE id = ?";
		
		pstmt = CONN.prepareStatement(sql);
		pstmt.setInt(1, id);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			account.setId(rset.getInt(1));
			account.setTitle(rset.getString(2));
			account.setCreated(rset.getTimestamp(3));
		}
		return account;
	}

	@Override
	public List<Account> selectAll_overriding(List<Account> list) throws SQLException {
		list = new ArrayList<Account>();
		String sql = "SELECT * FROM Account";
		
		pstmt = CONN.prepareStatement(sql);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			Account account = new Account();
			account.setId(rset.getInt(1));
			account.setTitle(rset.getString(2));
			account.setCreated(rset.getTimestamp(3));
			list.add(account);
		}
		return list;
	}

	@Override
	public Account update_overriding(Account account) throws SQLException {
		String sql = "UPDATE Account SET title = ? WHERE id = ?";
		
		pstmt = CONN.prepareStatement(sql);
		pstmt.setString(1, account.getTitle());
		pstmt.setInt(2, account.getId());
		pstmt.executeUpdate();
		return null;
	}

	@Override
	public Account deleteOne_overriding(Account account) throws SQLException {
		String sql = "DELETE FROM Account WHERE id = ?";
		
		pstmt = CONN.prepareStatement(sql);
		pstmt.setInt(1, account.getId());
		pstmt.executeUpdate();
		return null;
	}
	
	@Override
	public Account deleteAll_overriding() throws SQLException {
		String sql = "DELETE FROM Account";
		
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
		return null;
	}
}