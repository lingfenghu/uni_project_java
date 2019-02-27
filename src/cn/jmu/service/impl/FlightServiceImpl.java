package cn.jmu.service.impl;


import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.jmu.mapper.FlightMapper;
import cn.jmu.po.Flight;
import cn.jmu.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService {
	@Resource(name="flightMapper")
	private FlightMapper flightMapper;

	public Flight getFlightByID(String ID) throws Exception{
		return this.flightMapper.getFlightByID(ID);
	}
	public List<Flight> getAllFlight() throws Exception{
		return this.flightMapper.getAllFlight();
	}
	public void updateFlight(Flight flight) throws Exception{
		this.flightMapper.updateFlight(flight);
	}
	public void addFlight(Flight flight) throws Exception{
		this.flightMapper.addFlight(flight);
	}
}
