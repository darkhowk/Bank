package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.atm.dao.MemberDao;
import bank.atm.dao.TradeDao;

public class WithdrawPwService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		// 잔액, 수수료초기화, 이전페이지에서 거래금액, 비밀번호를 가져옴.
		int balance;
		int trade_amount = Integer.parseInt(request.getParameter("trade_amount"));
		int commission = 900;
		String user_pw = request.getParameter("user_pw");

		// 세션에 있던 계좌번호, 유저번호 이름을 가져옴.
		HttpSession session = request.getSession();
		String account_no = (String) session.getAttribute("account_no");
		String user_no = (String) session.getAttribute("user_no");
		String kor_name = (String) session.getAttribute("kor_name");

		// MemberDao, TradeDao 를 초기화, 메모리 할당
		MemberDao md = MemberDao.getInstance();
		TradeDao td = TradeDao.getInstance();

		// 비밀번호를 확인하고, 이름을 가져옴.
		String kor_name2 = md.chk(user_no, user_pw);

		// 총 거래 금액은 출금액 + 수수료
		int total = -(trade_amount + commission);

		// 필요한 변수들 선언
		String trade_gbn = "출금";
		String trade_account_no = account_no;
		String content1 = kor_name;
		String content2 = kor_name;

		// 만약 원래 가지고온 이름과 비밀번호확인후 가져온 이름이 같으면 정상적인 상태.
		if (kor_name.equals(kor_name2)) {
			// 거래 전 잔액을 가져옴
			balance = td.balance(account_no);

			// 만약 출금액이 잔액보다 크다면 에러.
			if (total > balance) {
				return "error.do?code=withdraw_trade_amount_over.jsp";

				// 출금액이 잔액보다 작으면 거래 시작
			} else {

				// DB에 데이터 입력, 잔액을 가져옴
				int result = td.trademoney(account_no, trade_gbn, trade_account_no, total, content1, content2);

				// 잔액이 0보다 작다면, DB에서 기록 또는 잔액 읽어오기 실패.
				if (result <= 0) {
					return "error.do?code=withdraw_db_error.jsp";

					// 잔액이 0보다 크면, 기록 성공.
				} else {

					// 결과를 잔액에 넣고, 다음 페이지로 필요한 변수들을 보내줌.
					balance = result;
					request.setAttribute("account_no", account_no);
					request.setAttribute("trade_amount", trade_amount);
					request.setAttribute("balance", balance);
					request.setAttribute("commission", commission);
					return "withdraw.do?withdraw=withdraw_check.jsp";
				}
			}
			// 이름이 틀리면 오류창으로.
		} else {
			return "error.do?code=name_error.jsp";
		}
	}
}
