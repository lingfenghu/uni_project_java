package cn.jmu.mapper;

import java.util.List;

import cn.jmu.po.Flight;
import cn.jmu.po.FlightProduct;

public interface FlightMapper {
	public Flight getFlightByID(String ID) throws Exception;
	public List<Flight> getAllFlight() throws Exception;
	public void updateFlight(Flight flight) throws Exception;
	public void addFlight(Flight flight)  throws Exception;
}
