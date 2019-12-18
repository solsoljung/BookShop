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
import com.sol.vo.CartVo;

public class CartDao {

	private static CartDao instance;

	public static CartDao getInstance() {
		if(instance == null) {
			instance = new CartDao();
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
	
	public void addCart(CartVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select count(*) cnt from tbl_cart where mem_id = ? and book_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMem_id());
			pstmt.setInt(2, vo.getBook_num());
			rs = pstmt.executeQuery();
			int count = 0;
			if(rs.next()) {
				count = rs.getInt("cnt");
			}
			
			if(count == 0) {
				String sql2 = "insert into tbl_cart(cart_num, book_num, book_amount, mem_id) "
						+ "    values(seq_cart_num.nextval, ?, ?, ?)";
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, vo.getBook_num());
				pstmt2.setInt(2, vo.getBook_amount());
				pstmt2.setString(3, vo.getMem_id());
				int insert = pstmt2.executeUpdate();
				if(insert > 0) {
					System.out.println("새롭게 장바구니를 만듦!");
				}
			} else {
				String sql2 = "update tbl_cart set book_amount = book_amount + 1 where book_num = ? and mem_id = ?";
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, vo.getBook_num());
				pstmt2.setString(2, vo.getMem_id());
				int update = pstmt2.executeUpdate();
				if(update > 0) {
					System.out.println("이미 있는 장바구니라 수량만 ++함!");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt2, null);
			closeAll(conn, pstmt, rs);
		}
	}
	
	public List<CartVo> getMyCartList(String mem_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select b.book_name, b.book_image, b.book_price, "
					+ "   c.cart_num, c.book_num, c.book_amount, c.mem_id "
					+ "   from tbl_cart c, tbl_book b "
					+ "   where c.book_num = b.book_num and c.mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			List<CartVo> list = new ArrayList<CartVo>();
			while(rs.next()) {
				String book_name = rs.getString("book_name");
				String book_image = rs.getString("book_image");
				int book_price = rs.getInt("book_price");
				int cart_num = rs.getInt("cart_num");
				int book_num = rs.getInt("book_num");
				int book_amount = rs.getInt("book_amount");
				
				CartVo vo = new CartVo();
				vo.setBook_name(book_name);
				vo.setBook_image(book_image);
				vo.setBook_price(book_price);
				vo.setCart_num(cart_num);
				vo.setBook_num(book_num);
				vo.setBook_amount(book_amount);
				vo.setMem_id(mem_id);
				
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
	
	public boolean deleteCart(List<CartVo> list) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = getConnection();
				conn.setAutoCommit(false);
				String sql = "delete tbl_cart where book_num = ? and mem_id = ?";
				int index = 0;
				int result = 0;
				for(int i=0;i<list.size();i++) {
					pstmt = conn.prepareStatement(sql);
					CartVo vo = list.get(i);
					pstmt.setInt(++index, vo.getBook_num());
					pstmt.setString(++index, vo.getMem_id());
					result = pstmt.executeUpdate();
					index = 0;
				}
				if(result > 0) {
					return true;
				}
				conn.commit();
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			closeAll(conn, pstmt, null);
		}
			return false;
	}
	
	public boolean changeBookAmount(CartVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "update tbl_cart set book_amount = ? where book_num = ? and mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getBook_amount());
			pstmt.setInt(2, vo.getBook_num());
			pstmt.setString(3, vo.getMem_id());
			int result = pstmt.executeUpdate();
			if(result > 0) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	
}
