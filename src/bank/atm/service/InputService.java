package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InputService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		String input = request.getParameter("input");
		if (input == null || input == "") {
			input = "inputmoney.jsp";
		} else {
		}
		HttpSession session = request.getSession();

		request.setAttribute("accountno", (String) session.getAttribute("accountno"));
		request.setAttribute("input", input);

		return "main.do?select=input/input.jsp";
	}

}
