package bank.atm.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.atm.dao.AccountDao;
import bank.atm.dao.MemberDao;

public class AcCheckService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
System.out.println("1-1");

		// AtmMain.jsp에 있던 account_no 요청
		String account_no = request.getParameter("account_no");
System.out.println("1-2");
		// AccountDao, MemberDao 메모리 할당, 초기화.
		AccountDao ad = AccountDao.getInstance();
		System.out.println("1-03");
		MemberDao md = MemberDao.getInstance();
		// 입력받은 계좌번호로 유저넘버, 이름 가져오기
		System.out.println("1");
		String user_no = ad.checkid(account_no); // mybatis
		System.out.println("2");
		String kor_name = md.getKorName(user_no);
		// 만약 가져온 이름이 없거나, 빈칸이라면 존재 하지 않은 계좌번호.
		if (user_no == null || user_no.equals("")) {

			return "error.do?code=account_not_existence.jsp";

			// 존재하는 계좌번호
		} else {
			// 세션 시간 10분 로그인, 계좌번호, 유저번호, 이름 세션에 저장
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10 * 60);
			session.setAttribute("account_no", account_no);
			session.setAttribute("user_no", user_no);
			session.setAttribute("kor_name", kor_name);
			return "main.do";
		}

	}

}
