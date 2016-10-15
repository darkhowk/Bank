package bank.pc.custom.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.pc.custom.dao.AccountOpen;
import bank.pc.custom.dao.AccountOpenDao;

public class AccountRequestSubmitService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		/*
		 * HttpSession session = request.getSession(); String connect_gbn =
		 * (String) session.getAttribute("connect_gbn"); int user_no =
		 * Integer.parseInt((String) session.getAttribute("user_no"));
		 */
		// 이전 페이지에서 상품번호를 가져옴

		int product_no = Integer.parseInt(request.getParameter("product_no"));
		
		// 원래 유저넘버, 접근방법 세션에서 가져와야하지만 넣어주자.
		int user_no = 1;
		String connect_gbn = "0101";

		// AccountOpen 초기화, 메모리할당
		AccountOpen ao = new AccountOpen();

		// AccountOpen에 값들을 넣어줌.
		ao.setUser_no(user_no);
		ao.setProduct_no(product_no);
		ao.setConnect_gbn(connect_gbn);

		// AccountOpenDao 초기화, 메모리 할당
		AccountOpenDao aod = AccountOpenDao.getInstance();
		
		// 넣어준 값들을 주고 신청을함.
		int result = aod.insert(ao);
		
		// 결과값이 0보다 작거나 같으면 오류
		if (result <= 0) {
			return "error.do?code=requesterror.jsp";
			
			// 잘되면 저기로 보냄.
		} else {
			return "view/pc/requestcheck.jsp";
		}
	}

}
