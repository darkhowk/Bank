package bank.atm.model;

public class Trade {
	private int trade_no;
	private int trade_amount;
	private String account_no;
	private String trade_gbn;
	private String trade_account_no;
	private String trade_bank;
	private String content1;
	private String content2;
	private String connect_gbn;
	private String trade_datetime;

	public int getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(int trade_no) {
		this.trade_no = trade_no;
	}

	public int getTrade_amount() {
		return trade_amount;
	}

	public void setTrade_amount(int trade_amount) {
		this.trade_amount = trade_amount;
	}

	public String getAccount_no() {
		return account_no;
	}

	public void setAccount_no(String account_no) {
		this.account_no = account_no;
	}

	public String getTrade_gbn() {
		return trade_gbn;
	}

	public void setTrade_gbn(String trade_gbn) {
		this.trade_gbn = trade_gbn;
	}

	public String getTrade_account_no() {
		return trade_account_no;
	}

	public void setTrade_account_no(String trade_account_no) {
		this.trade_account_no = trade_account_no;
	}

	public String getTrade_bank() {
		return trade_bank;
	}

	public void setTrade_bank(String trade_bank) {
		this.trade_bank = trade_bank;
	}

	public String getContent1() {
		return content1;
	}

	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent2() {
		return content2;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getConnect_gbn() {
		return connect_gbn;
	}

	public void setConnect_gbn(String connect_gbn) {
		this.connect_gbn = connect_gbn;
	}

	public String getTrade_datetime() {
		return trade_datetime;
	}

	public void setTrade_datetime(String trade_datetime) {
		this.trade_datetime = trade_datetime;
	}

}
