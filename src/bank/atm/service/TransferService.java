package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TransferService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		// 이체 값을 요청함
		String transfer = request.getParameter("transfer");

		// 세션에 있는 계좌번호를 가져옴.
		HttpSession session = request.getSession();
		String account_no = (String) session.getAttribute("account_no");

		// 만약 이체값이 없으면 이체할 다른 계좌번호를 받는 페이지로 보냄
		if (transfer == null || transfer == "") {
			transfer = "transfer_other_account_no.jsp";
		} else {
		}

		// 만약 다른 계좌번호가 비어있다면
		if (request.getParameter("other_account_no") == null || request.getParameter("other_account_no").equals("")) {

			// 이체값만 다음페이지로 보냄
			request.setAttribute("transfer", transfer);
		} else {

			// 다른 계좌번호를 가져옴
			String other_account_no = request.getParameter("other_account_no");

			// 만약 내 계좌번호와 다른 계좌번호가 같으면 거래 종료
			if (account_no.equals(other_account_no)) {
				return "error.do?code=transfer_account_overlap.jsp";

				// 내 계좌번호와 다른 계좌번호가 다르면 다른 계좌번호와 이체값을 다음페이지로 보냄
			} else {
				request.setAttribute("other_account_no", other_account_no);
				request.setAttribute("transfer", transfer);
			}
		}

		// 만약 거래금액이 비어있으면
		if (request.getParameter("trade_amount") == null || request.getParameter("trade_amount").equals("")) {

			// 다른 계좌번호와 이체값을 보내줌
			String other_account_no = request.getParameter("other_account_no");
			request.setAttribute("transfer", transfer);
			request.setAttribute("other_account_no", other_account_no);

			// 거래금액이 비어있지 않으면
		} else {

			// 거래금액과 다른계좌를 가져오고, 이체값을 다음페이지로 보내줌
			int trade_amount = Integer.parseInt(request.getParameter("trade_amount"));
			String other_account_no = request.getParameter("other_account_no");
			request.setAttribute("transfer", transfer);
			request.setAttribute("other_account_no", other_account_no);
			request.setAttribute("trade_amount", trade_amount);
		}

		// 만약 다른유저 이름이 비어있다면 아무짓 안함
		if (request.getParameter("other_user_name") == null || request.getParameter("other_user_name").equals("")) {

			// 만약 다른유저 이름이 있다면
		} else {

			// 다음페이지로 보냄
			String other_user_name = request.getParameter("other_user_name");
			request.setAttribute("other_user_name", other_user_name);
		}

		// 다음페이지로 이체값을 보냄
		request.setAttribute("transfer", transfer);
		return "main.do?select=transfer/transfer.jsp";
	}
}
