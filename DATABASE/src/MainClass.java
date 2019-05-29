import java.sql.*;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws Exception {
		
		String number;
		String name;
		String birth;
		String address;
		
		Scanner in = new Scanner(System.in);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String userName = "tester";
		String passWord = "123456";
		String ipAddress = "192.168.23.99";
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + ipAddress + "/student?characterEncoding=UTF-8&serverTimezone=UTC", userName, passWord);
		
		Statement stmt = conn.createStatement();
		PreparedStatement pstmt = null;
		
		System.out.print("학번 : ");
		number = in.nextLine();
		System.out.print("이름 : ");
		name = in.nextLine();
		System.out.print("생일 : ");
		birth = in.nextLine();
		System.out.print("주소 : ");
		address = in.nextLine();
		
		pstmt = conn.prepareStatement("INSERT INTO `student_table` (`number`, `name`, `birth`, `address`) VALUES (?, ?, ?, ?)");
		pstmt.setString(1, number);
		pstmt.setString(2, name);
		pstmt.setString(3, birth);
		pstmt.setString(4, address);
		pstmt.executeUpdate();
		
		ResultSet rset = stmt.executeQuery("select * from student_table");
		while(rset.next()) {
			System.out.println(rset.getInt(1) + ", " +
								rset.getString(2) + ", " +
								rset.getInt(3) + ", " +
								rset.getString(4));
		}
		
		rset.close();
		stmt.close();
		conn.close();
		in.close();
		

	}

}
