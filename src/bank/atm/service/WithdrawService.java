package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WithdrawService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		// 이전페이지에서 출금값을 읽어옴
		String withdraw = request.getParameter("withdraw");

		// 만약 출금값이 빈값이면, 출금액을 입력받는 창으로 보냄.
		if (withdraw == null || withdraw == "") {
			withdraw = "trade_amount.jsp";
		} else {
		}

		// 만약 거래금액이 null이면, 그대로 출금값을 다음페이지로 보냄
		if (request.getParameter("trade_amount") == null || request.getParameter("trade_amount").equals("")) {
			request.setAttribute("withdraw", withdraw);

			// 만약 거래금액이 null이 아니면 거래금액을 요청받고, 다음페이지로 출금값과 함께 보냄
		} else {
			int trade_amount = Integer.parseInt(request.getParameter("trade_amount"));
			request.setAttribute("trade_amount", trade_amount);
			request.setAttribute("withdraw", withdraw);
		}
		return "main.do?select=withdraw/withdraw.jsp";
	}
}
