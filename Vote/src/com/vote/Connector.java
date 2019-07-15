package com.vote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 로드 실패");
		}
		final String USERNAME = "root";
		final String PASSWORD = "dptmzbdpf";
		final String ADDRESS = "localhost";
		final String DB_NAME = "kopo08";
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://" + ADDRESS + "/" + DB_NAME, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		}
		return conn;
	}
}
