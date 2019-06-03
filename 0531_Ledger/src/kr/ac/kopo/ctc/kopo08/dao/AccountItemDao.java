package kr.ac.kopo.ctc.kopo08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import kr.ac.kopo.ctc.kopo08.domain.AccountItem;

public interface AccountItemDao extends GenericDao<AccountItem> {
	List<AccountItem> selectContainsTitle(String title);
	List<AccountItem> selectContainsTitle_overriding(Connection conn, PreparedStatement pstmt, ResultSet rset, List<AccountItem> list, AccountItem aItem, String title) throws SQLException;
}
