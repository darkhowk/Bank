package bank.pc.custom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class AccountOpenDao {
	private static AccountOpenDao instance = new AccountOpenDao();

	private AccountOpenDao() {
	}

	public static AccountOpenDao getInstance() {
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

	public List<Product> allproduct() {
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from product_tb where use_flag =?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Y");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product pd = new Product();
				pd.setProduct_no(rs.getInt("product_no"));
				pd.setProduct_name(rs.getString("product_name"));
				pd.setContent(rs.getString("content"));
				pd.setContract_period_year(rs.getInt("contract_period_year"));
				pd.setReg_datetime(rs.getString("reg_datetime"));
				pd.setRelease_date(rs.getString("release_date"));
				list.add(pd);
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

	public List<Product> selectproduct(String select) {
		List<Product> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from product_tb where use_flag =? and product_no =?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Y");
			pstmt.setString(2, select);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product pd = new Product();
				pd.setProduct_no(rs.getInt("product_no"));
				pd.setProduct_name(rs.getString("product_name"));
				pd.setContent(rs.getString("content"));
				pd.setContract_period_year(rs.getInt("contract_period_year"));
				pd.setReg_datetime(rs.getString("reg_datetime"));
				pd.setRelease_date(rs.getString("release_date"));
				list.add(pd);
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

	public int insert(AccountOpen ao) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into account_open_tb (user_no, product_no, open_datetime, connect_gbn) values (?,?, date_format(now(), '%Y%m%d%H%i%S') ,?);";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ao.getUser_no());
			pstmt.setInt(2, ao.getProduct_no());
			pstmt.setString(3, ao.getConnect_gbn());
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

	public List<AccountOpen> requestlist() {
		List<AccountOpen> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from account_open_tb where open_gbn = ?";
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "N");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				AccountOpen ao = new AccountOpen();
				ao.setOpen_no(rs.getInt("open_no"));
				ao.setUser_no(rs.getInt("user_no"));
				ao.setProduct_no(rs.getInt("product_no"));
				ao.setOpen_datetime(rs.getString("open_datetime"));
				ao.setOpen_gbn(rs.getString("open_gbn"));
				if (rs.getString("connect_gbn").equals("0101")) {
					ao.setConnect_gbn("PC");
				} else {
					ao.setConnect_gbn(rs.getString("connect_gbn"));
				}

				list.add(ao);
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

	public int updateconfirm(int open_no, int user_no, int product_no, String connect_gbn) {
		int result = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "update account_open_tb set open_gbn = 'Y' where open_no = ?";
		String sql2 = "insert into account_tb  (account_no, account_pw, user_no, product_no, account_state, day_trans_limit, once_trans_limit, open_datetime) values ( concat( (select ifnull(max(left (a.account_no,6))+1,'703000') from account_tb a) , lpad(?,2,'0') ,  lpad((select count(a.account_no)+1 from account_tb as a where user_no =?) ,3,'0')) , password((select right(b.birthday,4) from member_tb as b where user_no =?) ), ?, ?, ?, ?, ?, date_format(now(), '%Y%m%d') ) ";
		Connection conn = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, open_no);
			result = pstmt.executeUpdate();
			if (result <= 0) {
				result = -1;
			} else {
				pstmt.close();
				pstmt = conn.prepareStatement(sql2);
				pstmt.setInt(1, product_no);
				pstmt.setInt(2, user_no);
				
				pstmt.setInt(3, user_no);				
				pstmt.setInt(4, user_no);
				pstmt.setInt(5, product_no);
				pstmt.setString(6, "0401");
				pstmt.setInt(7, 3000000);
				pstmt.setInt(8, 300000);
				result = pstmt.executeUpdate();

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
