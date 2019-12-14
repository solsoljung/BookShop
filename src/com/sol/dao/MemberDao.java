package com.sol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sol.vo.MemberVo;

public class MemberDao {

	private static MemberDao instance;

	public static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
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
	
	public boolean checkId(String mem_id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select count(*) cnt from tbl_member where mem_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int count = rs.getInt("cnt");
				if(count > 0) {
					return true;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return false;
	}
	
	public boolean register(MemberVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into tbl_member (mem_id, mem_pw, mem_name, mem_phone, mem_address) values (?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMem_id());
			pstmt.setString(2, vo.getMem_pw());
			pstmt.setString(3, vo.getMem_name());
			pstmt.setString(4, vo.getMem_phone());
			pstmt.setString(5, vo.getMem_address());
			int success = pstmt.executeUpdate();
			if(success > 0) {
				return true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	
	public boolean login(String mem_id, String mem_pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select count(*) cnt from tbl_member where mem_id = ? and mem_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_pw);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int count = rs.getInt("cnt");
				if(count > 0) {
					return true;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return false;
	}
	
}
