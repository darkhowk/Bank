package pc.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pc.board.dao.Board;
import pc.board.dao.BoardDao;

public class ListService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		/*
		 * HttpSession session = request.getSession(); String user_code =
		 * (String)session.getAttribute("user_code");
		 */

		String user_code = request.getParameter("user_code");

		BoardDao bd = BoardDao.getInstance();
		List<Board> list = bd.select();

		
		request.setAttribute("list", list);
		request.setAttribute("user_code", user_code);
		return "view/board/list.jsp";
	}

}
