package bank.pc.custom.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.pc.custom.dao.AccountOpenDao;

public class AccountRequestConfirm implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		// 건수를 담을 count 초기화
		int count = 0;

		// 체크한 녀석들의 값들을 배열로 담아온다.
		String[] checkbox = request.getParameterValues("checkbox");
		String[] user_no = request.getParameterValues("user_no");
		String[] product_no = request.getParameterValues("product_no");
		String[] connect_gbn = request.getParameterValues("connect_gbn");
		// AccountOpenDao 초기화, 메모리할당
		AccountOpenDao aod = AccountOpenDao.getInstance();
		System.out.println("1");
		System.out.println(user_no.length);
		System.out.println(checkbox.length);
		for (int i = 0; i < checkbox.length; i++) {
			System.out.println("2");
			System.out.println(user_no[i]);
			System.out.println(product_no[i]);
			System.out.println(connect_gbn[i]);
			// 배열 길이만큼 값들을 넣어줌
			int up = aod.updateconfirm(Integer.parseInt(checkbox[i]), Integer.parseInt(user_no[i]),
					Integer.parseInt(product_no[i]), connect_gbn[i]);
			// 넣었으면 넣은갯수 카운트에 더해줌
			count = count + up;
		}

		// 카운트를 다음페이지로 보냄
		request.setAttribute("count", count);
		return "view/pc/confirmcheck.jsp";
	}

}
