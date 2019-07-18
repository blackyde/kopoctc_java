package com.twice.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.twice.dto.Twice;
import com.twice.conn.Connector;

public class TwiceDaoImpl implements TwiceDao<Twice> {
	
	public static final Connection CONN = Connector.getConnection();
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	public Twice t;
	public List<Twice> once;

	@Override
	public Twice insert(Twice t) {
		// TODO Auto-generated method stub
		try {
			t = insert_override(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			t = null;
			e.printStackTrace();
		}
		return t;
	}
	
	@Override
	public Twice insert_override(Twice t) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("INSERT INTO twicecompany ("
				+ "`goods_name`, `stock`, `describe`, `image`) VALUES ("
				+ "%d, '%s', %d, '%s', '%s')",
				t.getGoods_name(),
				t.getStock(),
				t.getDescribe(),
				t.getImage());
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
		
		t = selectOne(t);
		return t;
	}

	@Override
	public Twice selectOne(Twice t) {
		// TODO Auto-generated method stub
		try {
			t = selectOne_override(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			t = null;
			e.printStackTrace();
		}
		return t;
	}
	
	@Override
	public Twice selectOne_override(Twice t) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("SELECT * FROM twicecompany"
				+ " WHERE `goods_id` = %d",
				t.getGoods_id());
		pstmt = CONN.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		t = new Twice();
		
		while(rs.next()) {
			t.setGoods_id(rs.getInt(1));
			t.setGoods_name(rs.getString(2));
			t.setStock(rs.getInt(3));
			t.setU_date(rs.getTimestamp(4));
			t.setC_date(rs.getTimestamp(5));
			t.setDescribe(rs.getString(6));
			t.setImage(rs.getString(7));
		}
		
		return t;
	}

	@Override
	public List<Twice> select() {
		// TODO Auto-generated method stub
		try {
			once = select_override();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			once = null;
			e.printStackTrace();
		}
		return once;
	}
	
	@Override
	public List<Twice> select_override() throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("SELECT * FROM twicecompany");
		pstmt = CONN.prepareStatement(sql);
		rs = pstmt.executeQuery();
		once = new ArrayList<Twice>();
		
		while(rs.next()) {
			t = new Twice();
			t.setGoods_id(rs.getInt(1));
			t.setGoods_name(rs.getString(2));
			t.setStock(rs.getInt(3));
			t.setU_date(rs.getTimestamp(4));
			t.setC_date(rs.getTimestamp(5));
			t.setDescribe(rs.getString(6));
			t.setImage(rs.getString(7));
			once.add(t);
		}
		
		return once;
	}

	@Override
	public Twice update(Twice t) {
		// TODO Auto-generated method stub
		try {
			t = update_override(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			t = null;
			e.printStackTrace();
		}
		return t;
	}
	
	@Override
	public Twice update_override(Twice t) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("UPDATE twicecompany SET "
				+ "`goods_name` = '%s', "
				+ "`stock` = %d, "
				+ "`describe` = '%s', "
				+ "`image` = '%s' "
				+ "WHERE goods_id = %d",
				t.getGoods_name(),
				t.getStock(),
				t.getDescribe(),
				t.getImage(),
				t.getGoods_id());
		pstmt = CONN.prepareStatement(sql);
		pstmt.executeUpdate();
		
		t = selectOne(t);		
		return t;
	}

	@Override
	public int delete(Twice t) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = delete_override(t);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public int delete_override(Twice t) throws SQLException {
		// TODO Auto-generated method stub
		String sql = String.format("DELETE FROM twicecompany "
				+ "WHERE `goods_id` = %d",
				t.getGoods_id());
		pstmt = CONN.prepareStatement(sql);
		
		return pstmt.executeUpdate();
	}
	
}
