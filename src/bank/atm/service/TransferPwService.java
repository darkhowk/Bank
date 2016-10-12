package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.atm.dao.Account;
import bank.atm.dao.AccountDao;
import bank.atm.dao.MemberDao;
import bank.atm.dao.TradeDao;

public class TransferPwService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		String other_account_no = request.getParameter("other_account_no");
		String other_user_name = request.getParameter("other_user_name");
		System.out.println(request.getParameter("other_user_name"));
		String user_pw = request.getParameter("user_pw");
		int trade_amount = Integer.parseInt(request.getParameter("trade_amount"));
		int commission = 900;
		int balance;
		int total;

		HttpSession session = request.getSession();
		String account_no = (String) session.getAttribute("account_no");
		String user_no = (String) session.getAttribute("user_no");
		String user_name = (String) session.getAttribute("kor_name");

		AccountDao ad = AccountDao.getInstance();
		TradeDao td = TradeDao.getInstance();
		MemberDao md = MemberDao.getInstance();
		
		String user_name2 = md.chk(user_no, user_pw);

		if (!user_name2.equals(user_name)) {
			return "error.do?code=transfer_pw_error.jsp";
		} else {
			Account as = ad.check_account_state(account_no);
			int todaytrade = td.todattrade(account_no);

			if (trade_amount > as.getOnce_trans_limit()) {
				return "error.do?code=transfer_once_transfer_limit.jsp";
			} else {
				if (todaytrade > as.getDay_trans_limit()) {
					return "error.do?code=transfer_day_transfer_limit.jsp";
				} else {
					int inputmoney = td.inputmoney(account_no);
					int outputmoney = td.outputmoney(account_no);
					balance = inputmoney - outputmoney;
					total = trade_amount + commission;
					if (total > balance) {
						return "error.do?code=transfer_balance_error.jsp";
					} else {
						int result1 = td.withdraw(account_no, total, user_name, other_user_name, "", "",
								other_account_no);
						if (result1 <= 0) {
							return "error.do?code=transfer_withdraw_error.jsp";
						} else {
					
							int result2 = td.insertmoney(other_account_no, trade_amount, other_user_name, user_name, "","", account_no);
							if (result2 <= 0) {
								return "error.do?code=transfer_deposit_error.jsp";
							} else {
								request.setAttribute("other_account_no", other_account_no);
								request.setAttribute("trade_amount", trade_amount);
								request.setAttribute("commission", commission);
								request.setAttribute("balance", balance);
								return "transfer.do?transfer=transfer_check.jsp";
							}
						}
					}
				}
			}
		}
	}
}
