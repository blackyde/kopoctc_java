package kr.ac.kopo.ctc.kopo08.dao;

import java.sql.*;
import java.util.List;

public interface GenericDao<T> {
	//C
	T create(T t);
	T create_overriding(Connection conn, PreparedStatement pstmt, T t) throws SQLException;
	
	//R
	T selectOne(T t);
	T selectOne_overriding(Connection conn, PreparedStatement pstmt, ResultSet rset, T t) throws SQLException;
	List<T> selectAll();
	List<T> selectAll_overriding(Connection conn, PreparedStatement pstmt, ResultSet rset, List<T> list) throws SQLException;
		
	//U
	T update(T t);
	T update_overriding(Connection conn, PreparedStatement pstmt, T t) throws SQLException;
	
	//D
	T deleteOne(T t);
	T deleteOne_overriding(Connection conn, PreparedStatement pstmt, T t) throws SQLException;
	T deleteAll();
	T deleteAll_overriding(Connection conn, PreparedStatement pstmt) throws SQLException;
}
