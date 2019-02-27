package cn.jmu.po;

import java.sql.Time;

public class Flight {
	private String flightID;
	private Time preDepartTime;
	private String preTotalTime;
	private String flightType;
	private int totalSeatNum;
	private String departCity;
	private String arriveCity;
	private int insurancePrice;
	public String getFlightID() {
		return flightID;
	}
	public Flight(String flightID, Time preDepartTime, String preTotalTime, String flightType, int totalSeatNum,
			String departCity, String arriveCity, int insurancePrice) {
		super();
		this.flightID = flightID;
		this.preDepartTime = preDepartTime;
		this.preTotalTime = preTotalTime;
		this.flightType = flightType;
		this.totalSeatNum = totalSeatNum;
		this.departCity = departCity;
		this.arriveCity = arriveCity;
		this.insurancePrice = insurancePrice;
	}
	public Flight() {
		
	}
	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}
	public Time getPreDepartTime() {
		return preDepartTime;
	}
	public void setPreDepartTime(Time preDepartTime) {
		this.preDepartTime = preDepartTime;
	}
	public String getPreTotalTime() {
		return preTotalTime;
	}
	public void setPreTotalTime(String preTotalTime) {
		this.preTotalTime = preTotalTime;
	}
	public String getFlightType() {
		return flightType;
	}
	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}
	public int getTotalSeatNum() {
		return totalSeatNum;
	}
	public void setTotalSeatNum(int totalSeatNum) {
		this.totalSeatNum = totalSeatNum;
	}
	public String getDepartCity() {
		return departCity;
	}
	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}
	public String getArriveCity() {
		return arriveCity;
	}
	public void setArriveCity(String arriveCity) {
		this.arriveCity = arriveCity;
	}
	public int getInsurance() {
		return insurancePrice;
	}
	public void setInsurance(int insurancePrice) {
		this.insurancePrice = insurancePrice;
	}
}
