package bank.atm.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import bank.atm.model.Account;

public class AccountDao {
	private static AccountDao instance = new AccountDao();
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

	private AccountDao() {
	}

	public static AccountDao getInstance() {
		return instance;
	}

	public String checkid(String account_no) {
		String user_no = null;
		try {
			Account ac = (Account) session.selectOne("Account.select", account_no);
			user_no = ac.getUser_no();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user_no;
	}

	public Account check_account_state(String account_no) {
		Account ac = new Account();
		try {
			ac = (Account) session.selectOne("Account.select", account_no);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ac;
	}

}
