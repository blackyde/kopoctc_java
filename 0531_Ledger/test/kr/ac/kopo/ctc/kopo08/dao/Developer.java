package kr.ac.kopo.ctc.kopo08.dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import kr.ac.kopo.ctc.kopo08.conn.Conn;
import kr.ac.kopo.ctc.kopo08.domain.AccountItem;

public class Developer {
    
    public String name;
    public int career;
     
    public static void main(String[] args){
     
//        for(Category type : Category.values()){
//            System.out.println(type.name() + " " + type.getName());
//        }
    	
    	List<String> list = new ArrayList<String>();
//    	List<String> list2 = new ArrayList<String>();
    	list.add("id");
    	list.add("1");
    	
    	
    			
    	
//    	Connection conn = Conn.getConnection();
//    	try {
//    		String sql = "SELECT * FROM test where id = ?";
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, list.get(1));
//			ResultSet rset = pstmt.executeQuery();
//			
//			while(rset.next()) {
//				System.out.printf("%d %s %s", rset.getInt(1), rset.getString(2), rset.getString(3));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
		AccountItemDao dao = new AccountItemDaoImpl();
		List<String> filter = new ArrayList<String>();
		filter.add("id");
		filter.add("1");
		filter.add("3");
		//String sql = "SELECT * FROM AccountItem WHERE " + filter.get(0) + " BETWEEN ? AND ?";
		List<AccountItem> alist = dao.selectContainsTitle(filter);
		
		for(AccountItem aItem : alist) {
			System.out.println(aItem.getId() + " " + aItem.getTitle());
		}
    	
    }
 
}
 
