package cn.jmu.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jmu.po.ExFlight;
import cn.jmu.po.ExFlightProduct;

public interface ExFlightService {
	public List<ExFlight> getAllExFlight() throws Exception;
	public List<ExFlight> getExFlightByFlightID(String flightID) throws Exception;
	public ExFlight getExFlightByFlightIDAndExFlghtDate(String flightID,String exFlightDate)throws Exception;
	public void updateExFlight(ExFlight exFlight) throws Exception;

	public ExFlight getExFlightAndFlightStateAndFlightByDateaAndFlightID(String flightID,String exFlightDate) throws Exception;
	public List<ExFlight> getAllExFlightAndFlightProductByCityAndDate(String exFlightDate,String departCity,String arriveCity) throws Exception;
	public List<ExFlight> getAllExFlightAndFligtStateAndFlightByCityAndDate(String exFlightDate,String departCity,String arriveCity) throws Exception;
	
	
}
