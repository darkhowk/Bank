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
		int total = trade_amount + commission;
		System.out.println(total +"출금액");
		// 계좌 상태 체크

		TradeDao td = TradeDao.getInstance();
		int result = td.withdraw(account_no, total, kor_name, "", "","", "");
		// 일단거래 테이블 입력
		if (result <= 0) {
			// 입력 실패
		}
		int inputmoney = td.inputmoney(account_no);
		int outputmoney = td.outputmoney(account_no);
		int balance = inputmoney - outputmoney;

		// 잔액 계산

		request.setAttribute("account_no", account_no);
		request.setAttribute("trade_amount", trade_amount);
		request.setAttribute("balance", balance);
		request.setAttribute("commission", commission);
		return "view/atm/input/inputcheck.jsp";
	}

}
