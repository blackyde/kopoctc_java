package com.book.dao;

import java.sql.*;
import java.util.List;
import com.board.connector.*;

public abstract class GenericDaoImpl<B> implements GenericDao<B> {
	
	public static final Connection CONN = Connector.getConnection();
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	public B ret;
	public List<B> list;
	
	public B insert(B b) {

		try {
			ret = insert_override(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
		
	}
	
	public List<B> select(Timestamp today) {

		try {
			list = select_override(today);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public B selectOne(B b) {

		try {
			ret = selectOne_override(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
		
	}
	
	public B update(B b) {

		try {
			ret = update_override(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
		
	}
	
	public void delete(B b) {

		try {
			delete_override(b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
