package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.atm.dao.TradeDao;

public class OutputCheckService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String account_no = (String) session.getAttribute("account_no");
		int trade_amount = Integer.parseInt(request.getParameter("trade_amount"));
		String kor_name = (String) session.getAttribute("kor_name");
		int commission = 900;
		int total = -(trade_amount + commission);
		System.out.println(total);
		String trade_gbn = "출금";
		String trade_account_no = account_no;
		String content1 = kor_name;
		String content2 = kor_name;
		int balance;
		// 계좌 상태 체크

		TradeDao td = TradeDao.getInstance();
		int result = td.trademoney(account_no, trade_gbn, trade_account_no, total, content1, content2);

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
