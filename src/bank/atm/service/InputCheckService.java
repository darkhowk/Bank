package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InputCheckService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String accountno = (String) session.getAttribute("accountno");
		System.out.println(accountno);
		int inputmoney = Integer.parseInt(request.getParameter("inputmoney"));
		// DB 저장, 잔액 가져오기.
		int balance = 0;
		request.setAttribute("accountno", accountno);
		request.setAttribute("inputmoney", inputmoney);
		request.setAttribute("balance", balance);
		return "view/atm/input/inputcheck.jsp";
	}

}
