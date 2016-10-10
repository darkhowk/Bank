package bank.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	public int checkaccountno(String accountno) {
		int result = 0;
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
				result = 1;
				rs.getInt(1);
				System.out.println(rs.getInt(1));
				rs.getString(2);
				System.out.println(rs.getString(2));
				rs.getString(3);
				System.out.println(rs.getString(3));
				rs.getString(4);
				System.out.println(rs.getString(4));
				rs.getString(5);
				System.out.println(rs.getString(5));
				rs.getInt(6);
				System.out.println(rs.getInt(6));
				rs.getInt(7);
				System.out.println(rs.getInt(7));
				rs.getInt(8);
				System.out.println(rs.getInt(8));
				rs.getString(9);
				System.out.println(rs.getString(9));
				rs.getString(10);
				System.out.println(rs.getString(10));
			
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

}
