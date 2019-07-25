package com.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.board.dto.Board;

public interface BoardDao<B> {
	
	//C
	B insert(B b) throws SQLException;
	B reInsert(B b) throws SQLException;
	
	//R
	List<B> select() throws SQLException;
	List<Board> selectList(int start, int total) throws SQLException;
	B selectOne(B b) throws SQLException;
	
	//U
	B update(B b) throws SQLException;
	B viewCnt(B b) throws SQLException;
	B reCnt(B b) throws SQLException;
	
	//D
	void delete(B b) throws SQLException;

	
}
