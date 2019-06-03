package com.javachobo.jbp;

import java.sql.*;

/**
 * @FileName : InsertTable.java
 * @Project : 0531
 * @Date : 2019. 5. 31.
 * @Author : JBP
 * @Descript : 데이터 삽입(insert)
 */
public class InsertTable {

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
		
		//insert sql 실행
		stmt.execute("insert into examtable(name, studentid, kor, eng, mat)"
				+ " values('효민', 209901, 95, 100, 95);");
		stmt.execute("insert into examtable(name, studentid, kor, eng, mat)"
				+ " values('보람', 209902, 95, 95, 95);");
		stmt.execute("insert into examtable(name, studentid, kor, eng, mat)"
				+ " values('은정', 209903, 100, 100, 100);");
		stmt.execute("insert into examtable(name, studentid, kor, eng, mat)"
				+ " values('지연', 209904, 100, 95, 90);");
		stmt.execute("insert into examtable(name, studentid, kor, eng, mat)"
				+ " values('소연', 209905, 80, 100, 70);");
		stmt.execute("insert into examtable(name, studentid, kor, eng, mat)"
				+ " values('큐리', 209906, 100, 100, 70);");
		stmt.execute("insert into examtable(name, studentid, kor, eng, mat)"
				+ " values('화영', 209907, 70, 70, 70);");
		
		stmt.close();
		conn.close();
	}

}
