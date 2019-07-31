package com.book.dto;

import java.sql.*;
import java.util.*;

import com.board.connector.Connector;

public class Tester {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Connection CONN = Connector.getConnection();
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String month = cal.get(Calendar.YEAR) + String.format("%02d", cal.get(Calendar.MONTH) + 1);
		String day = String.format("%02d", cal.get(Calendar.DATE));
		String sql = String.format("SELECT cal.dt, DAYOFWEEK(cal.dt) AS 'dow', " + 
				"IFNULL((SELECT `name` FROM book WHERE room = 1 AND resv_date = cal.dt), '예약 가능') AS 'room1', " + 
				"IFNULL((SELECT `name` FROM book WHERE room = 2 AND resv_date = cal.dt), '예약 가능') AS 'room2', " + 
				"IFNULL((SELECT `name` FROM book WHERE room = 3 AND resv_date = cal.dt), '예약 가능') AS 'room3' " + 
				"FROM (" + 
				"	SELECT dt + INTERVAL lv-1 DAY dt" + 
				"	FROM (SELECT ordinal_position lv, CONCAT('%s', '%s') dt" + 
				"			FROM information_schema.columns" + 
				"			WHERE table_schema = 'mysql'" + 
				"				AND table_name = 'user'" + 
				"	        ) AS dt_table" + 
				"	WHERE lv <= DAY(LAST_DAY(dt))	) cal", month, day);
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		System.out.println("준비");
		try {
			pstmt = CONN.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("커넥션?");
			e.printStackTrace();
		}
		System.out.println("준비완료");
		List<OneShot> list = new ArrayList<OneShot>();
		
		if(rs != null) {
			try {
				while(rs.next()) {
					OneShot os = new OneShot(rs.getString("dt"), rs.getInt("dow"),
							rs.getString("room1"), rs.getString("room2"), rs.getString("room3"));
					list.add(os);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("리절트?");
				e.printStackTrace();
			}
		}
		System.out.println("리스트 준비?");
		if(list.size() == 0) {
			System.out.println("리스트 = 0");
		}
		for(OneShot os : list) {
			System.out.println(os.getDays());
		}
	}

}
