package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.atm.dao.AccountDao;

public class AccountNoCheckService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String accountno = request.getParameter("accountno");
		AccountDao ad = AccountDao.getInstance();
		int check = ad.checkaccountno(accountno);

		if (check == 0) {
			return "view/atm/miss.jsp";
		} else {
			
			request.setAttribute("accountno", accountno);
			return "main.do";
		}
	}
}
