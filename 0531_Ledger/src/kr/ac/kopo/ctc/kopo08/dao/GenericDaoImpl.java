package kr.ac.kopo.ctc.kopo08.dao;

import java.sql.*;
import java.util.*;

import kr.ac.kopo.ctc.kopo08.conn.Conn;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
	
	public T create(T t) {

		PreparedStatement pstmt = null;
		Connection conn = Conn.getConnection();
		
		try {
			create_overriding(conn, pstmt, t);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("created");
		return null;
	}

	public T selectOne(T t) {
		
		PreparedStatement pstmt = null;
		Connection conn = Conn.getConnection();
		ResultSet rset = null;
		
		try {
			selectOne_overriding(conn, pstmt, rset, t);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<T> selectAll() {
		
		PreparedStatement pstmt = null;
		Connection conn = Conn.getConnection();
		ResultSet rset = null;
		List<T> list = new ArrayList<T>();
		
		try {
			selectAll_overriding(conn, pstmt, rset, list);
			conn.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return list;
	}

	public T update(T t) {
		
		PreparedStatement pstmt = null;
		Connection conn = Conn.getConnection();
		
		try {
			update_overriding(conn, pstmt, t);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public T deleteOne(T t) {
		
		PreparedStatement pstmt = null;
		Connection conn = Conn.getConnection();
		
		try {
			deleteOne_overriding(conn, pstmt, t);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public T deleteAll() {
		
		PreparedStatement pstmt = null;
		Connection conn = Conn.getConnection();
		
		try {
			deleteAll_overriding(conn, pstmt);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
