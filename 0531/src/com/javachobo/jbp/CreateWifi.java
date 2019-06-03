package com.javachobo.jbp;

import java.sql.*;


/**
 * @FileName : CreateWifi.java
 * @Project : 0531
 * @Date : 2019. 5. 31.
 * @Author : JBP
 * @Descript : wifi 테이블 만들기
 */
public class CreateWifi {

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
		
		String sql = "create table freewifi("	//freewifi 테이블 생성
				+ "inst_place	varchar(50),"	//설치장소명
				+ "inst_place_detail	varchar(200),"	//설치장소상세
				+ "inst_city	varchar(50),"	//설치시도명
				+ "inst_country	varchar(50),"	//설치시군구명
				+ "inst_place_flag	varchar(50),"	//설치시설구분
				+ "service_provider	varchar(50),"	//서비스제공사명
				+ "wifi_ssid	varchar(100),"	//와이파이ssid
				+ "inst_date	date,"	//설치년월 -> 정제
				+ "place_addr_road	varchar(200),"	//소재지도로명주소
				+ "place_addr_land	varchar(200),"	//소재지지번주소
				+ "manage_office	varchar(50),"	//관리기관명
				+ "manage_office_phone	varchar(50),"	//관리기관전화번호
				+ "latitude	double,"	//위도
				+ "longitude double,"	//경도
				+ "write_date	date)";	//데이터기준일자
		//테이블 생성 sql
		stmt.execute(sql); //실행
		sql ="alter table freewifi add constraint freewifi_pk primary key ("
				+ "inst_place, inst_place_detail, inst_city, place_addr_land, "
				+ "manage_office_phone, service_provider)";
		stmt.execute(sql);
		stmt.close();
		conn.close();
	}

}
