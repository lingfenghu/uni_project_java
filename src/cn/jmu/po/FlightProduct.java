package cn.jmu.po;

public class FlightProduct {
	private String flightProductID;
	private String flightProductName;
	public String getFlightProductID() {
		return flightProductID;
	}
	public void setFlightProductID(String flightProductID) {
		this.flightProductID = flightProductID;
	}
	public String getFlightProductName() {
		return flightProductName;
	}
	public void setFlightProductName(String flightProductName) {
		this.flightProductName = flightProductName;
	}
	public FlightProduct(String flightProductID, String flightProductName) {
		super();
		this.flightProductID = flightProductID;
		this.flightProductName = flightProductName;
	}
	public FlightProduct() {
		
	}
}
