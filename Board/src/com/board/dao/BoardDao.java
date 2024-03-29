package com.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.board.dto.Board;

public interface BoardDao<B> {
	
	//C
	B insert(B b) throws SQLException;
	
	//R
	List<B> select() throws SQLException;
	List<Board> selectDesc() throws SQLException;
	B selectOne(B b) throws SQLException;
	
	//U
	B update(B b) throws SQLException;
	
	//D
	void delete(B b) throws SQLException;

}
