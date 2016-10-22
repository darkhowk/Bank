package bank.atm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.atm.dao.TradeDao;
import bank.atm.model.Trade;

public class SearchService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String account_no = (String) session.getAttribute("account_no");
		TradeDao td = TradeDao.getInstance();
		List<Trade> list = td.select(account_no);

		request.setAttribute("list", list);

		return "main.do?select=search/search.jsp";
	}

}
