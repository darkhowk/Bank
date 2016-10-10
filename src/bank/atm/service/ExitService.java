package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExitService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		return "view/atm/Exit.jsp";
	}

}
