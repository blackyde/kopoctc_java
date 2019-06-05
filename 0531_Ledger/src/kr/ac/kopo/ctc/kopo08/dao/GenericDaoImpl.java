package kr.ac.kopo.ctc.kopo08.dao;

import java.sql.*;
import java.util.*;

import kr.ac.kopo.ctc.kopo08.conn.Conn;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
	
	public static final Connection CONN = Conn.getConnection();
	public static PreparedStatement pstmt = null;
	public static ResultSet rset = null;
	public static ResultSet rset2 = null;
	public T ret;
	public List<T> list;
	
	public T create(T t) {

		try {
			ret = create_overriding(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeAll();
		return ret;
		
	}

	public T selectOne(int id) {
		
		try {
			ret = selectOne_overriding(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeAll();
		return ret;
	}
	
	public List<T> selectAll() {
		
		try {
			list = selectAll_overriding(list);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		closeAll();
		return list;
	}

	public T update(T t) {
		
		try {
			ret = update_overriding(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeAll();
		return ret;
	}
	
	public T deleteOne(T t) {
		
		try {
			ret = deleteOne_overriding(t);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeAll();
		return ret;
	}
	
	public T deleteAll() {
		
		try {
			ret = deleteAll_overriding();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeAll();
		return ret;
	}
	
	public void closeAll() {
		try {
			if(rset2 != null) {
				rset2.close();
			}
			if(rset != null) {
				rset.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			CONN.close();
			System.out.println("CONN close 완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}