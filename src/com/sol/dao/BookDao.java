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
import com.sol.vo.PagingVo;
import com.sol.vo.SearchVo;
import com.sol.vo.TempBuyVo;

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
	
	public int allBookCount(SearchVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try {
			conn = getConnection();
			String sql = "select count(*) cnt from tbl_book where book_name || book_explain || book_writer "
					+ "  like '%' || ? || '%'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSearchKeyword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("CNT");
				return count;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);;
		}
		return 0;
	}
	
	public boolean addCategory(String category_code, String category_code_explain) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into tbl_category(category_code, category_code_explain) values(?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category_code);
			pstmt.setString(2, category_code_explain);
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
	
	public boolean deleteCategory(String category_code) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			String sql = "delete tbl_book where category_code = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, category_code);
			pstmt.executeUpdate();
			
			String sql2 = "delete tbl_category where category_code = ?";
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, category_code);
			int count = pstmt2.executeUpdate();
			if(count > 0) {
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
			closeAll(null, pstmt2, null);
			closeAll(conn, pstmt, null);
		}
			return false;
	}
	
	public boolean deleteBook(int book_num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "delete tbl_book where book_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book_num);
			int count = pstmt.executeUpdate();
			if(count > 0) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
			return false;
	}
	
	public List<BookVo> getCategory() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select * from tbl_category order by category_code asc";
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
					+ "   and b.category_code = ? "
					+ "   order by b.book_num";
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
	
	public List<BookVo> getBestSellerList(SearchVo searchVo, PagingVo pagingVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = "select *from "
					+ "(select rownum rnum, a.* from "
					+ "(select * from tbl_book where book_name || book_writer "
					+ "|| book_explain like '%' || ? || '%' order by book_sold_count desc) a)"
					+ " where rnum >= ? and rnum <= ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchVo.getSearchKeyword());
			pstmt.setInt(2, pagingVo.getStart_page());
			pstmt.setInt(3, pagingVo.getEnd_page());
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
	
	public List<BookVo> getTempList(List<TempBuyVo> list) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select book_name, book_image, book_price from tbl_book where book_num = ?";
			int index = 0;
			List<BookVo> bookList = new ArrayList<BookVo>();
			for(int i=0;i<list.size();i++) {
				pstmt = conn.prepareStatement(sql);
				TempBuyVo vo = list.get(i);
				pstmt.setInt(++index, vo.getBook_num());
				rs = pstmt.executeQuery();
				while(rs.next()) {
					String book_name = rs.getString("book_name");
					String book_image = rs.getString("book_image");
					int book_price = rs.getInt("book_price");
					
					BookVo bookVo = new BookVo();
					bookVo.setBook_num(vo.getBook_num());
					bookVo.setBook_name(book_name);
					bookVo.setBook_image(book_image);
					bookVo.setBook_price(book_price);
					bookVo.setBook_amount(vo.getBook_amount());
					bookList.add(bookVo);
				}
				index = 0;
			}
			return bookList;
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
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
	
	public boolean updateBookInfo(BookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "update tbl_book set book_name = ?, book_price = ?, book_explain = ?, book_writer = ?,"
					+ "   book_stock = ?, book_image = ?, category_code = ? where book_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBook_name());
			pstmt.setInt(2, vo.getBook_price());
			pstmt.setString(3, vo.getBook_explain());
			pstmt.setString(4, vo.getBook_writer());
			pstmt.setInt(5, vo.getBook_stock());
			pstmt.setString(6, vo.getBook_image());
			pstmt.setString(7, vo.getCategory_code());
			pstmt.setInt(8, vo.getBook_num());
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
	
	public boolean addBook(BookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into tbl_book (book_num, book_name, book_price, category_code, "
					+ "						book_explain, book_writer, book_stock, book_image) "
					+ "						values (seq_book_num.nextval, ?, ?, ?, "
					+ "						?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getBook_name());
			pstmt.setInt(2, vo.getBook_price());
			pstmt.setString(3, vo.getCategory_code());
			pstmt.setString(4, vo.getBook_explain());
			pstmt.setString(5, vo.getBook_writer());
			pstmt.setInt(6, vo.getBook_stock());
			pstmt.setString(7, vo.getBook_image());
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
