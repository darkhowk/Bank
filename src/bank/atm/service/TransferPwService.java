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

		// 이전페이지에서 값들을 가져옴. 각 변수값 초기화.
		String trade_account_no = request.getParameter("other_account_no");
		String other_user_name = request.getParameter("other_user_name");
		String user_pw = request.getParameter("user_pw");
		int trade_amount = Integer.parseInt(request.getParameter("trade_amount"));
		int commission = 900;
		int balance;
		int total;

		// 세션에서 내 계좌번호와 내 번호, 이름을 가져옴
		HttpSession session = request.getSession();
		String account_no = (String) session.getAttribute("account_no");
		String user_no = (String) session.getAttribute("user_no");
		String user_name = (String) session.getAttribute("kor_name");
		String trade_gbn = "출금";
		String trade_gbn2 = "입금";
		String content1 = user_name;
		String content2 = other_user_name;

		// AccountDao, TradeDao 초기화, 메모리할당
		AccountDao ad = AccountDao.getInstance();
		TradeDao td = TradeDao.getInstance();
		MemberDao md = MemberDao.getInstance();

		// 비밀번호 체크하면서 이름을 가져옴
		String user_name2 = md.chk(user_no, user_pw);

		// 만약 내 이름하고, 비밀번호 체크하면서 가져온 이름이 다르면 에러.
		if (!user_name2.equals(user_name)) {
			return "error.do?code=transfer_pw_error.jsp";

			// 이름이 같으면
		} else {

			// 그 계좌에서 1일 이체액, 1회 이체액등을 가져옴.
			Account as = ad.check_account_state(account_no);

			// 오늘 이체한 금액을 가져옴. 그리고 양수로 바꿔줌
			int todaytrade = -(td.todaytrade(account_no));

			// 만약 거래금액이 1회 거래액 크다면 거래 제한
			if (trade_amount > as.getOnce_trans_limit()) {
				return "error.do?code=transfer_once_transfer_limit.jsp";

			} else {

				// 만약 오늘 이체한 금액과 지금 이체하는 금액을 더한게 1일 이체리미트보다 크다면 거래제한
				if (todaytrade + trade_amount > as.getDay_trans_limit()) {
					return "error.do?code=transfer_day_transfer_limit.jsp";
				} else {

					// 아니면 잔액을 가져옴. 그리고 거래총액은 거래액 + 이자
					balance = td.balance(account_no);
					total = trade_amount + commission;

					// 거래금액이 잔액보다 크다면 거래 제한
					if (total > balance) {
						return "error.do?code=transfer_balance_error.jsp";

					} else {

						// 일단 내 통장에서 돈을 뺌
						int result1 = td.trademoney(account_no, trade_gbn, trade_account_no, total, content1, content2);

						// 결과 잔액이 0보다 작으면 DB입력에서 에러.
						if (result1 <= 0) {
							return "error.do?code=transfer_withdraw_error.jsp";

							// 상대 통장에 돈을 넣어줌.
						} else {
							int result2 = td.trademoney(trade_account_no, trade_gbn2, account_no, trade_amount,
									content2, content1);

							// 만약 상대편 잔액이 0보다 작으면 DB입력 에러
							if (result2 <= 0) {
								return "error.do?code=transfer_deposit_error.jsp";

								// 아니면 결과값출력에 필요한 것들을 넘겨줌
							} else {
								request.setAttribute("trade_account_no", trade_account_no);
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
