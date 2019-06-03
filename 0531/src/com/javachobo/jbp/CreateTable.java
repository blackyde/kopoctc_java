package com.javachobo.jbp;

import java.sql.*;

/**
 * @FileName : CreateTable.java
 * @Project : 0531
 * @Date : 2019. 5. 31.
 * @Author : JBP
 * @Descript : 테이블 만들기
 */
public class CreateTable {

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
		
		String sql = "create table examtable("
				+ "name varchar(20),"
				+ "studentid int primary key,"
				+ "kor int,"
				+ "eng int,"
				+ "mat int)";
		//테이블 생성 sql
		stmt.execute(sql); //실행
		stmt.close();
		conn.close();
	}

}