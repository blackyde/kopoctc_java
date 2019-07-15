package com.twice.dao;

import java.sql.SQLException;
import java.util.List;

public interface TwiceDao<T> {
	
	//C
	T insert(T t) throws SQLException;
	
	//R
	List<T> select() throws SQLException;
	T selectOne(T t) throws SQLException;
	
	//U
	T update(T t) throws SQLException;
	
	//D
	void delete(T t) throws SQLException;
	
}
