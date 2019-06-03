package com.javachobo.jbp;

import java.sql.*;

/**
 * @FileName : SelectTable.java
 * @Project : 0531
 * @Date : 2019. 5. 31.
 * @Author : JBP
 * @Descript : 테이블 조회  select
 */
public class SelectTable {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		//java.lang.Class.forName(String className) throws ClassNotFoundException
		//com.mysql.cj.jdbc.Driver 구버전에서 쓰던 com.mysql.jdbc.Driver 는 더이상 사용하지 않는다.
		String userName = "root";
		String passWord = "dptmzbdpf";
		String ipAddress = "127.0.0.1";
		String dbName = "kopo08";
		Connection conn = DriverManager.getConnection("jdbc:mysql://"
							+ ipAddress + "/" + dbName, userName, passWord);		
		//지정한 DBMS 와 커넥션(세션)을 생성
		Statement stmt = conn.createStatement();
		//sql 실행과 결과값 리턴을 위한 객체
		String sql = "select * from examtable";
		//테이블 조회 sql
		ResultSet rset = stmt.executeQuery(sql); //실행
		
		while(rset.next()) {
			System.out.printf("%4s  %6d  %3d  %3d  %3d\n",
					rset.getString(1), rset.getInt(2), rset.getInt(3),
					rset.getInt(4), rset.getInt(5));
		}
		
		rset.close();
		stmt.close();
		conn.close();
	}

}
