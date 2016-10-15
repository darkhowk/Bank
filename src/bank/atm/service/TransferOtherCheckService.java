package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.atm.dao.AccountDao;
import bank.atm.dao.MemberDao;

public class TransferOtherCheckService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		// 이전페이지에서 다른계좌번호값을 받음
		String other_account_no = request.getParameter("other_account_no");

		// AccountDao, MemberDao 초기화, 메모리 할당
		AccountDao ad = AccountDao.getInstance();
		MemberDao md = MemberDao.getInstance();

		// 상대 계좌번호를 체크해서 값을 읽어옴.
		String other_user_no = ad.checkaccountno(other_account_no);

		// 상대 유저번호가 없으면 상대방 상태가 정상이 아님.
		if (other_user_no == null || other_user_no.equals("")) {
			return "error.do?code=other_user_state_error.jsp";

			// 상대방 이름을 가져오면서 상태 체크
		} else {

			String other_user_name = md.getkor_name(other_user_no);

			// 만약 상대방 이름이 없으면 상태가 정상이 아님.
			if (other_user_name.equals("") || other_user_name == null) {
				return "error.do?code=other_user_state_error.jsp";
			} else {
				// 상태가 정상이면 다음페이지로 값을 넘겨줌
				request.setAttribute("other_user_name", other_user_name);
				request.setAttribute("other_account_no", other_account_no);
				return "transfer.do?transfer=trade_amount.jsp";
			}
		}

	}

}
