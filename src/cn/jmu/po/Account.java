package cn.jmu.po;

public class Account {
	
	private String account;
	private String password;
	private boolean right;
	
	public Account(String account, String password, boolean right) {
		super();
		this.account = account;
		this.password = password;
		this.right = right;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	@Override
	public String toString() {
		return "Account [account=" + account + ", password=" + password + ", right=" + right + "]";
	}
	
	
}
