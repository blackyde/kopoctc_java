package com.javachobo.jbp;

import java.sql.*;
import java.util.Scanner;

public class Conn {
	public static void main(String[] args) throws Exception {
        
		String name;
		int studentid;
		int kor;
		int eng;
		int mat;
		
		Scanner in = new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String userName = "root";
		String passWord = "dptmzbdpf";
		String ipAddress = "127.0.0.1";
		String dbName = "kopo08";
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + ipAddress + "/" + dbName, userName, passWord);
		PreparedStatement pstmt = null;
		
		while(true) {
		
			System.out.print("이름(종료는 end) : ");
			name = in.nextLine();
			if(name.contentEquals("end")) {
				break;
			}
			System.out.print("학번 : ");
			studentid = in.nextInt();
			System.out.print("국어 : ");
			kor = in.nextInt();
			System.out.print("영어 : ");
			eng = in.nextInt();
			System.out.print("수학 : ");
			mat = in.nextInt();
			in.nextLine();
			
			pstmt = conn.prepareStatement(
					"INSERT INTO `examtable`"
					+ " (`name`, `studentid`, `kor`, `eng`, `mat`) VALUES (?, ?, ?, ?, ?)");
			pstmt.setString(1, name);
			pstmt.setInt(2, studentid);
			pstmt.setInt(3, kor);
			pstmt.setInt(4, eng);
			pstmt.setInt(5, mat);
			pstmt.executeUpdate();
			
		}
	
		System.out.println("=======================================================");
	
		pstmt = conn.prepareStatement(
				"SELECT name AS '이름',"
				+ " studentid AS '학번',"
				+ " kor AS '국어',"
				+ " eng AS '영어',"
				+ " mat AS '수학'"
				+ " FROM `examtable`");
		ResultSet rset = pstmt.executeQuery();
		
		ResultSetMetaData rsmd = rset.getMetaData();
		
		System.out.printf("%-17s%s%10s%8s%8s\n",
				rsmd.getColumnLabel(1),
				rsmd.getColumnLabel(2),
				rsmd.getColumnLabel(3),
				rsmd.getColumnLabel(4),
				rsmd.getColumnLabel(5));
		
		System.out.println("=======================================================");
		
		while(rset.next()) {
			System.out.printf("%-17s%6s%10s%10s%10s\n",
					rset.getString(1),
					rset.getInt(2),
					rset.getInt(3),
					rset.getInt(4),
					rset.getInt(5));
		}
		
		System.out.println("=======================================================");
		
//		pstmt = conn.prepareStatement(
//				"SELECT SUM(kor) AS '국어합계',"
//				+ " SUM(eng) AS '영어합계',"
//				+ " SUM(mat) AS '수학합계',"
//				+ " AVG(kor) AS '국어평균',"
//				+ " AVG(eng) AS '영어평균',"
//				+ " AVG(mat) AS '수학평균'"
//				+ " FROM `examtable`");
//		rset = pstmt.executeQuery();
//		
//		rsmd = rset.getMetaData();
//		
//		System.out.printf("%s%12s%12s%12s%10s%10s\n",
//				rsmd.getColumnLabel(1),
//				rsmd.getColumnLabel(2),
//				rsmd.getColumnLabel(3),
//				rsmd.getColumnLabel(4),
//				rsmd.getColumnLabel(5),
//				rsmd.getColumnLabel(6));
//		
//		while(rset.next()) {
//			System.out.printf("%s%12s%12s%12.2f%10.2f%10.2f\n",
//					rset.getInt(1),
//					rset.getInt(2),
//					rset.getInt(3),
//					rset.getFloat(4),
//					rset.getFloat(5),
//					rset.getFloat(6));
//		}
//		
//		System.out.println("=======================================================");
		
		rset.close();
		conn.close();
		in.close();
		
    }
}
