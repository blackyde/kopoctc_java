package com.javachobo.jbp;

import java.sql.*;

/**
 * @FileName : DeleteTable.java
 * @Project : 0531
 * @Date : 2019. 5. 31.
 * @Author : JBP
 * @Descript : Delete from Table
 */
public class DeleteTable {

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
		
		String sql = "delete from examtable";
		//테이블안의 데이터 삭제
		stmt.execute(sql); //실행
		stmt.close();
		conn.close();
	}

}
