package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ErrorService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");
		if (code == null || code == "") {
			code = "error_common.jsp";
		} else {
		}
		return "erroe.jsp";
	}
}
