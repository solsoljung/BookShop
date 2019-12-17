package com.sol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sol.vo.BuyVo;

public class BuyDao {

	private static BuyDao instance;

	public static BuyDao getInstance() {
		if(instance == null) {
			instance = new BuyDao();
		}
		return instance;
	}
	
	public Connection getConnection() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup("java:comp/env");
			// javax.sql.DataSource
			DataSource ds = (DataSource)envCtx.lookup("jdbc/basicjsp"); 
			Connection conn = ds.getConnection();
			return conn;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) try { rs.close(); } catch (Exception e) { }
		if (pstmt != null) try { pstmt.close(); } catch (Exception e) { }
		if (conn != null) try { conn.close(); } catch (Exception e) { }
	}
	
	public void addBuyList(List<BuyVo> list, String mem_id) {
		Connection conn = null;
		PreparedStatement pstmt0 = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt[] = new PreparedStatement[list.size()+2];
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			
			String sql3 = "select count(*) cnt from tbl_buy where mem_id = ?";
			pstmt0 = conn.prepareStatement(sql3);
			pstmt0.setString(1, mem_id);
			rs = pstmt0.executeQuery();
			int count = 0;
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
			if(count > 0) {
				String sql2 = "delete tbl_buy where mem_id = ?";
				pstmt1 = conn.prepareStatement(sql2);
				pstmt1.setString(1, mem_id);
				pstmt1.executeUpdate();
			}
			
			String sql = "insert into tbl_buy(buy_info_num, book_num, book_amount, mem_id) "
					+ "                values(seq_buy_num.nextval, ?, ?, ?)";
			for(int i=2;i<list.size()+2;i++) {
				pstmt[i] = conn.prepareStatement(sql);
				BuyVo vo = list.get(i-2);
				int j = 0;
				pstmt[i].setInt(++j, vo.getBook_num());
				pstmt[i].setInt(++j, vo.getBook_amount());
				pstmt[i].setString(++j, vo.getMem_id());
				pstmt[i].executeUpdate();
			}
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0;i<list.size()+2;i++) {
				closeAll(null, pstmt[i], null);
			}
			closeAll(conn, null, rs);
		}
	}
	
	public List<BuyVo> getBuyList(String mem_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select b.book_name, b.book_image, b.book_price, "
					+ "          y.buy_info_num, y.book_num, y.book_amount"
					+ "   from tbl_buy y, tbl_book b "
					+ "   where y.book_num = b.book_num and y.mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			
			List<BuyVo> list = new ArrayList<BuyVo>();
			
			while(rs.next()) {
				String book_name = rs.getString("book_name");
				String book_image = rs.getString("book_image");
				int book_price = rs.getInt("book_price");
				int buy_info_num = rs.getInt("buy_info_num");
				int book_num  = rs.getInt("book_num");
				int book_amount  = rs.getInt("book_amount");
				
				BuyVo vo = new BuyVo();
				vo.setBook_name(book_name);
				vo.setBook_image(book_image);
				vo.setBook_price(book_price);
				vo.setBuy_info_num(buy_info_num);
				vo.setBook_num(book_num);
				vo.setBook_amount(book_amount);
				list.add(vo);
			}
			return list;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	
	public boolean deleteBuyList(int book_num, String mem_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "delete tbl_buy where book_num = ? and mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book_num);
			pstmt.setString(2, mem_id);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("삭제 성공! 다오에서 날아온 메세지");
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	
	public void paymentProcess() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			
			String sql = "insert into tbl_point(point_num, mem_id, point_score, point_code) "
					+ "                  values(seq_point_num.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "여기하는중인비다아~~~");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
	}
	
}
