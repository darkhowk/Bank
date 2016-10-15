package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		// 이전페이지에 있는 값들을 요청.
		String select = request.getParameter("select");
		String menu = request.getParameter("menu");
		
		// 만약 select 가 null 또는 빈값 ==> 초기 페이지상태 
		if (select == null || select == "") {
			// 초기 페이지에서는 메뉴가 보임.
			select = "notice2.jsp";
			menu = "menu2.jsp";
		} else {
			// 초기페이지가 아니면 메뉴가 보이지 않음.
			menu = "";
		}

		// 셀렉값과 메뉴값을 다음페이지로 보냄
		request.setAttribute("select", select);
		request.setAttribute("menu", menu);
		return "view/atm/main.jsp";
	}

}
