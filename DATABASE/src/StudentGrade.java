import java.sql.*;
import java.util.Scanner;

public class StudentGrade {

	public static void main(String[] args) throws Exception {
		
		String name;
		String english;
		String math;
		
		Scanner in = new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String userName = "tester";
		String passWord = "123456";
		String ipAddress = "192.168.23.99";
		Connection conn = null;
		conn = DriverManager.getConnection(
				"jdbc:mysql://" + ipAddress +
				"/student?characterEncoding=UTF-8&serverTimezone=UTC",
				userName, passWord);
		
		PreparedStatement pstmt = null;
		
		
		while(true) {
			
			System.out.print("이름(종료는 end) : ");
			name = in.nextLine();
			if(name.contentEquals("end")) {
				break;
			}
			System.out.print("영어 : ");
			english = in.nextLine();
			System.out.print("수학 : ");
			math = in.nextLine();
			
			pstmt = conn.prepareStatement(
					"INSERT INTO `student_grade`"
					+ " (`name`, `english`, `math`) VALUES (?, ?, ?)");
			pstmt.setString(1, name);
			pstmt.setString(2, english);
			pstmt.setString(3, math);
			pstmt.executeUpdate();
			
		}
		
		System.out.println("=====================================================");
		
		pstmt = conn.prepareStatement(
				"SELECT name AS 'NAME', english AS 'ENG',"
				+ " math AS 'MAT',"
				+ " english + math AS 'SUM',"
				+ " (english + math) / 2 AS 'AVG'"
				+ " FROM `student_grade`");
		ResultSet rset = pstmt.executeQuery();
		
		ResultSetMetaData rsmd = rset.getMetaData();
		
		System.out.printf("%-17s%6s%10s%10s%10s\n",
				rsmd.getColumnLabel(1),
				rsmd.getColumnLabel(2),
				rsmd.getColumnLabel(3),
				rsmd.getColumnLabel(4),
				rsmd.getColumnLabel(5));
		
		System.out.println("=====================================================");
		
		while(rset.next()) {
			System.out.printf("%-17s%6s%10s%10s%10s\n",
					rset.getString(1),
					rset.getInt(2),
					rset.getInt(3),
					rset.getInt(4),
					rset.getInt(5));
		}
		
		System.out.println("=====================================================");
		
		pstmt = conn.prepareStatement(
				"SELECT SUM(english) AS 'SUM_ENG',"
				+ " SUM(math) AS 'SUM_MAT',"
				+ " AVG(english) AS 'AVG_ENG',"
				+ " AVG(math) AS 'AVG_MAT'"
				+ " FROM `student_grade`");
		rset = pstmt.executeQuery();
		
		rsmd = rset.getMetaData();
		
		System.out.printf("%17s%12s%12s%12s\n",
				rsmd.getColumnLabel(1),
				rsmd.getColumnLabel(2),
				rsmd.getColumnLabel(3),
				rsmd.getColumnLabel(4));
		
		while(rset.next()) {
			System.out.printf("%17s%12s%12s%12s\n",
					rset.getInt(1),
					rset.getInt(2),
					rset.getInt(3),
					rset.getInt(4));
		}
		
		System.out.println("=====================================================");
		
		rset.close();
		conn.close();
		in.close();
		
	}

}
