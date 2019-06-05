package kr.ac.kopo.ctc.kopo08.dao;

import java.sql.*;
import java.util.List;

public interface GenericDao<T> {
	//C
	T create(T t);
	T create_overriding(T t) throws SQLException;
	
	//R
	T selectOne(int id);
	T selectOne_overriding(int id) throws SQLException;
	List<T> selectAll();
	List<T> selectAll_overriding(List<T> list) throws SQLException;
		
	//U
	T update(T t);
	T update_overriding(T t) throws SQLException;
	
	//D
	T deleteOne(T t);
	T deleteOne_overriding(T t) throws SQLException;
	T deleteAll();
	T deleteAll_overriding() throws SQLException;
}
