package bank.atm.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ibatis.common.resources.Resources;

import bank.atm.model.Trade;

public class TradeDao {
	private static TradeDao instance = new TradeDao();

	private TradeDao() {
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

	public static TradeDao getInstance() {
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Trade> select(String account_no) {
		List<Trade> list = new ArrayList<>();

		try {
			list = session.selectList("Trade.selectlist", account_no);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;

	}

	public int todaytrade(String account_no) {
		int today_trade = -1;

		try {
			today_trade = (int) session.selectOne("Trade.today_trade", account_no);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return today_trade;

	}

	public int trademoney(Trade trade) {

		// 초기리턴값 -1
		int result = -1;

		try {
			result = (int) session.selectOne("Trade.trade_his", trade);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		if (result <= 0) {
			return result;

			// 기록이 되어서 1건이 정상 처리가되면 잔액을 리턴
		} else {
			result = (int) session.selectOne("Trade.get_balance", trade.getAccount_no());
		}

		return result;
	}

	public int balance(String account_no) {
		int result = 0;

		result = (int) session.selectOne("Trade.get_balance", account_no);

		if (result < 0) {
			result = -1;
		} else {
		}

		return result;

	}

}
