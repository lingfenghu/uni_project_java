package cn.jmu.service;

import java.util.List;

import cn.jmu.po.Flight;

public interface FlightService {
	public Flight getFlightByID(String ID) throws Exception;
	public List<Flight> getAllFlight() throws Exception;
	public void updateFlight(Flight flight) throws Exception;
	public void addFlight(Flight flight) throws Exception;
}
