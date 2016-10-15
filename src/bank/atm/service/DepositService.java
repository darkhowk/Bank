package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DepositService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		// 이전페이지에서 입금페이지 값 요청
		String deposit = request.getParameter("deposit");
		if (deposit == null || deposit == "") {
			deposit = "trade_amount.jsp";
		} else {
		}

		// 다음페이지로 입금페이지 값 보내줌.
		request.setAttribute("deposit", deposit);
		return "main.do?select=deposit/deposit.jsp";
	}

}
