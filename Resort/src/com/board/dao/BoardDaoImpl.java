package com.board.dao;

import java.sql.*;
import java.util.*;

import com.board.connector.Connector;
import com.board.dto.Board;

public class BoardDaoImpl implements BoardDao<Board> {
	
	public static final Connection CONN = Connector.getConnection();
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	public Board b;
	public List<Board> lb;

	@Override
	public Board insert(Board b) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("INSERT INTO notice (`subject`,"
				+ "`contents`) VALUES ("
				+ "'%s', '%s')",
				b.getSubject(),
				b.getContents());
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
		
		b = selectOne(b);		
		return b;
	}

	@Override
	public List<Board> select() throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("SELECT * FROM notice");
		pstmt = CONN.prepareStatement(sql);
		rs = pstmt.executeQuery();		
		lb = new ArrayList<Board>();
		
		while(rs.next()) {
			b = new Board();
			b.setWrite_num(rs.getInt(1));
			b.setSubject(rs.getString(2));
			b.setWrite_date(rs.getTimestamp(3));
			b.setContents(rs.getString(4));
			lb.add(b);
		}
		
		return lb;
	}
	
	@Override
	public List<Board> selectDesc() throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("SELECT * FROM notice ORDER BY write_num DESC");
		pstmt = CONN.prepareStatement(sql);
		rs = pstmt.executeQuery();		
		lb = new ArrayList<Board>();
		
		while(rs.next()) {
			b = new Board();
			b.setWrite_num(rs.getInt(1));
			b.setSubject(rs.getString(2));
			b.setWrite_date(rs.getTimestamp(3));
			b.setContents(rs.getString(4));
			lb.add(b);
		}
		
		return lb;
	}

	@Override
	public Board selectOne(Board b) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("SELECT * FROM notice "
				+ "WHERE `write_num` = %d",
				b.getWrite_num());
		pstmt = CONN.prepareStatement(sql);
		rs = pstmt.executeQuery();
		b = new Board();
		
		while(rs.next()) {
			b.setWrite_num(rs.getInt(1));
			b.setSubject(rs.getString(2));
			b.setWrite_date(rs.getTimestamp(3));
			b.setContents(rs.getString(4));
		}
		
		return b;
	}

	@Override
	public Board update(Board b) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("UPDATE notice SET "
				+ "`subject` = '%s', "
				+ "`contents` = '%s' "
				+ "WHERE `write_num` = %d",
				b.getSubject(),
				b.getContents(),
				b.getWrite_num());
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
		b = selectOne(b);
		
		return b;
	}

	@Override
	public void delete(Board b) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("DELETE FROM notice "
				+ "WHERE `write_num` = %d",
				b.getWrite_num());
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
	}

}
