package cn.jmu.po;

import java.sql.Timestamp;

public class OrderList {
	private String account;
	private int orderID;
	private Timestamp orderTime;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public Timestamp getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	public OrderList(String account, int orderID, Timestamp orderTime) {
		super();
		this.account = account;
		this.orderID = orderID;
		this.orderTime = orderTime;
	}
	public OrderList() {
		
	}
}
