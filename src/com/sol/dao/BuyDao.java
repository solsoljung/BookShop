package com.sol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sol.vo.BuyVo;
import com.sol.vo.PointVo;

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
	
	public void addPoint(PointVo pointVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into tbl_point(point_num, mem_id, point_score, point_code) VALUES(seq_point_num.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pointVo.getMem_id());
			pstmt.setInt(2, pointVo.getPoint_score());
			pstmt.setString(3, pointVo.getPoint_code());
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
	}
	
	//바이다오 만들기
	public boolean buy(List<BuyVo> buyList, PointVo pointVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			
			//재고바꾸기
			BookDao.getInstance().changeBookScore(buyList);
			
			//포인트 적립
			addPoint(pointVo);
			
			//구매테이블 추가
			String  sql = 	"INSERT ALL ";
				for(int i=0;i<buyList.size();i++) {
					sql += "   INTO tbl_buy (buy_info_num, book_num, book_amount, mem_id, mem_phone, mem_address)";
					sql += "   VALUES (seq_buy_num.nextval, ?, ?, ?, ?, ?)";
				}
					sql += "   SELECT * FROM DUAL";
			int index = 0;
			pstmt = conn.prepareStatement(sql);
			for(int i=0;i<buyList.size();i++) {
				BuyVo vo = buyList.get(i);
				System.out.println("제 부모님은 어디 계시죠? "+buyList.size());
				pstmt.setInt(++index, vo.getBook_num());
				pstmt.setInt(++index, vo.getBook_amount());
				pstmt.setString(++index, vo.getMem_id());
				pstmt.setString(++index, vo.getMem_phone());
				pstmt.setString(++index, vo.getMem_address());
			}
			int result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
				return true;
			}
		} catch(Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeAll(conn, pstmt, null);
		}
		return false;
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
	
	public List<BuyVo> getMyBuyList(String mem_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select y.buy_info_num, y.buy_date, y.book_num, y.book_amount, "
					+ "   y.mem_id, y.mem_phone, y.mem_address, b.book_name "
					+ "   from tbl_buy y, tbl_book b "
					+ "   where y.book_num = b.book_num and mem_id = ? "
					+ "   order by buy_info_num desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			
			List<BuyVo> list = new ArrayList<BuyVo>();
			
			while(rs.next()) {
				int buy_info_num = rs.getInt("buy_info_num");
				Timestamp buy_date = rs.getTimestamp("buy_date");
				int book_num = rs.getInt("book_num");
				int book_amount = rs.getInt("book_amount");
				//mem_id 잊지마...
				String mem_phone = rs.getString("mem_phone");
				String mem_address = rs.getString("mem_address");
				String book_name = rs.getString("book_name");
				
				BuyVo vo = new BuyVo();
				vo.setBuy_info_num(buy_info_num);
				vo.setBuy_date(buy_date);
				vo.setBook_num(book_num);
				vo.setBook_amount(book_amount);
				vo.setMem_id(mem_id);
				vo.setMem_phone(mem_phone);
				vo.setMem_address(mem_address);
				vo.setBook_name(book_name);
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
	
	public Map<Integer, Integer> getCountBuyList(String mem_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select buy_info_num, count(*) cnt from tbl_buy where mem_id = ? group by buy_info_num order by buy_info_num";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			while(rs.next()) {
				int buy_info_num = rs.getInt("buy_info_num");
				int count = rs.getInt("CNT");
				map.put(buy_info_num, count);
			}
			return map;
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
