package bank.pc.custom.dao;

public class AccountOpen {
	private int open_no;
	private int user_no;
	private int product_no;
	private String open_datetime;
	private String open_gbn;

	public String getOpen_gbn() {
		return open_gbn;
	}

	public void setOpen_gbn(String open_gbn) {
		this.open_gbn = open_gbn;
	}

	private String connect_gbn;

	public int getOpen_no() {
		return open_no;
	}

	public void setOpen_no(int open_no) {
		this.open_no = open_no;
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

	public String getOpen_datetime() {
		return open_datetime;
	}

	public void setOpen_datetime(String open_datetime) {
		this.open_datetime = open_datetime;
	}

	public String getConnect_gbn() {
		return connect_gbn;
	}

	public void setConnect_gbn(String connect_gbn) {
		this.connect_gbn = connect_gbn;
	}

}
