package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.atm.dao.TradeDao;
import bank.atm.model.Trade;

public class DepositCheckService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		// 이전페이지에서 입금액 요청, 잔액 초기화
		int trade_amount = Integer.parseInt(request.getParameter("trade_amount"));
		int balance;

		// 세션에서 계좌번호, 이름 가져옴. 변수들 이름으로 저장.
		HttpSession session = request.getSession();
		String account_no = (String) session.getAttribute("account_no");
		String kor_name = (String) session.getAttribute("kor_name");

		String content1 = kor_name;
		String content2 = kor_name;
		String trade_account_no = account_no;

		// TradeDao 초기화, 메모리할당
		TradeDao td = TradeDao.getInstance();

		// DB에 입금을 기록
		Trade trade = new Trade();
		trade.setAccount_no(account_no);
		trade.setConnect_gbn("0103");
		trade.setTrade_gbn("입금");
		trade.setTrade_account_no(trade_account_no);
		trade.setTrade_amount(trade_amount);
		trade.setTrade_bank("0601");
		trade.setContent1(content1);
		trade.setContent2(content2);
		int result = td.trademoney(trade);

		if (result <= 0) {
			return "error.do?code=deposit_amount_error.jsp";
		} else {
			balance = result;
			request.setAttribute("account_no", account_no);
			request.setAttribute("trade_amount", trade_amount);
			request.setAttribute("balance", balance);
			return "deposit.do?deposit=deposit_check.jsp";
		}
	}
}
