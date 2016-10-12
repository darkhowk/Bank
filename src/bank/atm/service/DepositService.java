package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DepositService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		String deposit = request.getParameter("deposit");
		if (deposit == null || deposit == "") {
			deposit = "trade_amount.jsp";
		} else {
		}
						
		request.setAttribute("deposit", deposit);

		return "main.do?select=deposit/deposit.jsp";
	}

}
