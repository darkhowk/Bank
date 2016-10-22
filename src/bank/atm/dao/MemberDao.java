package bank.atm.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import bank.atm.model.Member;

public class MemberDao {
	private static MemberDao instance = new MemberDao();

	private MemberDao() {
	}

	private static SqlSession session;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("configuration.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
			session = ssf.openSession(true);
			reader.close();
		} catch (IOException e) {
			System.out.println("sqlMap Error : " + e.getMessage());
		}
	}

	public static MemberDao getInstance() {
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

	public String getKorName(String user_no) {
		String name = "";
		try {
			Member member = (Member) session.selectOne("Member.select", user_no);
			name = member.getKor_name();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return name;
	}

	public String chk(String user_no, String user_pw) {
		String result = "";
		String kor_name = "";
		Map<String, String> map = new HashMap<>();
		map.put("user_no", user_no);
		map.put("user_pw", user_pw);
		try {
			kor_name = (String) session.selectOne("Member.select", user_no);
			if (kor_name.equals("") || kor_name == null) {

			} else {
				result = kor_name;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return result;

	}

	public int checkstate(String other_user_no) {

		return 0;
	}

}
