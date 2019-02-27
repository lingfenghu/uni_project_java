package cn.jmu.service.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.jmu.mapper.ExFlightMapper;
import cn.jmu.po.ExFlight;
import cn.jmu.po.ExFlightProduct;
import cn.jmu.service.ExFlightService;
@Service
public class ExFlightServiceImpl implements ExFlightService{
	@Resource(name="exFlightMapper")
	private ExFlightMapper exFlightMapper;
	public List<ExFlight> getAllExFlight() throws Exception{
		return this.exFlightMapper.getAllExFlight();
	}
	public List<ExFlight> getExFlightByFlightID(String flightID) throws Exception{
		return this.exFlightMapper.getExFlightByFlightID(flightID);
	}
	public ExFlight getExFlightByFlightIDAndExFlghtDate(String flightID,String exFlightDate)throws Exception{
		return this.exFlightMapper.getExFlightAndFlightStateAndFlightByDateaAndFlightID(flightID, exFlightDate);
	}
	public void updateExFlight(ExFlight exFlight) throws Exception{
		this.exFlightMapper.updateExFlight(exFlight);
	}
	public ExFlight getExFlightAndFlightStateAndFlightByDateaAndFlightID(String flightID,String exFlightDate) throws Exception{
		return this.exFlightMapper.getExFlightAndFlightStateAndFlightByDateaAndFlightID(flightID, exFlightDate);
	}
	
	public List<ExFlight> getAllExFlightAndFlightProductByCityAndDate(String exFlightDate,String departCity,String arriveCity) throws Exception{
		return this.exFlightMapper.getAllExFlightAndFlightProductByCityAndDate(exFlightDate, departCity, arriveCity);
	}
	
	public List<ExFlight> getAllExFlightAndFligtStateAndFlightByCityAndDate(String exFlightDate, String departCity, String arriveCity) throws Exception {
		return this.exFlightMapper.getAllExFlightAndFligtStateAndFlightByCityAndDate(exFlightDate, departCity, arriveCity);
	}
}
