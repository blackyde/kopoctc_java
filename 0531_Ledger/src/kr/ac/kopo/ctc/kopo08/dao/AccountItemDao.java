package kr.ac.kopo.ctc.kopo08.dao;

import java.sql.SQLException;
import java.util.List;

import kr.ac.kopo.ctc.kopo08.domain.AccountItem;

public interface AccountItemDao extends GenericDao<AccountItem> {
	List<AccountItem> selectContainsTitle(List<String> filter);
	List<AccountItem> selectContainsTitle_overriding(List<AccountItem> list, AccountItem aItem, List<String> title) throws SQLException;
}
