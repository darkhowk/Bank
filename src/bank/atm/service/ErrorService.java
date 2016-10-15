package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ErrorService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		HttpSession session = request.getSession();
		session.invalidate();
		if (code == null || code == "") {
			code = "error_common.jsp";
		} else {

		}
		request.setAttribute("code", code);
		return "view/atm/error/error.jsp";
	}
}
