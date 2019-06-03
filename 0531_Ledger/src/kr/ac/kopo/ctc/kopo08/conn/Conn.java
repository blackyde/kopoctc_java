package kr.ac.kopo.ctc.kopo08.conn;

import java.sql.*;

public class Conn {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		final String USERNAME = "root";
		final String PASSWORD = "dptmzbdpf";
		final String ADDRESS = "127.0.0.1";
		final String DB_NAME = "kopo08_ledger";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://" + ADDRESS + "/" + DB_NAME, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
