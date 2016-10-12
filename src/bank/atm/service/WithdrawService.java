package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WithdrawService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		String withdraw = request.getParameter("withdraw");

		if (withdraw == null || withdraw == "") {
			withdraw = "trade_amount.jsp";
		} else {
		}

		if (request.getParameter("trade_amount") == null || request.getParameter("trade_amount").equals("")) {
			request.setAttribute("withdraw", withdraw);
		} else {
			int trade_amount = Integer.parseInt(request.getParameter("trade_amount"));
			request.setAttribute("trade_amount", trade_amount);
			request.setAttribute("withdraw", withdraw);
		}
		return "main.do?select=withdraw/withdraw.jsp";
	}

}
