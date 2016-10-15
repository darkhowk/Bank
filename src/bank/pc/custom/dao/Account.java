package bank.pc.custom.dao;

public class Account {
	private String account_no;
	private String account_pw;
	private int user_no;
	private int product_no;
	private String account_atate;
	private int day_trans_limit;
	private int once_trans_limit;
	private String open_datetime;
	private String uer_flag;
	private String auto_date;
	private int auto_amount;

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

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public int getProduct_no() {
		return product_no;
	}

	public void setProduct_no(int product_no) {
		this.product_no = product_no;
	}

	public String getAccount_atate() {
		return account_atate;
	}

	public void setAccount_atate(String account_atate) {
		this.account_atate = account_atate;
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

	public String getOpen_datetime() {
		return open_datetime;
	}

	public void setOpen_datetime(String open_datetime) {
		this.open_datetime = open_datetime;
	}

	public String getUer_flag() {
		return uer_flag;
	}

	public void setUer_flag(String uer_flag) {
		this.uer_flag = uer_flag;
	}

	public String getAuto_date() {
		return auto_date;
	}

	public void setAuto_date(String auto_date) {
		this.auto_date = auto_date;
	}

	public int getAuto_amount() {
		return auto_amount;
	}

	public void setAuto_amount(int auto_amount) {
		this.auto_amount = auto_amount;
	}

}
