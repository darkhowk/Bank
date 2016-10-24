package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.atm.dao.TradeDao;
import bank.atm.model.Trade;

public class OutputCheckService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String account_no = (String) session.getAttribute("account_no");
		int trade_amount = Integer.parseInt(request.getParameter("trade_amount"));
		String kor_name = (String) session.getAttribute("kor_name");
		int commission = 900;
		int total = -(trade_amount + commission);
		String trade_account_no = account_no;
		String content1 = kor_name;
		String content2 = kor_name;
		int balance;
		// 계좌 상태 체크
		Trade trade = new Trade();
		trade.setAccount_no(account_no);
		trade.setConnect_gbn("0103");
		trade.setContent1(content1);
		trade.setContent2(content2);
		trade.setTrade_account_no(trade_account_no);
		trade.setTrade_amount(total);
		trade.setTrade_bank("0601");
		trade.setTrade_gbn("출금");

		TradeDao td = TradeDao.getInstance();
		int result = td.trademoney(trade);

		if (result <= 0) {
			return "error.do?code=withdrawerror.jsp";
		} else {
			balance = result;

			request.setAttribute("account_no", account_no);
			request.setAttribute("trade_amount", trade_amount);
			request.setAttribute("balance", balance);
			request.setAttribute("commission", commission);
			return "view/atm/input/inputcheck.jsp";
		}
	}

}
