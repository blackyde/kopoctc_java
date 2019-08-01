package com.book.dao;

import java.sql.*;
import java.util.List;

public interface GenericDao<B> {
	//C
	B insert(B b);
	B insert_override(B b) throws SQLException;
	
	//R
	List<B> select();
	List<B> select_override() throws SQLException;
	B selectOne(B b);
	B selectOne_override(B b) throws SQLException;
	
	//U
	B update(B b);
	B update_override(B b) throws SQLException;
	
	//D
	void delete(B b);
	void delete_override(B b) throws SQLException;
}
