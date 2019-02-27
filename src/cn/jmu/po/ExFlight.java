package cn.jmu.po;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

public class ExFlight {
	private String flightID;
	private Date exFlightDate;
	private int flightStateID;
	private int foodTypeID;
	private String totalTime;
	private Time departTime;
	private Time arriveTime;
	private boolean onRevise;
	private boolean onRefund;
	
	private FlightState flightState;
	public FlightState getFlightState() {
		return flightState;
	}
	public void setFlightState(FlightState flightState) {
		this.flightState = flightState;
	}
	private Flight flight;	
	private List<ExFlightProduct> exFlightProduct;
	
	public Flight getFlightType() {
		return flight;
	}
	public List<ExFlightProduct> getExFlightProduct() {
		return exFlightProduct;
	}
	public void setExFlightProduct(List<ExFlightProduct> exFlightProduct) {
		this.exFlightProduct = exFlightProduct;
	}
	public void setFlightType(Flight flight) {
		this.flight = flight;
	}
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
	public int getFlightStateID() {
		return flightStateID;
	}
	public void setFlightStateID(int flightStateID) {
		this.flightStateID = flightStateID;
	}
	public int getFoodTypeID() {
		return foodTypeID;
	}
	public void setFoodTypeID(int foodTypeID) {
		this.foodTypeID = foodTypeID;
	}
	public String getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	public Time getDepartTime() {
		return departTime;
	}
	public void setDepartTime(Time departTime) {
		this.departTime = departTime;
	}
	public Time getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(Time arriveTime) {
		this.arriveTime = arriveTime;
	}
	public boolean isOnRevise() {
		return onRevise;
	}
	public void setOnRevise(boolean onRevise) {
		this.onRevise = onRevise;
	}
	public boolean isOnRefund() {
		return onRefund;
	}
	public void setOnRefund(boolean onRefund) {
		this.onRefund = onRefund;
	}
	public ExFlight(String flightID, Date exFlightDate, int flightStateID, int foodTypeID, String totalTime,
			Time departTime, Time arriveTime, boolean onRevise, boolean onRefund) {
		super();
		this.flightID = flightID;
		this.exFlightDate = exFlightDate;
		this.flightStateID = flightStateID;
		this.foodTypeID = foodTypeID;
		this.totalTime = totalTime;
		this.departTime = departTime;
		this.arriveTime = arriveTime;
		this.onRevise = onRevise;
		this.onRefund = onRefund;
	}
	public ExFlight() {

	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
}
