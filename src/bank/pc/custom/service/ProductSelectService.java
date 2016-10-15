package bank.pc.custom.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.pc.custom.dao.AccountOpenDao;
import bank.pc.custom.dao.Product;

public class ProductSelectService implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {

		// 이전페이지에서 셀렉값 읽어옴
		String select = request.getParameter("select");

		// 셀렉값이 null이면 에러메세지
		if (select == null || select.equals("")) {
			select = "error.do?code=productselecterror.jsp";
			
			// AccountOpneDao 초기화, 메모리할당
		} else {
			AccountOpenDao aod = AccountOpenDao.getInstance();
			
			// 상품 대용을 DB에서 가져옴. 그리고 리스트를 다음페이지로 보냄
			List<Product> product_list = aod.selectproduct(select);
			request.setAttribute("product_list", product_list);
		}
		return "view/pc/productdtail.jsp";
	}

}
