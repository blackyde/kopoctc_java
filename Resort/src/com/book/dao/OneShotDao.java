package com.book.dao;

import java.sql.SQLException;
import java.util.List;

import com.book.dto.OneShot;

public interface OneShotDao extends GenericDao<OneShot>{

	List<OneShot> selectOneShot();
	List<OneShot> selectOneShot_override() throws SQLException;
}
