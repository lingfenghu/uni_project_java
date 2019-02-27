package cn.jmu.po;

public class FlightState {
	private int flightStateID;
	private String flightStateContext;
	public int getFlightStateID() {
		return flightStateID;
	}
	public void setFlightStateID(int flightStateID) {
		this.flightStateID = flightStateID;
	}
	public String getFlightStateContext() {
		return flightStateContext;
	}
	public void setFlightStateContext(String flightStateContext) {
		this.flightStateContext = flightStateContext;
	}
	public FlightState(int flightStateID, String flightStateContext) {
		super();
		this.flightStateID = flightStateID;
		this.flightStateContext = flightStateContext;
	}
	public FlightState() {
		
	}
}
