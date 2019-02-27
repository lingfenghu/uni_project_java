package cn.jmu.po;

import java.sql.Date;

public class ExFlightProduct {
	@Override
	public String toString() {
		return "ExFlightProduct [flightID=" + flightID + ", exFlightDate=" + exFlightDate + ", flightProductID="
				+ flightProductID + ", price=" + price + ", pointPrice=" + pointPrice + ", leftTicketNum="
				+ leftTicketNum + ", onSale=" + onSale + "]";
	}
	private String flightID;
	private Date exFlightDate;
	private String flightProductID;
	private int price;
	private int pointPrice;
	private int leftTicketNum;
	private boolean onSale;
	public String getFlightID() {
		return flightID;
	}
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
	public Date getExFlightDate() {
		return exFlightDate;
	}
	public void setExFlightDate(Date exFlightDate) {
		this.exFlightDate = exFlightDate;
	}
	public String getFlightProductID() {
		return flightProductID;
	}
	public void setFlightProductID(String flightProductID) {
		this.flightProductID = flightProductID;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPointPrice() {
		return pointPrice;
	}
	public void setPointPrice(int pointPrice) {
		this.pointPrice = pointPrice;
	}
	public int getLeftTicketNum() {
		return leftTicketNum;
	}
	public void setLeftTicketNum(int leftTicketNum) {
		this.leftTicketNum = leftTicketNum;
	}
	public boolean isOnSale() {
		return onSale;
	}
	public void setOnSale(boolean onSale) {
		this.onSale = onSale;
	}
	public ExFlightProduct(String flightID, Date exFlightDate, String flightProductID, int price, int pointPrice,
			int leftTicketNum, boolean onSale) {
		super();
		this.flightID = flightID;
		this.exFlightDate = exFlightDate;
		this.flightProductID = flightProductID;
		this.price = price;
		this.pointPrice = pointPrice;
		this.leftTicketNum = leftTicketNum;
		this.onSale = onSale;
	}
	public ExFlightProduct() {
		
	}
	public String getSale() {
		if(this.isOnSale()==true)
			return "ÊÇ";
		else
			return "·ñ";
	}
}
