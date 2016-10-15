package pc.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pc.board.dao.Board;
import pc.board.dao.BoardDao;

public class ModifyService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		
		String user_code = request.getParameter("user_code");
		System.out.println(user_code);
		
		if (user_code.equals("0104")) {
		System.out.println("1");	
			request.setAttribute("user_code", user_code);
			
			return "view/board/update.jsp";
		}
System.out.println("2");
		int board_no = Integer.parseInt(request.getParameter("board_no"));

		BoardDao bd = BoardDao.getInstance();
		
		List<Board> board = bd.update(board_no);

		request.setAttribute("user_code", user_code);
		request.setAttribute("board_no", board_no);
		request.setAttribute("board", board);

		return "view/board/update.jsp";
	}

}
