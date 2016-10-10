package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainViewService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		return "view/atm/mainview.jsp";
	}

}
