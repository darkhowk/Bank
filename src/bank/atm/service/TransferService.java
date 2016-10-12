package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TransferService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		String transfer = request.getParameter("transfer");

		HttpSession session = request.getSession();
		String account_no = (String) session.getAttribute("account_no");
		System.out.println("1");
		if (transfer == null || transfer == "") {
			System.out.println("2");
			transfer = "transfer_other_account_no.jsp";
		} else {
		}
		System.out.println("3");
		if (request.getParameter("other_account_no") == null || request.getParameter("other_account_no").equals("")) {
			System.out.println("4");
			String other_account_no = "";
			request.setAttribute("other_account_no", other_account_no);
			request.setAttribute("transfer", transfer);
		} else {
			System.out.println("5");
			String other_account_no = request.getParameter("other_account_no");
			if (account_no.equals(other_account_no)) {
				System.out.println("6");
				return "error.do?code=transfer_account_overlap.jsp";

			} else {
				System.out.println("7");
				request.setAttribute("other_account_no", other_account_no);
				request.setAttribute("transfer", transfer);
			}
		}
		System.out.println("8");
		if (request.getParameter("trade_amount") == null || request.getParameter("trade_amount").equals("")) {
			System.out.println("9");
			String other_account_no = request.getParameter("other_account_no");
			request.setAttribute("transfer", transfer);
			request.setAttribute("other_account_no", other_account_no);
		} else {
			System.out.println("10");
			int trade_amount = Integer.parseInt(request.getParameter("trade_amount"));
			String other_account_no = request.getParameter("other_account_no");
			request.setAttribute("transfer", transfer);
			request.setAttribute("other_account_no", other_account_no);
			request.setAttribute("trade_amount", trade_amount);
		}
		System.out.println("11");
		if (request.getParameter("other_user_name") == null || request.getParameter("other_user_name").equals("")) {
			System.out.println("12");
		} else {
			System.out.println("13");
			String other_user_name = request.getParameter("other_user_name");
			request.setAttribute("other_user_name", other_user_name);
		}
		System.out.println("14");
		request.setAttribute("transfer", transfer);
		return "main.do?select=transfer/transfer.jsp";
	}
}
