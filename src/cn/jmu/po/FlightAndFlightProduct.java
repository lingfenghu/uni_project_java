package cn.jmu.po;

public class FlightAndFlightProduct {
	private String flightProductID;
	private String flightID;
	private int seatNum;
	private int prePrice;
	private int prePointPrice;
	private int rewardPoint;
	
	private FlightProduct flightProduct;
	public FlightProduct getFlightProduct() {
		return flightProduct;
	}
	public void setFlightProduct(FlightProduct flightProduct) {
		this.flightProduct = flightProduct;
	}
	public String getFlightProductID() {
		return flightProductID;
	}
	public void setFlightProductID(String flightProductID) {
		this.flightProductID = flightProductID;
	}
	public String getFlightID() {
		return flightID;
	}
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public int getPrePrice() {
		return prePrice;
	}
	public void setPrePrice(int prePrice) {
		this.prePrice = prePrice;
	}
	public int getPrePointPrice() {
		return prePointPrice;
	}
	public void setPrePointPrice(int prePointPrice) {
		this.prePointPrice = prePointPrice;
	}
	public int getRewardPoint() {
		return rewardPoint;
	}
	public void setRewardPoint(int rewardPoint) {
		this.rewardPoint = rewardPoint;
	}
}
