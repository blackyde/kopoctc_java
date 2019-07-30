package com.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.book.dto.Book;

public class BookDaoImpl extends GenericDaoImpl<Book> implements BookDao {

	@Override
	public Book insert_override(Book b) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("INSERT INTO book (`name`, `resv_date`, `room`, "
				+ "`addr`, `telnum`, `in_name`, `comment`) VALUES ("
				+ "'%s', '%s', %d, '%s', '%s', '%s', '%s')", 
				b.getName(), b.getResv_date(), b.getRoom(), b.getAddr(), 
				b.getTelnum(), b.getIn_name(), b.getComment(), b.getProcessing());
		exUpdate(sql);		
		b = selectOne(b);
		return b;
	}
	
	@Override
	public List<Book> select_override(Timestamp today) throws SQLException {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		cal.add(Calendar.DATE, 30);
		String todayString = sdf.format(cal.getTime()) + " 00:00:00.0";
		Timestamp lastday = Timestamp.valueOf(todayString);
		String sql = String.format("SELECT `name`, `resv_date`, `room`, `addr`, "
				+ "`telnum`, `in_name`, `comment`, `write_date`, `processing` FROM "
				+ "book WHERE resv_date BETWEEN '%s' AND '%s'", today, lastday);
		rs = exQuery(sql);
		list = new ArrayList<Book>();
		if(rs != null) {
			while(rs.next()) {
				Book b = new Book();
				b.setName(rs.getString("name"));
				b.setResv_date(rs.getTimestamp("resv_date"));
				b.setRoom(rs.getInt("room"));
				b.setAddr(rs.getString("addr"));
				b.setTelnum(rs.getString("telnum"));
				b.setIn_name(rs.getString("in_name"));
				b.setComment(rs.getString("comment"));
				b.setWrite_date(rs.getTimestamp("write_date"));
				b.setProcessing(rs.getInt("processing"));
				list.add(b);
			}
		}
		return list;
	}

	@Override
	public Book selectOne_override(Book b) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("");
		rs = exQuery(sql);
		if(rs != null) {
			while(rs.next()) {
				
			}
		}		
		return b;
	}

	@Override
	public Book update_override(Book b) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("");
		exUpdate(sql);		
		b = selectOne(b);
		return b;
	}

	@Override
	public void delete_override(Book b) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("");
		exUpdate(sql);
	}
	
	public void exUpdate(String sql) throws SQLException {
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
	}
	
	public ResultSet exQuery(String sql) throws SQLException {
		pstmt = CONN.prepareStatement(sql);
		rs = pstmt.executeQuery();
		return rs;
	}

}
