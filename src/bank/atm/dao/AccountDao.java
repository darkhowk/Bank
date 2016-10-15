package bank.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AccountDao {
	private static AccountDao instance = new AccountDao();

	private AccountDao() {
	}

	public static AccountDao getInstance() {
		return instance;
	}

	// Connection pool
	private Connection getConnection() {
		Connection conn = null;
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySql");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

	public String checkaccountno(String accountno) {
		
		String result = "";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from account_tb where account_state = '0401' and account_no =? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getString("user_no");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return result;

	}

	public List<Account> searchaccount(String accountno) {
		List<Account> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from * where accountno =?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountno);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Account ac = new Account();
				ac.setAccount_no(rs.getString("account_no"));

				list.add(ac);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return list;

	}

	public Account check_account_state(String account_no) {
		Account ac = new Account();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from account_tb where account_no =?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_no);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				ac.setAccount_no(rs.getString("account_no"));
				ac.setAccount_state(rs.getString("account_state"));
				ac.setDay_trans_limit(rs.getInt("day_trans_limit"));
				ac.setOnce_trans_limit(rs.getInt("once_trans_limit"));

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return ac;
	}

}
