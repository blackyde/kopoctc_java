import java.sql.*;
import java.util.*;

public class StudentGrade2 {

	public static void main(String[] args) throws Exception {
		
		String name;
		String english;
		String math;
		
		List<StudentArray> sArr = new ArrayList<StudentArray>();
		
		int sumEng = 0;
		int sumMath = 0;
		int count = 0;
		
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
		pstmt = conn.prepareStatement("SELECT * FROM `student_grade`");
		ResultSet rset = pstmt.executeQuery();
		System.out.printf("%-27s%12s%16s%17s%16s\n",
				"이름",
				"영어",
				"수학",
				"총점",
				"평균");
		
		System.out.println("=====================================================");
		while(rset.next()) {
			System.out.printf("%-17s%6s%10s",
					rset.getString(1),
					rset.getInt(2),
					rset.getInt(3));
					StudentArray sa = new StudentArray();
					sa.setSum(rset.getInt(2) + rset.getInt(3));
					sa.setAvg(sa.getSum() / 2);
					sArr.add(sa);
			System.out.printf("%10s%10s\n", sa.getSum(), sa.getAvg());
					sumEng += rset.getInt(2);
					sumMath += rset.getInt(3);
					count++;
		}
		
		System.out.println("=====================================================");
		
		System.out.println("영어 평균 : " + (sumEng / count));
		System.out.println("수학 평균 : " + (sumMath / count));
		
		rset.close();
		conn.close();
		in.close();
		

	}

}
