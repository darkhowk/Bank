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

	public int todaytrade(String account_no) {
		int todaytrade = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 내 통장에서 다른 거래한이체통장번호가 내것이 아니고, 출금인것들중, 오늘 거래한것만 모두 더함. 
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

	public int trademoney(String account_no, String trade_gbn, String trade_account_no, int trade_amount,
			String content1, String content2) {

		// 초기리턴값 -1
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// sql1 은 실제로 DB에 기록, sql2 는 기록후 잔액을 읽어옴.
		String sql1 = "insert into trade_his_tb (account_no, trade_gbn, trade_account_no, trade_bank, trade_amount, content1, content2, connect_gbn, trade_datetime) values (?, ?, ?, ?, ?, ?, ?, ?,date_format(sysdate(), '%Y%m%d%H%i%S'))";
		String sql2 = "select sum(trade_amount) balance from trade_his_tb where account_no = ?";
		try {
			// DB에 기록
			conn = getConnection();
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, account_no);
			pstmt.setString(2, trade_gbn);
			pstmt.setString(3, trade_account_no);
			pstmt.setString(4, "0601");
			pstmt.setInt(5, trade_amount);
			pstmt.setString(6, content1);
			pstmt.setString(7, content2);
			pstmt.setString(8, "0103");
			result = pstmt.executeUpdate();

			// 기록이 되어서 1건이 정상 처리가 되지 않으면 그 값을 리턴
			if (result <= 0) {
				return result;

				// 기록이 되어서 1건이 정상 처리가되면 잔액을 리턴
			} else {
				pstmt.close();
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, account_no);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					result = rs.getInt("balance");
					return result;
				}
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

	public int balance(String account_no) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql1 = "select sum(trade_amount) balance from trade_his_tb where account_no = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1, account_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("balance");
				return result;
			} else {
				result = -1;
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
