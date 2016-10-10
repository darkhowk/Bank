package bank.atm.service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public interface CommandProcess {

	String requestPro(HttpServletRequest request,
			HttpServletResponse response);

}