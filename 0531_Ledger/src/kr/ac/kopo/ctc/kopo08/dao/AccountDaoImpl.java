package kr.ac.kopo.ctc.kopo08.dao;

import java.sql.*;
import java.util.List;

import kr.ac.kopo.ctc.kopo08.domain.Account;

public class AccountDaoImpl extends GenericDaoImpl<Account> implements AccountDao {
	
	@Override
	public Account create_overriding(Connection conn, PreparedStatement pstmt, Account account) throws SQLException {
		
		String sql = "INSERT INTO Account"
				+ " (title) VALUES (?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, account.getTitle());
		pstmt.executeUpdate();
		pstmt.close();
		return null;
	}

	@Override
	public Account selectOne_overriding(Connection conn, PreparedStatement pstmt, ResultSet rset, Account account) throws SQLException {
		
		String sql = "SELECT * FROM Account WHERE id = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, account.getId());
		rset = pstmt.executeQuery();
		while(rset.next()) {
			account.setId(rset.getInt(1));
			account.setTitle(rset.getString(2));
			account.setCreated(rset.getDate(3));
		}
		pstmt.close();
		return account;
	}

	@Override
	public List<Account> selectAll_overriding(Connection conn, PreparedStatement pstmt, ResultSet rset, List<Account> list) throws SQLException {
				
		String sql = "SELECT * FROM Account";
		
		pstmt = conn.prepareStatement(sql);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			Account account = new Account();
			account.setId(rset.getInt(1));
			account.setTitle(rset.getString(2));
			account.setCreated(rset.getDate(3));
			list.add(account);
		}
		pstmt.close();
		return list;
	}

	@Override
	public Account update_overriding(Connection conn, PreparedStatement pstmt, Account account) throws SQLException {
		
		String sql = "UPDATE Account SET title = ? WHERE id = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, account.getTitle());
		pstmt.setInt(2, account.getId());
		pstmt.executeUpdate();
		pstmt.close();
		return null;
	}

	@Override
	public Account deleteOne_overriding(Connection conn, PreparedStatement pstmt, Account account) throws SQLException {
		
		String sql = "DELETE FROM Account WHERE id = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, account.getId());
		pstmt.executeUpdate();
		pstmt.close();
		return null;
	}
	
	@Override
	public Account deleteAll_overriding(Connection conn, PreparedStatement pstmt) throws SQLException {
		
		String sql = "DELETE FROM Account";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		return null;
	}
}