package com.twice.dao;

import java.sql.SQLException;
import java.util.List;

public interface TwiceDao<T> {
	
	//C
	T insert(T t);
	T insert_override(T t) throws SQLException;
	
	//R
	List<T> select();
	List<T> select_override() throws SQLException;
	T selectOne(T t);
	T selectOne_override(T t) throws SQLException;
	
	//U
	T update(T t);
	T update_override(T t) throws SQLException;
	
	//D
	int delete(T t);
	int delete_override(T t) throws SQLException;
	
}
