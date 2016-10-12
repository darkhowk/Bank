package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.atm.dao.MemberDao;
import bank.atm.dao.TradeDao;

public class WithdrawPwService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		int balance;

		int trade_amount = Integer.parseInt(request.getParameter("trade_amount"));
		int commission = 900;
		String user_pw = request.getParameter("user_pw");

		HttpSession session = request.getSession();
		String account_no = (String) session.getAttribute("account_no");
		String user_no = (String) session.getAttribute("user_no");
		String user_name = (String) session.getAttribute("kor_name");

		MemberDao md = MemberDao.getInstance();
		TradeDao td = TradeDao.getInstance();
		String kor_name = md.chk(user_no, user_pw);

		int withdraw = trade_amount + commission;

		if (user_name.equals(kor_name)) {
			int inputmoney = td.inputmoney(account_no);
			int outputmoney = td.outputmoney(account_no);
			balance = inputmoney - outputmoney;

			if (withdraw > balance) {
				return "error.do?code=withdraw_trade_amount_over.jsp";
			} else {
				int result1 = td.withdraw(account_no, withdraw, user_name, "", "", "", "");
				if (result1 <= 0) {
					return "error.do?code=withdraw_db_error.jsp";
				} else {
					int inputmoney2 = td.inputmoney(account_no);
					int outputmoney2 = td.outputmoney(account_no);
					balance = inputmoney2 - outputmoney2;

					request.setAttribute("account_no", account_no);
					request.setAttribute("trade_amount", trade_amount);
					request.setAttribute("balance", balance);
					request.setAttribute("commission", commission);
					return "withdraw.do?withdraw=withdraw_check.jsp";
				}
			}
		} else {
			return "error.do?code=name_error.jsp";
		}
	}
}
