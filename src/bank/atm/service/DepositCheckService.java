package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.atm.dao.TradeDao;

public class DepositCheckService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		
		int trade_amount = Integer.parseInt(request.getParameter("trade_amount"));
		int balance;
		
		HttpSession session = request.getSession();
		String account_no = (String) session.getAttribute("account_no");
		String kor_name = (String) session.getAttribute("kor_name");
		
		TradeDao td = TradeDao.getInstance();
		int result = td.insertmoney(account_no, trade_amount, kor_name, "", "", "", "");
		
		if (result <= 0) {
			return "error.do?code=deposit_amount_error.jsp";
		} else {
			int inputmoney = td.inputmoney(account_no);
			int outputmoney = td.outputmoney(account_no);
			balance = inputmoney - outputmoney;
			request.setAttribute("account_no", account_no);
			request.setAttribute("trade_amount", trade_amount);
			request.setAttribute("balance", balance);
			return "deposit.do?deposit=deposit_check.jsp";
		}
	}
}
