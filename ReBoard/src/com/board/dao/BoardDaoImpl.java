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
		String sql = String.format("INSERT INTO board (`subject`,"
				+ "`contents`, `relevel`, `recnt`) VALUES ("
				+ "'%s', '%s', %d, %d)",
				b.getSubject(),
				b.getContents(), 0, 0);
		if(b.getFile().size() > 0) {
			String file = b.getFile().get(0);
			for(int i = 1; i < b.getFile().size(); i++) {
				file += "," + b.getFile().get(i);
			}
			sql = String.format("INSERT INTO board (`subject`,"
					+ "`contents`, `relevel`, `recnt`, `file`) VALUES ("
					+ "'%s', '%s', %d, %d, '%s')",
					b.getSubject(),
					b.getContents(), 0, 0, file);
		}
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
		
		sql = String.format("UPDATE board SET `rootid` = `write_num` WHERE `relevel` = 0");
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
		
		
		
		b = selectOne(b);
		return b;
	}
	
	@Override
	public Board reInsert(Board b) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("INSERT INTO board (`subject`,"
				+ "`contents`, `rootid`, `relevel`, `recnt`) VALUES ("
				+ "'%s', '%s', %d, %d, %d)",
				b.getSubject(),
				b.getContents(),
				b.getRootid(),
				b.getRelevel(),
				b.getRecnt());
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
		
		b = selectOne(b);
		return b;
	}

	@Override
	public List<Board> select() throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("SELECT * FROM board "
				+ "ORDER BY write_num DESC");
		pstmt = CONN.prepareStatement(sql);
		rs = pstmt.executeQuery();		
		lb = new ArrayList<Board>();
		
		while(rs.next()) {
			b = new Board();
			b.setWrite_num(rs.getInt(1));
			b.setSubject(rs.getString(2));
			b.setWrite_date(rs.getTimestamp(3));
			b.setContents(rs.getString(4));
			b.setRootid(rs.getInt(5));
			b.setRelevel(rs.getInt(6));
			b.setRecnt(rs.getInt(7));
			b.setViewcnt(rs.getInt(8));
			lb.add(b);
		}
		
		return lb;
	}
	
	@Override
	public List<Board> selectDesc() throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("SELECT * FROM board"
				+ " ORDER BY rootid DESC, "
				+ "recnt ASC, "
				+ "relevel ASC, "
				+ "write_num DESC");
		pstmt = CONN.prepareStatement(sql);
		rs = pstmt.executeQuery();		
		lb = new ArrayList<Board>();
		
		while(rs.next()) {
			b = new Board();
			b.setWrite_num(rs.getInt(1));
			b.setSubject(rs.getString(2));
			b.setWrite_date(rs.getTimestamp(3));
			b.setContents(rs.getString(4));
			b.setRootid(rs.getInt(5));
			b.setRelevel(rs.getInt(6));
			b.setRecnt(rs.getInt(7));
			b.setViewcnt(rs.getInt(8));
			lb.add(b);
		}
		
		return lb;
	}

	@Override
	public Board selectOne(Board b) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("SELECT * FROM board "
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
			b.setRootid(rs.getInt(5));
			b.setRelevel(rs.getInt(6));
			b.setRecnt(rs.getInt(7));
			b.setViewcnt(rs.getInt(8));
		}
		
		return b;
	}

	@Override
	public Board update(Board b) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("UPDATE board SET "
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
		String sql = String.format("DELETE FROM board "
				+ "WHERE `write_num` = %d",
				b.getWrite_num());
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
	}
	
	@Override
	public Board viewCnt(Board b) throws SQLException {
		String sql = String.format("UPDATE board SET "
				+ "`viewcnt` = `viewcnt` + 1 "
				+ "WHERE `write_num` = %d",
				b.getWrite_num());
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
		b = selectOne(b);
		
		return b;		
	}
	
	@Override
	public Board reCnt(Board b) throws SQLException {
		String sql = String.format("UPDATE board SET "
				+ "`recnt` = `recnt` + 1 "
				+ "WHERE `rootid` = %d "
				+ "AND "
				+ "`relevel` != 0 "
				+ "AND "
				+ "`recnt` >= %d",
				b.getRootid(),
				b.getRecnt());
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
		b = selectOne(b);
		
		return b;		
	}

}
