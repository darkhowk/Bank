package bank.atm.model;

public class Account {
	private String account_no;
	private String account_pw;
	private String user_no;
	private String product_code;
	private String account_state;
	private int day_trans_limit;
	private int once_trans_limit;
	private String reg_date;
	private String user_flag;

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getAccount_pw() {
		return account_pw;
	}

	public void setAccount_pw(String account_pw) {
		this.account_pw = account_pw;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	public String getProduct_code() {
		return product_code;
	}

	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}

	public String getAccount_state() {
		return account_state;
	}

	public void setAccount_state(String account_state) {
		this.account_state = account_state;
	}

	public int getDay_trans_limit() {
		return day_trans_limit;
	}

	public void setDay_trans_limit(int day_trans_limit) {
		this.day_trans_limit = day_trans_limit;
	}

	public int getOnce_trans_limit() {
		return once_trans_limit;
	}

	public void setOnce_trans_limit(int once_trans_limit) {
		this.once_trans_limit = once_trans_limit;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getUser_flag() {
		return user_flag;
	}

	public void setUser_flag(String user_flag) {
		this.user_flag = user_flag;
	}

}
