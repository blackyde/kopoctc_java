package com.book.dao;

import java.sql.SQLException;
import java.util.List;

import com.book.dto.Book;

public interface BookDao extends GenericDao<Book>{
	public List<Book> selectPage(int from, int row) throws SQLException;
}
