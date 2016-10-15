package bank.pc.custom.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.pc.custom.dao.AccountOpen;
import bank.pc.custom.dao.AccountOpenDao;
import bank.pc.custom.dao.Product;

public class AccountRequestService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		// 세션에서 현재 로그인한 코드값을 읽어옴.
		// HttpSession session = request.getSession();
		// String code = (String) session.getAttribute("code");

		// 테스트용.
		String code = (String) request.getParameter("code");
		// AccountOpenDao에 메모리 할당
		AccountOpenDao aod = AccountOpenDao.getInstance();
		// 코드가 0104 = 관리자이라면
		if ("0104".equals(code)) {

			// 그중 신청하고 확인 안한 DB를 읽어옴
			List<AccountOpen> product_list = aod.requestlist();
			// 코드와 리스트를 보냄.
			request.setAttribute("product_list", product_list);
			request.setAttribute("code", code);
		} else {
			// 관리자가 아니면
			// 상품 정보는 가져옴
			List<Product> product_list = aod.allproduct();

			// 코드와 리스트를 보냄
			request.setAttribute("product_list", product_list);
			request.setAttribute("cdoe", code);
		}

		return "view/pc/accountrequest.jsp";
	}

}
