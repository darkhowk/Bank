package bank.atm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class TradeDao {
	private static TradeDao instance = new TradeDao();

	private TradeDao() {
	}

	public static TradeDao getInstance() {
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

	public List<Trade> select(String accountno) {
		List<Trade> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select *, STR_TO_DATE(trade_datetime, '%Y%m%d%H%i%s') time from trade_his_tb where account_no = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountno);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				Trade trd = new Trade();
				trd.setTrade_no(rs.getInt("trade_no"));
				trd.setAccount_no(rs.getString("account_no"));
				if ("0601".equals(rs.getString("trade_bank"))) {
					trd.setTrade_bank("삼조은행");
				} else {
					trd.setTrade_bank("기타은행");
				}
				trd.setTrade_gbn(rs.getString("trade_gbn"));
				trd.setAccount_no(rs.getString("account_no"));

				trd.setTrade_amount(rs.getInt("trade_amount"));
				trd.setContent1(rs.getString("CONTENT1"));
				trd.setContent2(rs.getString("CONTENT2"));
				if ("0101".equals(rs.getString("connect_gbn"))) {
					trd.setConnect_gbn("PC");
				} else if ("0102".equals(rs.getString("connect_gbn"))) {
					trd.setConnect_gbn("Mobile");
				} else {
					trd.setConnect_gbn("ATM");
				}
				trd.setTrade_datetime(rs.getString("time"));
				list.add(trd);
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

	public int todattrade(String account_no) {
		int todaytrade = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select sum(trade_amount) from trade_his_tb where not trade_account_no=? and  account_no = ? and trade_gbn =? and trade_datetime between date_format(now() , '%Y%m%d000000') and date_format(now() , '%Y%m%d24595999')";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "");
			pstmt.setString(2, account_no);
			pstmt.setString(3, "입금");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				todaytrade = rs.getInt(1);

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
		return todaytrade;

	}

	public int insertmoney(String account_no, int trade_amount, String kor_name, String other_kor_name, String content1,
			String content2, String other_account_no) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into trade_his_tb (account_no, trade_gbn, trade_bank, trade_amount, content1, content2, connect_gbn, trade_datetime) values(?,?,?,?,?,?,?,date_format(now(), '%Y%m%d%H%i%S'))";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_no);
			pstmt.setString(2, "입금");
			pstmt.setString(3, "0601");
			pstmt.setInt(4, trade_amount);
			if (content1.equals("") || content1 == null) {
				pstmt.setString(5, kor_name);
			} else {
				pstmt.setString(5, content1);
			}
			if (content2.equals("") || content2 == null) {
				pstmt.setString(6, other_kor_name);
			} else {
				pstmt.setString(6, content2);
			}
			pstmt.setString(7, "0103");
			result = pstmt.executeUpdate();

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

	public int inputmoney(String account_no) {
		int inputmoney = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select  sum(trade_amount) from trade_his_tb where account_no =? and trade_gbn = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_no);
			pstmt.setString(2, "입금");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				inputmoney = rs.getInt(1);

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

		return inputmoney;
	}

	public int outputmoney(String account_no) {
		int outputmoney = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select  sum(trade_amount) from trade_his_tb where account_no =? and trade_gbn = ? ";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_no);
			pstmt.setString(2, "출금");

			rs = pstmt.executeQuery();
			while (rs.next()) {
				outputmoney = rs.getInt(1);

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

		return outputmoney;
	}

	public int withdraw(String account_no, int total, String kor_name, String other_kor_name, String content1,
			String conten2, String trade_account_no) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into trade_his_tb (account_no, trade_account_no, trade_gbn, trade_bank, trade_amount, content1, content2, connect_gbn, trade_datetime) values(?,?,?,?,?,?,?,?,date_format(now(), '%Y%m%d%H%i%S'))";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account_no);
			pstmt.setString(2, trade_account_no);
			pstmt.setString(3, "출금");
			pstmt.setString(4, "0601");
			pstmt.setInt(5, total);
			pstmt.setString(6, kor_name);
			pstmt.setString(7, "");
			pstmt.setString(8, "0103");

			result = pstmt.executeUpdate();
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
