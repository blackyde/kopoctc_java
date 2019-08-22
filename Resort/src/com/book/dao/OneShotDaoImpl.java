package com.book.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.book.dto.OneShot;

public class OneShotDaoImpl extends GenericDaoImpl<OneShot> implements OneShotDao {
	
	public List<OneShot> selectOneShot() {
		
		try {
			list = selectOneShot_override();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public OneShot insert_override(OneShot b) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OneShot> select_override() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OneShot selectOne_override(OneShot b) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OneShot> selectOneShot_override() throws SQLException {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String month = cal.get(Calendar.YEAR) + 
				String.format("%02d", cal.get(Calendar.MONTH) + 1);
		String day = String.format("%02d", cal.get(Calendar.DATE));
		String sql = String.format("SELECT cal.dt, DAYOFWEEK(cal.dt) AS 'dow', " + 
				"IFNULL((SELECT `name` FROM book WHERE room = 1" + 
				" AND resv_date = cal.dt), '예약 가능') AS 'room1', " + 
				"IFNULL((SELECT `name` FROM book WHERE room = 2" + 
				" AND resv_date = cal.dt), '예약 가능') AS 'room2', " + 
				"IFNULL((SELECT `name` FROM book WHERE room = 3" + 
				" AND resv_date = cal.dt), '예약 가능') AS 'room3' " + 
				"FROM (" + 
				"	SELECT dt + INTERVAL lv-1 DAY dt" + 
				"	FROM (SELECT ordinal_position lv, CONCAT('%s', '%s') dt" + 
				"			FROM information_schema.columns" + 
				"			WHERE table_schema = 'mysql'" + 
				"				AND table_name = 'user'" + 
				"	        ) AS dt_table" + 
				"	WHERE lv <= DAY(LAST_DAY(dt))	) cal", month, day);
		rs = exQuery(sql);
		list = new ArrayList<OneShot>();
		if(rs != null) {
			while(rs.next()) {
				OneShot os = new OneShot(rs.getString("dt"), rs.getInt("dow"),
						rs.getString("room1"), rs.getString("room2"), rs.getString("room3"));
				list.add(os);
			}
		}
		return list;
	}

	@Override
	public OneShot update_override(OneShot b) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete_override(OneShot b) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	public void exUpdate(String sql) throws SQLException {
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
	}
	
	public ResultSet exQuery(String sql) throws SQLException {
		pstmt = CONN.prepareStatement(sql);
		rs = pstmt.executeQuery();
		return rs;
	}

}
