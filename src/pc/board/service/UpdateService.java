package pc.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pc.board.dao.Board;
import pc.board.dao.BoardDao;

public class UpdateService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		String user_code = request.getParameter("user_code");
		if (user_code.equals("0104")) {
			Board board = new Board();
			
			String board_gbn = request.getParameter("board_gbn");
			String content = request.getParameter("content");
			String start_date = request.getParameter("start_date");
			String end_date = request.getParameter("end_date");
			String title = request.getParameter("title");

			board.setTitle(title);
			board.setBoard_gbn(board_gbn);
			board.setContent(content);
			board.setEnd_date(end_date);
			board.setStart_date(start_date);

			BoardDao bd = BoardDao.getInstance();

			int result = bd.insrt(board);

			
			
			
		}

		Board board = new Board();
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String board_gbn = request.getParameter("board_gbn");
		String content = request.getParameter("content");
		String start_date = request.getParameter("start_date");
		String end_date = request.getParameter("end_date");
		String title = request.getParameter("title");

		board.setTitle(title);
		board.setBoard_gbn(board_gbn);
		board.setBoard_no(board_no);
		board.setContent(content);
		board.setEnd_date(end_date);
		board.setStart_date(start_date);

		BoardDao bd = BoardDao.getInstance();

		int result = bd.update(board);
		if (result <= 0) {
			System.out.println("수정실패");

		} else {
			return "list.do";
		}

		return "a";

	}

}
