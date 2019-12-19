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

import com.sol.vo.BookVo;
import com.sol.vo.BuyVo;

public class BookDao {
	
	private static BookDao instance;

	public static BookDao getInstance() {
		if(instance == null) {
			instance = new BookDao();
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
	
	public List<BookVo> getCategory() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select * from tbl_category";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<BookVo> list = new ArrayList<>();
			while(rs.next()) {
				String category_code = rs.getString("category_code");
				String category_code_explain = rs.getString("category_code_explain");
				
				BookVo vo = new BookVo();
				vo.setCategory_code(category_code);
				vo.setCategory_code_explain(category_code_explain);
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
	
	public List<BookVo> getCategoryBook(String category_code){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from tbl_category c, tbl_book b "
					+ "   where c.category_code = b.category_code "
					+ "   and b.category_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category_code);
			rs = pstmt.executeQuery();
			List<BookVo> list = new ArrayList<BookVo>();
			while(rs.next()) {
				int book_num = rs.getInt("book_num");
				String book_name = rs.getString("book_name");
				int book_price = rs.getInt("book_price");
				int book_stock = rs.getInt("book_stock");
				int book_sold_count = rs.getInt("book_sold_count");
				String book_explain = rs.getString("book_explain");
				String book_writer = rs.getString("book_writer");
				String book_image = rs.getString("book_image");
				int book_score = rs.getInt("book_score");
				String category_code_explain = rs.getString("category_code_explain");
				
				BookVo vo = new BookVo();
				vo.setBook_num(book_num);
				vo.setBook_name(book_name);
				vo.setBook_price(book_price);
				vo.setCategory_code(category_code);
				vo.setBook_explain(book_explain);
				vo.setBook_writer(book_writer);
				vo.setBook_score(book_score);
				vo.setBook_sold_count(book_sold_count);
				vo.setBook_image(book_image);
				vo.setBook_stock(book_stock);
				vo.setCategory_code(category_code);
				vo.setCategory_code_explain(category_code_explain);
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
	
	public List<BookVo> getBestSellerList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from tbl_book order by book_sold_count desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			List<BookVo> list = new ArrayList<BookVo>();
			while(rs.next()) {
				int book_num = rs.getInt("book_num");
				String book_name = rs.getString("book_name");
				int book_price = rs.getInt("book_price");
				String category_code = rs.getString("category_code");
				String book_explain = rs.getString("book_explain");
				String book_writer = rs.getString("book_writer");
				int book_score = rs.getInt("book_score");
				int book_sold_count = rs.getInt("book_sold_count");
				String book_image = rs.getString("book_image");
				int book_stock = rs.getInt("book_stock");
				
				BookVo vo = new BookVo();
				vo.setBook_num(book_num);
				vo.setBook_name(book_name);
				vo.setBook_price(book_price);
				vo.setCategory_code(category_code);
				vo.setBook_explain(book_explain);
				vo.setBook_writer(book_writer);
				vo.setBook_score(book_score);
				vo.setBook_sold_count(book_sold_count);
				vo.setBook_image(book_image);
				vo.setBook_stock(book_stock);
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
	
	public BookVo getOneBook(int book_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from tbl_book where book_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book_num);
			rs = pstmt.executeQuery();
			BookVo vo = new BookVo();
			while(rs.next()) {
				String book_name = rs.getString("book_name");
				int book_price = rs.getInt("book_price");
				String category_code = rs.getString("category_code");
				String book_explain = rs.getString("book_explain");
				String book_writer = rs.getString("book_writer");
				int book_score = rs.getInt("book_score");
				int book_sold_count = rs.getInt("book_sold_count");
				String book_image = rs.getString("book_image");
				int book_stock = rs.getInt("book_stock");
				
				vo.setBook_num(book_num);
				vo.setBook_name(book_name);
				vo.setBook_price(book_price);
				vo.setCategory_code(category_code);
				vo.setBook_explain(book_explain);
				vo.setBook_writer(book_writer);
				vo.setBook_score(book_score);
				vo.setBook_sold_count(book_sold_count);
				vo.setBook_image(book_image);
				vo.setBook_stock(book_stock);
			}
			return vo;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	
	public void changeBookScore(List<BuyVo> list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			String sql = "update tbl_book set book_sold_count = book_sold_count + ?, "
					+ "   book_stock = book_stock -? where book_num = ?";
			int index = 0;
			for(int i=0;i<list.size();i++) {
				pstmt = conn.prepareStatement(sql);
				BuyVo vo = list.get(i);
				pstmt.setInt(++index, vo.getBook_amount());
				pstmt.setInt(++index, vo.getBook_amount());
				pstmt.setInt(++index, vo.getBook_num());
				pstmt.executeUpdate();
				index = 0;
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
	}
	
	public List<BookVo> sameWriter(String book_writer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select * from tbl_book where book_writer = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_writer);
			rs = pstmt.executeQuery();
			List<BookVo> list = new ArrayList<BookVo>();
			while(rs.next()) {
				int book_num = rs.getInt("book_num");
				String book_name = rs.getString("book_name");
				int book_price = rs.getInt("book_price");
				String category_code = rs.getString("category_code");
				String book_explain = rs.getString("book_explain");
				int book_score = rs.getInt("book_score");
				int book_sold_count = rs.getInt("book_sold_count");
				String book_image = rs.getString("book_image");
				int book_stock = rs.getInt("book_stock");
				
				BookVo vo = new BookVo();
				vo.setBook_num(book_num);
				vo.setBook_name(book_name);
				vo.setBook_price(book_price);
				vo.setCategory_code(category_code);
				vo.setBook_explain(book_explain);
				vo.setBook_writer(book_writer);
				vo.setBook_score(book_score);
				vo.setBook_sold_count(book_sold_count);
				vo.setBook_image(book_image);
				vo.setBook_stock(book_stock);
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
}
