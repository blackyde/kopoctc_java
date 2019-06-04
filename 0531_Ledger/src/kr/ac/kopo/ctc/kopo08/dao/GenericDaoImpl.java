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

enum Cat {
	 
    FOOD("식비"),
    HOME("주거/통신"),
    LIVING("생활용품"),
    CLOTH("의복/미용"),
    CULTURE("건강/문화"),
    EDUCATION("교육/육아"),
    TRAFFIC("교통/차량"),
    DUES("경조사/회비"),
    TAX("세금/이자"),
    ETC("용돈/기타"),
    CREDIT("카드대금"),
    SAVE("저축/보험"),
    WIRE("이체/대체");
     
    final private String name;
     
    public String getName() {
        return name;
    }
 
    private Cat(String name){
        this.name = name;
    }
}