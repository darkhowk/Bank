package pc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	private static BoardDao instance = new BoardDao();

	private BoardDao() {
	}

	public static BoardDao getInstance() {
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

	public List<Board> select() {
		List<Board> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select *, str_to_date(start_date, '%Y%m%d') sd,str_to_date(end_date, '%Y%m%d') ed, STR_TO_DATE(reg_date, '%Y%m%d%H%i%s') wd from board_tb where del_flag = ?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "N");

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board brd = new Board();
				brd.setBoard_no(rs.getInt("board_no"));
				brd.setBoard_gbn(rs.getString("board_gbn"));
				brd.setTitle(rs.getString("title"));
				brd.setUser_id(rs.getString("user_id"));
				brd.setContent(rs.getString("content"));
				brd.setStart_date(rs.getString("sd"));
				brd.setEnd_date(rs.getString("ed"));
				brd.setReg_date(rs.getString("wd"));
				brd.setRead_count(rs.getInt("read_count"));

				list.add(brd);
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

	public List<Board> update(int board_no) {
		List<Board> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * , str_to_date(start_date, '%Y%m%d') sd,str_to_date(end_date, '%Y%m%d') ed from board_tb where board_no=?";
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Board brd = new Board();
				brd.setBoard_gbn(rs.getString("board_gbn"));
				brd.setTitle(rs.getString("title"));
				brd.setContent(rs.getString("content"));
				brd.setStart_date(rs.getString("sd"));
				brd.setEnd_date(rs.getString("ed"));
				list.add(brd);
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

	public int update(Board board) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update board_tb set board_gbn=?, title=?, content=? ,start_date=date_format(?, '%Y%m%d'),"
				+ "end_date=date_format(?, '%Y%m%d'), reg_date =date_format(now(), '%Y%m%d%H%i%S')  where board_no=?";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_gbn());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getStart_date());
			pstmt.setString(5, board.getEnd_date());
			pstmt.setInt(6, board.getBoard_no());

			result = pstmt.executeUpdate();

		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return result;
	}

	public int insrt(Board board) {
		int result = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into board_tb (board_gbn, title, content, start_date, end_date, user_id, reg_date) "
				+ "values('0501','ddd','2',date_format(sysdate(), '%Y%m%d'),date_format(sysdate(), '%Y%m%d'),'2',date_format(sysdate(), '%Y%m%d%H%i%S'));";

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_gbn());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getStart_date());
			pstmt.setString(5, board.getEnd_date());
			pstmt.setString(6, "admin");

			result = pstmt.executeUpdate();

		} catch (

		Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {

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
