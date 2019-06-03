package com.javachobo.jbp;

import java.io.*;
import java.sql.*;

/**
 * @FileName : InsertWifi.java
 * @Project : 0531
 * @Date : 2019. 5. 31.
 * @Author : JBP
 * @Descript : freewifi 테이블에 데이터 삽입
 */
public class InsertWifi {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		
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
		
		File f = new File("c:\\Study\\File\\전국무료와이파이표준데이터.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;
		if((readtxt = br.readLine()) == null) {
		//한줄을 미리 실행시키면서 null 인지 비교한다.
		//처음 제목행이 readtxt 에 담긴다.
			System.out.println("빈 파일입니다.");
			return;
		}
		@SuppressWarnings("unused")
		String[] field_name = readtxt.split("\t");
		//탭키를 기준으로 구분.. 제목행은 넣을 일이 없다. 테이블 만들때 넣어야지...
		
		int lineCnt = 1; //몇행이 들어갔나 체크해보자
		while((readtxt = br.readLine()) != null) {
		//한줄씩 읽어가며 null 이 아닌동안 루프
			String[] field = readtxt.split("\t");
			String sql;
			
			sql = String.format("insert into freewifi("
					+ "inst_place, inst_place_detail, inst_city, "
					+ "inst_country, inst_place_flag, service_provider, "
					+ "wifi_ssid, inst_date, place_addr_road, "
					+ "place_addr_land, manage_office, manage_office_phone, "
					+ "latitude, longitude, write_date) values ("
					+ "'%s', '%s', '%s', '%s', '%s', "
					+ "'%s', '%s', '%s', '%s', '%s', "
					+ "'%s', '%s', %s, %s, '%s')",
					field[0], field[1], field[2], field[3], field[4],
					field[5], field[6], 
					field[7].trim().length() == 0 ? "1900-01-01" : field[7], field[8], field[9],
					field[10], field[11], field[12], field[13], field[14]);
			
			try {
				stmt.execute(sql);
			} catch(SQLIntegrityConstraintViolationException duplicate) {
				continue;
			}
			
			
			System.out.printf("%d번째 항목 Insert OK []\n", lineCnt);
			lineCnt++;
		}
		
		br.close();		
		stmt.close();
		conn.close();
	}

}
