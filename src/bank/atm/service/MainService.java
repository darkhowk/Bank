package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		String select = request.getParameter("select");
		String menu = request.getParameter("menu");
		if (select == null || select == "") {
			select = "notice2.jsp";
			menu = "menu2.jsp";
		} else {
			menu = "";
		}

		request.setAttribute("select", select);
		request.setAttribute("menu", menu);
		return "view/atm/main.jsp";
	}

}
