package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.atm.dao.AccountDao;
import bank.atm.dao.MemberDao;

public class TransferOtherCheckService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		String other_account_no = request.getParameter("other_account_no");
		
		AccountDao ad = AccountDao.getInstance();
		MemberDao md = MemberDao.getInstance();
		String other_user_no = ad.checkaccountno(other_account_no);
		
		if (other_user_no == null || other_user_no.equals("")) {
			return "error.do?code=other_user_state_error.jsp";
		}
		System.out.println(other_user_no);
		String other_user_name = md.getkor_name(other_user_no);
		
		request.setAttribute("other_user_name", other_user_name);
		request.setAttribute("other_account_no", other_account_no);
		
		return "transfer.do?transfer=trade_amount.jsp";
	}

}
