package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.atm.dao.AccountDao;
import bank.atm.dao.MemberDao;

public class AccountNoCheckService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("1");
		String account_no = request.getParameter("account_no");

		AccountDao ad = AccountDao.getInstance();
		String user_no = ad.checkaccountno(account_no);
		MemberDao md = MemberDao.getInstance();
		String kor_name = md.getkor_name(user_no);

		if (user_no.equals("") || user_no == null) {
			System.out.println("2");
			return "error.do?code=account_not_existence.jsp";
		} else {
			System.out.println("3");
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10 * 60); // 10분 로그인 상태 지속할 수 있게 설정함.
			session.setAttribute("account_no", account_no);
			session.setAttribute("user_no", user_no);
			session.setAttribute("kor_name", kor_name);
			request.setAttribute("accountno", account_no);
			return "main.do";
		}

	}

}
