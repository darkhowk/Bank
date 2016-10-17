package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainViewService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();

		// 세션 초기화 거래후, 또는 오류후에 왔을경우 세션에 있는 정보 삭제.
		return "view/atm/AtmMain.jsp";
	}

}
