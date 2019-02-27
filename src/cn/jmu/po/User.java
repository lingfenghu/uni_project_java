package cn.jmu.po;

import java.sql.Date;

public class User {
	private String account;
	private String password;
	private boolean right;
	private String userName;
	private int memberID;
	private Date birthdate;
	private String userIDCard;
	private String userTel;
	private String email;
	private int point;
	private boolean userSex;
	
	private Member member;
	public boolean isUserSex() {
		return userSex;
	}
	public void setUserSex(boolean userSex) {
		this.userSex = userSex;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public boolean isSex() {
		return userSex;
	}
	public void setSex(boolean userSex) {
		this.userSex = userSex;
	}
	public String getAccount() {
		return account;
	}
	public User(String account, String password, boolean right, String userName, int memberID, Date birthdate,
			String userIDCard, String userTel, String email, int point, boolean userSex) {
		this.account = account;
		this.password = password;
		this.right = right;
		this.userName = userName;
		this.memberID = memberID;
		this.birthdate = birthdate;
		this.userIDCard = userIDCard;
		this.userTel = userTel;
		this.email = email;
		this.point = point;
		this.userSex = userSex;
	}
	public User() {
		
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
	public boolean isRight() {
		return right;
	}
	public void setRight(boolean right) {
		this.right = right;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getMemberID() {
		return memberID;
	}
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getUserIDCard() {
		return userIDCard;
	}
	public void setUserIDCard(String userIDCard) {
		this.userIDCard = userIDCard;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
